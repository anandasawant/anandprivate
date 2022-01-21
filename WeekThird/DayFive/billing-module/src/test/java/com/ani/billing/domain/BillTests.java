package com.ani.billing.domain;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.time.LocalDate;

public class BillTests {

    @DisplayName("Doamin : Cheacking Object Creation")
    @Test
    void testObjectCreation(){
        var bill = new Bill();
        Assertions.assertNotNull(bill);
    }

    @DisplayName("Doamoin : Cheaking getter and setter ")
    @Test
    void testObjectGettersSetter(){

        var bill = new Bill();
        bill.setBillDate(Date.valueOf(LocalDate.of(2022,1,10)));
        bill.setBillAmount(3666);
        bill.setBillStatus(true);
        bill.setPaidDate(Date.valueOf(LocalDate.of(2022,2,10)));
        bill.setTreatment("corona");
        bill.setPatientName("abc");
        bill.setId(12l);

        Assertions.assertEquals(
                Date.valueOf(LocalDate.of(2022,1,10)),
                bill.getBillDate()
        );
        Assertions.assertEquals(3666,bill.getBillAmount());

        Assertions.assertEquals(true,bill.getBillStatus());

        Assertions.assertEquals(
                Date.valueOf(LocalDate.of(2022,2,10)),
                bill.getPaidDate()
        );

        Assertions.assertEquals("corona",bill.getTreatment());

        Assertions.assertEquals("abc",bill.getPatientName());

        Assertions.assertEquals(12L,bill.getId());

    }
}
