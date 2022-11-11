package com.claritysoftware.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "metric")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Metric extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String system;
    private String name;
    private LocalDate date;
    private Integer value;
}
