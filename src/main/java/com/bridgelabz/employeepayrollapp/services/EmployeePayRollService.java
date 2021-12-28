package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayRollService implements IEmployeePayRollServices{

    @Autowired
    private EmployeePayRollRepository employeePayRollRepository;

    @Override
    public List<EmployeePayRollData> getEmployeeData() {
        return employeePayRollRepository.findAll();
    }
    @Override
    public EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(emp);
        log.debug("Employee Data : " + empData.toString());
        return employeePayRollRepository.save(empData);
    }

    @Override
    public EmployeePayRollData updateEmployeeData(int id ,EmployeePayRollDTO employeePayRollDTO) {
        EmployeePayRollData empData = this.getEmployeeDataById(id);
        empData.updateEmployeeData(employeePayRollDTO);
        return employeePayRollRepository.save(empData);
    }

    @Override
    public void deleteEmployeeData(int id) {
        EmployeePayRollData empData = this.getEmployeeDataById(id);
        employeePayRollRepository.delete(empData);
    }


    @Override
    public EmployeePayRollData getEmployeeDataById(int id) {
        return employeePayRollRepository.findById(id).orElseThrow(() 
                    -> new EmployeePayRollException("Employee Not Found"));
    }
    @Override
    public List<EmployeePayRollData> getEmployeesPayRollDataByDepartment(String department) {
        return employeePayRollRepository.findEmployeesByDepartment(department);
    }
    
}
