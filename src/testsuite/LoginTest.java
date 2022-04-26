package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find login link and click on login link and
        clickOnElement(By.linkText("Log in"));
        verifyText("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome Text Display");

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find login link and click on login link
        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"),"wxyz@gmail.com");

        sendTextToElement(By.id("Password"),"password");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        verifyText("Log out",(By.className("ico-logout")),"Log Out");
    }
    @Test
    public void verifyTheErrorMessage(){
        //find login link and click on login link

        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"),"xyz1@gmail.com");

        sendTextToElement(By.id("Password"),"Abc1234@");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        verifyText("Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect",(By.xpath("//form[@method='post']//div[@class='message-error validation-summary-errors']")),"Error message not valid");
    }
    @After
    public void close(){
        closeBrowser();
    }

}