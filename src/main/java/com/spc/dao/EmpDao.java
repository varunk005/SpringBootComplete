package com.spc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.model.Employee;

@Repository
public interface EmpDao extends JpaRepository<Employee,Integer> {

	
	//for custom validation
	List<Employee> findByAddress(String Address);
}
