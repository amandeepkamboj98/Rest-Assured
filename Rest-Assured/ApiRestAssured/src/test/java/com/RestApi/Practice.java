package com.RestApi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Practice {
	@Test
	public void aman() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Rohit Kumar\",\r\n"
				+ "    \"phone_number\": \"(+91) 8708735317\",\r\n"
				+ "    \"address\": \"350,sector-30, cohen 09\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).log().all();
	
		
		// put method
		 
		 given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json");
	}

}
