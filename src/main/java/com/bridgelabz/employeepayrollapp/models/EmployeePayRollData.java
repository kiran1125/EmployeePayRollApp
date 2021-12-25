package com.bridgelabz.employeepayrollapp.models;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;

public class EmployeePayRollData {
    private int employeeId;
    private String name;
    private long salary;
    public EmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayRollDTO.getName();
        this.salary = employeePayRollDTO.getSalary();
    }
    public EmployeePayRollData() {
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "EmployeePayRollData [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
    }
}
