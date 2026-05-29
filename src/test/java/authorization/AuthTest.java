package authorization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


import org.testng.annotations.Test;


public class AuthTest {

	@Test
	public void premptivebasicAuth() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
		}
	
	@Test
	public void testDigestAuth() {
		
		given()
		.auth().digest("postman", "password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
		}

}

