package api.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {
     public Page<Product> getProducts(@PathVariable(value = "batchId") Long batchId, Pageable pageable);

    public Product createProduct(@PathVariable(value = "batchId") Long batchId, @Valid Product productRequest);

    public Product updateProduct(
            @PathVariable(value = "batchId") Long batchId,
            @PathVariable(value = "productId") Long productId,
            @Valid @RequestBody Product productRequest
    );

    public void createBatches(List<Product> products);

    public ResponseEntity<?> deleteProduct(
            @PathVariable(value = "batchId") Long batchId,
            @PathVariable(value = "productId") Long productId
    );
}
