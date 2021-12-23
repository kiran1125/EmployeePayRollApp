package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.models.EmployeePayRollDTO;
@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayRollController {
	
	@RequestMapping("")
	public ResponseEntity<String> employeePayRoll(){
		return new ResponseEntity<String>("Its Suceesfully connected",HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<String> employeePayRollById(@PathVariable ("id") int id){
		return new ResponseEntity<String>("Getting the details of employee with id :" + id,HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addEmployeePayRollData(@RequestBody EmployeePayRollDTO emp){
		return new ResponseEntity<String>("adding the details of employee :" + emp,HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> updatingEmployeePayRollData(@RequestBody EmployeePayRollDTO emp){
		return new ResponseEntity<String>("updating the details of employee :" + emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeePayRollById(@PathVariable ("id") int id){
		return new ResponseEntity<String>("Deleting the details of employee with id :" + id,HttpStatus.OK);
	}
	
}
