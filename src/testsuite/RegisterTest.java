package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // WebElement registerButton = driver.findElement(By.linkText("Register"));//register button locator
        //registerButton.click();//click register button
        clickOnElement(By.linkText("Register"));
        //WebElement registerText = driver.findElement(By.linkText("Register"));//register text locator
        //String actualMessage = registerText.getText();// get text
        //String expectedMessage = "Register";// stored expected msg
        //Assert.assertEquals("Register Text not visible", expectedMessage, actualMessage);// validation of actual and expected
        verifyText("Register",By.linkText("Register"),"Register");
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // WebElement registerButton= driver.findElement(By.linkText("Register"));//register button locator
        //registerButton.click();//click register button
        clickOnElement(By.linkText("Register"));

        sendTextToElement(By.id("FirstName"),"xyz");

        sendTextToElement(By.id("LastName"),"uvw");

        WebElement emailField=driver.findElement(By.id("Email"));// email field locator
        emailField.click();// click email field
        clickOnElement(By.id("Email"));
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username"+ randomInt +"@gmail.com");// creating random email generator

        sendTextToElement(By.id("Password"),"Churchstreet");

        sendTextToElement(By.id("ConfirmPassword"),"Churchstreet");

        clickOnElement(By.id("register-button"));


        verifyText("Your registration completed",By.xpath("//div[@class='page-body']//div[@class='result']"),"Registration completed text not visible");
    }
    @After
    public void close(){
        closeBrowser();

    }
}
