package com.sping.employeeAddress.service;

import com.sping.employeeAddress.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;


public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public String deleteById(int theId);

    public List<Employee> findByEname(String ename);


    public Object[] findDuplicates();

    public Object[] findPincodeIsNull();

    public Object[] findEmployeesLessthan2();

    public Object[] findLikePattern77and66();

    public Object[] findAvgSalary();

    public Object[] findJoinedBefore();

    public Object[] findDeptsNoEmps();

    Object[] findNameTotalSal();

    List<Employee> findUsingNameMail(String name, String mail);

    public List<Employee> findUsingNameMail2(List<String> name, List<String> email);

    public List<Employee> findUsingNameMobileDate(List<String> name, List<Long> mobile, Date date);

    public List<Employee> findByEnameAndMobileAndJoiningDate(String ename, Long mobile, Date joiningDate);

    public List<Employee> findByEnameInAndMobileIn(List<String> ename, List<Long> mobile);

    public Page<Employee> findEmployeesWithPagination(int pageno, int pageSize);


    List<Employee> findFirstByOrderByEnameAsc();

    List<Employee> findFirstByOrderByEnameDesc();

    List<Employee> findFirst3ByOrderByEnameDesc();

    List<Employee> findFirst3ByOrderByEnameAsc();

    public List<Employee> findTopByOrderBySalaryAsc();

    List<Employee> findTopByOrderBySalaryDesc();

    Integer updateName(String name, int id);

    List<Employee> findTop10ByEname(String ename, Pageable pageable);

}


















/*

    Integer deleteByEName(String ename);

*/
