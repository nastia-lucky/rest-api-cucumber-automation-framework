package steps;

import assertions.UserAsserts;
import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import services.UserService;

import java.util.List;
import java.util.Map;

public class UserSteps {

  private final TestContext testContext;
  private final UserService userService;
  private final UserAsserts userAsserts;


  public UserSteps(TestContext context, UserService userService, UserAsserts userAsserts) {
    this.testContext = context;
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
    testContext.setResponse(userService.getUser(userName));
    return testContext.getResponse().getBody().as(User.class);
  }


  @When("I create a user")
  public void createUser(DataTable dataTable) {
    List<User> users = dataTable.asList(User.class);
    User createdUser = users.get(0);
    testContext.setUser(createdUser);
    testContext.setResponse(userService.createUser(createdUser));
  }

  @Then("I can get created user by username")
  public void iCanGetCreatedUserByUsername() {
    testContext.setResponse(userService.getUser(testContext.getUserName()));
    userAsserts.isStatusCodesEquals(testContext.getCode(), 200);
  }

  @Then("I check got user the same as created user")
  public void iCheckGotUserTheSameAsCreatedUser() {
    User gotUser = getUser(testContext.getUserName());
    userAsserts.isUserEquals(gotUser, testContext.getCreatedUser());
  }

  @Then("I delete a user")
  public void iDeleteAUser() {
    testContext.setResponse(userService.deleteUser(testContext.getUserName()));
  }

  @Then("I check I can't get user by userName")
  public void iCheckICanTGetUserByUserName() {
    testContext.setResponse(userService.getUser(testContext.getUserName()));
    userAsserts.isStatusCodesEquals(testContext.getCode(), 404);
  }

  @Then("I update the user")
  public void iUpdateTheUser(DataTable table) {
    List<User> users = table.asList(User.class);
    User updatedUser = users.get(0);
    testContext.setUpdatedUser(updatedUser);
    testContext.setUserName(updatedUser.getUsername());
    testContext.setResponse(userService.updateUser(testContext.getUpdatedUser().getUsername(), updatedUser));
  }

  @Then("I check got user the same as updated user")
  public void iCheckGotUserStringTheSameAsUpdatedUser() {
    User gotUser = getUser(testContext.getUserName());
    userAsserts.isUserEquals(gotUser, testContext.getUpdatedUser());
  }

  @When("I create a user with firstName {string}, lastName {string}, email {string}, password {string}, phone {string}, userStatus {int}")
  public void iCreateAUserWithIdIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatusUserStatus(String firstname, String lastname, String email, String password, String phone, int userStatus) {
    User user = new User(firstname, lastname, email, password, phone, userStatus);
    testContext.setUser(user);
    testContext.setResponse(userService.createUser(testContext.getCreatedUser()));
  }
}
