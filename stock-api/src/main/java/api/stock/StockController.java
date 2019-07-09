package api.stock;

import api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StockController implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stocks")
    @Override
    public Page<Stock> getStocks(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }

    @GetMapping("/stocks/{stockId}")
    @Override
    public Stock getStockById(@PathVariable(value = "stockId") Long stockId) {
        return stockRepository.findById(stockId).orElseThrow(() ->
                new ResourceNotFoundException("StockId " + stockId + " not found"));
    }

    @PostMapping("/stocks")
    @Override
    public Stock createStock(@Valid @RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @PutMapping("/stocks/{stockId}")
    @Override
    public Stock updateStock(@PathVariable(value = "stockId") Long stockId,@Valid @RequestBody Stock stockRequest) {
        return stockRepository.findById(stockId).map(stock -> {
            stock.setName(stockRequest.getName());
            return stockRepository.save(stock);
        }).orElseThrow(() -> new ResourceNotFoundException("StockId " + stockId + " not found"));
    }

    @DeleteMapping("/stocks/{stockId}")
    @Override
    public ResponseEntity<?> deleteStock(@PathVariable(value = "stockId") Long stockId) {
        return stockRepository.findById(stockId).map(stock ->{
            stockRepository.delete(stock);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("StockId " + stockId + " not found"));
    }
}
