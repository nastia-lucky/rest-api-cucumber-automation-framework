package steps;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

  private static final Logger logger = LogManager.getLogger();


  private final TestContext context;

  public Hooks(TestContext context) {
    this.context = context;
  }

  @Before
  public void beforeScenario(Scenario scenario) {

    logger.info(
        "STARTED TEST: {}",
        scenario.getName()
    );
  }

  @After
  public void afterScenario(Scenario scenario) {

    if (scenario.isFailed()) {

      logger.error(
          "FAILED TEST: {}",
          scenario.getName()
      );

      if (context.getResponse() != null) {

        logger.error(
            "RESPONSE BODY:\n{}",
            context.getResponse()
                .getBody()
                .prettyPrint()
        );
      }

    } else {

      logger.info(
          "PASSED TEST: {}",
          scenario.getName()
      );
    }
  }
}
