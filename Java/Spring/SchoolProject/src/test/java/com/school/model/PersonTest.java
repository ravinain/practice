package com.school.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.school.model.Person;

public class PersonTest {

	private static Validator validator;

	@BeforeClass
	public static void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testInvalidData() {
		Person person = new Person();
		
		Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
		
		System.out.println(constraintViolations.size());
		
		for(ConstraintViolation<Person> constraintViolation:constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
		
	}
	
}
