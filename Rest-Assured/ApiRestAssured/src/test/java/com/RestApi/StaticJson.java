/*package com.RestApi;

// convert the content of file into string payload data body me file name ko add krna 

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.Files.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StaticJson {
	@Test
	public void addBook() throws IOException
	{
		RestAssured.baseURI = "http://216.10.245.166";
		Response resp = given().
				header("Content-Type", "application/json").
				body(GenerateStringFromResource("C:\\Users\\rahul\\Documents\\Addbookdetails.json")).
				when().
				post("/Library/Addbook.php").
				then().assertThat().statusCode(200).
				extract().response();
		JsonPath js = new JsonPath(resp);
		String id = js.get("ID");
		System.out.println(id);

		// deleteBOok
	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
*/