package tech.itpark.repository;

import tech.itpark.domain.Processing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcessingRepository extends JpaRepository<Processing, Long> {
    Processing findByCard(String card);

    Optional<Processing> findByAccountId(Long accountId);
}
