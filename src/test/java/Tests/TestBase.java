package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static MailPage mailPage;
    public static HomePage homePage;
    public static PassportPage passportPage;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mailPage = new MailPage(driver);
        homePage = new HomePage(driver);
        passportPage = new PassportPage(driver);

    }

    @After
    public void close() {
        driver.quit();
    }

}
