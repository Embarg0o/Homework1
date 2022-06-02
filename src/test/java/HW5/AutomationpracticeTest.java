package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationpracticeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String Automationpractice_BASE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(Automationpractice_BASE_URL);
    }
    @Test
    void DressyFiltrTest(){


        WebElement dressy = driver.findElement(By.id("layered_id_feature_16"));
        dressy.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-remove']")));
        driver.findElement(By.xpath("//i[@class='icon-remove']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='icon-remove']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//i[@class='icon-remove']")).getText(), true);

    }
    @Test
    void DressyTest(){
        WebElement sizeL = driver.findElement(By.id("layered_id_attribute_group_3"));
        sizeL.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        driver.findElement(By.xpath("//a[@title='Cancel']")).click();
    }

    @Test
    void CasualDresses(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("layered_id_feature_11")));
        Assertions.assertEquals(driver.findElement(By.id("layered_id_feature_11")).getText(), true);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
