package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.impl.SimpleLogger;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowser = new ThreadLocal<>();
    public static WebDriver getDriver()
    {
            Locale.setDefault(new Locale("EN"));
            System.setProperty("user.language", "EN");

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

            if (threadBrowser.get()==null)
                threadBrowser.set("chrome");

            if (threadDriver.get() == null) {

                String browserName=threadBrowser.get();

                switch (browserName){

                    case "chrome":
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                        threadDriver.set(new ChromeDriver());
                        break;

                    case "firefox":
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        threadDriver.set(new FirefoxDriver());
                        break;

                    case "safari":
                        threadDriver.set(new SafariDriver());
                        break;

                }
            }
            return threadDriver.get();
    }

    public static void quitDriver() {

        if (threadDriver.get() != null)
        {
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }
}