package com.sping.employeeAddress.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "did")
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private int did;

    @Column(name = "dname")
    private String dname;

    @Column(name = "dlocation")
    private String dlocation;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "department")
    @JsonIgnore()
    private Employee employee;

}
