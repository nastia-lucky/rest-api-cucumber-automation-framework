package services;

import utilities.RestAssuredExtension;

public class BaseService {

  protected RestAssuredExtension extension;

  public BaseService(RestAssuredExtension extension) {
    this.extension = extension;
  }

}
