package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import models.Pet;
import utilities.JSONUtils;
import utilities.Method;
import utilities.RestAssuredExtension;

public class PetService extends BaseService {

  private final String petURI = "/pet";

  public PetService(RestAssuredExtension extension) {
    super(extension);
  }

  @Step("User creates a pet")
  public ResponseOptions<Response> createPet(Pet pet) {
    return extension.execute(petURI, Method.POST, pet);
  }

  @Step("User gets a pet with petId {petId}")
  public ResponseOptions<Response> getPet(int petId) {
    return extension.execute(petURI + "/" + Integer.toString(petId), Method.GET, null);
  }

  @Step("User deletes a pet with petId {petId}")
  public ResponseOptions<Response> deletePet(int petId) {
    return extension.execute(petURI + "/" + Integer.toString(petId), Method.DELETE, null);
  }

  @Step("Uer update a pet")
  public ResponseOptions<Response> updatePet(Pet pet) {
    return extension.execute(petURI, Method.PUT, pet);
  }

  public Pet mapPet(String json) {
    Pet pet;
    try {
      pet = JSONUtils.mapper.readValue(json, Pet.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return pet;
  }
}
