package demo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Demo1_GET_Request {
	
	
	@Test
	public void getWeatherDetails() {
		
		String path = System.getProperty("user.dir"); 
		String Extentreppath = path+
		
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
