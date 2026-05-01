package req_Res;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class cookieDemo {

	@Test(enabled = false)
	void cookie() {
	Response res=
	
	when()
	.get("https://www.google.com/")
	
	.then()
	// Validating that the cookie exists (this will fail if the value changes)
	.cookie("AEC", containsStringIgnoringCase("Aaj"))
	.log().all()
	.extract().response();// This "fills" the 'res' variable
	
	System.out.println(res.getCookie("AEC"));
	
	}
	
	
	@Test
	void cookieMultiple() {
	Response res=
	
	when()
	.get("https://www.google.com/");
	
	Map<String,String> cookies_values=res.getCookies();
	
	System.out.println("cookies key "+cookies_values.keySet());
	
	for(String k:cookies_values.keySet()) {
		
		System.out.println(k+" "+res.getCookie(k));
	}
	
	
	}
	
}
	

