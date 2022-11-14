package com.claritysoftware.service;


import com.claritysoftware.dto.MetricDto;

import java.time.Instant;
import java.util.List;

public interface MetricService {
    List<MetricDto> listAllMetrics();
    List<MetricDto> listAllMetricsWith(String system, String name, String from,String to);
    MetricDto retrieveById(Long id);
    void save(MetricDto dto);
    MetricDto update(MetricDto dto,Long id);
}
