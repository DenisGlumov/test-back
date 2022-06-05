package home3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RecipesCuisine extends AbstractTest{

    @Test
    void postRecipesCuisine () {
        given()
                .queryParam("apiKey", getApikey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Pork roast with green beans")
                .formParam("language", "de")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","borsch")
                .formParam("language", "en")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .formParam("ingredientList", "2 liters of milk")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApikey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .formParam("ingredientList", "2 ml rum")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .statusCode(200);

    }

}
