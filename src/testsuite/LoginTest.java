package testsuite;

import browserfactory.Uitility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Uitility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "Admin");
        sendTextToElement(By.name("password"), "admin123");
        clickOnTheElement(By.xpath("//button[@type= 'submit']"));
        String expText = "Dashboard";
        String actText = getTextFromElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        Assert.assertEquals("Not Matching",actText, expText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
