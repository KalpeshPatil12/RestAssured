package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JSONObjectPayload {
	
	@Test()
	public void jsonObjectPayload() {
		
		Map<String, Object> jsonPayload = new LinkedHashMap<String, Object>();
		
		jsonPayload.put("id", 1);
		jsonPayload.put("F_Name", "Kalpesh");
		jsonPayload.put("L_Name", "Patil");
		jsonPayload.put("Salary", 3000);
		
		RestAssured.given().log().all().body(jsonPayload).get();
		
	}
	
	@Test
	public void nestedJSONObjectPayload() {
		
        Map<String, Object> jsonObjectPayload = new LinkedHashMap<String, Object>();
		
        jsonObjectPayload.put("id", 1);
        jsonObjectPayload.put("F_Name", "Kalpesh");
        jsonObjectPayload.put("L_Name", "Patil");
        jsonObjectPayload.put("Salary", 3000);
		
		Map<String, Object> addressMap = new LinkedHashMap<String, Object>();
		
		addressMap.put("HomeNumber", 243);
		addressMap.put("City", "Jalgaon");
		addressMap.put("State", "Maharastra");
		
		jsonObjectPayload.put("address", addressMap);
		
		RestAssured.given().log().all().body(jsonObjectPayload).get();
		
	}
	
	@Test
	public void arrayPayload() {
		
		Map<String, Object> empDatails = new HashMap<String, Object>();
		empDatails.put("id", 1);
		empDatails.put("F_Name", "Kalpesh");
		empDatails.put("L_Name", "patil");
		empDatails.put("email", "jksjj");
		empDatails.put("Sal", 2000);
		
		List<Map<String, Object>> allEmp = new ArrayList<Map<String, Object>>();
		allEmp.add(empDatails);
		
		RestAssured.given().log().all().body(allEmp).get();
	}
	
	@Test
	public void convertJSONArrayResponseToList() {
		
		List<Object> allEmp = RestAssured.
				get("https://run.mocky.io/v3/13955989-52d2-4ac3-8775-61a6d13e8efb").
				as(List.class);
		
		System.out.println(allEmp.size());
	}
	
	

}
