package services;

import utilities.RestAssuredExtension;

public class BaseService<T> {

  protected RestAssuredExtension extension;
  protected final String uri;
  private final Class<T> clazz;

  public BaseService(RestAssuredExtension extension, String uri, Class<T> clazz) {
    this.uri = uri;
    this.extension = extension;
    this.clazz = clazz;
  }

  
}
