package computer;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestSuite extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser(){
        openBrowser(baseUrl);
    }




    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        Actions action = new Actions(driver);

        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        action.moveToElement(computer).build().perform();
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        action.moveToElement(desktop).click().build().perform();

        Thread.sleep(3000);
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));

        String expectedText = "Name: Z to A";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("User not able to navigate ", expectedText,actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Actions action = new Actions(driver);

        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        action.moveToElement(computer).build().perform();
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        action.moveToElement(desktop).click().build().perform();

       Thread.sleep(5000);
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));

        Thread.sleep(5000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("User not able to navigate ", expectedText,actualText);

        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='product_attribute_1']"), "1");
        selectByValueDropDown(By.xpath("//select[@id='product_attribute_2']"),"5");
        clickOnElement(By.xpath("//label[text()='400 GB [+$100.00]']"));
        Thread.sleep(5000);

        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//label[text()='Total Commander [+$5.00]']"));


        String expectedPrice = "$1,475.00";
        Thread.sleep(5000);
        String actualPrice = getTextFromElement(By.xpath("//span[@class='price-value-1']"));
        Assert.assertEquals("User not able to add to cart ", expectedPrice,actualPrice);

        clickOnElement(By.id("add-to-cart-button-1"));

        String expectedGreenBarMassage = "The product has been added to your shopping cart";
        Thread.sleep(5000);
        String actualGreenBarMassage = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("The product will not added to the cart ", expectedGreenBarMassage,actualGreenBarMassage);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        Thread.sleep(5000);

        WebElement shoppingCart = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        action.moveToElement(shoppingCart).build().perform();
        Thread.sleep(5000);
        action.moveToElement(goToCart).click().build().perform();

        String expectedHeadingText = "Shopping cart";
        String actualHeadingText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User is not on shopping cart ",expectedHeadingText,actualHeadingText);

       Thread.sleep(5000);
        WebElement quantityBox = driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        String expectedCartTotal = "$2,950.00";
        String actualCartTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("User shopping cart is not updated ",expectedCartTotal,actualCartTotal);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(5000);

        String expectedSignInText = "Welcome, Please Sign In!";
        String actualSignInText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("User is not able to complete shopping ",expectedSignInText,actualSignInText);

        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        Thread.sleep(5000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Dipak");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']']"),"Dipak123@gmail.com");
       Thread.sleep(5000);


        selectByValueDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Ahmedabad");
        sendTextToElement(By.xpath("//input[contains(@id,'BillingNewAddress_Address1')]"),"16 B H Colony");
        Thread.sleep(5000);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"380012");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"0777888092");

       Thread.sleep(5000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//div[@class='method-name']//input[contains(@id,'shippingoption_1')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        Thread.sleep(5000);
        selectByValueDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");

        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"D Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5404 0000 0000 0001");

        selectByValueDropDown(By.xpath("//select[@id='ExpireMonth']"),"11");
        selectByValueDropDown(By.xpath("//select[@id='ExpireYear']"),"2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

       Thread.sleep(5000);
        String expectedPaymentMethodText = "Credit Card";
        String actualPaymentMethodText = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("User payment method is wrong ",expectedPaymentMethodText,actualPaymentMethodText);

        String expectedShippingMethodText = "Next Day Air";
        String actualShippingMethodText = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("User shipping method is wrong ",expectedShippingMethodText,actualShippingMethodText);

        Thread.sleep(5000);

        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("User Total method is wrong ",expectedTotal,actualTotal);

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        String expectedFinishShoppingText = "Thank you";
        String actualFinishShoppingText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("User not able to greeting text ",expectedFinishShoppingText,actualFinishShoppingText);

        Thread.sleep(5000);

        String expectedSuccessfulText = "Your order has been successfully processed!";
        String actualSuccessfulText = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("User not able to finish shopping successfully ",expectedSuccessfulText,actualSuccessfulText);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        String expectedWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("User not navigate to home page ",expectedWelcomeText,actualWelcomeText);
    }


    @After

    public void tearBrowser(){
        closeBrowser();
    }


    }

