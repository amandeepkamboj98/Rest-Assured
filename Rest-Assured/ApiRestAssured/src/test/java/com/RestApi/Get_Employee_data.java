package com.RestApi;

import com.Files.Methods;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Get_Employee_data {

	@Test
	public void AddBook() {  
		 RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		String res = given().log().all().header("Content-Type", "text/html; charset=UTF-8")
				  // dynamically sending parameter to payload in body
				.when().get("/employees")
				.then().assertThat().statusCode(200).log().all()  // log().all() used to get all response
		     	.extract().response().asString(); // get response in a string 

		JsonPath js = new JsonPath(res);  // class used to get particular data into full response
		String id = js.get("ID");
		System.out.println(id);
		
	//Delete Book
	
	}
	
}
