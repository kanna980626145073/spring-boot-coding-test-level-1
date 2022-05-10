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
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "idol_name")
    private String idolName;

    @Column(name = "address")
    private String address;

    @Column(name = "idol_status")
    private String idolStatus;

}
