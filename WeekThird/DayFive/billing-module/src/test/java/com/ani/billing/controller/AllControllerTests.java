package com.ani.billing.controller;


import com.ani.billing.dto.AppResponse;
import com.ani.billing.dto.BillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllControllerTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;


    @DisplayName("Testing Post Method")
    @Test
    void testPostMethod(){
        String url ="http://"+"localhost"+":"+port+"/bill/";

        var bill =new BillDto();
        bill.setId(1l);
        bill.setPatientName("vinod");
        bill.setBillDate(Date.valueOf(LocalDate.of(2021,1,23)));
        bill.setBillAmount(1011);
        bill.setPaidDate(Date.valueOf(LocalDate.of(2021,11,23)));
        bill.setTreatment("covid");
        bill.setBillStatus(true);


        var va1=template.postForEntity(
                url,
                bill,
                AppResponse.class
        );
        Assertions.assertEquals(HttpStatus.OK,va1.getStatusCode());
    }

    @DisplayName("Testing Put Mapping")
    @Test
    void testPutMethod(){
        BillDto obj =new BillDto();
        obj.setId(10l);
        String url ="http://"+"localhost"+":"+port+"/bill/update";
        var bill =new BillDto();
        bill.setId(10l);
        bill.setPatientName("vinod");
        bill.setBillDate(Date.valueOf(LocalDate.of(2021,1,23)));
        bill.setBillAmount(1011);
        bill.setPaidDate(Date.valueOf(LocalDate.of(2021,11,23)));
        bill.setTreatment("covid");
        bill.setBillStatus(true);

        Assertions.assertEquals(10l,bill.getId());

    }
}
