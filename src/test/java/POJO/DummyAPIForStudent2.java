package POJO;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class DummyAPIForStudent2 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
		s1.setAccountNo(23150);
		s1.setBalance(85300);
		s1.setEmail("ajdjd@gmail.com");
		s1.setFirst_name("Kalpesh");
		s1.setLast_name("Patil");
		s1.setGender("male");
		
		Student s2 = new Student();
		
		s2.setAccountNo(23150);
		s2.setBalance(85300);
		s2.setEmail("ajdjd@gmail.com");
		s2.setFirst_name("Kalpesh");
		s2.setLast_name("Patil");
		s2.setGender("male");
		
		List<Student> jsonArrayStudent = new ArrayList<Student>();
		jsonArrayStudent.add(s1);
		jsonArrayStudent.add(s2);
		
		
		RestAssured.given().log().all().body(jsonArrayStudent).when().get();		
	}

}
