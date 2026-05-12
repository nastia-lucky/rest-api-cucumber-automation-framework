package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class Category {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;


  public Category(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Category() {
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Category category = (Category) object;
    return id == category.id && Objects.equals(name, category.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
