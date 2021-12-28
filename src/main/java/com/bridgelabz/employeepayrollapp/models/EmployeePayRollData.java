package com.bridgelabz.employeepayrollapp.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayRollData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column
    private String name;

    @Column
    private long salary;

    @Column
    private String gender;

    @Column(name = "start_date")
	private LocalDate startDate;

    @Column
	private String note;

    @Column(name = "profile_pic")
	private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department" , joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
	private List<String> departments;


    public EmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
        this.gender = employeePayRollDTO.getGender();
        this.startDate = employeePayRollDTO.getStartDate();
        this.note = employeePayRollDTO.getNote();
        this.profilePic = employeePayRollDTO.getProfilePic();
        this.departments = employeePayRollDTO.getDepartments();
    }
    public EmployeePayRollData() {}
    public void updateEmployeeData(EmployeePayRollDTO employeePayRollDTO) {
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
        this.gender = employeePayRollDTO.getGender();
        this.startDate = employeePayRollDTO.getStartDate();
        this.note = employeePayRollDTO.getNote();
        this.profilePic = employeePayRollDTO.getProfilePic();
        this.departments = employeePayRollDTO.getDepartments();
    }
}
