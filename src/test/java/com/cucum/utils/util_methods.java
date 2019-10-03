package com.cucum.utils;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


//import hamcrest matchers for assertions
import static org.hamcrest.Matchers.lessThan;

public class util_methods {
	private static RequestSpecification request;
	private static Response response;
	private static ValidatableResponse validateresponse;
	
	public static void setBaseURL(String baseURL) {
		RestAssured.baseURI = baseURL;
	}
	
	public static void setcustomheaders() {
		//use this method for setting custom headers
	}
	
	
	public static void checkStatusCode(int statuscode) {
		validateresponse = response.then().statusCode(statuscode);
		if(statuscode!=200) {
			System.out.println("Failed due to incorrect status");
			System.exit(0);
		}
	}
	
	public static void checkStatusCodeForPost(int statuscode) {
		//method implementation same as above - just check 201 - Resource create instead of 200
	}
	
	public static void hitPostRequest(String path) {
		response = request.post(path);
	}
	
	
	public static RequestSpecification getRequest() {
		return request;
	}
	
	public static void validateResponseTime(long responsetime) {
		validateresponse = response.then().time(lessThan(responsetime),TimeUnit.SECONDS);
	}
	
	public static void hitGetRequest(String path) {
		response = request.get(path);
	}
	
	public static void logEverything() {
		response.then().log().everything(true);
	}

	
	public static void getResponse() {
		response.getBody().asString();
	}
	
	
	public static boolean checkJSONKey(String params) {
		validateresponse = response.then().body("$", Matchers.hasKey(params));
		return validateresponse!=null;
	}
	
	public static void setContentType(String type) {
		request = request.contentType(type);
	}
}
