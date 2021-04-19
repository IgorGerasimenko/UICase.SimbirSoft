package Tests;

import org.junit.Assert;
import org.junit.Test;

public class MailTests extends TestBase {

        @Test
        public void UITest(){
            homePage
                    .login()
                    .openMailPage();
            mailPage
                    .getThemeCountBeforeSendMessage()
                    .sendMessage()
                    .getThemeCountAfterSendMessage();
            Assert.assertEquals(mailPage.themeCountAfterSendMessage-1, mailPage.themeCountBeforeSendMessage);

        }

}
