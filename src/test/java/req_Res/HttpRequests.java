package req_Res;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;
/*
 * given()
 * contenttype,set cookies,and auth,add params,set headers info etc....
 * when()
 * requests likes get,post,put,delete
 * then()
 * validations status code,extract response, extract header cookies & response body
 * */

public class HttpRequests {

	@Test
	public void inventory() {
		
		given()
		
		.when()
		.get("https://petstore.swagger.io/v2/store/inventory")
		
		.then()
		.statusCode(200)
		.body("available", greaterThan(0))//equalTo()
		.log().all();
	}
	
	@Test
	void createWithList() {
		
		LinkedHashMap<String,Object> data=new LinkedHashMap<>();
		data.put("id",0);
		data.put("username","kalpak");
		data.put("firstName","hm");
		data.put("lastName","shetty");
		data.put("password","1234");
		data.put("phone","123456789");
		data.put("userStatus",0);
	
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://petstore.swagger.io/v2/user")
	
	.then()
	.statusCode(200)
	.body("code", equalTo(200))
	.log().all();
	}
	
	
	
	
}
