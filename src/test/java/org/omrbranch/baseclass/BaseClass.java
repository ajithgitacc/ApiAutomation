package org.omrbranch.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification requestSpecification;
	Response response;
	public void addHeader( String headerName,String headerValue) {
		requestSpecification = RestAssured.given().header(headerName,headerValue);
	}
	
	public void addHeaders(Headers headers ) {
		requestSpecification = RestAssured.given().headers(headers);
	}
	
	public void addAuthentication(String username,String password) {
		requestSpecification.auth().preemptive().basic(username, password);
	}
	
	public void addRequestBody(String body) {
		requestSpecification.body(body);
	}
	
	public void addRequestBody(Object body) {
		requestSpecification.body(body);
	}
	
	public Response addRequestType(String reqtype,String endpoint) {
		switch (reqtype) {
		case "GET":
			response = requestSpecification.get(endpoint);
			break;
			
		case "POST":
			response = requestSpecification.post(endpoint);
			break;
			
		case "PUT":
			response = requestSpecification.put(endpoint);
			break;
			
		case "DELETE":
			response = requestSpecification.delete(endpoint);
			break;
		

		default:
			break;
		}
		return response;
	}
	
	public int getResponsecode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
		
	}
	
	public String getResponseBody(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
	
	public void addFormData(String key,File pathfile) {
			requestSpecification.multiPart(key,pathfile);
	}
	
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties= new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\ConfigProperties"));
		String value=(String)properties.get(key);
		return value;
		
	}
	
	

}
