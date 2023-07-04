package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility
{
    String baseUrl="https://www.saucedemo.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyUserShouldLoginSuccessfullyWithCredentials()
    {
        //Enter “standard_user” username
        sendTextToElements(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElements(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on 'LOGIN' button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text "PRODUCTS"
        String expectedText="Products";
        String actualText=getTextFromElement(By.xpath("//span[@class ='title']"));
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayOnPage()
    {
        //Enter “standard_user” username
        sendTextToElements(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElements(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify that six products are displayed on page
        String expectedText= "Sauce Labs Backpack";
        String actualText=getTextFromElement(By.xpath("//div[@class='inventory_item_name']"));
    }
    @After
    public void tearDown()
    {
        //close the Browser
        driver.quit();
    }
}
