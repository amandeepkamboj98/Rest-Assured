package com.RestApi;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class JsonSchemaValidator {
	@Test
	public void schemaValidate() {
		   RestAssured.baseURI = "https://reqres.in/api";
	        
	     given()

	                .when().get("/users?page=2")
	                .then()
	                .assertThat()
	                .body(matchesJsonSchemaInClasspath("schema.json"))
	                .statusCode(200).log().all();
	     
	     System.out.println("json-schema-validation is done successfully.....");
	}
}
