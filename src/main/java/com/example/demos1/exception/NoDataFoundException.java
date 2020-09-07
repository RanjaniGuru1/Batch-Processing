package com.example.demos1.exception;

public class NoDataFoundException extends RuntimeException {
	
	public NoDataFoundException() {
		super("No Data Found");
	}
}
