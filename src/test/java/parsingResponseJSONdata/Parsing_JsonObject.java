
package parsingResponseJSONdata;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Parsing_JsonObject {

	//using JSONObject class  json and path dependencies 
	
	
	@Test(priority=1)
	public void JSONObject_all() {
		
		Response res=
		given()
		.header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
		.contentType("application/json")
		
		.when()
		.get("https://reqres.in/api/products?page=1");
		
		
		JSONObject jo=new JSONObject(res.asString());//converting response to JSONObject 
		
		//to print all the name  of data
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			String name=jo.getJSONArray("data").getJSONObject(i).get("name").toString();
			System.out.println(name);
		}
		
		
		
		
	}
	
	@Test(priority=2)
	//search for the name "aqua sky" in the data
	public void JSONObject_search_name() {
		
		Response res=
				given()
				.header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
				.contentType("application/json")
				
				.when()
				.get("https://reqres.in/api/products?page=1");
				
			JSONObject	jo=new JSONObject(res.asString());//converting response  json object  
			
			boolean status=false;
			for(int i=0;i<jo.getJSONArray("data").length();i++) {
				
				String name=jo.getJSONArray("data").getJSONObject(i).get("name").toString();
				if(name.equals("aqua sky")) {
					status=true;
					break;
				}
				
			}
			
			Assert.assertEquals(status, true,"name not found");
			
		
	}
	
	
	
	//validate the total value
	@Test(priority=3)
	public void JSONObject_total() {
		
		Response res=
				given()
				.header("x-api-key","pub_4e471ae2a0aa521f23c3b16bc00605b2")
				.contentType("application/json")
				
				.when()
				.get("https://reqres.in/api/products?page=1");
			
		
		JSONObject jo = new JSONObject(res.asString());//since response started as object
	//	JSONArray  ja=new JSONArray(res.asString());//if  response started as array
		
		double total_value=0;
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			
			String string_value=jo.getJSONArray("data").getJSONObject(i).get("pantone_value").toString();
			
			 String last_4_digit=string_value.substring(string_value.length()-4);
			
			total_value=total_value+Double.parseDouble(last_4_digit);
			
		}
		
		System.out.println("the total value : "+total_value);
		
		
	}
	
	
	
	
}
