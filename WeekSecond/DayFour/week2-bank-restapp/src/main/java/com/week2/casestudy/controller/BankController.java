package com.week2.casestudy.controller;

import com.week2.casestudy.domain.BankAccount;
import com.week2.casestudy.dto.AppResponse;
import com.week2.casestudy.exception.InvalidAmountException;
import com.week2.casestudy.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bank")
@RestController //=@Component
public class BankController {

    private final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService service;

    @PostMapping // POST -> http://localhost:8080/bank/
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba) {

        logger.info("creating bank account");

        service.createNewAccount(ba);

        var response = new AppResponse<Integer>();
        response.setMsg("account created successfully");
        response.setSts("success");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/withdraw") // PUT -> http://localhost:8080/123456
    public ResponseEntity<AppResponse<Double>> withdrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money withdrawn successfully");
            response.setSts("success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/deposit") // PUT -> http://localhost:8080/bank/deposit
    public ResponseEntity<AppResponse<Double>> depositMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.deposit(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money deposit successfully");
            response.setSts("success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<AppResponse<List<BankAccount>>> findAll(){

        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.findAllBankAccounts());
            try{
                return ResponseEntity.ok(response);
            }catch (Exception e){
                return null;
            }


    }

    @PutMapping("/Activate")
    public  ResponseEntity<AppResponse<List<BankAccount>>> ActivateAccount(@RequestBody BankAccount ba){

        var response =new AppResponse<List <BankAccount>>();

//        Boolean status=service.activateAccount(ba.getAcNum());
        Long acNo= ba.getAcNum();
        service.activateAccount(acNo);
        response.setMsg("Account Acativated");
        response.setMsg("Sucess");


        return ResponseEntity.ok(response);
    }


    @PutMapping("/Activate")
    public  ResponseEntity<AppResponse<List<BankAccount>>> DeActivateAccount(@RequestBody BankAccount ba){

        var response =new AppResponse<List <BankAccount>>();

//        Boolean status=service.activateAccount(ba.getAcNum());
        Long acNo= ba.getAcNum();
        service.deActivateAccount(acNo);
        response.setMsg("Deactivate Account");
        response.setMsg("Sucess");


        return ResponseEntity.ok(response);
    }

    @GetMapping("/{AcNum}")
    public ResponseEntity<AppResponse<List<BankAccount>>> findByAccountNo(@PathVariable Long acNum) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
//       BankAccount ba= service.findAccountByAcNum(acNum);
        response.setBody(service.findAccountByAcNum(acNum) );

        return ResponseEntity.ok(response);
    }

}
