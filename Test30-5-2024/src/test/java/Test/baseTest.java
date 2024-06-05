package Test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class baseTest {
    WebDriver driver;
    public Faker fake=new Faker();
    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions opt = new EdgeOptions();
        opt.addExtensions(new File("src/main/resources/gighmmpiobklfepjocnamgkkbiglidom.crx"));
        driver=new EdgeDriver(opt);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   Thread.sleep(5000);
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.get("https://www.travelkwt.com/");

    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
