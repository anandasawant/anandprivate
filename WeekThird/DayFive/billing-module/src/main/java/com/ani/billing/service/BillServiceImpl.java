package com.ani.billing.service;

import com.ani.billing.domain.Bill;
import com.ani.billing.dto.BillDto;
import com.ani.billing.exception.InvalidIdException;
import com.ani.billing.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = {SQLException.class},
        noRollbackFor = InvalidIdException.class
)

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repository;

    @Override
    public BillDto createBill(BillDto dto) {

        var bill = new Bill();
        bill.setBillDate(dto.getBillDate());
        bill.setBillAmount(dto.getBillAmount());
        bill.setBillStatus(dto.getBillStatus());
        bill.setPaidDate(dto.getPaidDate());
        bill.setTreatment(dto.getTreatment());
        bill.setPatientName(dto.getPatientName());

        repository.save(bill);

        return dto;
    }

    @Override
    public Integer updateBill(BillDto dto) throws InvalidIdException {
        Bill bill1 = repository.findById(dto.getId()).orElseThrow(() -> new InvalidIdException("Id is Not Valid"));
        var bill = new Bill();

        bill.setBillDate(dto.getBillDate());
        bill.setBillAmount(dto.getBillAmount());
        bill.setBillStatus(dto.getBillStatus());
        bill.setPaidDate(dto.getPaidDate());
        bill.setTreatment(dto.getTreatment());
        bill.setPatientName(dto.getPatientName());
        bill.setId(dto.getId());

        repository.save(bill);

        return 1;
    }

    @Override
    public boolean PaidBill(Long id) throws InvalidIdException {

        Optional<Bill> ba = repository.findById(id);

        Bill oldBill = ba.orElseThrow(() -> new InvalidIdException("Id is Not Valid"));
        boolean newStatus = true;
        Bill bill = new Bill();

        bill.setBillDate(oldBill.getBillDate());
        bill.setBillAmount(oldBill.getBillAmount());
        bill.setBillStatus(newStatus);
        bill.setPaidDate(oldBill.getPaidDate());
        bill.setTreatment(oldBill.getTreatment());
        bill.setPatientName(oldBill.getPatientName());
        bill.setId(oldBill.getId());

        repository.save(bill);

        return bill.getBillStatus();
    }

    @Override
    public List<BillDto> findByUnpaidBill(String treatment) {

        List<Bill> allList = repository.findAll();

        List<BillDto> list = new ArrayList<>();

        for (int i = 0; i < allList.size(); i++) {

            Bill bill = allList.get(i);

            if (!bill.getBillStatus() && bill.getTreatment().equals(treatment)) {

                BillDto dto = new BillDto(
                        bill.getId(),
                        bill.getTreatment(),
                        bill.getBillDate(),
                        bill.getPatientName(),
                        bill.getPaidDate(),
                        bill.getBillStatus(),
                        bill.getBillAmount()
                );

                list.add(dto);

            }
        }

        return list;
    }
}
