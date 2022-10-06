package tests;

import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static io.restassured.RestAssured.*;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class GetAndPostExamples {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	ExtentSparkReporter spark1 = new ExtentSparkReporter("FailedTests.html");
	ExtentSparkReporter spark2 = new ExtentSparkReporter("SkipandWarning.html");
	
	
	

	@Test
	public void testGet() {
		
		ExtentTest test = extent.createTest("Simple");
		
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[0].first_name", equalTo("Michael")).body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
		
			
	}

	@Test
	public void testPost() {
		
		ExtentTest test = extent.createTest("Simple1");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Kalpesh");
//		map.put("job", "teacher");
//		
//		System.out.println(map);
//		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Kalpesh");
		request.put("job", "Teacher");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		
		given().
		body(request.toJSONString()).
		when().post("/users").
		then().
		statusCode(201).log().all();
		
		
	}
	
	@BeforeTest
	public void beforeTest() {
		
		
		
		extent.attachReporter(spark);
		extent.attachReporter(spark1);
		extent.attachReporter(spark2);
			
	}
	
	@AfterTest
	public void afterTest() {
		
		extent.flush();
	}
}
