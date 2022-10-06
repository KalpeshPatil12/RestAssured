package demo;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo3_Punt_Request {
	
	public static HashMap map = new HashMap();
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	int emp_id= 11254;
	
	@BeforeClass
	public void putData() {
		
		map.put("name", empName);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
		
	}
	
	@Test
	public void testPut() {
		
		given().contentType("application/json").body(map).when().put().then().statusCode(403).log().all();
	}

}
