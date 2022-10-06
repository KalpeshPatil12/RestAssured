package demo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_1 {
	
	@Test
	public void test_1() {
		
	Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	
	System.out.println(response.getStatusCode());
	
	System.out.println(response.getTime());
	
	System.out.println(response.getBody().asString());
	
	System.out.println(response.getStatusLine());
	
	System.out.println(response.getHeader("content-type"));
	
	int statusCode = response.getStatusCode();
	
	Assert.assertEquals(statusCode, 200);
	
}
	
	@Test
	public void test_2() {
		
	//	baseURI = "https://reqres.in/api";
		
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     statusLine("HTTP/1.1 200 OK").
		     header("Content-Type", "application/json; charset=utf-8");
		
		
	}

}
