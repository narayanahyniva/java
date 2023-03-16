package com.sping.employeeAddress.dao;

import com.sping.employeeAddress.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDeptRepository extends JpaRepository<Department, Integer> {

}
