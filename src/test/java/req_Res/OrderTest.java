package req_Res;

import pojo.Order;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

@Test
public class OrderTest {

	public void createOrderUsingPojo() {
		
		Order order=new Order();
		order.setId(1);
		order.setPetid(12);
		order.setQuantity(20);
		order.setShipdate("2026-03-15T14:58:36.242Z");
		order.setStatus("placed");
		order.setComplete(true);
		
	given().contentType("application/json").body(order)
	
	.when()
	.post("https://petstore.swagger.io/v2/store/order")
	
	.then()
	.statusCode(200)
	.body("status", equalTo("placed"))
	.log().all();
		
	}
}
