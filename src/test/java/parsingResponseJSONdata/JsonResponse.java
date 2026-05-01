
package parsingResponseJSONdata;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class JsonResponse {

	//using the hamcrest mathchers 
	@Test
	public void jsonResponseHamcrest() {
		
		given()
		.header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
		
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		//.log().body()
		.body("data[0].email", equalTo("george.bluth@reqres.in"))
		.body("data[2].first_name", equalTo("Emma"))
		;
	}
	
}
