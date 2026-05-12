package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import utilities.Utils;

import java.util.List;
import java.util.Objects;

@Data
@Builder
public class Pet {

  @JsonProperty("id")
  private int id;

  @JsonProperty("category")
  private Category category;

  @JsonProperty("name")
  private String name;

  @JsonProperty("photoUrls")
  private List<String> photoUrls;

  @JsonProperty("tags")
  private List<Tag> tags;

  @JsonProperty("status")
  private String status;

  public Pet(Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
    this.id = Utils.generateId();
    this.category = category;
    this.name = name;
    this.photoUrls = photoUrls;
    this.tags = tags;
    this.status = status;
  }

  public Pet(int id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.photoUrls = photoUrls;
    this.tags = tags;
    this.status = status;
  }

  public Pet() {
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Pet pet = (Pet) object;
    return id == pet.id && Objects.equals(category, pet.category) && Objects.equals(name, pet.name) && Objects.equals(photoUrls, pet.photoUrls) && Objects.equals(tags, pet.tags) && Objects.equals(status, pet.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, name, photoUrls, tags, status);
  }

  public int getId() {
    return id;
  }
}
