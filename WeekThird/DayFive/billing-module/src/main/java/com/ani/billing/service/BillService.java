package com.ani.billing.service;

import com.ani.billing.dto.BillDto;

import java.util.List;
import java.util.Map;

public interface BillService {

     BillDto createBill (BillDto dto);

     Integer updateBill (BillDto dto);

     boolean PaidBill( Long id);

   List<BillDto>findByUnpaidBill(String treatment);

   List<Map<String,Integer>> findTreatmentWiseAmount();


}
