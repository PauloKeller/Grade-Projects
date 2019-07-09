package api.batch;

import api.exception.ResourceNotFoundException;
import api.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BatchController implements BatchService {
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    @GetMapping("/stocks/{stockId}/batches")
    public Page<Batch> getBatches(@PathVariable(value = "stockId") Long stockId, Pageable pageable) {
        return batchRepository.findByStockId(stockId, pageable);
    }

    @Override
    @PostMapping("/stocks/{stockId}/batches")
    public Batch createBatch(
            @PathVariable(value = "stockId") Long stockId,
            @Valid @RequestBody Batch batchRequest
    ) {
        return stockRepository.findById(stockId).map(stock -> {
            batchRequest.setStock(stock);
            return batchRepository.save(batchRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("StockId " + stockId + " not found"));
    }

    @Override
    @PutMapping("/stocks/{stockId}/batches/{batchId}")
    public Batch updateBatch(
            @PathVariable(value = "stockId") Long stockId,
            @PathVariable(value = "batchId") Long batchId,
            @Valid @RequestBody Batch batchRequest
    ) {
        System.out.println(stockId);
        System.out.println(batchId);
        System.out.println(batchRequest);

        if (!stockRepository.existsById(stockId)) {
            throw new ResourceNotFoundException("StockId " + stockId+ " not found");
        }

        return batchRepository.findById(batchId).map(batch -> {
            batch.setDescription(batchRequest.getDescription());
            batch.setExpirationDate(batchRequest.getExpirationDate());
            batch.setManufactureDate(batchRequest.getManufactureDate());
            batch.setUnits(batchRequest.getUnits());
            return batchRepository.save(batch);
        }).orElseThrow(() -> new ResourceNotFoundException("BatchId " + batchId + " not found"));
    }

    @Override
    public void createBatches(List<Batch> batches) {

    }

    @Override
    @DeleteMapping("/stocks/{stockId}/batches/{batchId}")
    public ResponseEntity<?> deleteBatch(
            @PathVariable(value = "stockId") Long stockId,
            @PathVariable(value = "batchId") Long batchId
    ) {
        return batchRepository.findByIdAndStockId(batchId, stockId).map(batch -> {
            batchRepository.delete(batch);
            return ResponseEntity.ok().build();
        }).orElseThrow(() ->
                new ResourceNotFoundException("Batch not found with id " + batchId + " and stockId " + stockId));
    }
}
