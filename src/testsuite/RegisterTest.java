package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void  verifyThatSigningUpPageDisplay(){
// click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
// Verify the text ‘Signing up is easy!’
String expectedText = "Signing up is easy!";
String actualText = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals("Text is not displayed",expectedText,actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully() {
// click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
// Enter First name
    WebElement firstName = driver.findElement(By.id("customer.firstName"));
   firstName.sendKeys("abc");
// Enter Last name
        WebElement lastName = driver.findElement(By.name("customer.lastName"));
        lastName.sendKeys("patel");
// Enter Address
        WebElement address = driver.findElement(By.name("customer.address.street"));
        address.sendKeys("alvarado Rd.");
//  Enter City
        driver.findElement(By.id("customer.address.city")).sendKeys("phoenix");
//  Enter State
        driver.findElement(By.id("customer.address.state")).sendKeys("Arizona");
// Enter Zip Code
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("85035");
// Enter Phone
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("+15751234567");
// Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
// Enter Username
        driver.findElement(By.id("customer.username")).sendKeys("prish");
// Enter Password
        driver.findElement(By.id("customer.password")).sendKeys("abc123");
// Enter Confirm
        driver.findElement(By.id("repeatedPassword")).sendKeys("abc123");
//Click on REGISTER button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
// Verify the text 'Your account was created successfully. You are now logged in.'
        String expectedText = "Your account was created successfully. You are now logged in.";
String actualText = driver.findElement(By.xpath("//div[@id='bodyPanel']/div[2]/p")).getText();
        System.out.println(actualText);
Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
