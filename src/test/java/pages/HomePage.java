package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.Set;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='desk-notif-card__login-new-item-title']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='desk-notif-card__mail-title']")
    public WebElement mailButton;


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
        // получаем набор дескрипторов текущих открытых окон
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        mailButton.click();

        // ожидаем открытия и получаем дескриптор нового окна
        String newWindowHandle = wait.until(new ExpectedCondition<String>() {
                                                public String apply(WebDriver driver) {
                                                    Set<String> newWindowsSet = driver.getWindowHandles();
                                                    newWindowsSet.removeAll(oldWindowsSet);
                                                    return newWindowsSet.size() > 0 ?
                                                            newWindowsSet.iterator().next() : null;
                                                }
                                            }
        );
        // переключаемся на новое окно
        driver.switchTo().window(newWindowHandle);


    }


}
