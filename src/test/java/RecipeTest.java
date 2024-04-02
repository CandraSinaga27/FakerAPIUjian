import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.hamcrest.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Test Meal Plan")
public class RecipeTest extends BaseTest2 {
    String apiKey = "84834bb3cc554ce68998372034271ce3";
    String hash = "01a4d4bab106327462e8c4b15156b39f713c0619";
    String username = "candra0";

    @Test(description = "Search Recipes")
    public void SearchReceipes() {
        given()
                //header
                .queryParam("apiKey", apiKey)
                .log().ifValidationFails()
                .when()
                //baseURL
                .get("complexSearch")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("results.size()", equalTo(10));
    }

    @Test(description = "Analyze Recipe")
    public void AnalyzeRecipe() {
            String requestBody = "{\n" +
                    "    \"title\": \"Spaghetti Carbonara\",\n" +
                    "    \"servings\": 2,\n" +
                    "    \"ingredients\": [\n" +
                    "        \"1 lb spaghetti\",\n" +
                    "        \"3.5 oz pancetta\",\n" +
                    "        \"2 Tbsps olive oil\",\n" +
                    "        \"1  egg\",\n" +
                    "        \"0.5 cup parmesan cheese\"\n" +
                    "    ],\n" +
                    "    \"instructions\": \"Bring a large pot of water to a boil and season generously with salt. Add the pasta to the water once boiling and cook until al dente. Reserve 2 cups of cooking water and drain the pasta. \"\n" +
                    "}";
            given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .queryParam("apiKey", apiKey)
                    .body(requestBody)
                    .log().ifValidationFails()
                    .when()
                    //baseURL
                    .post("analyze")
                    .then()
                    .log().ifValidationFails()
                    .statusCode(200)
                    .body("title", equalTo("Spaghetti Carbonara"));
        }

    @Test(description = "findByIngredients")
    public void findByIngredients() {
        given()
                //header
                .queryParam("apiKey", apiKey)
                .log().ifValidationFails()
                .when()
                //baseURL
                .get("findByIngredients")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("usedIngredients.size()", equalTo(0));
    }
}