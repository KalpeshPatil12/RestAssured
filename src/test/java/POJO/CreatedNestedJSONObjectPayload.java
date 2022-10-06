package POJO;

import io.restassured.RestAssured;

public class CreatedNestedJSONObjectPayload {

	public static void main(String[] args) {
		
		Emp emp = new Emp();
		
		emp.setFirstName("Kalpesh");
		emp.setLastName("Patil");
		emp.setEmail("jdjjd@gmail.com");
		
		Address address = new Address();
		address.setHouseNumber(560);
		address.setCity("Jalgaon");
		address.setState("Maharastra");
		address.setCountry("India");
		
		emp.setAddress(address);
		
		RestAssured.given().log().all().body(emp).post();

	}

}
