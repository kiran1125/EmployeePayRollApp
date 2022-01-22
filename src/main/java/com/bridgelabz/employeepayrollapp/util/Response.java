package com.bridgelabz.employeepayrollapp.util;

import lombok.Data;

@Data
public class Response {
    private Integer StatusCode;
	private String Statusmessage;
	private Object token;
	public Response(Integer statusCode, String statusmessage, Object token) {
		super();
		StatusCode = statusCode;
		Statusmessage = statusmessage;
		this.token = token;
	}
    public Response(int i, String string) {
		super();
		StatusCode = i;
		Statusmessage = string;
    }
	
}
