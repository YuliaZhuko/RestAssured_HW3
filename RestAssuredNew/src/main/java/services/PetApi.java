package services;

import dto.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetApi {
    private RequestSpecification spec;
    private final static String BASE_URI= "https://petstore.swagger.io/v2";
    private final static String PET = "/pet";
    public PetApi() {
        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .log().all();
    }
    public ValidatableResponse createPet(PetDTO pet) {
        return  given(spec)
                .body(pet)
                .when()
                .post(PET)
                .then()
                .log().all();
    }


}
