package utilities;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

  public static int generateId(){
    return ThreadLocalRandom.current().nextInt(100000);
  }
}
