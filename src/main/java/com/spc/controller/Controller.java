package com.spc.controller;

import java.util.List;

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

import com.spc.customexception.BusinessException;
import com.spc.customexception.ControllerException;
import com.spc.model.Employee;
import com.spc.service.EmpService;

@RestController
@RequestMapping("/ec")
public class Controller {

	
	@Autowired 
	private EmpService emps;
       
	  // Create Employee
	  @PostMapping("/save")
	  public ResponseEntity<?> addemp(@RequestBody Employee emp){
	try {
		return new  ResponseEntity<Employee>(emps.addemployee(emp),HttpStatus.CREATED);
	}catch(BusinessException e) {
	
	ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
	return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		ControllerException ce= new ControllerException("677","something went wrong in contoller");
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
	}
	
	
	  }
	 
	  
	  // Fetch All Employee
	  @GetMapping("/fetch")
	  public ResponseEntity<List<Employee>> getEmp(){
		  
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
