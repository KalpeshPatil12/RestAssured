package tests;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLSchemaValidator {
	
	@Test
	public void XMLSchemaValidator() throws IOException  {
		
		File file = new File("D:\\Appzlogic\\Add(2).xml");
		
		if(file.exists())
		System.out.println("File Exists");
		
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		
		given().
		     contentType("test/xml").
		     accept(ContentType.XML).
		     body(requestBody).
		when().
		     post("/calculator.asmx").
		then().
		     statusCode(200);
//		     log().
//		     all().
//		     and().
//		     body("//*:AddResult.text()", equalTo("5")).and().
//		     assertThat().
//		     body(RestAssuredMatchers.matchesXsdInClasspath("Calculator.xsd"));
		
			
		
	}

}
