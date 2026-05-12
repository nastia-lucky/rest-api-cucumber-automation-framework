package utilities;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExtension {

  private final String baseUrl;

  public RestAssuredExtension() {
    this.baseUrl = System.getProperty(
        "apiUrl",
        System.getenv("API_URL"));

    if (baseUrl == null || baseUrl.isBlank()) {
      throw new IllegalStateException(
          "API URL is not configured"
      );
    }
  }

  private RequestSpecification buildRequest() {

    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


    return RestAssured.given()
        .baseUri(baseUrl)
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .filter(new RequestLoggingFilter())
        .filter(new ResponseLoggingFilter());
  }

  public ResponseOptions<Response> execute(
      String uri,
      Method method,
      Object body
  ) {

    RequestSpecification request = buildRequest();

    if (body != null) {
      request.body(body);
    }

    return request.request(
        method.name(),
        uri
    );
  }

}
