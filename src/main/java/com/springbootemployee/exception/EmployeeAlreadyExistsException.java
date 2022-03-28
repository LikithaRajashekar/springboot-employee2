package com.springbootemployee.exception;

public class EmployeeAlreadyExistsException extends Exception {
	
	public EmployeeAlreadyExistsException() {
		System.out.println("Employee Already Exists in the database");
	}
	
	public EmployeeAlreadyExistsException(String s) {
		super(s);
	}



}
