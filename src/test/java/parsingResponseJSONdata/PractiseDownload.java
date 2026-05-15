package parsingResponseJSONdata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PractiseDownload {

	@Test
	public void downloadFileTest() throws IOException {
        // 1. Send GET request to a public image URL
        Response response = RestAssured.given()
        .when()
            .get("https://httpbin.org/image/png") // This API returns a simple PNG image
        .then()
            .statusCode(200)
            .extract().response();

        // 2. Convert response to byte array
        byte[] bytes = response.asByteArray();

        // 3. Define where to save the file on your Mac
        File downloadedFile = new File(System.getProperty("user.dir") + "/Resources/downloaded_image.png");

        // 4. Use Java Files utility to write the bytes to the disk
        Files.write(downloadedFile.toPath(), bytes);

        // 5. Assertions (Interviewers love this part!)
        System.out.println("File downloaded to: " + downloadedFile.getAbsolutePath());
        Assert.assertTrue(downloadedFile.exists(), "File was not downloaded!");
        Assert.assertTrue(downloadedFile.length() > 0, "Downloaded file is empty!");//check downloaded file >0KB
    }
}
