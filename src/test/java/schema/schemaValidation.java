package schema;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class schemaValidation {

	@Test
	public void validateschema() {
		System.out.println(getClass().getClassLoader().getResource("userschema.json"));

		given()
		
		.when()
		.get("https://mocki.io/v1/3d381905-170c-4e4b-ad67-e9b592c65016")
		
		.then()
		.log().all()
		.assertThat()
		
		// ✅ Schema validation
		.body(matchesJsonSchemaInClasspath("userschema.json"))
		// ✅ Basic validations
		.body("id", equalTo(1))
		.body("email", containsString("@"))
		
		// ✅ Nested validation
		.body("address.city",equalTo("New York"))
		
		 // ✅ Array validation
<<<<<<< HEAD
        .body("tags.size()", greaterThan(0))
=======
        .body("tags.size()", greaterThan(0)) //Check that array is NOT empty size=2
>>>>>>> c9e76707067e966584525190396bf056eee0b991
        .body("tags", hasItem("developer"));
	}
	
}
