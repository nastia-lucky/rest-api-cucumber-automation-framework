package services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import models.Pet;
import utilities.Method;
import utilities.RestAssuredExtension;

public class PetService extends BaseService<Pet> {

  public PetService(RestAssuredExtension extension) {
    super(extension, "/pet", Pet.class);
  }

  @Step("User creates a pet")
  public ResponseOptions<Response> createPet(Pet pet) {
    return extension.execute(uri, Method.POST, pet);
  }

  @Step("User gets a pet with petId {petId}")
  public ResponseOptions<Response> getPet(int petId) {
    return extension.execute(uri + "/" + petId, Method.GET, null);
  }

  @Step("User deletes a pet with petId {petId}")
  public ResponseOptions<Response> deletePet(int petId) {
    return extension.execute(uri + "/" + petId, Method.DELETE, null);
  }

  @Step("Uer update a pet")
  public ResponseOptions<Response> updatePet(Pet pet) {
    return extension.execute(uri, Method.PUT, pet);
  }

}
