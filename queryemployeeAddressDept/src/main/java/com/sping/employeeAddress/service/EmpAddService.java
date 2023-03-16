package com.sping.employeeAddress.service;

import com.sping.employeeAddress.entity.EmpAddress;

import java.util.List;


public interface EmpAddService {
    public List<EmpAddress> findAll();

    public EmpAddress findById(int theId);
}
