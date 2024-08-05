package com.spc.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.spc.dao.EmpDao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator,String> {

	@Autowired
	EmpDao dao;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		// check whether the list of email address is emoty for duplccates 
		if(dao.findByAddress(value).size()==0) {
			return true;
		}
		return false;
	}

}
