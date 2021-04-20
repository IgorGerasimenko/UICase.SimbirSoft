package tests;

import org.junit.After;
import pages.HomePage;
import pages.MailPage;
import pages.PassportPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailTests  {
    public WebDriver driver;
    public MailPage mailPage;
    public HomePage homePage;
    public PassportPage passportPage;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        passportPage = new PassportPage(driver);
        mailPage = new MailPage(driver);
    }

    @After
    public void close() { driver.quit();
    }

    @Test
    public void UITest(){
        homePage
                .open()
                .clickSignIn();
        passportPage
                .fillLogin("SimbirSoftGerasimenko")
                .clicklSignIn()
                .fillPassword("Qwerty123")
                .clicklSignIn();
        homePage
                .openMailPage();
        mailPage
                .getThemeCountBeforeSendMessage()
                .createNewMessage()
                .fillEmailAdress("SimbirSoftGerasimenko@yandex.ru")
                .fillTheme("Simbirsoft theme")
                .fillTextBox("найдено " + mailPage.themeCountBeforeSendMessage + " писем/письма")
                .sendMessage()
                .returnToInbox()
                .refreshPage()
                .getThemeCountAfterSendMessage();
        Assert.assertEquals(mailPage.themeCountAfterSendMessage-1, mailPage.themeCountBeforeSendMessage);
    }

}
