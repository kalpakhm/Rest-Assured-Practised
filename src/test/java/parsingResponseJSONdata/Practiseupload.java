package parsingResponseJSONdata;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Practiseupload {

	@Test
	public void testFileUpload() {
        // 1. Prepare the file (ensure this file exists in your project)
        // TIP: Use System.getProperty("user.dir") so it works on your Mac and any other machine
        File file = new File(System.getProperty("user.dir") + "/Resources/test_upload.txt");

        // 2. Perform the Upload
        RestAssured.given()
            .multiPart("file", file) // "file" is the key name httpbin expects
            .log().all()             // This shows you the request details in the console
        .when()
            .post("https://httpbin.org/post")
        .then()
            .log().all()             // This shows you the server's response
            .statusCode(200)
            .body("files.file", notNullValue()); // Verify the server received the file
    }
}
