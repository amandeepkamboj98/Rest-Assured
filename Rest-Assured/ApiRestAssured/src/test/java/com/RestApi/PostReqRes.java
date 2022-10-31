package com.RestApi;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostReqRes {

	@Test
	public void post() {
		 RestAssured.baseURI = "https://reqres.in/api/users";   // site is not working

	        RequestSpecification httpRequest = RestAssured.given();

	        //Specifying request Payload in JSON format
	        JSONObject requestParams = new JSONObject();  // JSONObject class is used for insert data as a body
	        requestParams.put("name", "amandeep");
	        requestParams.put("job", "hacker");

	        //Specify body type is Json/content type
	        httpRequest.header("Content-Type", "application/json");
	        // Add the Json to the body of the request
	        httpRequest.body(requestParams.toJSONString());   // Must be there    given().body(requestParams.toJSONString())

	        //POST request

	        Response response = httpRequest.request(Method.POST);    // when().post(" ").
	        String responseBody = response.getBody().asString();
	        System.out.println(responseBody);                          //   .then().log().all();

	
	}	
}
