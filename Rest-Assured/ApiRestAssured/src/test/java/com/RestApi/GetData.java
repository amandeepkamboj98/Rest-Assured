package com.RestApi;

import static io.restassured.RestAssured.given;

import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;  
import static org.hamcrest.Matcher.*;
import static org.hamcrest.CoreMatchers.equalTo;  // body validation equalTO

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetData {
	
	 @Test
	    public void getData(){
		   
		 System.out.println("First way..........");
	//	 1st way
		 
//		 JSONObject js =new JSONObject();
//		 js.put(js, js)
		 Response response = RestAssured.get("https://reqres.in/api/users/2");
		 
		 System.out.println(response.asString());
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getHeaders());
		 System.out.println(response.getTime());
		 System.out.println(response.getStatusLine());
		 Assert.assertEquals(response.getStatusCode(),200);
		 System.out.println(response.getHeader("Content-type"));
		 
		 System.out.println("Successfully completed.....");
		 
		// 2nd way  BDD Approach
		 
		 System.out.println("2nd way.......");
	        RestAssured.baseURI = "https://reqres.in/api";
	        
//	        JSONObject js = new JSONObject();
//	        js.put(response, js);

	     String res = given()

	                .when().get("/users/2")
	                .then().statusCode(200).log().body()
	                 .body("data.email",equalTo("janet.weaver@reqres.in"))
	               .extract().response().asString();
	              
	     
	        JsonPath js =new JsonPath(res);
            String id  = js.getString("data.id");
	        System.out.println(id);
	        String email  = js.getString("data.email");
	        System.out.println(email);
	        String url = js.getString("support.url");
	        System.out.println(url);
		 
		    System.out.println("successfully completed.....");
	        
		// 3rd way
	        System.out.println("3rd way.......");
		 RestAssured.baseURI = "https://reqres.in/api/users/2";
		 RequestSpecification http = RestAssured.given();
		 Response res1 = http.request(Method.GET);
		 
		// JSONObject js =new JSONObject();
		 
		 String responseBody = res1.getBody().asString();
		 System.out.println(responseBody);
		 
		 int statuscode = res1.getStatusCode();
		 System.out.println(statuscode); 
		 
		 Assert.assertEquals(statuscode,200);
		  
		  System.out.println("successfully completed.....");
	    }
	 
	   @Test
	   public void postData() {
		   
		   RestAssured.baseURI = "https://reqres.in";
		   
//		   HashMap<String, Object> map = new HashMap<String,Object>();
//		   
//		   map.put("name","Aman");
//		   map.put("job","Tester");
		   
		JSONObject req = new JSONObject();
		req.put("name","Aman");
		req.put("job","Tester");
		
		
		
		   System.out.println(req.toJSONString());
		   
		String data =   given().header("Content-Type","application/json")
		   .body(req.toJSONString())
		  .when().post("/api/users")
		  .then().statusCode(201).log().all().extract().response().asString();
		
		JsonPath path = new JsonPath(data);
		System.out.println(path.get("id"));
		System.out.println(path.get("createdAt"));
		
	   }
	   
	   @Test
	   public void putData() {
		   
		   RestAssured.baseURI = "https://reqres.in";
		   
//		   HashMap<String, Object> map = new HashMap<String,Object>();
//		   
//		   map.put("name","Aman");
//		   map.put("job","Tester");
		   
		JSONObject req = new JSONObject();
		req.put("name","Aman");
		req.put("job","Tester");
		
		
		
		   System.out.println(req.toJSONString());
		   
		String data =   given() .header("Content-Type","application/json")
		   .body(req.toJSONString())
		  .when().put("/api/users/2")
		  .then().statusCode(200).log().all().extract().response().asString();
		
		JsonPath path = new JsonPath(data);
	//	System.out.println(path.get("id"));
		System.out.println(path.get("updatedAt"));
		System.out.println(path.get("name"));
	   }
	   
	   @Test
	   public void patchData() {
		   
		   RestAssured.baseURI = "https://reqres.in";
		   
//		   HashMap<String, Object> map = new HashMap<String,Object>();
//		   
//		   map.put("name","Aman");
//		   map.put("job","Tester");
		   
		JSONObject req = new JSONObject();
		req.put("name","Aman");
		req.put("job","Tester");
		
		
		
		   System.out.println(req.toJSONString());
		   
		String data =   given() .header("Content-Type","application/json")
		   .body(req.toJSONString())
		  .when().patch("/api/users/2")
		  .then().statusCode(200).log().all().extract().response().asString();
		
		JsonPath path = new JsonPath(data);
	//	System.out.println(path.get("id"));
		System.out.println(path.get("updatedAt"));
		System.out.println(path.get("name"));
	   }
	   
	   @Test
	   public void deleteData() {
		   
		   RestAssured.baseURI = "https://reqres.in";
		   
//		   HashMap<String, Object> map = new HashMap<String,Object>();
//		   
//		   map.put("name","Aman");
//		   map.put("job","Tester");
//		   
//		JSONObject req = new JSONObject();
//		req.put("name","Aman");
//		req.put("job","Tester");
//		
//		
//		
//		   System.out.println(req.toJSONString());
//		   
		String data =   given()
		//   .body(req)
		  .when().delete("/api/users/2")
		  .then().statusCode(204).log().all().extract().response().asString();
		
		JsonPath path = new JsonPath(data);
		System.out.println(path);
	//	System.out.println(path.get("id"));
	//	System.out.println(path.get("updatedAt"));
		
	   }
}
