package api.batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface BatchService {
    public Page<Batch> getBatches(@PathVariable(value = "storeId") Long stockId, Pageable pageable);

    public Batch createBatch(@PathVariable(value = "stockId") Long stockId, @Valid Batch batchRequest);

    public Batch updateBatch(
            @PathVariable(value = "stockId") Long stockId,
            @PathVariable(value = "batchId") Long batchId,
            @Valid @RequestBody Batch batchRequest
    );

    public void createBatches(List<Batch> batches);

    public ResponseEntity<?> deleteBatch(
            @PathVariable(value = "stockId") Long stockId,
            @PathVariable(value = "batchId") Long batchId
    );

}
