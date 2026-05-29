package faker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import net.datafaker.*;
import pojo.User;
import utils.UserDataPetStore;

public class FakerTest {

	
//	@Test
	public void basicFaker() {
		
		Faker faker=new Faker();
		System.out.println(faker.name().firstName());
		System.out.println(faker.internet().emailAddress());
	}
	
	@Test
	public static void petSwag() {
		
		List<User> users=UserDataPetStore.createUsers(2);//classname.methodname
		
		given()
		.baseUri("https://petstore.swagger.io/v2")
		.header("Content-Type","application/json")
		.body(users)
		
		.when()
		.post("/user/createWithList")
		
		.then()
		.statusCode(200)
		.log().all()
		;
	}
	
}
