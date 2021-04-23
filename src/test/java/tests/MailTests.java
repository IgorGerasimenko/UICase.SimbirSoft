package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MailPage;
import pages.PassportPage;

import java.util.concurrent.TimeUnit;

public class MailTests {
    public WebDriver driver;
    public MailPage mailPage;
    public HomePage homePage;
    public PassportPage passportPage;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        passportPage = new PassportPage(driver);
        mailPage = new MailPage(driver);
    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void UITest() {
        homePage
                .open()
                .clickSignIn();
        passportPage
                .fillLogin("SimbirSoftGerasimenko")
                .clickSignIn()
                .fillPassword("Qwerty123")
                .clickSignIn();
        homePage
                .openMailPage();
        int themeCountBeforeSendMessage = mailPage.getMessageCountByTheme("Simbirsoft theme");
        mailPage
                .createNewMessage()
                .fillEmailAdress("SimbirSoftGerasimenko@yandex.ru")
                .fillTheme("Simbirsoft theme")
                .fillTextBox("найдено " + themeCountBeforeSendMessage + " писем/письма")
                .sendMessage()
                .returnToInbox()
                .refreshPage();
        Assert.assertEquals(themeCountBeforeSendMessage, mailPage.getMessageCountByTheme("Simbirsoft theme") - 1);
    }

}
