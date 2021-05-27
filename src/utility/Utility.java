package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {

    public WebDriver driver;

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    //this method get text form element
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();

    }

    //this method will send text on element
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    public void selectByValueDropDown(By by, String value) {

        //this method select value from drop down

        Select select = new Select(driver.findElement(by));

        //Select by value
        select.selectByValue(value);
    }

    //this method verify the text of navigated page
    public void verifyExpectedText (By by, String expectedMessage) {

        String actualMessage = driver.findElement(by).getText();

        Assert.assertEquals("User does not navigate to " + expectedMessage + "page", expectedMessage, actualMessage);
    }


    //this method mouse hover on selected element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //this method mouse hover on selected element and click on that element
    public void mouseHoverAndClickElement(By by){

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();

    }



    //this method verify current and base url
    public void verifyCurrentUrl(String baseUrl){

        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals("Current url and baseurl does not match",baseUrl,currentUrl);

    }







}
