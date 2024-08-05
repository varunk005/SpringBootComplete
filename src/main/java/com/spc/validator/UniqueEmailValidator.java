package com.spc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//annotate with @ to tell jvm it is annotation below 3 things to make an annotaion

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidation.class})


public @interface UniqueEmailValidator {
      
	//error message
	public String message() default "Invalid Email address";
	
	//reprsents  group of constraints 
	public Class<?>[] groups() default {};
	
	// represents additional information about annotation
	
	public Class<? extends Payload>[] payload() default{};
	
}
