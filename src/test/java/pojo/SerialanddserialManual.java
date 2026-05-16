package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialanddserialManual {

	@Test
	public void manualSerializationDeserialization() throws JsonProcessingException {
		
		Order order=new Order();
		order.setId(1);
		order.setPetid(100);
		order.setQuantity(3);
		order.setShipdate("2026-05-16T12:07:14.786Z");
		order.setStatus("placed");
		order.setComplete(true);
		
		ObjectMapper mapper=new ObjectMapper();//import com.fasterxml.jackson.databind.ObjectMapper;
		
		//Manual Serialization
		String orderjson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
		System.out.println("Serialized JSON:\n"+orderjson);
		
		//Manual deserialization
		Order deserializedOrder=mapper.readValue(orderjson, Order.class);
		System.out.println("Deserialized Order Status:"+deserializedOrder.getStatus());
		
	}
}
