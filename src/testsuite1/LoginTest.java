package testsuite1;

import browserfactory.Uitility;
import net.bytebuddy.build.Plugin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;

import java.util.PriorityQueue;

public class LoginTest extends Uitility {
    String BaseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        System.out.println(1);
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnTheElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String actText = "Secure Area";
        // String expText= getTextFromElement(By.xpath("//h2[@xpath='1']"));
        String expText = getTextFromElement(By.xpath("//h2[normalize-space()='Secure Area']"));
        Assert.assertEquals("Not Matching", actText, expText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        System.out.println(2);
        sendTextToElement(By.id("username"), "tomsmith1");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnTheElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String expText = "Your username is invalid!";
        System.out.println("size of exp string : " + expText.length());
        String expTextcap = "Your username is invalid!\n" +
                "×";
        //String actText= getTextFromElement(By.id("flash"));
        String actText = getTextFromElement(By.xpath("//div[@id='flash']"));
        System.out.println(expText);
        Assert.assertEquals("Not Matching", expTextcap, actText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        System.out.println(3);
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickOnTheElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String expText = "Your password is invalid!";
        System.out.println("size of the expText : " + expText.length());
        //String expTextcap="Your password is invalid!\n" +
        //       "×";
        // String actText= getTextFromElement(By.xpath("//h2[@xpath='1']"));
        // String actText= getTextFromElement(By.id("flash"));
        String actText = getTextFromElement(By.xpath("//*[@id=\"flash\"]")).substring(0, 25);
        System.out.println(actText);
        //Assert.assertEquals("Not Matching",expTextcap,actText);
        Assert.assertEquals(expText, actText);
//Assert.assertTrue(expText,equals(actText));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
