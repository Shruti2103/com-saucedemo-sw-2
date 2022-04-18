package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class loginTest extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    // click on login click
    @Before
    public void setbrowser() {
        openbrowser(baseurl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //create username
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        // create password
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("secret_sauce");
        // create login button
        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();
        // verify text "Products"
        WebElement product = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        product.getText();
        //  varify product field
        String expextedmessage = "PRODUCTS";
        WebElement actualmessage = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        actualmessage.getText();
        String actualmessage1 = actualmessage.getText();
        //Assert actual with expected
        Assert.assertEquals("User is on Products ", expextedmessage, actualmessage1);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // create user name
        WebElement username = driver.findElement(By.xpath("standard_user"));
        username.sendKeys("standard_user");
        // password field create
        WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
        passwordfield.sendKeys("secret_sauce");
        // click log in button
        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();
        // varify that 6 products are displayed
        int expectedmessage = 6;
        List<WebElement> produsts = driver.findElements(By.className("inventory_item"));
        int size = produsts.size();
        System.out.println(size);
        // validate expected and actual message
        Assert.assertEquals("unable to display 6 products", expectedmessage, size);


    }
@After
    public void teardown(){
        closebrowser();
}

}
