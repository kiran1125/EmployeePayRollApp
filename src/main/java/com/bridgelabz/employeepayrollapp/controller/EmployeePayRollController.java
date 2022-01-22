package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.dto.UserDetailsDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayRollServices;
import com.bridgelabz.employeepayrollapp.util.Response;


/**
 * The EmployeePayRollContoller acts as an RestController 
 * for the EmployeePayRollApp 
 * @author Kiran
 * @since 2021-12-23
 *
 */
@RestController
@RequestMapping("/employeepayroll")
@Slf4j
public class EmployeePayRollController {

	@Autowired
	private IEmployeePayRollServices employeePayRollServices;
	/**
	 * This Rest API method is used to get 
	 * whether its connected or not
	 * @return Response : with a String,empData and OK status
	 */

	@PostMapping("/Login")
	public ResponseEntity<Response> login(@RequestBody UserDetailsDTO userDetailsDTO){
		Response response=employeePayRollServices.loginDetails(userDetailsDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Response> createcontact(@RequestBody EmployeePayRollDTO userDetailsDTO){
		
		Response response=employeePayRollServices.createContact(userDetailsDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

	
	@GetMapping("/get/{token}")
	public ResponseEntity<ResponseDTO> employeePayRoll(@PathVariable ("token") String token){
		List<EmployeePayRollData> empDataList = null;
		empDataList = employeePayRollServices.getEmployeeData(token);
		ResponseDTO responseDTO = new ResponseDTO("Get call Successful", empDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	/**
	 * This Rest API method is used to get 
	 * the details of employee with use of id
	 * @param id it is the parameter that we pass as an path variable
	 * @return Response : with a String + empdata and OK status
	 */
	@GetMapping("/get/id/{token}")
	public ResponseEntity<ResponseDTO> employeePayRollById(@PathVariable ("token") String token){
		EmployeePayRollData empData = null;
		empData = employeePayRollServices.getEmployeeDataById(token);
		ResponseDTO responseDTO = new ResponseDTO("Get call for id Successful", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	/**
	 * This Rest API method is used to get 
	 * add details of employee
	 * @param emp it is the parameter that we pass as an body
	 * @return Response : with a String + emp and OK status
	 */
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> addEmployeePayRollData(@Valid @RequestBody EmployeePayRollDTO emp){
		log.debug("EmployeeDTO : " + emp.toString());
		EmployeePayRollData empData = null;
		empData = employeePayRollServices.addEmployeeData(emp);
		ResponseDTO responseDTO = new ResponseDTO("post data is Successful", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	/**
	 * This Rest API method is used to
	 * update details of employee
	 * @param emp it is the parameter that we pass as an body
	 * @return Response : with a String + emp and OK status
	 */
	@PutMapping("/put/{token}")
	public ResponseEntity<ResponseDTO> updatingEmployeePayRollData(@PathVariable("token") String token, @Valid @RequestBody EmployeePayRollDTO emp){
		EmployeePayRollData empData = null;
		empData = employeePayRollServices.updateEmployeeData(token,emp);
		ResponseDTO responseDTO = new ResponseDTO("put or update data is Successful", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	/**
	 * This Rest API method is used to 
	 * delete details of employee by using the id
	 * @param id it is the parameter that we pass as an body
	 * @return Response : with a String + id and OK status
	 */
	@DeleteMapping("/delete/{token}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayRollById(@PathVariable ("token") String token){
		employeePayRollServices.deleteEmployeeData(token);
		ResponseDTO responseDTO = new ResponseDTO("delete data is Successful of token :", token);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	// @GetMapping("/department/{department}")
	// public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department) {

	// 	List<EmployeePayRollData> employeeList = null;
	// 	employeeList = employeePayRollServices.getEmployeesPayRollDataByDepartment(department);
	// 	ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList);
	// 	return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	// }
	
}
