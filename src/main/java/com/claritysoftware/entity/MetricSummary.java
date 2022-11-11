package com.claritysoftware.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metric_summary")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class MetricSummary {
    @Id
    private int id;
}
