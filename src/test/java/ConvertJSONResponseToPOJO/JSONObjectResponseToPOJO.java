package ConvertJSONResponseToPOJO;

import io.restassured.RestAssured;

public class JSONObjectResponseToPOJO {

	public static void main(String[] args) {
		
		Employee employee = RestAssured.get("https://run.mocky.io/v3/97920f35-a192-4814-ac1b-a05431994a13").as(Employee.class);
		
		int age = employee.getAge();
		
		System.out.println(age);

	}

}
