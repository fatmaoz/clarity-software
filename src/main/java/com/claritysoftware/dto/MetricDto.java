package com.claritysoftware.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MetricDto {

    private Integer id;
    private String system;
    private String name;
    private LocalDate date;
    private Integer value;

}
