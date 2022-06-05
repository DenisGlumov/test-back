package home3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ComplexSearch extends AbstractTest {

    @Test
    void getComplexSearch() {
        given()
                .queryParam("apiKey", getApikey())
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .queryParam("query", "pasta")
                .queryParam("equipment", "pan")
                .queryParam("excludeIngredients", "eggs")
                .queryParam("fillIngredients", "false")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .queryParam("maxCarbs", "100")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .queryParam("excludeCuisine", "greek")
                .queryParam("intolerances", "gluten")
                .queryParam("includeIngredients", "tomato,cheese")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .queryParam("excludeCuisine", "greek")
                .queryParam("intolerances", "gluten")
                .queryParam("excludeIngredients", "eggs")
                .queryParam("instructionsRequired", "true")
                .queryParam("titleMatch", "Crock Pot")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200);
    }


}
