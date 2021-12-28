package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.models.EmployeePayRollData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData,Integer>{
    
}
