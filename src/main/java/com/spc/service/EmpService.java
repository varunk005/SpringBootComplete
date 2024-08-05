package com.spc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.customexception.BusinessException;
import com.spc.customexception.EmptyInputException;

import com.spc.dao.EmpDao;
import com.spc.model.Employee;

@Service
public class EmpService {

	
	@Autowired
	private EmpDao dao;

	
	public List<Employee> fetchEmployees() {
		List<Employee> emplist =  dao.findAll();
		try {
		
			if(emplist.isEmpty()) 
				 throw new BusinessException("701","Employee List is empty ");
				
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return emplist;
		
	}

	
	public Employee addemployee(Employee emp) {
		
			if(emp.getName().isEmpty()||emp.getName().length()==0) {
		    throw new EmptyInputException("601","Input Fields are empty");
		   
		}
			try {
			 Employee ep= dao.save(emp);
				return 	ep;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602","given employee is null"+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603","Something went wrong in service layer"+e.getMessage());
		}
		
	}
	

	public Employee getEmplById(int id) {
		
		// need to use get because of optional 
		return dao.findById(id).get();
	}

	public void delEmployee(int did) {
		
		dao.deleteById(did); 
	}

	public Employee updateRecord(Employee emp) {
	
		Employee exist =dao.findById(emp.getId()).orElseThrow(()->new RuntimeException("Entity not found"));
	    exist.setName(emp.getName());
	    return dao.save(exist);
	}
	
	
	
}
