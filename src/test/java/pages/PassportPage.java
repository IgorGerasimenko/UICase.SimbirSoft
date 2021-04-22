package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportPage extends Page {

    public PassportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='passp-field-login']")
    public WebElement loginBar;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    public WebElement passwordBar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sigInButton;

    public PassportPage fillLogin(String login) {
        loginBar.sendKeys(login);
        return this;
    }

    public PassportPage fillPassword(String pass) {
        passwordBar.sendKeys(pass);
        return this;
    }

    public PassportPage clicklSignIn() {
        sigInButton.click();
        return this;
    }


}
