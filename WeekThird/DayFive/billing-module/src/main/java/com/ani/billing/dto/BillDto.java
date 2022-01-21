package com.ani.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@AllArgsConstructor
@Setter
@Getter
public class BillDto {

    private Long id;
    private String patientName;
    private Date billDate;
    private String treatment;
    private Date paidDate;
    private Boolean billStatus;
    private Integer billAmount;
}
