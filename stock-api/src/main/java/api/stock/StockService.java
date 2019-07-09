package api.stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StockService {
    public Page<Stock> getStocks(Pageable pageable);

    public Stock getStockById(Long stockId);

    public Stock createStock(Stock stock);

    public Stock updateStock(Long stockId, Stock stockRequest);

    public ResponseEntity<?> deleteStock(Long stockId);

}
