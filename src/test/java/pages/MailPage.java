package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage extends Page {

    @FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
    public WebElement composeButton;

    @FindBy(xpath = "//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']//div[1]")
    public WebElement emailAdressBar;

    @FindBy(xpath = "//input[@class='composeTextField ComposeSubject-TextField']")
    public WebElement themeBar;

    @FindBy(xpath = "//div[@placeholder='Напишите что-нибудь']//div")
    public WebElement messageTextBox;

    @FindBy(xpath = "//div[@class='ComposeControlPanel-Part']//div")
    public WebElement sendButton;

    @FindBy(xpath = "//a[contains(text(),'Вернуться во \"Входящие\"')]")
    public WebElement returnToInboxButton;

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getMessageCountByTheme(String theme) {
        List<WebElement> themesCountList = driver.findElements(By.xpath("//span[@title='" + theme + "']"));
        return themesCountList.size();
    }

    public MailPage returnToInbox() {
        returnToInboxButton.click();
        return this;
    }

    public MailPage createNewMessage() {
        composeButton.click();
        return this;
    }

    public MailPage fillEmailAdress(String email) {
        emailAdressBar.sendKeys(email);
        return this;
    }

    public MailPage fillTheme(String theme) {
        themeBar.sendKeys(theme);
        return this;
    }

    public MailPage fillTextBox(String text) {
        messageTextBox.sendKeys(text);
        return this;
    }

    public MailPage sendMessage() {
        sendButton.click();
        return this;
    }


}