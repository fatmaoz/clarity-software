package com.claritysoftware.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "metric_summary")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Where(clause = "is_deleted=false")
public class MetricSummary{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String system;

    private String name;
    private Instant datefrom;
    private Instant dateto;
    private Integer value;
}
