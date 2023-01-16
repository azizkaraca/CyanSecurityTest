package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends _Parent {

    public LoginPage()
    {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h4[contains(text(),'Welcome')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'invalid')]")
    private WebElement invalidData;

    WebElement myElement;

    public void findAndSend(String strElement, String value)
    {
        switch (strElement)
        {
            case "username": myElement = username;break;
            case "password": myElement = password;break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "loginButton": myElement = loginButton;break;
        }
        clickFunction(myElement);
    }

    public void findAndVerify(String strElement, String text)
    {
        switch (strElement) {
            case "successMessage": myElement = successMessage;break;
            case "invalidData": myElement = invalidData;break;
        }
        verifyContainsText(myElement, text);
    }

}
