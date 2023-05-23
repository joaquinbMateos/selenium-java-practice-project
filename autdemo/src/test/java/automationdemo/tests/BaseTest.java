package automationdemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import automationdemo.pages.HomePage;
import automationdemo.pages.LoginPage;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

