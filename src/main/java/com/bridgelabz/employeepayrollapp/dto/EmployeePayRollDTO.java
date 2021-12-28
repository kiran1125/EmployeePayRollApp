package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayRollDTO {


	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	private String name;

	@Min(value = 500, message = "Min wage is not more than 500")
	private long salary;
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
	public EmployeePayRollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public EmployeePayRollDTO() {
	}
	@Override
	public String toString() {
		return "EmployeePayRollDTO [name=" + name + ", salary=" + salary + "]";
	}
	
}
