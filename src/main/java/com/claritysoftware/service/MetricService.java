package com.claritysoftware.service;


import com.claritysoftware.dto.MetricDto;

import java.util.List;

public interface MetricService {
    List<MetricDto> listAllMetrics();
    MetricDto retrieveById(Integer id);
    void save(MetricDto dto);
    MetricDto update(MetricDto dto);
}
