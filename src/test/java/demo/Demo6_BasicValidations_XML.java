package demo;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.RestAssured.*;


public class Demo6_BasicValidations_XML {

	// Verifying so=ingle content in XML Response
	
	@Test(priority=1)
	public void testSingleContent() {
		
		given().
		when().
		     get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/").
		then().
		     body("CUSTOMER.ID", equalTo("15")).
		     log().all();
		
	}
	
	// Verifying multiple content in XML Response
	
	@Test(priority=2)
	public void testMultipleContent() {
		
		given().	
		when().
		     get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/").
		then().
		     body("CUSTOMER.ID", equalTo("15"))
		     .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		     .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		     .body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		     .body("CUSTOMER.CITY", equalTo("Seattle"));
		
	}
	
	// Verifying all content in XML response in one go
	
	@Test(priority=3)
	public void testMultipleContentInOneGo() {
		
		given().
		when().
		      get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/").
		then().
		      body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
		     
	}
	
	// Find values using XML path in XML response
	
//	@Test(priority=4)
//	public void testUsingXMLPath() {
//		
//		given().
//		when().
//		     get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/").
//		then().
//		     body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
//	}
//
//	@Test()
//	public void testUsingXPath() {
//		
//		given().when().get("http://thomas-bayer.com/sqlrest/INVOICE/").then().body(hasXPath("/INVOICEList/INVOICE[test()='30']"))
//	}
//	
	
	
	
	
	
	
	
	
	
}
