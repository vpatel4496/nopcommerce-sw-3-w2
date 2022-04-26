package browsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);// launch the Url
        driver.manage().window().maximize();// maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// implicit time to driver

    }
    public void closeBrowser(){
        driver.close();
    }
}
