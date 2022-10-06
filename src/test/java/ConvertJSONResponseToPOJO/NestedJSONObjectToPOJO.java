package ConvertJSONResponseToPOJO;

import io.restassured.RestAssured;

public class NestedJSONObjectToPOJO {

	public static void main(String[] args) {
		
		EmployeeWithAddress employee = RestAssured.get("https://run.mocky.io/v3/97920f35-a192-4814-ac1b-a05431994a13").as(EmployeeWithAddress.class);
		
		//String fn = employee.getFirstname();
		//System.out.println(fn);
		
		Address address = employee.getAddress();
		System.out.println(address);
		
		System.out.println(employee.getAddress().getCity());

	}

}
