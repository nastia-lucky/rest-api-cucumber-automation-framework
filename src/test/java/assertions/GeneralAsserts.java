package assertions;

import org.testng.Assert;

public class GeneralAsserts  {

  public void isStatusCodesEquals(int statusCode1, int statusCode2){
     Assert.assertEquals(statusCode1, statusCode2);
  }


}
