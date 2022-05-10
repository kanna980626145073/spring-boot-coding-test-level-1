package com.codejam.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVENUE")
public class Revenue {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "monthly_rate")
    private String monthlyRate;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "date_time")
    private String dateTime;
}
