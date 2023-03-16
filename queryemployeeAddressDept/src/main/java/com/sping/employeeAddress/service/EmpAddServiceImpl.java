package com.sping.employeeAddress.service;

import com.sping.employeeAddress.dao.EmpAddressRepository;
import com.sping.employeeAddress.entity.EmpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpAddServiceImpl implements EmpAddService{

    @Autowired
    private EmpAddressRepository empAddressRepository;

    @Override
    public List<EmpAddress> findAll() {
        return empAddressRepository.findAll();
    }

    @Override
    public EmpAddress findById(int theId) {
        Optional<EmpAddress> result= empAddressRepository.findById(theId);

        EmpAddress theEmpAddress=null;
        if (result.isPresent()){
           theEmpAddress= result.get();
        }
        else {
            throw new RuntimeException("The address details are not found for id - "+ theId);
        }
        return theEmpAddress;
    }
}
