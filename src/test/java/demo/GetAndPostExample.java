package demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class GetAndPostExample {

	@Test
	public void testGet() {
		
		given().
		get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"));
	}
}
