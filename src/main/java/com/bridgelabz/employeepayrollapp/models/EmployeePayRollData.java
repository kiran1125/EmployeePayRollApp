package com.bridgelabz.employeepayrollapp.models;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;

import lombok.Data;

public @Data class EmployeePayRollData {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;


    public EmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
        this.gender = employeePayRollDTO.getGender();
        this.startDate = employeePayRollDTO.getStartDate();
        this.note = employeePayRollDTO.getNote();
        this.profilePic = employeePayRollDTO.getProfilePic();
        this.departments = employeePayRollDTO.getDepartments();
    }
    public EmployeePayRollData() {}
}
