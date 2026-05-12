package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class Tag {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  public Tag(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Tag() {
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Tag tag = (Tag) object;
    return id == tag.id && Objects.equals(name, tag.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
