package com.RestApi;

import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Files.Methods;

public class ComplexNestedJson {
	@Test
	public void test() {
		JsonPath js = new JsonPath(Methods.coursePrice()); // here call the method with class name of other package

		// print number of courses by API
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// print purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		// Print first course name
		String name = js.get("courses[0].title");
		System.out.println(name);
		System.out.println("............");

		// Print all courses title and their Price Dynamic code
		for (int i = 0; i < count; i++) {
			System.out.println(js.getString("courses[" + i + "].title"));
			System.out.println(js.get("courses[" + i + "].price"));
			System.out.println(js.get("courses[" + i + "].copies"));
			System.out.println("     ");
		}
		// Find copies of particular course
		System.out.println("total number of copies sold by RPA");
		for (int j = 0; j < count; j++) {
			String coursetitle = js.get("courses[" + j + "].title");
			if (coursetitle.equalsIgnoreCase("RPA")) {
				int countCopies = js.get("courses[" + j + "].copies");
				System.out.println(countCopies);
				break;
			}
		}
		
	// caclulate the total amount off all copies sold and compare with purchaseAmount 
		System.out.println("              ");
		int sum = 0;
		for (int i1 = 0; i1 < count; i1++) {
			int countPrice = js.get("courses[" + i1 + "].price");
			int countCpies = js.get("courses[" + i1 + "].copies");
			int total = countCpies * countPrice;

			sum = sum + total;
		}
		System.out.println(sum);

		Assert.assertEquals(sum, totalAmount);

		System.out.println("Actual amount is equal to Expected amount");

	}
}
