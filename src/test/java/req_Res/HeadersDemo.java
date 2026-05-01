package req_Res;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import static org.testng.Assert.assertListContainsObject;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test
	void headerdemo() {
		//Response res=
		
		when()
		.get("https://www.google.com/")
		
		.then()
		.log().headers()
		.header("Server","gws")
		.header("Content-Type",containsString("text/html"));
		//.extract().response();
		//System.out.println("the header content type :"+res.getHeader("Content-Type"));
		
		}
	
	//@Test(priority=2)
	void headersdemo() {
		Response res=
		
		when()
		.get("https://www.google.com/")
		
		.then()
		.log().headers()
		.extract().response();
		
	Headers	allHeaders=res.getHeaders();
	
	for(Header h:allHeaders) {
		System.out.println("HeaderName "+h.getName()+"------>"+h.getValue());
	}
		}
	
}
