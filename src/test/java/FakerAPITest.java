import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.hamcrest.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Test FakerAPI")
public class FakerAPITest extends BaseTest3{
    String apiKey = "84834bb3cc554ce68998372034271ce3";
    //String hash = "01a4d4bab106327462e8c4b15156b39f713c0619";
    //String username = "candra0";
    @Test(description = "Addresses")
    public void Addresses(){
        given()
                .queryParam("apiKey",apiKey)
                .queryParam("_quantity", 1)
                .log().ifValidationFails()
                .when()
                .get("addresses?_quantity=1")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("total.size",equalTo(1));
    }

    @Test(description = "Addresses2")
    public void Addresses2(){
        given()
                .queryParam("apiKey",apiKey)
                .queryParam("_quantity", 1)
                .log().ifValidationFails()
                .when()
                .get("addresses?_quantity=1")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("data.size",equalTo(1));
    }

    @Test(description = "Books")
    public void Books(){
        given()
                .queryParam("apiKey",apiKey)
                .queryParam("_quantity", 1)
                .log().ifValidationFails()
                .when()
                .get("addresses?_quantity=1")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
//                Assertion isi 1 hari mealplan ada 3 dish
                .body("total.size",equalTo(1));
    }

}