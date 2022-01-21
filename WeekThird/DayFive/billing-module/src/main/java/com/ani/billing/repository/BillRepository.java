package com.ani.billing.repository;

import com.ani.billing.domain.Bill;
import com.ani.billing.dto.BillDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {


//    List<BillDto>findByTreatmentdBill(String prefix);
}
