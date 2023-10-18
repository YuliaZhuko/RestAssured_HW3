package Pet.createPet;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import services.PetFindApi;


import static org.hamcrest.Matchers.*;

public class FindPetTest {

    private static Long PET_ID = 9223372036854774581l;
    @Test
    @DisplayName("Поиск валидного значения id")
    public void findPetTest(){
        PetFindApi petFindApi = new PetFindApi();
        petFindApi.findPet()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(PET_ID));

    }
    @Test
    @DisplayName("Поиск невалидного значения id")
    public void findInvalidPetIDTest(){
        PetFindApi petFindApi = new PetFindApi();
        petFindApi.findInvalidPet()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message",equalTo("Pet not found"));

    }
}
