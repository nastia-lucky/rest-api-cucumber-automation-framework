package assertions;

import models.Pet;
import org.testng.Assert;

public class PetAsserts extends GeneralAsserts {

  public void isPetEquals(Pet pet1, Pet pet2) {
    Assert.assertEquals(pet1, pet2);
  }

}
