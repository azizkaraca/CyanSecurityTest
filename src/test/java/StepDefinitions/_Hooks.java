package StepDefinitions;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class _Hooks {

    @Before
    public void before()
    {
        System.out.println("Scenario Start");
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("Scenario Finished");
        System.out.println("Scenario Result="+ scenario.getStatus());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy-HH:mm");

        if (scenario.isFailed()){

            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();
            File screenFolder = screenshot.getScreenshotAs(OutputType.FILE);

            ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {
                FileUtils.copyFile(screenFolder,
                        new File("target/FailedScreenShots/"+ date.format(formatter)+scenario.getId()+".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        GWD.quitDriver();
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
