package com.sda.company.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "personal_numeric_code")
    private Long personalNumericCode;

    // == Relationships ==
    @ManyToMany
    @JoinTable(
            name = "project_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    @JsonIgnoreProperties("employeeList")
    private List<Project> projectList;

    @ManyToOne
    @JsonIgnoreProperties("employeeSetDepartment")
    private Department department;

    @ManyToOne
    @JsonIgnoreProperties("employeeSetCompany")
    private Company company;

}
