package context;

import models.Pet;

public class PetContext extends BaseContext {

  protected Pet addedPet;
  protected Pet gotPet;
  protected Pet petForUpdate;
  protected int petId;


  public void setAddedPet(Pet addedPet) {
    this.addedPet = addedPet;
  }


  public void setGotPet(Pet gotPet) {
    this.gotPet = gotPet;
  }

  public void setPetForUpdate(Pet petForUpdate) {
    this.petForUpdate = petForUpdate;
  }


  public Pet getAddedPet() {
    return addedPet;
  }


  public Pet getPetForUpdate() {
    return petForUpdate;
  }


  public int getPetId() {
    return petId;
  }

  public void setPetId(int petId) {
    this.petId = petId;
  }
}
