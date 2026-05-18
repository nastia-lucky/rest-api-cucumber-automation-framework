package steps;

import assertions.PetAsserts;
import context.PetContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Category;
import models.Pet;
import models.Tag;
import services.PetService;

import java.util.Arrays;

public class PetSteps {

  private final PetContext petContext;
  private final PetService service;
  private final PetAsserts petAsserts;


  public PetSteps(PetContext context, PetService service, PetAsserts petAsserts) {
    this.petContext = context;
    this.service = service;
    this.petAsserts = petAsserts;
  }

  @When("I create a pet with name {string}, status {string}, categoryId {int}, categoryName {string}, tagId {int}, tagName {string}, photoURL {string}")
  public void iCreateAUserWithIdIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatusUserStatus(String name, String status, int categoryId, String categoryName, int tagId, String tagName, String photoURL) {
    Pet pet = new Pet(new Category(categoryId, categoryName), name, Arrays.asList(photoURL), Arrays.asList(new Tag(tagId, tagName)), status);
    petContext.setAddedPet(pet);
    petContext.setPetId(pet.getId());
    petContext.setResponse(service.createPet(petContext.getAddedPet()));
  }


  @Then("I check status code as expected {int} for pet")
  public void iCheckStatusCodeAsExpected(int statusCode) {
    petAsserts.isStatusCodesEquals(petContext.getCode(), statusCode);
  }


  @Then("I check by getting pet I get expected code {int}")
  public void iCheckICanGetPetByPetId(int statusCode) {
    petContext.setResponse(service.getPet(petContext.getPetId()));
    petAsserts.isStatusCodesEquals(petContext.getCode(), statusCode);

  }


  @Then("I check got cat the same as created cat")
  public void iCheckGotCatTheSameAsCreatedCat() {
    petContext.setResponse(service.getPet(petContext.getPetId()));
    Pet gotPet = petContext.getResponse().getBody().as(Pet.class);
    petContext.setGotPet(gotPet);
    petAsserts.isPetEquals(petContext.getAddedPet(), gotPet);
  }

  @Then("I check got cat the same as updated cat")
  public void iCheckGotCatTheSameAsUpdatedCat() {
    petContext.setResponse(service.getPet(petContext.getPetId()));
    Pet gotPet = petContext.getResponse().getBody().as(Pet.class);
    petContext.setGotPet(gotPet);
    petAsserts.isPetEquals(petContext.getPetForUpdate(), gotPet);
  }


  @Then("I delete a pet")
  public void iDeleteAPet() {
    petContext.setResponse(service.deletePet(petContext.getPetId()));
  }

  @Then("I check I can update created pet with name {string}, status {string}, categoryId {int}, categoryName {string}, tagId {int}, tagName {string}, photoURL {string}")
  public void iCheckICanUpdateCreatedPet(String name, String status, int categoryId, String categoryName, int tagId, String tagName, String photoURL) {
   /* Pet pet = Pet.builder().id(testContext.getPetId())
        .name(name)
        .status(status)
        .category(new Category(categoryId, categoryName))
        .tags(Arrays.asList(new Tag(tagId, tagName)))
        .photoUrls(Arrays.asList(photoURL))
        .build(); */
    Pet pet = new Pet(petContext.getPetId(), new Category(categoryId, categoryName), name, Arrays.asList(photoURL), Arrays.asList(new Tag(tagId, tagName)), status);
    petContext.setPetForUpdate(pet);
    petContext.setResponse(service.updatePet(pet));
  }
}