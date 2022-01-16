package com.bankAssigenment.controller;

import com.bankAssigenment.entity.Bank;
import com.bankAssigenment.repo.Bankrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Bankcontroller {

    @Autowired
    private Bankrepo bankrepo;

    @RequestMapping("add")
    public List<Bank> createAcount(@RequestBody Bank bank){
        try {
            bankrepo.save(bank);
            return bankrepo.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping("get")
    public List<Bank> get(){
        try {
            return bankrepo.findAll();
        }catch (Exception e){
            return null;
        }

    }

    @RequestMapping("get{acNum}")
    public Bank get(@PathVariable Long acNum)
    {
        try
        {

            return bankrepo.findById(acNum).get();
            }
        catch (Exception e)
        {
            return null;
        }

    }

    @RequestMapping("delete{acNum}")
   void delete (@PathVariable long acNum){

        try {
            bankrepo.deleteById(acNum);
        }
        catch (Exception e){

        }
   }
}
