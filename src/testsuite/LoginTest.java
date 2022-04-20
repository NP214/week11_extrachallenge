package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

// Enter valid username
        driver.findElement(By.name("username")).sendKeys("abcn");
//Enter valid password
        driver.findElement(By.name("password")).sendKeys("abcn123");
//Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//Verify the ‘Accounts Overview’ text is display
        String expectedText = "Accounts Overview";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")).getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);
 }
 @Test
        public void verifyTheErrorMessage() {
//Enter invalid username
            driver.findElement(By.name("username")).sendKeys("abcn");
//Enter invalid password
            driver.findElement(By.name("password")).sendKeys("abcn123");
//Click on Login button
            driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//Verify the error message ‘The username and password could not be verified.’
            String expectedText = "The username and password could not be verified.";
            String actualText = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")).getText();
            System.out.println(actualText);
            Assert.assertEquals(expectedText,actualText);
        }
        @Test
        public void userShouldLogOutSuccessfully () {
//Enter valid username
            driver.findElement(By.name("username")).sendKeys("vpatel47");
//Enter valid password
            driver.findElement(By.name("password")).sendKeys("123456");
//Click on ‘LOGIN’ button
            driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//Click on ‘Log Out’ link
            driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
//Verify the text ‘Customer Login’
            String expectedText = "Customer Login";
            String actualText = driver.findElement(By.xpath("Customer Login")).getText();
            System.out.println(actualText);
            Assert.assertEquals(expectedText,actualText);
        }
        @After
    public void tearDown(){
        closeBrowser();
        }
    }
