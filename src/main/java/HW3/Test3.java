package HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sizeL = driver.findElement(By.id("layered_id_attribute_group_3"));
        sizeL.click();

        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        driver.findElement(By.xpath("//a[@title='Cancel']")).click();

        //Thread.sleep(5000);
        WebElement dressy = driver.findElement(By.id("layered_id_feature_16"));
        dressy.click();
        Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-remove']")));
        driver.findElement(By.xpath("//i[@class='icon-remove']")).click();

        Thread.sleep(10000);
        driver.quit();

    }
}
