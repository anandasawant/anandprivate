package com.ani.billing.repository;

import com.ani.billing.domain.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;

public class BillRepositoryTests {




        @Autowired
        private BillRepository repository;
        @DisplayName("Bill Repo : Creating Bill")
        @Test
        void testCreateBill() {

            var bill = new Bill();

            bill.setBillDate(Date.valueOf(LocalDate.of(2022,1,10)));
            bill.setBillAmount(3666);
            bill.setBillStatus(true);
            bill.setPaidDate(Date.valueOf(LocalDate.of(2022,2,10)));
            bill.setTreatment("corona");
            bill.setPatientName("xyz");
            bill.setId(22l);

            Assertions.assertNotNull(bill);

        }
}
