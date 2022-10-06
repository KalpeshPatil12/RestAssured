package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchAndDeleteExamples  {
	
    ExtentReports extent = new ExtentReports();
	
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	

	@Test
	public void testPut() {
				
		ExtentTest test = extent.createTest("Simple");
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Kalpesh");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   put("/users/2").
		then().
		   statusCode(200).
		   log().all();
	}
	
	@Test
	public void testPatch() {
		
		ExtentTest test = extent.createTest("Simple");
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Kalpesh");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
		   header("Content-Type", "application/json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   patch("/api/users/2").
		then().
		   statusCode(200).
		   log().all();
 	}
	
	@Test
	
	public void testDelete() {
		
		ExtentTest test = extent.createTest("Simple");
		
		baseURI = "https://reqres.in";
		
		when().delete("/api/users/2").
		then().
		   statusCode(200).
		   log().all();
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
