package com.ani.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@AllArgsConstructor
@Setter
@Getter
public class BillDto {

    private Long id;
    @NotBlank
    @NotNull
    private String patientName;
    private Date billDate;
    private String treatment;
    private Date paidDate;
    private Boolean billStatus;
    @NotNull
    private Integer billAmount;
}
