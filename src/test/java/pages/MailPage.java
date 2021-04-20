package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage  {

        WebDriver driver;
        public int themeCountBeforeSendMessage;
        public int themeCountAfterSendMessage;


        public MailPage(WebDriver driver) {
            PageFactory.initElements(driver,this);
            this.driver = driver;
        }

        @FindBy(xpath="//span[@class='mail-ComposeButton-Text']")
        public WebElement composeButton;

        @FindBy(xpath="//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']//div[1]")
        public WebElement emailAdressBar;

        @FindBy(xpath="//input[@class='composeTextField ComposeSubject-TextField']")
        public WebElement themeBar;

        @FindBy(xpath="//div[@placeholder='Напишите что-нибудь']//div")
        public WebElement messageTextBox;

        @FindBy(xpath="//div[@class='ComposeControlPanel-Part']//div")
        public WebElement sendButton;

        @FindBy(xpath="//a[contains(text(),'Вернуться во \"Входящие\"')]")
        public WebElement returnToInboxButton;

        @FindBy(xpath="//span[@title='Simbirsoft theme']")
        public List<WebElement> simbirsoftTheme;




    public MailPage getThemeCountBeforeSendMessage(){
        themeCountBeforeSendMessage = simbirsoftTheme.size();
        System.out.println("Количество писем с темой Simbirsoft theme до отправки письма равно:" + themeCountBeforeSendMessage);
        return this;
    }

    public MailPage getThemeCountAfterSendMessage(){
        themeCountAfterSendMessage = simbirsoftTheme.size();
        System.out.println("Количество писем с темой Simbirsoft theme после отправки письма равно:" + themeCountAfterSendMessage);
        return this;
    }

    public MailPage returnToInbox (){
        returnToInboxButton.click();
        return this;
    }

    public MailPage refreshPage(){
        driver.navigate().refresh();
        return this;
    }

    public MailPage createNewMessage(){
        composeButton.click();
        return this;
    }

    public MailPage fillEmailAdress(String email){
        emailAdressBar.sendKeys(email);
        return this;
    }

    public MailPage fillTheme(String theme){
        themeBar.sendKeys(theme);
        return this;
    }

    public MailPage fillTextBox(String text){
        messageTextBox.sendKeys(text);
        return this;
    }

    public MailPage sendMessage(){
        sendButton.click();
        return this;
    }


}