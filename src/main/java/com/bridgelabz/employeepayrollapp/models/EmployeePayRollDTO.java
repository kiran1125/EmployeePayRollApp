package com.bridgelabz.employeepayrollapp.models;

public class EmployeePayRollDTO {
	
	private String name;
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
