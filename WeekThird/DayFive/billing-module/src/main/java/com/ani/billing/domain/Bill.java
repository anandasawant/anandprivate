package com.ani.billing.domain;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    private String patientName;

    @Column(unique = false,nullable = false)
    private Date billDate;

    @Column(unique = false,nullable = true)
    private String treatment;

    @Column(unique = false,nullable = false)
    private Date paidDate;

    @Column(unique = false,nullable = false)
    private Boolean billStatus;

    @Column(unique = false,nullable = false)
    private Integer billAmount;




}
