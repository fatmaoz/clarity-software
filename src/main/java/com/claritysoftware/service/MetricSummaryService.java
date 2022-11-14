package com.claritysoftware.service;

import com.claritysoftware.dto.MetricDto;
import com.claritysoftware.dto.MetricSummaryDto;

import java.time.Instant;
import java.util.List;

public interface MetricSummaryService {
    List<MetricSummaryDto> listAllMetricsWith(String system, String name, Instant from, Instant to);
}
