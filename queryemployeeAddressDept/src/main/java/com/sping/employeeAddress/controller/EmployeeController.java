package com.sping.employeeAddress.controller;

import com.sping.employeeAddress.entity.Employee;
import com.sping.employeeAddress.entity.Propertyconfig;
import com.sping.employeeAddress.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@PropertySource("sql.properties")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId) {

        return employeeService.findById(theId);
    }

    @PutMapping("/employees/update")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @PostMapping("/employee/insert")
    public Employee addemp(@RequestBody Employee theEmployee) {
        Employee emp = employeeService.save(theEmployee);
        return emp;
    }

    @DeleteMapping("/employee/delete/{theId}")
    public String deleteById(@PathVariable int theId) {

        return employeeService.deleteById(theId);
    }

    @GetMapping("/employeeduplicate")
    public Object[] duplicates() {
        return employeeService.findDuplicates();
    }

    @GetMapping("/employeepincodeisnull")
    public Object[] pincodeisnull() {
        return employeeService.findPincodeIsNull();
    }

    @GetMapping("/employeelessthan2")
    public Object[] findEmployeesLessthan2() {
        return employeeService.findEmployeesLessthan2();
    }

    @GetMapping("/employeelikepattern")
    public Object[] findLikePattern77and66() {
        return employeeService.findLikePattern77and66();
    }

    @GetMapping("/employeeavgsalary")
    public Object[] findAvgSalary() {
        return employeeService.findAvgSalary();
    }

    @GetMapping("/empjoinedbefore")
    public Object[] findJoinedBefore() {
        return employeeService.findJoinedBefore();
    }

    @GetMapping("empdeptnoemps")
    public Object[] findDeptsNoEmps() {
        return employeeService.findDeptsNoEmps();
    }

    @GetMapping("/empnametotalsal")
    public Object[] findNameTotalSal() {
        return employeeService.findNameTotalSal();
    }

    @GetMapping("/nameAndEmail")
    public List<Employee> findnameandEmail(@RequestParam String name, @RequestParam String email) {
        return employeeService.findUsingNameMail(name, email);
    }


    @GetMapping("/nameAndEmail2")
    public List<Employee> findnameandEmail2(@RequestParam List<String> name, @RequestParam List<String> email) {
        return employeeService.findUsingNameMail2(name, email);
    }


    @GetMapping("/findUsingNameMobileDate")
    public List<Employee> findUsingNameMobileDate(@RequestParam List<String> name,
                                                  @RequestParam List<Long> mobile,
                                                  @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return employeeService.findUsingNameMobileDate(name, mobile, date);
    }

    @GetMapping("/findempnamemobiledate")

    @DateTimeFormat(pattern = "dd/MM/yyyy")   //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate
    @Temporal(TemporalType.TIMESTAMP)
    public List<Employee> findByEnameInAndMobileInAndJoiningDateIn(@RequestParam String ename,
                                                                   @RequestParam Long mobile,
                                                                   @RequestParam String joiningDate) throws Exception {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(joiningDate);
        return employeeService.findByEnameAndMobileAndJoiningDate(ename, mobile, date1);
    }


    @GetMapping("/findByEnameAndMobile")
    public List<Employee> findByEnameInAndMobileIn(@RequestParam List<String> ename, @RequestParam List<Long> mobile) {
        return employeeService.findByEnameInAndMobileIn(ename, mobile);

    }

    @GetMapping("/findByPagination/{pageno}/{pageSize}")
    public Page<Employee> findEmployeesWithPagination(@PathVariable int pageno, @PathVariable int pageSize) {
        return employeeService.findEmployeesWithPagination(pageno, pageSize);
    }

    @GetMapping("/findtop3")
    public List<Employee> findFirst3ByOrderByEnameAsc() {
        return employeeService.findFirst3ByOrderByEnameAsc();
    }


    @GetMapping("/findbynameasc")
    public List<Employee> findFirstByOrderByEnameAsc() {
        return employeeService.findFirstByOrderByEnameAsc();
    }

    @GetMapping("findbynamedesc")
    List<Employee> findFirstByOrderByEnameDesc() {
        return employeeService.findFirstByOrderByEnameDesc();
    }

    @GetMapping("/findbyenamelast3")
    List<Employee> findFirst3ByOrderByEnameDesc() {
        return employeeService.findFirst3ByOrderByEnameDesc();
    }

    @GetMapping("/topsalary")
    List<Employee> findTopByOrderBySalaryDesc() {
        return employeeService.findTopByOrderBySalaryDesc();
    }

    @GetMapping("/leastsalary")
    public List<Employee> findTopByOrderBySalaryAsc() {
        return employeeService.findTopByOrderBySalaryAsc();
    }


    @PutMapping("/employee/updateq")
    Integer updateName(@RequestParam String name, @RequestParam int id) {
        Integer nameid = employeeService.updateName(name, id);
        return nameid;
    }

    @GetMapping("/employee")
    List<Employee> findByEname(@RequestParam String ename) {
        return employeeService.findByEname(ename);
    }


    @GetMapping("/top10bypage")
    public List<Employee> findTop10ByEname(@RequestParam String ename, @RequestParam Pageable pageable) {
        return employeeService.findTop10ByEname(ename, pageable);
    }


    //Reading Property file

    @Autowired
    Propertyconfig property;

    @GetMapping("/fetchproperties")
    public String fetchproperties(){
        System.out.println("id " +property.getId());
        System.out.println("name " +property.getName());
        System.out.println("email "+ property.getEmail());
        return property.getName();
    }


    @Value("${spring.datasource.url}")
    private String url;

    @GetMapping("/checkurl")
    public String checkproperty() {;
        return url;
    }

}