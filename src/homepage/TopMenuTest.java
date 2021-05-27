package homepage;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before

    public void openBrowser(){
        openBrowser(baseUrl);
    }


    public void selectMenu (String menu){

       //driver.findElement(By.xpath(menu)).click();
        clickOnElement(By.xpath(menu));

    }

    @Test

    public void verifyPageNavigation(){
        selectMenu("//body/div[6]/div[2]/ul[1]/li[1]/a[1]");

        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String expectedMessage = "Computers";
        Assert.assertEquals("User should not navigate to computer page ",expectedMessage,actualMessage);


    }

}
