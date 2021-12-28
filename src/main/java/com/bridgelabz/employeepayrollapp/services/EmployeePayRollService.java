package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
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
    List<EmployeePayRollData> empDataList = new ArrayList<>();

    @Autowired
    private EmployeePayRollRepository employeePayRollRepository;

    @Override
    public List<EmployeePayRollData> getEmployeeData() {
        return empDataList;
    }
    @Override
    public EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(emp);
        empDataList.add(empData);
        log.debug("Employee Data : " + empData.toString());
        return employeePayRollRepository.save(empData);
    }

    @Override
    public EmployeePayRollData updateEmployeeData(int id ,EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(emp);
        empDataList.set((id-1),empData);
        return empData;
    }

    @Override
    public void deleteEmployeeData(int id) {
        empDataList.remove(id - 1);
    }


    @Override
    public EmployeePayRollData getEmployeeDataById(int id) {
        return empDataList.stream().filter
        (empData -> empData.getEmployeeId()== (id)).findFirst().orElseThrow(() 
        -> new EmployeePayRollException("Employee Not Found"));
    }
    
}
