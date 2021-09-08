import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class GoogleHomePage {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void GoogleHomePage() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.id("identifierId")).sendKeys("samianira544", Keys.ENTER);
        Thread.sleep(3000);
        wait = new WebDriverWait(driver, 20);
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("G!@123456", Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

        String text = driver.findElement(By.cssSelector("[id=name]")).getText();
        Assert.assertTrue(text.contains("Try Again"));
    }





}