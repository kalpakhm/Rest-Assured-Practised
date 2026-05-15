package fileUploadDownload;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;





public class DownloadFile {
	
	@Test
	public void fileDownload() throws IOException {
		
		// 1. Send GET request to a public image URL	
		Response res=
		given()
		
		.when()
		.get("https://httpbin.org/image/png") // This API returns a simple PNG image
		
		.then()
		.statusCode(200)
		.extract().response();
		
		// 2. Convert response to byte array
		byte[] bytes = res.asByteArray();
		
		// 3. Define where to save the file on your Mac
		File downloaded_file = new File(System.getProperty("user.dir")+"/Resources/downloaded_image.png");
		
		// 4. Use Java Files utility to write the bytes to the disk
		Files.write(downloaded_file.toPath(),bytes);
		
		// 5. Assertions (Interviewers love this part!)
		System.out.println("File downloaded to : "+ downloaded_file.getAbsolutePath());
		Assert.assertTrue(downloaded_file.exists(), "File was not Downloaded");
		Assert.assertTrue(downloaded_file.length()>0, "Downloaded file is Empty");//check downloaded file >0KB
	}
	
	
	
}
