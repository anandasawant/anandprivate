package com.ani.billing.repository;

import com.ani.billing.domain.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {



    @Query(value = "SELECT treatment , sum(bill_amount) from bill GROUP BY treatment", nativeQuery = true)
    List<Map<String,Integer>> findTreatmentwiseAmountData();



}
