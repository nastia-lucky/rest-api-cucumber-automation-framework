package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

  public static final ObjectMapper mapper=new ObjectMapper();

  static {
    mapper.findAndRegisterModules();
  }
}
