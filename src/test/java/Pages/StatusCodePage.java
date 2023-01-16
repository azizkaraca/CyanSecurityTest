package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusCodePage extends _Parent {
    public StatusCodePage()
    {
        PageFactory.initElements(GWD.getDriver(),this);
    }

   @FindBy(linkText = "200")
    private WebElement code200;

    @FindBy(linkText = "301")
    private WebElement code301;

    @FindBy(linkText = "404")
    private WebElement code404;

    @FindBy(linkText = "500")
    private WebElement code500;

    @FindBy(linkText = "here")
    private WebElement back;

    @FindBy(xpath="//p[contains(text(),'200')]")
    private WebElement success200;

    @FindBy(xpath="//p[contains(text(),'301')]")
    private WebElement success301;

    @FindBy(xpath="//p[contains(text(),'404')]")
    private WebElement success404;

    @FindBy(xpath="//p[contains(text(),'500')]")
    private WebElement success500;


    WebElement myElement;

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "code200": myElement = code200;break;
            case "code301": myElement = code301;break;
            case "code404": myElement = code404;break;
            case "code500": myElement = code500;break;
            case "back": myElement = back;break;

        }
        clickFunction(myElement);
    }

    public void findAndVerify(String strElement, String text)
    {
        switch (strElement)
        {
            case "success200": myElement = success200;break;
            case "success301": myElement = success301;break;
            case "success404": myElement = success404;break;
            case "success500": myElement = success500;break;

        }
        verifyContainsText(myElement,text);
    }

}
