package pojo;

import pojo.Order;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest {

	Order order=new Order();//created at global level
	//REST Assured Automatic Serialization
	@Test
	public void createOrderUsingPojo() {
		
		
		order.setId(1);
		order.setPetid(12);
		order.setQuantity(20);
		order.setShipdate("2026-03-15T14:58:36.242Z");
		order.setStatus("placed");
		order.setComplete(true);
		
	given()
	.contentType("application/json")
	.body(order)  // Serialization: Java object → JSON
	
	.when()
	.post("https://petstore.swagger.io/v2/store/order")
	
	.then()
	.statusCode(200)
	.body("status", equalTo("placed"))
	.body("complete", equalTo(true))
	.log().all();
		
	}
	
	//REST Assured Automatic Deserialization
	@Test
	public void getOrderTest() {
		
		System.out.println("REST Assured Automatic Deserialization");
		Order res=
				given()
				.when()
				.get("https://petstore.swagger.io/v2/store/order/1")
				.then()
				.statusCode(200)
				.extract().as(Order.class);  // Deserialization: JSON → Java object
		
		System.out.println("order ID "+res.getId());
		System.out.println("Pet ID "+res.getPetid());
		System.out.println("Status "+res.getShipdate());
		
		Assert.assertEquals("placed", res.getStatus());
		Assert.assertTrue(res.getComplete());
		
				
		
	}
	
}
