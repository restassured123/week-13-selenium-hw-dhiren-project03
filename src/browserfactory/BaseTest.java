package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void  openingBrowser(String baseUrl){

        driver= new ChromeDriver();

        driver.get(baseUrl);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    public void closingBrowser(){

        driver.quit();
    }
}
