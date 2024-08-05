package com.spc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spc.model.Employee;
import com.spc.service.EmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ec2")
public class Controller2 {

	
	//Logging
	
	Logger logger =LoggerFactory.getLogger(Controller2.class);
	
	
	
	@Autowired 
	private EmpService emps;
       
	  // Create Employee
	  @PostMapping("/save")
	  public ResponseEntity<Employee> addemp(@Valid @RequestBody Employee emp){
	
		return new  ResponseEntity<Employee>(emps.addemployee(emp),HttpStatus.CREATED);

	}
	
	
	  
	 
	  
	  // Fetch All Employee
	  @GetMapping("/fetch")
	  public ResponseEntity<List<Employee>> getEmp(){
		  logger.trace("Starting to get all employes with trace log level");
		  logger.info("Stating get all employees method with info log level ");
		  
		  return new ResponseEntity<>(emps.fetchEmployees(),HttpStatus.OK);
	  }
	
	  // Fetch Employee ById
	  // Path variable se empid liya aur use local variable id me idhar store kiya fir 
	  // use dao layer par bheja 
	   @GetMapping("/fetch/{empid}")
       public ResponseEntity<Employee> getEmpById(@PathVariable("empid") int id){
		  
		  return new ResponseEntity<Employee>(emps.getEmplById(id),HttpStatus.OK);
	  }
	
	   @DeleteMapping("/delete/{empid}")
	   
	   public ResponseEntity<Void> deleteEmp(@PathVariable("empid") int did){
		   
		   emps.delEmployee(did);
		   return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	   }
	  
	   @PutMapping("/update")
	   public ResponseEntity<Employee>updateEmp(@RequestBody Employee emp){
		   
		 return new ResponseEntity<Employee>(emps.updateRecord(emp),HttpStatus.OK);
	   }
}
