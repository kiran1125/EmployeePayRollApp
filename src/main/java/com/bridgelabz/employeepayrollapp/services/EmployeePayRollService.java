package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayRollService implements IEmployeePayRollServices{
    List<EmployeePayRollData> empDataList = new ArrayList<>();

    @Override
    public List<EmployeePayRollData> getEmployeeData() {
        return empDataList;
    }
    @Override
    public EmployeePayRollData addEmployeeData(EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(empDataList.size() + 1, emp);
        empDataList.add(empData);
        return empData;
    }

    @Override
    public EmployeePayRollData updateEmployeeData(int id ,EmployeePayRollDTO emp) {
        EmployeePayRollData empData = null;
        empData = new EmployeePayRollData(id, emp);
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
