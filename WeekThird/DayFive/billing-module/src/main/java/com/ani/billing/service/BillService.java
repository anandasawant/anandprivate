package com.ani.billing.service;

import com.ani.billing.dto.BillDto;
import com.ani.billing.exception.InvalidIdException;
import com.ani.billing.exception.InvalidTreatmentException;

import java.util.List;
import java.util.Map;

public interface BillService {

     BillDto createBill (BillDto dto);

     Integer updateBill (BillDto dto)throws InvalidIdException;

     boolean PaidBill( Long id)throws InvalidIdException;

   List<BillDto>findByUnpaidBill(String treatment)throws InvalidTreatmentException;

   List<Map<String,Integer>> findTreatmentWiseAmount();


}
