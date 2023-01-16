package Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/Login02.feature",
                    "src/test/java/FeatureFiles/StatusCode01.feature"},
        glue = {"StepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class _03_AllTestRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport()
    {
        ExtentService.getInstance().setSystemInfo("User Name", "Aziz Karaca");
        ExtentService.getInstance().setSystemInfo("Application Name", "Cyan Security");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Notes", "---");

    }

}
