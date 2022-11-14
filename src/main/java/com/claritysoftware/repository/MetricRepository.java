package com.claritysoftware.repository;

import com.claritysoftware.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface MetricRepository extends JpaRepository<Metric,Integer> {

    @Query("Select m from Metric  m where m.system=?1 and m.name = ?2 and m.date > ?3 and m.date <?4 ")
    List<Metric> findAllBySystemAndNameAndDateAfterAndDateBefore(String system, String name,
                                                                 Instant datefrom, Instant dateto);
    Optional<Metric> findById(Long id);
}
