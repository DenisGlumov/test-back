package home3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddAndDeleteShoppingList extends AbstractTest{

    @BeforeAll
    static void assuredTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void postAddAndDeleteShoppingList () {
        given()
                .contentType("application/json")
                .queryParam("apiKey", getApikey())
                .queryParam("hash", "e11170b8cbd2d74102651cb967fa28e5")
                .queryParam("username", "den.glumov")
                .body("{\n" +
                        "\t\"item\": \"TestGlimov01\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .when()
                .post(getBaseUrl()+"/mealplanner/den.glumov/shopping-list/items")
                .then()
                .statusCode(200);


    }
}
