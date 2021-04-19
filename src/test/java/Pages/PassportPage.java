package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportPage extends TestBase {


    public PassportPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath="//input[@id='passp-field-login']")
    public WebElement loginBar;

    @FindBy(xpath="//input[@id='passp-field-passwd']")
    public WebElement passwordBar;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement sigInButton;

}
