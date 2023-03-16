package com.sping.employeeAddress.service;

import com.sping.employeeAddress.entity.Department;
import com.sping.employeeAddress.entity.Employee;

import java.util.List;

public interface EmpDeptService {

    public List<Department> findAll();

    public Department findById(int theId);

}
