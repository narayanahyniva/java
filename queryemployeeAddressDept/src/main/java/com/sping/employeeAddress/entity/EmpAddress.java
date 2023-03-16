package com.sping.employeeAddress.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "aid")
public class EmpAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private int aid;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private int pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    @JsonIgnore()
    private Employee employee;

/*
    public EmpAddress() {
    }

    public EmpAddress(String address,String state, int pincode) {
        this.address = address;
        this.state = state;
        this.pincode = pincode;
    }
*/

}
