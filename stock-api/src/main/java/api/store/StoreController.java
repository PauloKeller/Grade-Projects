package api.store;

import java.util.List;
import java.util.Map;

import api.company.CompanyRepository;
import api.exception.ResourceNotFoundException;
import api.stock.Stock;
import api.stock.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StoreController implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockRepository stockRepository;


    @GetMapping("/companies/{companyId}/stores")
    @Override
    public Page<Store> getStores(@PathVariable(value = "companyId") Long companyId, Pageable pageable) {
        return storeRepository.findByCompanyId(companyId, pageable);
    }

    @PostMapping("/companies/{companyId}/stores")
    @Override
    public Store createStore(
            @PathVariable(value = "companyId") Long companyId,
            @Valid @RequestBody Store storeRequest
    ) {
        return companyRepository.findById(companyId).map(company -> {
            storeRequest.setCompany(company);
            return storeRepository.save(storeRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + companyId + " not found"));
    }

    @PutMapping("/companies/{companyId}/stores/{storeId}")
    @Override
    public Store updateStore(@PathVariable(value = "companyId") Long companyId,
                             @PathVariable(value = "storeId") Long storeId,
                             @Valid @RequestBody Store storeRequest) {
        if (!companyRepository.existsById(companyId)) {
            throw new ResourceNotFoundException("PostId " + companyId + " not found");
        }


        return storeRepository.findById(storeId).map(store -> {
            store.setName(storeRequest.getName());
            return storeRepository.save(store);
        }).orElseThrow(() -> new ResourceNotFoundException("StoreId " + storeId + " not found"));
    }

    @Override
    public void createStores(List<Store> stores) {

    }

    @DeleteMapping("/companies/{companyId}/stores/{storeId}")
    @Override
    public ResponseEntity<?> deleteStore(@PathVariable(value = "companyId") Long companyId,
                                         @PathVariable(value = "storeId") Long storeId) {
        return storeRepository.findByIdAndCompanyId(storeId, companyId).map(store -> {
            storeRepository.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Store not found with id " + storeId + " and companyId " + companyId));
    }

    @Override
    @PostMapping("/stores/{storeId}")
    public Store addStockToStore(@RequestBody Map<String, Long> jsonRequest, @PathVariable(value = "storeId") Long storeId) {
        final Long stockId = jsonRequest.get("stockId");
        final Stock stock = stockRepository.findById(stockId).orElseThrow(() ->
                new ResourceNotFoundException("StockId " + stockId + " not found"));
        final Store store = storeRepository.findById(storeId).orElseThrow(() ->
                new ResourceNotFoundException("StoreId " + storeId + " not found"));
        try {
            store.getStocks().add(stock);
            stock.getStores().add(store);
            return storeRepository.save(store);
        } catch (Exception e) {
            System.out.println(e);
        }


//        System.out.println(stock);
//        System.out.println(store);
//        return storeRepository.save(store);
        return null;
    }

    @Override
    public Store getStoreById(Long id) {
        return null;
    }
}