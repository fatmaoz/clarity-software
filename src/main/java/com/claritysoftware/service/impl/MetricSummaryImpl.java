package com.claritysoftware.service.impl;

import com.claritysoftware.dto.MetricSummaryDto;
import com.claritysoftware.entity.MetricSummary;
import com.claritysoftware.service.MetricSummaryService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MetricSummaryImpl implements MetricSummaryService {
    @Override
    public List<MetricSummaryDto> listAllMetricsWith(String system, String name, Instant from, Instant to) {
        return null;
    }
}
