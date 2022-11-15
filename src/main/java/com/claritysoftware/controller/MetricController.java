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

import javax.annotation.security.RolesAllowed;
import java.time.Instant;
import java.time.LocalDate;
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
    public ResponseEntity<ResponseWrapper> getMetrics(@RequestParam String system, @RequestParam String name,
                                                      @RequestParam String from, @RequestParam String to){
        List<MetricDto> metricDTOList = metricService.listAllMetricsWith(system, name, from, to);
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
    public ResponseEntity<ResponseWrapper> getMetricById(@PathVariable("id") Long id){
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
    @RolesAllowed("Admin")
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
    @PutMapping("/{id}")
    @RolesAllowed("Admin")
    public ResponseEntity<ResponseWrapper> updateMetric(@RequestBody MetricDto metricDTO, @PathVariable Long id){
        MetricDto metric = metricService.update(metricDTO,id);
        return ResponseEntity.ok(new ResponseWrapper("The metric was recorded", metricDTO, HttpStatus.OK));
    }
}
