package Pet.createPet;
import dto.*;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.PetApi;


import java.util.*;

import static org.hamcrest.Matchers.*;

public class CreateNewPetTest {
    @Test
    @DisplayName("Проверка создания Pet с заполнением всех полей")
    public void createPetTest() {
        PetApi petApi = new PetApi();


        CategoryDTO categoryAllField = CategoryDTO.builder()
                .mId(300l)
                .mName("Pilot")
                .build();
        TagDTO tagAllField = TagDTO.builder()
                .mId(500l)
                .mName("parrot")
                .build();
        List<TagDTO> listTags = new ArrayList<TagDTO>();
        listTags.add(tagAllField);

        List <String> photo = new ArrayList<>();
        photo.add("UP");
        photo.add("DOWN");
        PetDTO petAllField = PetDTO.builder()
                .mCategory(categoryAllField)
                .mId(333l)
                .mName("Kesha")
                .mPhotoUrls(photo)
                .mStatus("available")
                .mTags(listTags)
                .build();


        petApi.createPet(petAllField)
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreatePet.json"))
                .body("id",notNullValue())
                .body("photoUrls", empty())
                .body("tags", empty())
                .time(lessThan(5000L));
        CreatePetResponseDTO response = petApi.createPet(petAllField).extract().body().as(CreatePetResponseDTO.class);

    }

    @Test()
    @DisplayName("Проверка возможности создания Pet заполнив только обязательные поля")
    public void createPetOnlyObligatoryFieldTest(){

        PetApi petApi = new PetApi();


        CategoryDTO categoryAllField = CategoryDTO.builder()
                .mId(0l)
                .mName("")
                .build();
        TagDTO tagAllField = TagDTO.builder()
                .mId(0l)
                .mName("")
                .build();
        List<TagDTO> listTags = new ArrayList<TagDTO>();
        listTags.add(tagAllField);

        List <String> photo = new ArrayList<>();
        photo.add("");
        photo.add("");
        PetDTO petAllField = PetDTO.builder()
                .mCategory(categoryAllField)
                .mId(0l)
                .mName("")
                .mPhotoUrls(photo)
                .mStatus("")
                .mTags(listTags)
                .build();


        petApi.createPet(petAllField)
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreatePet.json"))
                .body("id",notNullValue())
                .body("photoUrls", empty())
                .body("tags", empty())
                .time(lessThan(5000L));
    }
}
