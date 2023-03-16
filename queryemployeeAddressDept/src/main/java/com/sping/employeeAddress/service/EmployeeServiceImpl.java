package com.sping.employeeAddress.service;

import com.sping.employeeAddress.dao.EmployeeRepository;
import com.sping.employeeAddress.entity.EmpAddress;
import com.sping.employeeAddress.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empid) {
        Optional<Employee> result = employeeRepository.findById(empid);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("The employee id " + empid + " is not present.");
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        List<EmpAddress> empAddress = theEmployee.getEmpAddress();
        List<EmpAddress> addList = new ArrayList<EmpAddress>();

        for (EmpAddress empAddress1 : empAddress) {
            empAddress1.setEmployee(theEmployee);
            addList.add(empAddress1);
        }
        theEmployee.setEmpAddress(addList);
        return employeeRepository.save(theEmployee);
    }

    @Override
    public String deleteById(int theId) {
        Optional<Employee> tempemp = employeeRepository.findById(theId);
        if (tempemp == null) {
            throw new RuntimeException("Employee is not found with id- " + theId);
        }
        employeeRepository.deleteById(theId);
        return "The employee with ID number " + theId + " has been deleted.";

    }

    @Override
    public Object[] findDuplicates() {
        return employeeRepository.findDuplicates();
    }

    @Override
    public Object[] findPincodeIsNull() {
        return employeeRepository.findPincodeIsNull();
    }

    @Override
    public Object[] findEmployeesLessthan2() {
        return employeeRepository.findEmployeesLessthan2();
    }

    @Override
    public Object[] findLikePattern77and66() {
        return employeeRepository.findLikePattern77and66();
    }

    @Override
    public Object[] findAvgSalary() {
        return employeeRepository.findAvgSalary();
    }

    @Override
    public Object[] findJoinedBefore() {
        return employeeRepository.findJoinedBefore();
    }

    @Override
    public Object[] findDeptsNoEmps() {
        return employeeRepository.findDeptsNoEmps();
    }

    @Override
    public Object[] findNameTotalSal() {
        return employeeRepository.findNameTotalSal();
    }

    @Override
    public List<Employee> findUsingNameMail(String name, String mail) {
        return employeeRepository.findUsingNameMail(name, mail);
    }
/*

    @Override
    public List<Employee> findUsingNameOrEmail(String name, String mail) {
        return employeeRepository.findUsingNameOrEmail(name, mail);
    }
*/


    @Override
    public List<Employee> findUsingNameMail2(List<String> name, List<String> email) {
        return employeeRepository.findUsingNameMail2(name, email);
    }

    @Override
    public List<Employee> findUsingNameMobileDate(List<String> name, List<Long> mobile, Date date) {
        return employeeRepository.findUsingNameMobileDate(name, mobile, date);
    }

    @Override
    public List<Employee> findByEnameAndMobileAndJoiningDate(String ename, Long mobile, Date joiningDate) {
        return employeeRepository.findByEnameAndMobileAndJoiningDate(ename, mobile, joiningDate);
    }

    @Override
    public List<Employee> findByEnameInAndMobileIn(List<String> ename, List<Long> mobile) {
        return employeeRepository.findByEnameInAndMobileIn(ename, mobile);
    }

    @Override
    public Page<Employee> findEmployeesWithPagination(int pageno, int pageSize) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(pageno, pageSize));
        return employees;
    }

    @Override
    public List<Employee> findFirstByOrderByEnameAsc() {
        return employeeRepository.findFirstByOrderByEnameAsc();
    }

    @Override
    public List<Employee> findFirstByOrderByEnameDesc() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "ename"));
    }

    @Override
    public List<Employee> findFirst3ByOrderByEnameDesc() {
        return employeeRepository.findFirst3ByOrderByEnameDesc();
    }

    @Override
    public List<Employee> findFirst3ByOrderByEnameAsc() {
        return employeeRepository.findFirst3ByOrderByEnameAsc();
    }

    @Override
    public List<Employee> findTopByOrderBySalaryAsc() {
        return employeeRepository.findTopByOrderBySalaryAsc();
    }

    @Override
    public List<Employee> findTopByOrderBySalaryDesc() {
        return employeeRepository.findTopByOrderBySalaryDesc();
    }

    @Override
    public Integer updateName(String name, int id) {
        return employeeRepository.updateName(name, id);
    }


    @Override
    public List<Employee> findTop10ByEname(String ename, Pageable pageable) {
        return employeeRepository.findTop10ByEname(ename, pageable);
    }

    public List<Employee> findByEname(String ename) {
        return employeeRepository.findByEname(ename);
    }




}








/*
    @Override
    public List<Employee> findAllWithSorting(String field) {
        return employeeRepository.findAll(Sort.by(field));
    }

*/




/*    @Override
    public Integer updateName(String name, int id) {
        return employeeRepository.updateName();
    }*/

/*
    @Override
    public Integer deleteByEName(String ename) {
        return employeeRepository.deleteByEname(ename);
    }
*/
