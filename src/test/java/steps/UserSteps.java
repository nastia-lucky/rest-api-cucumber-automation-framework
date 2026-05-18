package steps;

import assertions.UserAsserts;
import context.UserContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import services.UserService;

import java.util.List;
import java.util.Map;

public class UserSteps {

  private final UserContext userContext;
  private final UserService userService;
  private final UserAsserts userAsserts;


  public UserSteps(UserContext userContext, UserService userService, UserAsserts userAsserts) {
    this.userContext = userContext;
    this.userService = userService;
    this.userAsserts = userAsserts;
  }

  @DataTableType
  public User userEntry(Map<String, String> entry) {
    return new User(
        entry.get("firstName"),
        entry.get("lastName"),
        entry.get("email"),
        entry.get("password"),
        entry.get("phone"),
        Integer.parseInt(entry.get("userStatus"))
    );
  }


  public User getUser(String userName) {
    userContext.setResponse(userService.getUser(userName));
    return userContext.getResponse().getBody().as(User.class);
  }


  @When("I create a user")
  public void createUser(DataTable dataTable) {
    List<User> users = dataTable.asList(User.class);
    User createdUser = users.get(0);
    userContext.setUser(createdUser);
    userContext.setResponse(userService.createUser(createdUser));
  }

  @Then("I can get created user by username")
  public void iCanGetCreatedUserByUsername() {
    userContext.setResponse(userService.getUser(userContext.getUserName()));
    userAsserts.isStatusCodesEquals(userContext.getCode(), 200);
  }

  @Then("I check got user the same as created user")
  public void iCheckGotUserTheSameAsCreatedUser() {
    User gotUser = getUser(userContext.getUserName());
    userAsserts.isUserEquals(gotUser, userContext.getCreatedUser());
  }

  @Then("I delete a user")
  public void iDeleteAUser() {

    userContext.setResponse(userService.deleteUser(userContext.getUserName()));
  }

  @Then("I check I can't get user by userName")
  public void iCheckICanTGetUserByUserName() {
    userContext.setResponse(userService.getUser(userContext.getUserName()));
    userAsserts.isStatusCodesEquals(userContext.getCode(), 404);
  }

  @Then("I update the user")
  public void iUpdateTheUser(DataTable table) {
    List<User> users = table.asList(User.class);
    User updatedUser = users.get(0);
    userContext.setUpdatedUser(updatedUser);
    userContext.setUserName(updatedUser.getUsername());
    userContext.setResponse(userService.updateUser(userContext.getUpdatedUser().getUsername(), updatedUser));
  }

  @Then("I check got user the same as updated user")
  public void iCheckGotUserStringTheSameAsUpdatedUser() {
    User gotUser = getUser(userContext.getUserName());
    userAsserts.isUserEquals(gotUser, userContext.getUpdatedUser());
  }

  @When("I create a user with firstName {string}, lastName {string}, email {string}, password {string}, phone {string}, userStatus {int}")
  public void iCreateAUserWithIdIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatusUserStatus(String firstname, String lastname, String email, String password, String phone, int userStatus) {
    User user = new User(firstname, lastname, email, password, phone, userStatus);
    userContext.setUser(user);
    userContext.setResponse(userService.createUser(userContext.getCreatedUser()));
  }

  @Then("I check status code as expected {int} for user")
  public void iCheckStatusCodeAsExpected(int statusCode) {
    userAsserts.isStatusCodesEquals(userContext.getCode(), statusCode);
  }

}
