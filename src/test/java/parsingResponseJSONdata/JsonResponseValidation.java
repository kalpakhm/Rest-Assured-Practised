
package parsingResponseJSONdata;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class JsonResponseValidation {

	//validating using the testng assertions
	@Test
	public void jsonResponseHamcrest() {
		
		Response res=
		given()
		.header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
		.contentType("application/json")
		
		.when()
		.get("https://reqres.in/api/users");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.contentType(), "application/json; charset=utf-8");
		
		String firstname = res.jsonPath().get("data[2].first_name").toString();
		
		Assert.assertEquals(firstname, "Emma");
		
		
	}
	
}
