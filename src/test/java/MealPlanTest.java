import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.hamcrest.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Test Meal Plan")
public class MealPlanTest extends BaseTest{
    String apiKey = "84834bb3cc554ce68998372034271ce3";
    String hash = "01a4d4bab106327462e8c4b15156b39f713c0619";
    String username = "candra0";
    @Test(description = "Generate MealPlan")
    public void MealPlanGenerateTest(){
        given()
                .queryParam("apiKey",apiKey)
                .log().ifValidationFails()
                .when()
                .get("generate")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("week.monday.meals.size()",equalTo(3));
    }
    @Test(description = "Add item to mealplan")
    public void AddItemToMealPlan(){
        String requestBody = "[\n" +
                "    {\n" +
                "        \"date\": 1589500800,\n" +
                "        \"slot\": 1,\n" +
                "        \"position\": 0,\n" +
                "        \"type\": \"INGREDIENTS\",\n" +
                "        \"value\": {\n" +
                "            \"ingredients\": [\n" +
                "                {\n" +
                "                    \"name\": \"1 banana\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"coffee\",\n" +
                "                    \"unit\": \"cup\",\n" +
                "                    \"amount\": \"1\",\n" +
                "                    \"image\": \"https://img.spoonacular.com/ingredients_100x100/brewed-coffee.jpg\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"date\": 1589500800,\n" +
                "        \"slot\": 2,\n" +
                "        \"position\": 0,\n" +
                "        \"type\": \"CUSTOM_FOOD\",\n" +
                "        \"value\": {\n" +
                "            \"id\": 348,\n" +
                "            \"servings\": 1,\n" +
                "            \"title\": \"Aldi Spicy Cashews - 30g\",\n" +
                "            \"image\": \"https://img.spoonacular.com/ingredients_100x100/cashews.jpg\"\n" +
                "        }\n" +
                "    }\n" +
                "]";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("apiKey",apiKey)
                .queryParam("hash",hash)
                .body(requestBody)
                .log().ifValidationFails()
                .when()
                .post("/{username}/items", username)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("status",equalTo("success"));
    }
    @Test(description = "delete item to mealplan")
    public void DeleteitemToMealplanTest(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("apiKey",apiKey)
                .queryParam("hash",hash)
                .when()
                .delete("/{username}/items/25640960", username)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("status",equalTo("success"));
    }
}