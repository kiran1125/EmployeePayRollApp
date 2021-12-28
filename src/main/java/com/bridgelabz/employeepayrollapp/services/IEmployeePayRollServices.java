package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;

public interface IEmployeePayRollServices {

    List<EmployeePayRollData> getEmployeeData();

    EmployeePayRollData getEmployeeDataById(int id);

    EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp);

    EmployeePayRollData updateEmployeeData(int id ,EmployeePayRollDTO emp);

    void deleteEmployeeData(int id);

    List<EmployeePayRollData> getEmployeesPayRollDataByDepartment(String department);
    
}
