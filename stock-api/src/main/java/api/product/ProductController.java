package api.product;

import api.batch.BatchRepository;
import api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Override
    @GetMapping("/batches/{batchId}/products")
    public Page<Product> getProducts(@PathVariable(value = "batchId") Long batchId, Pageable pageable) {
        return productRepository.findByBatchId(batchId, pageable);
    }

    @Override
    @PostMapping("/batches/{batchId}/products")
    public Product createProduct(
            @PathVariable(value = "batchId") Long batchId,
            @RequestBody @Valid Product productRequest
    ) {
        return batchRepository.findById(batchId).map(batch -> {
            productRequest.setBatch(batch);
            return productRepository.save(productRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("BatchId " + batchId + " not found"));
    }

    @Override
    @PutMapping("/batches/{batchId}/products/{productId}")
    public Product updateProduct(
            @PathVariable(value = "batchId") Long batchId,
            @PathVariable(value = "productId") Long productId,
            @RequestBody @Valid Product productRequest
    ) {
        if (!batchRepository.existsById(batchId)) {
            throw new ResourceNotFoundException("BatchId " + batchId + " not found");
        }

        return productRepository.findById(productId).map(product -> {
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productId + "not found"));
    }

    @Override
    public void createBatches(List<Product> products) {

    }

    @Override
    @DeleteMapping("/batches/{batchId}/products/{productId}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable(value = "batchId") Long batchId,
            @PathVariable(value = "productId") Long productId
    ) {
        return productRepository.findByIdAndBatchId(productId, batchId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(() ->
                new ResourceNotFoundException("Product not found with id " + productId + " and batchId " + batchId));
    }
}
