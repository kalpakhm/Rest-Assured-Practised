package authorization;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class BearerToken {

	@Test
	public void testBearerTokenAuthentication() {
		
		String Bearertoken="bearertoken";
		
		given()
		.header("Authorization","Bearer "+Bearertoken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(401)//Expected to be 200 since data is secured 
		.log().all();
		
		}
	@Test
	void testOAuth2() {
		
		given()
		.auth().oauth2("ghp_24pH0Icz1PKHC1q0tLwj57AuDYmtSz2fuYKP")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(401)////Expected to be 200 since data is secured 
		.log().body();
	}
}
