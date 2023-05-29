package automationdemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import automationdemo.pages.HomePage;
import automationdemo.pages.LoginPage;
import automationdemo.pages.ContactPage;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static ContactPage contactPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

