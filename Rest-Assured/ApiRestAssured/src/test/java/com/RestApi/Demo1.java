package com.RestApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1 {
	@Test
	public void test() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	    System.out.println(res.getBody().asString());
        System.out.println(res.getStatusCode());
	}

}
