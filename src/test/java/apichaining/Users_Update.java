package apichaining;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import net.datafaker.Faker;

public class Users_Update {

	
	@Test
	public void update(ITestContext context) {
		
		String api_key="pro_956b088a9e89cf9197818cbd3bc9e4b67569cbc388f83f60";

		
		Faker faker =new Faker();
		
		//String id=(String)context.getAttribute("id");
		String id=(String)context.getSuite().getAttribute("id");//available in the suite level, not in the test level
		
		
		//updated body
		Map<String,Object>data=new HashMap();
		data.put("last_name", "updated last name");
		data.put("role", "Senior SDET Engineer");
		
		//final request body
		Map<String,Object> requestbody=new HashMap();
		requestbody.put("data", data);
		
		
		
		//Api call		
		
	
		given()
		.baseUri("https://reqres.in")
		.basePath("/api/collections/users/records/{id}")
		.pathParam("id", id)
		.queryParam("project_id", "5791")
		.header("x-api-key",api_key)
		.contentType("application/json")
		.body(requestbody)
		.log().all()//logs everything if test vlidation fails
		
		.when()
		.put()
		
		.then()
		.statusCode(200)
	//	.log().all()
		;		
		
	}
	
}
