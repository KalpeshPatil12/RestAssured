package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JSONSchemaValidator {
	
    ExtentReports extent = new ExtentReports();
	
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	

	@Test
	public void testGet() {
		
		ExtentTest test = extent.createTest("Simple");
		
		baseURI = "https://reqres.in/api";
		
		given().
		     get("/users/2").
		then().
		     assertThat().
		     body(matchesJsonSchemaInClasspath("schema.json")).
		     statusCode(200).
		     body("data.email", equalTo("janet.weaver@reqres.in")).
		     body("data.first_name", equalTo("Janet")).
		     body("data.last_name", equalTo("Weaver"));
		
	}
	
	@Test
	public void testGET() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/unknown/2").
		    
		then().
		     assertThat().
		     body(matchesJsonSchemaInClasspath("schema1.json")).
		     statusCode(200);
		
	}
	
	
	@BeforeTest
	public void beforeTest() {
		
		extent.attachReporter(spark);
			
	}
	
	@AfterTest
	public void afterTest() {
		
		extent.flush();
	}
	

}
