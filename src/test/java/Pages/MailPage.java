package Pages;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MailPage extends TestBase {

        public int themeCountBeforeSendMessage;
        public int themeCountAfterSendMessage;


        public MailPage(WebDriver driver) {
            PageFactory.initElements(driver,this);
            this.driver = driver;
        }

        @FindBy(xpath="//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span[@title='Simbirsoft theme']")
        public WebElement theme;

        @FindBy(xpath="//span[@class='mail-ComposeButton-Text']")
        public WebElement composeButton;

        @FindBy(xpath="//div[@class='ComposeRecipients-TopRow']//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']//div[1]")
        public WebElement emailAdressBar;

        @FindBy(xpath="//input[@class='composeTextField ComposeSubject-TextField']")
        public WebElement themeBar;

        @FindBy(xpath="//div[@placeholder='Напишите что-нибудь']//div")
        public WebElement messageTextBox;

        @FindBy(xpath="//div[@class='ComposeControlPanelButton ComposeControlPanel-Button ComposeControlPanel-SendButton ComposeSendButton ComposeSendButton_desktop']")
        public WebElement sendButton;

        @FindBy(xpath="//a[contains(text(),'Вернуться во \"Входящие\"')]")
        public WebElement returnToInboxButton;


    public MailPage getThemeCountBeforeSendMessage(){
        List<WebElement> themeBefore = driver.findElements(By.xpath("//span[@title='Simbirsoft theme']"));
        themeCountBeforeSendMessage = themeBefore.size();
        System.out.println("Количество писем с темой Simbirsoft theme до отправки письма равно:" + themeCountBeforeSendMessage);
        return this;
    }

    public MailPage getThemeCountAfterSendMessage(){
        returnToInboxButton.click();
        driver.navigate().refresh();
        List<WebElement> themeAfter = driver.findElements(By.xpath("//span[@title='Simbirsoft theme']"));
        themeCountAfterSendMessage = themeAfter.size();
        System.out.println("Количество писем с темой Simbirsoft theme после отправки письма равно:" + themeCountAfterSendMessage);
        return this;
    }

    public MailPage sendMessage(){
        composeButton.click();
        emailAdressBar.sendKeys("SimbirSoftGerasimenko@yandex.ru");
        themeBar.sendKeys("Simbirsoft theme");
        messageTextBox.sendKeys("найдено " + themeCountBeforeSendMessage + " писем/письма" );
        sendButton.click();
        return this;
    }



}