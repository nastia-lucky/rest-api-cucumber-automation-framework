package assertions;

import models.User;
import org.testng.Assert;

public class UserAsserts  extends GeneralAsserts{

  public void isUserEquals(User user1, User user2) {
    Assert.assertEquals(user1, user2);
  }


}
