package demo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Demo5_BasicValidation_JSON {
	
    ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	
	
	// Test Status Code
	
	private static final TimeUnit SECOUNDS = null;

	@Test(priority=1)
	public void testStatusCode() {
		
		ExtentTest test = extent.createTest("Verify");
		
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200);
	}
	
	// Log Response
	
	@Test(priority=2)
	public void testLogging() {
		
		ExtentTest test = extent.createTest("Simple");
		
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     log().all();
		
	}
	
	// Verify single content in response body
	
	@Test(priority=3)
	public void testSingleContent() {
		
		ExtentTest test = extent.createTest("Simple");
		
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     body("data[0].first_name", equalTo("Michael"));
	}
	
	// Verify multiple content in response body
	
	@Test(priority=4)
	public void testMultipleContent() {
		
		ExtentTest test = extent.createTest("Simple");
		
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron"));
	}
	
	

	// Setting parameters and headers
	
	@Test(priority=5)
	public void testParamersAndHeaders() {
		
		ExtentTest test = extent.createTest("Simple");
		
		given().
		     param("MyName", "Kalpesh").
		     header("MyHeader", "Indian").
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     body("data[0].first_name", equalTo("Michael"));	
	}
	
	@Test(priority=6)
	public void verifyTime() {
		
		ExtentTest test = extent.createTest("Simple2");
	
		given().
		when().
		     get("https://reqres.in/api/users?page=2").
		then().
		time(lessThan(200L), TimeUnit.MILLISECONDS);
	//	     time(lessThan(4000L));
	//	time(lessThan(2), TimeUnit.SECONDS);
	}
	
	@Test(priority=7)
	public void verifyTime1() {
		
		ExtentTest test = extent.createTest("Simple");
		
		Response response = (Response) RestAssured.given().baseUri("https://reqres.in/api/users?page=2").get();
		
		long responseTimeInMS = response.time();
		System.out.println("Response time in MS: "+responseTimeInMS);
		
		long responseTimeInS = response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response time is secounds: "+responseTimeInS);
		
		response.then().time(lessThan(2000L));
		response.then().time(greaterThan(200L));
		
		response.then().time(both(greaterThan(200L)).and(lessThan(2000L)));
		
		response.then().time(lessThan(2L), TimeUnit.SECONDS);
		
		response.then().time(lessThan(500L), TimeUnit.MILLISECONDS);
		
	}
	
		
    @Test(priority=8)
    public void verifyJSONArray() {
    	
    	ExtentTest test = extent.createTest("Simple");
    	
    	// To verify response is a JSON Array i.e. List
    	
    	given().
    	when().
    	     get("https://run.mocky.io/v3/58a5ff14-7dd9-4adf-bf81-24828b172fab").
    	then().
    	     body("", Matchers.instanceOf(List.class));
    	
		
	}
    
    
    @Test(priority=9)
    public void verifyJSONObject() {
    	
    	ExtentTest test = extent.createTest("Simple");
    	
    	// To verify response is a JSON Object i.e. Map
    	
    	given().
    	when().
    	     get("https://run.mocky.io/v3/fabdf1cf-78e8-403e-90f7-c1a13764d56a").
    	then().
    	     body("", Matchers.instanceOf(Map.class));
    	
    }
    
    @Test(priority=10)
    public void verifyPartOfResponse() {
    	
    	ExtentTest test = extent.createTest("Simple");
    	
    	// To verify part of response is a JSON Array i.e. List
    	
    	given().
    	when().
    	    get("https://run.mocky.io/v3/7f76ecc8-ba18-4c8d-9398-48878eb46352").
    	then().
    	    body("mob", Matchers.instanceOf(List.class));
    	
    	
    }
    
    @BeforeTest
    public void beforeTest() {
    	
    	
    	spark.config().setTheme(Theme.DARK);
    	spark.config().setDocumentTitle("MyReport");
    	extent.attachReporter(spark);
    	
		
	}
	
	@AfterTest
	public void afterTest() {
		
		extent.flush();
		
	}
    
    
    
	

	
	
	
	}
	
	
	
	
	
	
	
	
	
	

