package api.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByBatchId(Long batchId, Pageable pageable);
    Optional<Product> findByIdAndBatchId(Long productId, Long batchId);
}
