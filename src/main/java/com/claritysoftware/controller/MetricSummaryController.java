package com.claritysoftware.controller;

import com.claritysoftware.dto.MetricDto;
import com.claritysoftware.dto.MetricSummaryDto;
import com.claritysoftware.entity.MetricSummary;
import com.claritysoftware.entity.ResponseWrapper;
import com.claritysoftware.service.MetricSummaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/metricSummary")
public class MetricSummaryController {

    private final MetricSummaryService metricSummaryService;

    public MetricSummaryController(MetricSummaryService metricSummaryService) {
        this.metricSummaryService = metricSummaryService;
    }

    @Operation(summary = "Get all metrics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All list of metrics that meet the search criteria",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "A required parameter was not supplied or is invalid", content = @Content),
    })
    @GetMapping
    public ResponseEntity<ResponseWrapper> getMetricsSummary(@RequestParam @Valid String system, @RequestParam String name, @RequestParam Instant from, @RequestParam Instant to){
        List<MetricSummaryDto> metricDTOList = metricSummaryService.listAllMetricsWith(system, name, from, to);
        return ResponseEntity.ok(new ResponseWrapper("A list of metrics that meet the search criteria",metricDTOList, HttpStatus.OK));
    }
}
