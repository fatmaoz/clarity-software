package com.claritysoftware.controller;

import com.claritysoftware.dto.MetricDto;
import com.claritysoftware.entity.ResponseWrapper;
import com.claritysoftware.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metrics")
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @Operation(summary = "Get all metrics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All list of metrics that meet the search criteria",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "A required parameter was not supplied or is invalid", content = @Content),
    })
    @GetMapping
    public ResponseEntity<ResponseWrapper> getMetrics(){
        List<MetricDto> metricDTOList = metricService.listAllMetrics();
        return ResponseEntity.ok(new ResponseWrapper("A list of metrics that meet the search criteria",metricDTOList, HttpStatus.OK));
    }

    @Operation(summary = "Get Metric by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested metric",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "A required parameter was not supplied or is invalid", content = @Content),
            @ApiResponse(responseCode = "404", description = "The specified metric was not found", content = @Content),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getMetricById(@PathVariable("id") Integer id){
        MetricDto metricDTO = metricService.retrieveById(id);
        return ResponseEntity.ok(new ResponseWrapper("The requested metric",metricDTO,HttpStatus.OK));
    }

    @Operation(summary = "Create metric")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The metric was recorded",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "A required parameter was not supplied or is invalid", content = @Content),
    })
    @PostMapping
    public ResponseEntity<ResponseWrapper> createMetric(@RequestBody MetricDto metricDTO){
        metricService.save(metricDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("The metric was recorded",HttpStatus.CREATED));
    }

    @Operation(summary = "Update Metric")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The metric was recorded",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "A required parameter was not supplied or is invalid," +
                    " or system or name does not match the existing metric", content = @Content),
            @ApiResponse(responseCode = "404", description = "The specified metric was not found", content = @Content),
    })
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateMetric(@RequestBody MetricDto metricDTO){
        metricService.update(metricDTO);
        return ResponseEntity.ok(new ResponseWrapper("The metric was recorded",HttpStatus.OK));
    }
}
