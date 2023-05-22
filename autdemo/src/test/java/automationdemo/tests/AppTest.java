package automationdemo.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class AppTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //chrome web driver:
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joaco\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    // @Test
    // public void seleniumTest(){
    //     String url = "https://automationexercise.com/";
    //     //inicializar web driver:
    //     driver = new ChromeDriver();
    //     //visitar app:
    //     driver.get(url);
    //     //maximiza la pantalla.
    //     driver.manage().window().maximize();
    //     //validar titulo de la página:
    //     String expectedTitle = "Automation Exercise";
    //     String actualTitle = driver.getTitle();
    //     Assert.assertEquals(actualTitle, expectedTitle);
    //     //navigate:
    //     driver.navigate().to("https://automationexercise.com/products");
    //     driver.navigate().back();
    //     //validar url:
    //     String expectedUrl = "https://automationexercise.com/";
    //     String actualUrl = driver.getCurrentUrl();
    //     Assert.assertEquals(actualUrl, expectedUrl);
    // }

    // @Test
    // public void webElements(){
    //     //elemento:
    //     By productsBtn = By.xpath("//a[@href='/products']");
    //     driver.findElement(productsBtn).click();
    //     //elementos:
    //     By products = By.xpath("//div[@class='single-products']"); // 40 elementos
    //     List<WebElement> listOfProducts = driver.findElements(products);
    //     WebElement firstProduct = listOfProducts.get(0);
    //     JavascriptExecutor js = (JavascriptExecutor) driver;
    //     js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);
    // }

    @Test(dataProvider = "credentials")
    public void login(String email, String password){
        driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/login");
        //elementos:
        By emailInput = By.xpath("//div[@class='login-form']/form/input[@type='email']");
        By passInput = By.xpath("//div[@class='login-form']/form/input[@type='password']");
        By loginBtn = By.xpath("//div[@class='login-form']/form/button[@type='submit']");
        //metodos (acciones sobre elementos):
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    @AfterSuite
    public void tearDown(){
        //close-quit driver:
        driver.close();
		driver.quit();	
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentials(){
        return new Object[][]{
            {"test@automation.com","seleniumjava"},
            {"test1@automation.com","seleniumjava1"}
        };
    }
}
