package restAssuredTests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class createPostTest {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";

    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("bar", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));

        System.out.println("Status code is: "+response.statusCode());
        System.out.println("title is: " + response.jsonPath().getString("title") );
        System.out.println("body is: " + response.jsonPath().getString("body") );
        System.out.println("userId is: " + response.jsonPath().getString("userId"));
        System.out.println("id is: " + response.jsonPath().getString("id"));
    }

}
