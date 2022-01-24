package com.week2.casestudy.controller;

import com.week2.casestudy.domain.BankAccount;
import com.week2.casestudy.dto.AmountTransferDto;
import com.week2.casestudy.dto.AppResponse;
import com.week2.casestudy.exception.AccountNotFoundException;
import com.week2.casestudy.exception.InActiveAccountException;
import com.week2.casestudy.exception.InvalidAcHlNameException;
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

    @GetMapping("/{prefix}")//get http://localhost:8080/bank/prefix
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        try {
            var response = new AppResponse<List<BankAccount>>();
            response.setMsg("account list");
            response.setSts("success");
            response.setBody(service.namesStartsWith(prefix));

            return ResponseEntity.ok(response);
        } catch (InvalidAcHlNameException e) {
            var response = new AppResponse<List<BankAccount>>();
            response.setMsg("Invalid Name");
            response.setSts("Fail");
            return ResponseEntity.ok(response);
        }


    }

    @GetMapping("/findall")
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

    @GetMapping("/activate")//PUT -> http://localhost:8080/bank/activate
    public  ResponseEntity<AppResponse<Boolean>> activateAccount(@RequestBody BankAccount ba){

        Boolean status=service.activateAccount(ba.getAcNum());
        var response =new AppResponse<Boolean>();

        response.setMsg("Account Acativated");
        response.setMsg("Sucess");
        response.setBody(status);


        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }


    @GetMapping("/deActivate")//PUT -> http://localhost:8080/bank/deActivate
    public  ResponseEntity<AppResponse<Boolean>> DeActivateAccount(@RequestBody BankAccount ba){

        var response =new AppResponse<Boolean>();

        Boolean status=service.deActivateAccount(ba.getAcNum());


        response.setMsg("Deactivate Account");
        response.setMsg("Sucess");
        response.setBody(status);


        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{AcNum}")
    public ResponseEntity<AppResponse<List<BankAccount>>> findByAccountNo(@PathVariable Long acNum) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account find Successfull");
        response.setSts("success");
        response.setBody((List<BankAccount>)service.findAccountByAcNum(acNum));

        return ResponseEntity.ok(response);
    }

    @PutMapping // Put -> http://localhost:8080/bank/update
    public ResponseEntity<AppResponse<BankAccount>> updateBankDatails(@RequestBody BankAccount ba) {

        logger.info("update  bank account details");

        service.updateAccountDetails(ba);

        var response = new AppResponse<BankAccount>();
        response.setMsg("account updated successfully");
        response.setSts("success");
        response.setBody(ba);
         ResponseEntity.ok(response);
         return ResponseEntity.ok(response);
    }
    @PutMapping("/transfer")
    public ResponseEntity<AppResponse<Integer>> transferMoney(@RequestBody AmountTransferDto dto) {

        try {
            int sts = service.transferMoney(dto.getSrcAc(), dto.getDstAc(), dto.getAmt());
            var response = new AppResponse<Integer>();
            response.setSts("success");
            response.setMsg("money transfer successful");
            response.setBody(sts);

            return ResponseEntity.ok(response);
        }catch (InvalidAmountException | AccountNotFoundException | InActiveAccountException ex) {
            var response = new AppResponse<Integer>();
            response.setSts("fail");
            response.setMsg(ex.getMessage());
            response.setBody(0);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
