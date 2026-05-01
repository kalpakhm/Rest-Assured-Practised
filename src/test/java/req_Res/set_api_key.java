package req_Res;
import static  io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class set_api_key {
	
	@Test(priority=1)
	public void getusers() {
		//https://reqres.in/api/users?page=2
		
		given().header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
		.pathParam("mypath", "users")
		.queryParams("page", "2","id","2")
		
		.when().get("https://reqres.in/api/{mypath}")
		
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=2)
	void postData() {
		
		HashMap<String,Object> data=new HashMap();
				data.put("name", "kavana");
		data.put("job", "engineer");
		
		given().contentType("application/json").header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2").body(data)
		
		.when().post("https://reqres.in/api/users")
		
		.then().statusCode(201).log().all();
		
	}
	

	@Test(dependsOnMethods = {"postData"} )
	void updateData() {
		
		HashMap<String,Object> data=new HashMap();
				data.put("name", "kalpana gowda");
		data.put("job", "engineer");
		
		given().contentType("application/json").header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2").body(data)
		
		.when().put("https://reqres.in/api/users/2")
		
		.then().statusCode(200).log().all();
		
	}
	
	
	

	@Test(dependsOnMethods= {"updateData"})
	void deleteData() {
		
	
		given().contentType("application/json").header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
		
		.when().delete("https://reqres.in/api/users/2")
		
		.then().statusCode(204).log().all();
		
	}
	
}
