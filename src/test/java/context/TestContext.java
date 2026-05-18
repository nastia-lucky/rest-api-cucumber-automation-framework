package context;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import models.Pet;
import models.User;

public class TestContext {

  protected ResponseOptions<Response> response;
  protected Pet addedPet;
  protected Pet gotPet;
  protected Pet petForUpdate;
  protected User createdUser;
  protected User updatedUser;
  protected int userId;
  protected int petId;
  protected String userName;


  public void setAddedPet(Pet addedPet) {
    this.addedPet = addedPet;
  }

  public void setResponse(ResponseOptions<Response> response) {
    this.response = response;
  }

  public void setGotPet(Pet gotPet) {
    this.gotPet = gotPet;
  }

  public void setPetForUpdate(Pet petForUpdate) {
    this.petForUpdate = petForUpdate;
  }

  public void setUpdatedUser(User updatedUser) {
    this.updatedUser = updatedUser;
  }


  public ResponseOptions<Response> getResponse() {
    return response;
  }

  public Pet getAddedPet() {
    return addedPet;
  }


  public Pet getPetForUpdate() {
    return petForUpdate;
  }

  public User getCreatedUser() {
    return createdUser;
  }

  public User getUpdatedUser() {
    return updatedUser;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUser(User user) {
    this.createdUser = user;
    this.userId = user.getId();
    this.userName = user.getUsername();
  }

  public int getCode(){
    return response.statusCode();
  }

  public int getPetId() {
    return petId;
  }

  public void setPetId(int petId) {
    this.petId = petId;
  }
}
