package services;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import models.User;
import utilities.Method;
import utilities.RestAssuredExtension;

public class UserService extends BaseService {

  private final String userURI = "/user";

  public UserService(RestAssuredExtension extension) {
    super(extension);
  }


  @Step("User gets a user by userName {userName}")
  public ResponseOptions<Response> getUser(String userName) {
    return extension.execute(userURI + "/" + userName, Method.GET, null);
  }

  @Step("User creates a new user")
  public ResponseOptions<Response> createUser(User user) {
    return extension.execute(userURI, Method.POST, user);
  }

  @Step("User deletes a user by username {userName}")
  public ResponseOptions<Response> deleteUser(String userName) {
    return extension.execute(userURI + "/" + userName, Method.DELETE, null);
  }

  @Step("User updates a user with username {userName}")
  public ResponseOptions<Response> updateUser(String userName, User user) {
    return extension.execute(userURI + "/" + userName, Method.PUT, user);
  }
}
