package com.RestApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class SoapApi {

	@Test
	public void xmlSoapApi() {
		
		RestAssured.baseURI = "http://www.dneonline.com";
		
		given().contentType("text/xml").accept(ContentType.XML)
		.body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <a>2</a>\r\n"
				+ "      <b>4</b>\r\n"
				+ "    </Add>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>")
		  .when().post("/calculator.asmx") 
		  
		  .then().statusCode(200).log().body();
	}
}
