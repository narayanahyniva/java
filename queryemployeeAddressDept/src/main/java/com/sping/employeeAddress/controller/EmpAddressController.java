package com.sping.employeeAddress.controller;

import com.sping.employeeAddress.entity.EmpAddress;
import com.sping.employeeAddress.service.EmpAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EmpAddressController{

    @Autowired
    private EmpAddService empAddService;

    @GetMapping("/addresses")
    public List<EmpAddress> findAll(){

        List<EmpAddress> temp = empAddService.findAll();
        return temp;
    }

    @GetMapping("/addresses/{theId}")
    public EmpAddress findById(@PathVariable int theId){
        EmpAddress temp = empAddService.findById(theId);
        return temp;
    }
}
