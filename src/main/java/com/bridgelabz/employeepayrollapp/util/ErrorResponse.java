package com.bridgelabz.employeepayrollapp.util;

public class ErrorResponse extends Response {

	public ErrorResponse(Integer statusCode, String statusmessage, Object token) {
		super(statusCode, statusmessage, token);
		
	}

}