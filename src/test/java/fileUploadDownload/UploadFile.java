package fileUploadDownload;

import  org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class UploadFile {

	@Test
	public void fileUpload() {
		
		 // 1. Prepare the file (ensure this file exists in your project)
        // TIP: Use System.getProperty("user.dir") so it works on your Mac and any other machine
       
		
		File file_path=new File(System.getProperty("user.dir")+"/Resources/test_upload.txt");
		
		
		given()
		.multiPart("file",file_path) // "file" is the key name httpbin expects
		.log().all()  // This shows you the request details in the console

		.when()
		.post("https://httpbin.org/post")
		
		.then()
		.log().all() // This shows you the server's response
		.statusCode(200)
		.body("files.file", notNullValue()); // Verify the server received the file
		
	}
	
}
