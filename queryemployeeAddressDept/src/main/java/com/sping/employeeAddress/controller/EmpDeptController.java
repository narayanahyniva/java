package com.sping.employeeAddress.controller;

import com.sping.employeeAddress.entity.Department;
import com.sping.employeeAddress.service.EmpDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EmpDeptController {

    @Autowired
    public EmpDeptService empDeptService;

    @GetMapping("/departments")
    public List<Department> findAll(){
        List<Department> tempdept = empDeptService.findAll();
        return tempdept;
    }

    @GetMapping("/departments/{theId}")
    public Department findById(@PathVariable int theId){
        Department tempDept = empDeptService.findById(theId);
        return tempDept;
    }
}
