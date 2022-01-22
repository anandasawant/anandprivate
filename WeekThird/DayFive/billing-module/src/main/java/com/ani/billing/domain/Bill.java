package com.ani.billing.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(unique = true,nullable = false)
    private String patientName;

    @NotNull
    @Column(unique = false,nullable = false)
    private Date billDate;

    @Column(unique = false,nullable = true)
    private String treatment;

    @Column(unique = false,nullable = false)
    private Date paidDate;

    @Column(unique = false,nullable = false)
    private Boolean billStatus;

    @NotNull
    @Column(unique = false,nullable = false)
    private Integer billAmount;




}
