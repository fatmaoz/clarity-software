package com.claritysoftware.service.impl;

import com.claritysoftware.dto.MetricDto;
import com.claritysoftware.entity.Metric;
import com.claritysoftware.mapper.MapperUtil;
import com.claritysoftware.repository.MetricRepository;
import com.claritysoftware.service.MetricService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;
    private final MapperUtil mapperUtil;

    public MetricServiceImpl(MetricRepository metricRepository, MapperUtil mapperUtil) {
        this.metricRepository = metricRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<MetricDto> listAllMetrics() {
        List<Metric> metricList = metricRepository.findAll();
        return metricList.stream().map(metric -> mapperUtil.convert(metric,new MetricDto())).collect(Collectors.toList());
    }

    @Override
    public MetricDto retrieveById(Integer id) {
        return mapperUtil.convert(metricRepository.findById(id).get(), new MetricDto());
    }

    @Override
    public void save(MetricDto obj) {
        Metric metric = mapperUtil.convert(obj, new Metric());
        metricRepository.save(metric);
    }

    @Override
    public MetricDto update(MetricDto dto) {
        Optional<Metric> metric = metricRepository.findById(dto.getId());
        Metric convertedMetric = mapperUtil.convert(dto, new Metric());
        convertedMetric.setId(metric.get().getId());
        metricRepository.save(convertedMetric);
        return retrieveById(dto.getId());
    }
}
