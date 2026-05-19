package context;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class BaseContext {

  protected ResponseOptions<Response> response;

  public void setResponse(ResponseOptions<Response> response) {
    this.response = response;
  }


  public ResponseOptions<Response> getResponse() {
    return response;
  }


  public int getCode(){
    return response.statusCode();
  }


}
