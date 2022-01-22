package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class EmployeePayRollDTO {


	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	private String name;

	@Min(value = 500, message = "Min wage is not more than 500")
	private long salary;
	
	@Pattern(regexp = "male|female", message = "Employee should be male or female")
	private String gender;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotNull (message = "startDate Should not be Empty")
	@PastOrPresent(message = "Date should be present or past")
	private LocalDate startDate;

	@NotBlank(message = "note should not be blank")
	private String note;

	@NotBlank(message = "pic should not be blank")
	private String profilePic;

	@NotNull(message = "departments should not be blank")
	private List<String> departments;
	private String emailId;
    private String password; 

}
