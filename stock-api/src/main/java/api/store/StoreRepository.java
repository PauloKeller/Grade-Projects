package api.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Page<Store> findByCompanyId(Long companyId, Pageable pageable);
    Optional<Store> findByIdAndCompanyId(Long id, Long companyId);
}