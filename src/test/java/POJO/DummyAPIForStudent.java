package POJO;

import io.restassured.RestAssured;

public class DummyAPIForStudent {

	public static void main(String[] args) {
		
		Student s = new Student();
		
		s.setAccountNo(23150);
		s.setBalance(85300);
		s.setEmail("ajdjd@gmail.com");
		s.setFirst_name("Kalpesh");
		s.setLast_name("Patil");
		s.setGender("male");
		
		RestAssured.given().log().all().body(s).when().get();		
	}

}
