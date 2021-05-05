package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomePage extends Page {

    @FindBy(xpath = "//div[@class='desk-notif-card__login-new-item-title']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='desk-notif-card__mail-title']")
    public WebElement mailButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage open() {
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        return this;
    }

    public HomePage clickSignIn() {
        signInButton.click();
        return this;
    }

    public void openMailPage() {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        mailButton.click();
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }


}
