package apichaining;

import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Users_Delete {

	@Test
	public void delete(ITestContext context) {
		
		String api_key="pro_956b088a9e89cf9197818cbd3bc9e4b67569cbc388f83f60";
		//String id=(String) context.getAttribute("id");
		String id=(String) context.getSuite().getAttribute("id");//available in the suite level

		given()
		.baseUri("https://reqres.in")
		.basePath("/api/collections/users/records/{id}")
		.pathParam("id", id)
		.queryParam("project_id", 5791)
		.header("x-api-key",api_key)
		.contentType("application/json")
		.log().all()
		
	.when()
	.delete()
	
	.then()
	.statusCode(204);
	
	
	}
	
}
