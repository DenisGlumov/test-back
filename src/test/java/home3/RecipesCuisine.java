package home3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RecipesCuisine extends AbstractTest{

    @Test
    void postRecipesCuisine () {
        Response response = given().spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Pork roast with green beans")
                .formParam("language", "de")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);


        given().spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","borsch")
                .formParam("language", "en")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        given().spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        given().spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .formParam("ingredientList", "2 liters of milk")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        given().spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","eggs")
                .formParam("language", "en")
                .formParam("ingredientList", "2 ml rum")
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .spec(responseSpecification);

    }


}
