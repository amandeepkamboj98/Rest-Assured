package com.RestApi;

import com.Files.Methods;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test
	public void AddBook() {  
		RestAssured.baseURI = "http://216.10.245.166";

		String res = given().log().all().header("Content-Type", "application/json")
				.body(Methods.addBook("abg","170"))  // dynamically sending parameter to payload in body
				.when().post("Library/Addbook.php")
				.then().assertThat().statusCode(200).log().all()  // log().all() used to get all response
		     	.extract().response().asString(); // get response in a string 

		JsonPath js = new JsonPath(res);  // class used to get particular data into full response
		String id = js.get("ID");
		System.out.println(id);
	
	//Delete Book
	
	}
	
}
