package home3;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;

public class AddAndDeleteShoppingList extends AbstractTest {

    @BeforeAll
    static void assuredTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void postAddAndDeleteShoppingList() {

        given()
                //.contentType("application/x-www-form-urlencoded")
                .queryParam("apiKey", getApikey())
                .queryParam("hash", "4cff46e48bc0b34aa67e096741b1339d9f05d2c4")
                .queryParam("username", "88c3f9fa-a337-4a33-9057-ec74b43a0ac9")
                .body("{\n" +
                        "\t\"item\": \"TestGlimov01\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .when()
                .post(getBaseUrl() + "/mealplanner/88c3f9fa-a337-4a33-9057-ec74b43a0ac9/shopping-list/items")
                .then()
                .statusCode(200);


        String id = given()
                .queryParam("apiKey", getApikey())
                .queryParam("hash", "4cff46e48bc0b34aa67e096741b1339d9f05d2c4")
                .queryParam("username", "88c3f9fa-a337-4a33-9057-ec74b43a0ac9")
                .when()
                .get(getBaseUrl() + "/mealplanner/88c3f9fa-a337-4a33-9057-ec74b43a0ac9/shopping-list")
                .body()
                .jsonPath()
                .get("id")
                .toString();


    }
}
