package com.sping.employeeAddress.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "eid")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private int eid;

    @Column(name = "ename")
    private String ename;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private long mobile;

    @Column(name = "salary")
    private double salary;

    @Column(name = "joining_date")
    private Date joiningDate;

    //Bi-directional mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "employee")
    private List<EmpAddress> empAddress;
}
