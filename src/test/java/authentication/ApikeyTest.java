package authentication;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ApikeyTest {

	
	@Test
	public void testwithapikeyqueryparam() {
		
		String apikey="14c65cffdb9f9e547a32ef0b519287b7";
		String city="Bengaluru";
		
		given()
		.queryParams("appid", apikey)
		.queryParam("q", city)
		
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
		
		.then()
		.body("name",equalTo(city))
		.body("weather[0].description", notNullValue())
		.statusCode(200)
		.log().all();
		
	}
	
}
