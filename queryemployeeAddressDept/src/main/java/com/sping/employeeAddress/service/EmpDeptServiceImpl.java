package com.sping.employeeAddress.service;

import com.sping.employeeAddress.dao.EmpDeptRepository;
import com.sping.employeeAddress.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpDeptServiceImpl implements EmpDeptService{

    @Autowired
    private EmpDeptRepository empDeptRepository;

    @Override
    public List<Department> findAll() {
        List<Department> allDept = empDeptRepository.findAll();
        return allDept;
    }
    @Override
    public Department findById(int theId) {
        Optional<Department> deptId = empDeptRepository.findById(theId);
        Department dept=null;
        if (deptId.isPresent()){
            dept=deptId.get();
        }
        else throw new RuntimeException("Department details not found for id - " + theId);

        return dept;
    }
}
