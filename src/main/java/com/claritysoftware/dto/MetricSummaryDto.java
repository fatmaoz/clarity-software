package com.claritysoftware.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class MetricSummaryDto {

    private String system;
    private String name;
    private Integer from;
    private Integer to;
    private Integer value;

}
