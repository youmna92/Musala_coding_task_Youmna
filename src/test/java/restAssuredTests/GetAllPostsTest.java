package restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetAllPostsTest  {

    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void firstGetAPI(){

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        System.out.println("response status code is: " + response.statusCode());
        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                response.jsonPath().getString("title[0]"));
        System.out.println("first user title is: " + response.jsonPath().getString("title[0]"));


    }

}
