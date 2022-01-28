package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.UserDetailsDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.util.Response;

public interface IEmployeePayRollServices {

    List<EmployeePayRollData> getEmployeeData();

    EmployeePayRollData getEmployeeDataById(Long id);

    EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp);

    EmployeePayRollData updateEmployeeData(Long id ,EmployeePayRollDTO emp);

    void deleteEmployeeData(Long id);

    //List<EmployeePayRollData> getEmployeesPayRollDataByDepartment(String department);

    Response createContact(EmployeePayRollDTO userDetailsDTO);

    Response loginDetails(UserDetailsDTO userDetailsDTO);
    
}
