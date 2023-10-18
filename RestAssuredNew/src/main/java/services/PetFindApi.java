package services;
import dto.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetFindApi {
    private RequestSpecification spec;
    private final static String BASE_URI= "https://petstore.swagger.io/v2";
    private final static String PET = "/pet";
    private static String PET_ID = "9223372036854774581";
    public PetFindApi() {
        spec = given()
                .baseUri(BASE_URI+PET + "/")
                .log().all();
    }
    public ValidatableResponse findPet() {
        return  given(spec)
                .when()
                .get(PET_ID)
                .then()
                .log().all();
    }
    public ValidatableResponse findInvalidPet() {
        return  given(spec)
                .when()
                .get("0")
                .then()
                .log().all();
    }
}
