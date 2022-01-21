package com.ani.billing.controller;


import com.ani.billing.dto.AppResponse;
import com.ani.billing.dto.BillDto;
import com.ani.billing.exception.InvalidIdException;
import com.ani.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping  // POST -> http://localhost:8080/bill/
    public ResponseEntity<AppResponse<BillDto>>createBill(@RequestBody BillDto dto){


        var saObj= service.createBill(dto);

        var response = new AppResponse<BillDto>();
        response.setStatus("success");
        response.setMessage("Bill Create Successfull");
        response.setBody(saObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")  // PUT -> http://localhost:8080/bill/update
    public ResponseEntity<AppResponse<Integer>>updateBill(@RequestBody BillDto dto){
try {


    var updatedBill = service.updateBill(dto);
    var response = new AppResponse<Integer>();
    response.setStatus("success");
    response.setMessage("Bill Updated");
    response.setBody(1);
    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }catch (InvalidIdException e){
    var response = new AppResponse<Integer>();
    response.setStatus("fail");
    response.setMessage(e.getMessage());
   response.setBody(0);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }


    }

    @PutMapping("/{id}")  // PUT -> http://localhost:8080/bill/  id
    public ResponseEntity<AppResponse<Boolean>>paidBill(@PathVariable Long id ){
        try {
            boolean paidBill= service.PaidBill(id);
            var  response =new AppResponse<Boolean>();
            response.setStatus("success");
            response.setMessage("Mark as Paid ");
            response.setBody(paidBill);

            return ResponseEntity.ok(response);
        }catch (InvalidIdException e){

            var  response =new AppResponse<Boolean>();
            response.setStatus("Fail");
            response.setMessage(e.getMessage());
            response.setBody(false);

            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

        }


    }

    @GetMapping("/{treatment}")
    public ResponseEntity<AppResponse<List<BillDto>>>findByTreatment(@PathVariable String treatment){

        var response =new AppResponse<List<BillDto>>();
        response.setMessage("Account List");
        response.setStatus("success");
        response.setBody(service.findByUnpaidBill(treatment));

        return ResponseEntity.ok(response);
    }

}
