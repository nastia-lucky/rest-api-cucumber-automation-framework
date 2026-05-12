package steps;

import assertions.PetAsserts;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Category;
import models.Pet;
import models.Tag;
import services.PetService;

import java.util.Arrays;

public class PetSteps {

  private final TestContext testContext;
  private final PetService service;
  private final PetAsserts petAsserts;


  public PetSteps(TestContext context, PetService service, PetAsserts petAsserts) {
    this.testContext = context;
    this.service = service;
    this.petAsserts = petAsserts;
  }

  @When("I create a pet")
  public void createPet(String json) {
    Pet pet = service.mapPet(json);
    testContext.setAddedPet(pet);
    testContext.setResponse(service.createPet(pet));
  }

  @When("I create a pet with name {string}, status {string}, categoryId {int}, categoryName {string}, tagId {int}, tagName {string}, photoURL {string}")
  public void iCreateAUserWithIdIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatusUserStatus(String name, String status, int categoryId, String categoryName, int tagId, String tagName, String photoURL) {
    Pet pet = new Pet(new Category(categoryId, categoryName), name, Arrays.asList(photoURL), Arrays.asList(new Tag(tagId, tagName)), status);
    testContext.setAddedPet(pet);
    testContext.setPetId(pet.getId());
    testContext.setResponse(service.createPet(testContext.getAddedPet()));
  }


  @Then("I check status code as expected {int}")
  public void iCheckStatusCodeAsExpected(int statusCode) {
    petAsserts.isStatusCodesEquals(testContext.getCode(), statusCode);
  }


  @Then("I check by getting pet I get expected code {int}")
  public void iCheckICanGetPetByPetId(int statusCode) {
    testContext.setResponse(service.getPet(testContext.getPetId()));
    petAsserts.isStatusCodesEquals(testContext.getCode(), statusCode);

  }


  @Then("I check got cat the same as created cat")
  public void iCheckGotCatTheSameAsCreatedCat() {
    testContext.setResponse(service.getPet(testContext.getPetId()));
    Pet gotPet = testContext.getResponse().getBody().as(Pet.class);
    testContext.setGotPet(gotPet);
    petAsserts.isPetEquals(testContext.getAddedPet(), gotPet);
  }

  @Then("I check got cat the same as updated cat")
  public void iCheckGotCatTheSameAsUpdatedCat() {
    testContext.setResponse(service.getPet(testContext.getPetId()));
    Pet gotPet = testContext.getResponse().getBody().as(Pet.class);
    testContext.setGotPet(gotPet);
    petAsserts.isPetEquals(testContext.getPetForUpdate(), gotPet);
  }


  @Then("I delete a pet")
  public void iDeleteAPet() {
    testContext.setResponse(service.deletePet(testContext.getPetId()));
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
    Pet pet = new Pet(testContext.getPetId(), new Category(categoryId, categoryName), name, Arrays.asList(photoURL), Arrays.asList(new Tag(tagId, tagName)), status);
    testContext.setPetForUpdate(pet);
    testContext.setResponse(service.updatePet(pet));
  }
}