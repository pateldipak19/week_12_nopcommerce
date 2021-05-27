package homepage;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class tesy extends BaseTest {

    String expectedMessage;
    String baseUrl = "https://demo.nopcommerce.com/computers";

    public void selectMenu(String menu) {

        // clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        expectedMessage = menu;
        //getTextFromElement()

    }

    @Before

    public void setUp() {

        openBrowser(baseUrl);

    }
    @Test

    public void verifyPageNavigation() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        selectMenu("Computers");

        Assert.assertEquals("User does not navigate to Computers page ",expectedMessage, actualMessage);


    }
}
