 package com.RestApi;
 import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;  // static package, eclipse will not show auto suggestion for static package 
import org.testng.annotations.Test;
                                        // Google API        
public class Rest_basics {	 
	 //  validate if Add Place API is working as expected
	 // given - load all input details
	 // when - submit the all API, http method and resource
	// then - to validate the response 
	
	@Test   // notation TestNG framework    (we can also use java main method for run the code )
	
	// Add Place Post method
	
    public void test() {
	RestAssured.baseURI = "https://rahulshettyacademy.com";
    String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body("{\r\n"                                        
			+ "    \"location\": {\r\n"                      // java needs to understand this complete string as 
			+ "        \"lat\": -38.383494,\r\n"             //  json format (json payload)
			+ "        \"lng\": 33.427362\r\n"
			+ "    },\r\n"
			+ "    \"accuracy\": 50,\r\n"
			+ "    \"name\": \"Amandeep Kamboj\",\r\n"
			+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "    \"address\": \"40,sector-115,USA\",\r\n"
			+ "    \"types\": [\r\n"
			+ "        \"shoe park\",\r\n"
			+ "        \"shop\"\r\n"
			+ "    ],\r\n"
			+ "    \"website\": \"http://google.com\",\r\n"
			+ "    \"language\": \"French-IN\"\r\n"
			+ "}")
	 
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
	
      System.out.println(response);
      
      JsonPath js = new JsonPath(response);  // for parsing the json
	  String id = js.getString("place_id");  // pass path of particular value  
	   System.out.println(id);   // print the value of place id in console 
	
	  // Update Place Put method
	  
	   //String response1 =
	   given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\" : \"" +id+ "\",\r\n"
				+ "    \"address\" : \"Ratta Khera, Sirsa, Haryana\",\r\n"
				+ "    \"key\" : \"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/add/json")
		.then().statusCode(200).log().all().header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString(); 
    
	/*  JsonPath js1 = new JsonPath(response1);  // for parsing the json
	  String id1 = js1.getString("msg");  // pass path of particular value  
	   System.out.println(id1);    
	  
		// Get Place
	   
	/*  String getPlace = given().log().all().queryParam("key","qaclick123").queryParam("place_id",id)
	   .when().get("maps/api/place/add/json")
	   .then().assertThat().log().all().statusCode(200).extract().response().asString();
	   
	  JsonPath js2 = new JsonPath(getPlace);
	  String actualAddress = js2.getString("address");
	  System.out.println(actualAddress);
	*/
	}
}
