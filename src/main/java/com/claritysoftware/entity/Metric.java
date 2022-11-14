package com.claritysoftware.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Table(name = "metric")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Metric extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String system;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    @CreationTimestamp()
   // @Temporal(TemporalType.TIMESTAMP)
    private Instant date;
//
//    public Timestamp getDate() {
//        return Timestamp.valueOf(date);
//    }

    private Integer value;
}
