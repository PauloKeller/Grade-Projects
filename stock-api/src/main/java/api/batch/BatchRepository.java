package api.batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    Page<Batch> findByStockId(Long stockId, Pageable pageable);
    Optional<Batch> findByIdAndStockId(Long id, Long stockId);
}
