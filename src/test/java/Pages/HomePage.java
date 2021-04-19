package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class HomePage extends TestBase {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath="//a[@class='home-link desk-notif-card__login-new-item desk-notif-card__login-new-item_enter home-link_black_yes home-link_hover_inherit']//div[2]")
    public WebElement signInButton;

    @FindBy(xpath="//div[@class='desk-notif-card__mail-title']")
    public WebElement mailButton;


    public HomePage open(){
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        return this;
    }

    public HomePage login(){
        open();
        signInButton.click();
        passportPage.loginBar.sendKeys("SimbirSoftGerasimenko");
        passportPage.sigInButton.click();
        passportPage.passwordBar.sendKeys("Qwerty123");
        passportPage.sigInButton.click();
        return this;
    }

    public void openMailPage(){
        // получаем набор дескрипторов текущих открытых окон
       String originalWindow = driver.getWindowHandle();
       final Set<String> oldWindowsSet = driver.getWindowHandles();

       mailButton.click();

        // ожидаем открытия и получаем дескриптор нового окна
        String newWindowHandle = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
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
