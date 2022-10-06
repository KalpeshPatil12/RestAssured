package demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DemoRequest {
	
	@Test
	public void getWeatherDetails() {
		
		given().contentType(ContentType.JSON).
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     statusLine("HTTP/1.1 200 OK").
		    // assertThat().body("id", equalTo("7")).
		     header("Content-Type", "application/json; charset=utf-8");
		
		
	}
	
	

}
