package com.ani.billing.controller;


import com.ani.billing.dto.AppResponse;
import com.ani.billing.dto.BillDto;
import com.ani.billing.exception.InvalidIdException;
import com.ani.billing.exception.InvalidTreatmentException;
import com.ani.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping  // POST -> http://localhost:8080/bill/
    public ResponseEntity<AppResponse<BillDto>>createBill(@Valid @RequestBody BillDto dto){


        var saObj= service.createBill(dto);

        var response = new AppResponse<BillDto>();
        response.setStatus("success");
        response.setMessage("Bill Create Successfull");
        response.setBody(saObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")  // PUT -> http://localhost:8080/bill/update
    public ResponseEntity<AppResponse<Integer>>updateBill(@Valid @RequestBody BillDto dto){
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
    public ResponseEntity<AppResponse<List<BillDto>>>findByTreatment(@PathVariable String treatment) throws InvalidTreatmentException {

        var response =new AppResponse<List<BillDto>>();
        response.setMessage("List of UnpaidBill");
        response.setStatus("success");
        response.setBody(service.findByUnpaidBill(treatment));

        return ResponseEntity.ok(response);
    }

    @GetMapping     //http://localhost:8080/bill/
    public ResponseEntity<AppResponse<List<Map<String,Integer>>>>findTreatmentWiseAmount(){

        var response =new AppResponse<List<Map<String,Integer>>>();

        response.setMessage("Treatment wise Amount");
        response.setStatus("success");
        response.setBody(service.findTreatmentWiseAmount());

        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for(ObjectError oe : errors) {
            FieldError fe = (FieldError) oe;

            String errorField = fe.getField();
            String errorMessage = fe.getDefaultMessage();


            messages.put(errorField, errorMessage);
        }

        return messages;
    }

}
