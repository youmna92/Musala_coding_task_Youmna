package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostByIdTest {


    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void secondGetAPI(){

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        System.out.println("response status code is: " + response.statusCode());
        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                response.jsonPath().getString("title"));
        System.out.println("user title is: " + response.jsonPath().getString("title"));


    }
}
