package browserfactory;

import org.openqa.selenium.By;

public class Uitility extends BaseTest{
    public void clickOnTheElement(By by) {
        driver.findElement(by).click();
    }
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
}
