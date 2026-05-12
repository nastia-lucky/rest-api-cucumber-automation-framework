package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import utilities.Utils;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

  private static final Faker FAKER = new Faker();

  @JsonProperty("id")
  private int id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("userStatus")
  private int userStatus;

  public User(String firstName, String lastName, String password, String email, String phone, int userStatus) {
    this.id = Utils.generateId();
    this.username = FAKER.name().username()
        + "_" +
        UUID.randomUUID();
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.userStatus = userStatus;
  }

  public User() {
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    User user = (User) object;
    return id == user.id && userStatus == user.userStatus && Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, firstName, lastName, email, password, phone, userStatus);
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
