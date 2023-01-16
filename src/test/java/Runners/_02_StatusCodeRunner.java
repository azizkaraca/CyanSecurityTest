package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/java/FeatureFiles/StatusCode01.feature"},
        glue = {"StepDefinitions"}
)

public class _02_StatusCodeRunner extends AbstractTestNGCucumberTests {
}
