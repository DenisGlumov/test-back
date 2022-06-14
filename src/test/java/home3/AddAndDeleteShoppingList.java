package home3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class AddAndDeleteShoppingList extends AbstractTest {

    Integer numberId;

    @BeforeAll
    static void assuredTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void postAddAndDeleteShoppingList() {

        given().spec(requestSpecificationShoppingList)
                .body("{\n" +
                        "\t\"item\": \"TestGlimov01\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .when()
                .post(getBaseUrl() + "/mealplanner/88c3f9fa-a337-4a33-9057-ec74b43a0ac9/shopping-list/items")
                .then()
                .spec(responseSpecification);


        numberId = given().spec(requestSpecificationShoppingList)
                .when()
                .get(getBaseUrl() + "/mealplanner/88c3f9fa-a337-4a33-9057-ec74b43a0ac9/shopping-list")
                .body()
                .jsonPath()
                .get("aisles[0].items[0].id");
    }

    @AfterEach
    void tearDown() {
        given().spec(requestSpecificationShoppingList)
                .pathParam("id", numberId)
                .when()
                .delete(getBaseUrl() + "/mealplanner/88c3f9fa-a337-4a33-9057-ec74b43a0ac9/templates/{id}")
                .then()
                .spec(responseSpecification);

    }
}
