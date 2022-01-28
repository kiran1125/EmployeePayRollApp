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

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "employee_payroll")
@AllArgsConstructor
public @Data class EmployeePayRollData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column
    private String name;

    @Column
    private long salary;

    @Column
    private String gender;

    // @Column(name = "start_date")
	// private String startDate;

    @Column
	private String note;

    @Column(name = "profile_pic")
	private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department" , joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
	private List<String> department;
    private String emailId;
    private String password; 


    public EmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
        this.gender = employeePayRollDTO.getGender();
        // this.startDate = employeePayRollDTO.getStartDate();
        this.note = employeePayRollDTO.getNote();
        this.profilePic = employeePayRollDTO.getProfilePic();
        this.department = employeePayRollDTO.getDepartment();
        this.emailId  = employeePayRollDTO.getEmailId();
        this.password = employeePayRollDTO.getPassword();
        
    }
    public EmployeePayRollData() {}
    public void updateEmployeeData(EmployeePayRollDTO employeePayRollDTO) {
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
        this.gender = employeePayRollDTO.getGender();
        // this.startDate = employeePayRollDTO.getStartDate();
        this.note = employeePayRollDTO.getNote();
        this.profilePic = employeePayRollDTO.getProfilePic();
        this.department = employeePayRollDTO.getDepartment();
        this.emailId  = employeePayRollDTO.getEmailId();
        this.password = employeePayRollDTO.getPassword();
    }
}
