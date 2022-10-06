package POJO;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class CreatedNestedJSONObjectPayload2 {

	public static void main(String[] args) {
		
		Emp2 emp = new Emp2();
		
		emp.setFirstName("Kalpesh");
		emp.setLastName("Patil");
		emp.setEmail("jdjjd@gmail.com");
		
		Address address = new Address();
		address.setHouseNumber(560);
		address.setCity("Jalgaon");
		address.setState("Maharastra");
		address.setCountry("India");
		
		Address address2 = new Address();
		address2.setHouseNumber(555);
		address2.setCity("Jalna");
		address2.setState("MP");
		address2.setCountry("India");
		
		List<Address> allAddress = new ArrayList<Address>();
		allAddress.add(address);
		allAddress.add(address2);
				
		
		RestAssured.given().log().all().body(emp).post();

	}

}
