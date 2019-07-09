package api.store;

import api.stock.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StoreService {
  public Page<Store> getStores(Long companyId, Pageable pageable);

  public Store getStoreById(Long id);

  public Store createStore(Long companyId, Store storeRequest);

  public Store updateStore(Long companyId, Long storeId, Store storeRequest);

  public void createStores(List<Store> stores);

  public ResponseEntity<?> deleteStore(Long companyId, Long storeId);

  public Store addStockToStore(Map<String, Long> jsonRequest, Long storeId);

}