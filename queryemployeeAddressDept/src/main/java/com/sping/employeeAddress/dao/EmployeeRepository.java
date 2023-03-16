package com.sping.employeeAddress.dao;

import com.sping.employeeAddress.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    //1
    @Query(value = "select e.ename , d.dname, count(e.ename), count(d.dname) from employee e inner join department d on e.eid = d.did \n" +
            "group by e.ename having count(e.ename)>1 ;", nativeQuery = true)
    public Object[] findDuplicates();

    //2
    @Query(value = "select * from employee where eid =(select employee_eid from address where pincode is null)", nativeQuery = true)
    public Object[] findPincodeIsNull();


    //3
    @Query(value = "select d.dname, a.state , count(*) from department d inner join employee e" +
            " on d.did=e.eid inner join address a on e.eid=a.aid group by d.dname having count(*)<2 order by state desc", nativeQuery = true)
    public Object[] findEmployeesLessthan2();

    //4
    @Query(value = "select ename , mobile from employee where mobile like '77%66'", nativeQuery = true)
    public Object[] findLikePattern77and66();

    //5
    @Query(value = "select avg(e.salary) from employee e inner join department d on  e.dept_id = d.did " +
            "where salary between 20000 and 40000 and d.dname='it' and d.dlocation='bangalore' order by e.ename asc", nativeQuery = true)
    public Object[] findAvgSalary();

    //10 //1
    @Query(value = "select * from employee e inner join department d on e.eid=d.did inner join address a " +
            "on d.did=a.aid where joining_date < timestamp('2022-07-27 11:37:00')", nativeQuery = true)
    public Object[] findJoinedBefore();

    //10 //2
    @Query(value = "select d.dname from department d where d.did not in (select e.eid from employee e ) " +
            "group by d.dname order by d.dname", nativeQuery = true)
    public Object[] findDeptsNoEmps();

    //10 //3
    @Query(value = "select d.dname, ifnull(sum(e.salary)*count(e.eid),0) total_salary from employee e right outer join department d" +
            " on e.eid=d.did group by d.dname", nativeQuery = true)
    public Object[] findNameTotalSal();


    //11 /1
    @Query(value = "select * from employee e  join department d  join address a on e.eid=d.did=a.employee_eid where e.ename=?1 and e.email=?2", nativeQuery = true)
    public List<Employee> findUsingNameMail(String name, String email);

    @Query("from Employee  e where e.ename in (?1) and e.email in (?2) ")
    public List<Employee> findUsingNameMail2(List<String> name, List<String> email);

    @Query(value = "select * from employee e where e.ename in (?1) and e.mobile in (?2) " +
            "and e.joining_date < (?3)", nativeQuery = true)
    public List<Employee> findUsingNameMobileDate(List<String> name, List<Long> mobile, Date date);


    public List<Employee> findByEnameAndMobileAndJoiningDate(String ename, Long mobile, Date joiningDate);

    public List<Employee> findByEnameInAndMobileIn(List<String> ename, List<Long> mobile);

    public List<Employee> findFirstByOrderByEnameAsc();

    public List<Employee> findFirstByOrderByEnameDesc();
    List<Employee> findFirst3ByOrderByEnameAsc();

    /*List<Employee> findTop3ByOrderByEnameAsc();*/

    List<Employee> findFirst3ByOrderByEnameDesc();
    public List<Employee> findTopByOrderBySalaryDesc();

    public List<Employee> findTopByOrderBySalaryAsc();

    public List<Employee> findByEname(String ename);



    //update a value

    @Modifying
    @Transactional
    @Query("update Employee set ename=:name where eid=:id")
    Integer updateName(@Param("name") String name, @Param("id") Integer id);


    List<Employee> findTop10ByEname(String ename, Pageable pageable);

}














/*
    @Modifying
    @Transactional
    @Query("delete from Employee where ename=:name")
    Integer deleteByEname(@Param("name") String name);
*/






