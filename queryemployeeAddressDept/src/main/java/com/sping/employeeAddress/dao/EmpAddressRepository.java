package com.sping.employeeAddress.dao;

import com.sping.employeeAddress.entity.EmpAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpAddressRepository extends JpaRepository<EmpAddress, Integer> {

}
