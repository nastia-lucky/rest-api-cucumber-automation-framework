package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:features",
    glue = "steps",
    monochrome = true)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
