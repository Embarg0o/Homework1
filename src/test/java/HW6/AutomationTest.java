package HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void addToCartTest() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage(driver).login("movlyanandrew1993@mail.ru", "631679");

    }
    @AfterEach
    void tearDown () {
        driver.quit();
    }
}
