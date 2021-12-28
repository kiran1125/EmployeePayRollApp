package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class EmployeePayRollDTO {


	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	private String name;

	@Min(value = 500, message = "Min wage is not more than 500")
	private long salary;
	
	private String gender;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;

}
