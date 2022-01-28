package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.UserDetailsDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeeRegisterException;
import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;
import com.bridgelabz.employeepayrollapp.util.Response;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayRollService implements IEmployeePayRollServices{

    @Autowired
    private EmployeePayRollRepository employeePayRollRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TokenUtil tokenUtil;
    
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
    public EmployeePayRollData updateEmployeeData(Long id ,EmployeePayRollDTO employeePayRollDTO) {
        EmployeePayRollData empData = this.getEmployeeDataById(id);
        empData.updateEmployeeData(employeePayRollDTO);
        return employeePayRollRepository.save(empData);
        
    }

    @Override
    public void deleteEmployeeData(Long id) {
        EmployeePayRollData empData = this.getEmployeeDataById(id);
        employeePayRollRepository.delete(empData);
    }


    @Override
    public EmployeePayRollData getEmployeeDataById(Long id) {
        
        return employeePayRollRepository.findById(id).orElseThrow(() 
                    -> new EmployeePayRollException("Employee Not Found"));
        
    }
    // @Override
    // public List<EmployeePayRollData> getEmployeesPayRollDataByDepartment(String department) {
    //     return employeePayRollRepository.findEmployeesByDepartment(department);
    // }
    @Override
    public Response createContact(EmployeePayRollDTO userDetailsDTO) {
        Optional<EmployeePayRollData> isPresent=employeePayRollRepository.findByEmailId(userDetailsDTO.getEmailId());
		if(isPresent.isPresent()) {
			throw new EmployeeRegisterException(400, "Employee Already Added");
		}else {
			EmployeePayRollData employeePayRollData=modelMapper.map(userDetailsDTO, EmployeePayRollData.class);
			employeePayRollRepository.save(employeePayRollData);
			String token=tokenUtil.createToken(employeePayRollData.getEmployeeId());
			return new Response(200, "Employee Succefully Added", token);
		}
    }
    @Override
    public Response loginDetails(UserDetailsDTO userDetailsDTO) {
        Optional<EmployeePayRollData> emp=employeePayRollRepository.findByEmailId(userDetailsDTO.getEmailId());
        if(emp.isPresent()){
            String empData = emp.get().getPassword();
            if(empData.equals(userDetailsDTO.getPassword())){
                String token=tokenUtil.createToken(emp.get().getEmployeeId());
                return new Response(200, "Employee Login Successful", token);
            }else{
                return new Response(404, "Password Wrong");
            }
        }else{
            return new Response(400, "Login Failed");
        }
        
    }
    
}
