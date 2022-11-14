package com.claritysoftware.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricDto {


    private Long id;
    private String system;
    private String name;
    private Instant date;
    private Integer value;

}
