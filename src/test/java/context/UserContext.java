package context;

import models.User;

public class UserContext extends BaseContext {

  protected User createdUser;
  protected User updatedUser;
  protected int userId;
  protected String userName;


  public void setUpdatedUser(User updatedUser) {
    this.updatedUser = updatedUser;
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


}
