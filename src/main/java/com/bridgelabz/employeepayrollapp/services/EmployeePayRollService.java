package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayRollService implements IEmployeePayRollServices{

    @Override
    public List<EmployeePayRollData> getEmployeeData() {
        List<EmployeePayRollData> empDataList = new ArrayList<>();
        empDataList.add( new EmployeePayRollData(1, new EmployeePayRollDTO("kiran", 30000)));
        return empDataList;
    }

    @Override
    public EmployeePayRollData getEmployeeDataById(int id) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(id, new EmployeePayRollDTO("kiran", 30000));
        return empData;
    }

    @Override
    public EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(1, emp);
        return empData;
    }

    @Override
    public EmployeePayRollData updateEmployeeData(EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(1, emp);
        return empData;
    }

    @Override
    public void deleteEmployeeData(int id) {
         
    }
    
}
