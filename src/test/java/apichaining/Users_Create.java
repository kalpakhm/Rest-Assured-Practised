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

public class Users_Create {

	static int project_id;
	@Test
	public void create(ITestContext context) {
		
		Faker faker =new Faker();
		
		//profile object
		Map<String,Object> profile=new HashMap();
		profile.put("age", faker.number().numberBetween(20, 50));
		profile.put("company", faker.company().name());
		profile.put("location", faker.address().cityName());
		
		//skills List
		List<String>  skills=Arrays.asList(
				 faker.job().keySkills(),
				 faker.programmingLanguage().name(),
				 "Automation Testing"
				 );
		
		//data objects 
		Map<String,Object>data=new HashMap();
		data.put("first_name", faker.name().firstName());
		data.put("last_name", faker.name().lastName());
		data.put("email", faker.internet().emailAddress());
		data.put("role", faker.job().title());
		data.put("skills", skills);
		data.put("profile", profile);
		
		//final request body
		Map<String,Object> requestbody=new HashMap();
		requestbody.put("data", data);
		
		
		String api_key="pro_956b088a9e89cf9197818cbd3bc9e4b67569cbc388f83f60";
		
		//Api call		
		
		Response response=
		given()
		.baseUri("https://reqres.in")
		.basePath("/api/collections/users/records")
		.queryParam("project_id", "5791")
		.header("x-api-key",api_key)
		.contentType("application/json")
		.body(requestbody)
		.log().ifValidationFails()//logs everything if test vlidation fails
		
		.when()
		.post()
		
		.then()
		.statusCode(201)
		.extract().response();
		
		//response.prettyPrint();
		//response.statusCode();
		
		String projectid=response.jsonPath().getString("data.id");
		Assert.assertNotNull(projectid, "Project ID extraction failed! Response structure might have changed.");

		//store project_id in context
		context.setAttribute("id", projectid);
		
		System.out.println("Extracted  ID for Chaining is : "+projectid);
		
		
	}
	
}
