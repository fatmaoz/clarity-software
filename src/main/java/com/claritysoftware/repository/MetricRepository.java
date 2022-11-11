package com.claritysoftware.repository;

import com.claritysoftware.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric,Integer> {
}
