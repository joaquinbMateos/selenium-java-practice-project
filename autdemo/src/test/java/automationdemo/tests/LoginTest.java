package automationdemo.tests;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationdemo.pages.HomePage;
import automationdemo.pages.LoginPage;

public class LoginTest extends BaseTest{
    private static String homeUrl = "https://automationexercise.com/";
    private static String expectedUrl = "https://automationexercise.com/login";
    private static String expectedLoginTitle = "Login to your account";
    
    @Test(dataProvider = "userData")
    public void loginWithValidCredentials(String email, String password){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(homeUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlToBe(homeUrl));
        homePage.clickLogin();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        String loginTitle = loginPage.getLoginTitle();
        Assert.assertEquals(loginTitle, expectedLoginTitle);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        WebElement loggedUser = homePage.getLoggedUser();
        Assert.assertTrue(loggedUser.isDisplayed());
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String email, String password){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(homeUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlToBe(homeUrl));
        homePage.clickLogin();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        String loginTitle = loginPage.getLoginTitle();
        Assert.assertEquals(loginTitle, expectedLoginTitle);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        String invalidCredenstialsMsg = loginPage.getInvalidCredentialsMsg();
        Assert.assertEquals(invalidCredenstialsMsg, "Your email or password is incorrect!");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials(){
        return new Object[][]{
            {"agust@mail.com","213523"}
        };
    }

    @DataProvider(name = "validCredentials")
    public Object[][] getValidCredentials(){
        return new Object[][]{
            {"test@automation.com", "seleniumjava"}
        };
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws Exception {
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/java/automationdemo/utils/config.json")));
        JSONObject jsonObject = new JSONObject(jsonContent);
        String userEmail = jsonObject.getString("userEmail");
        String password = jsonObject.getString("password");

        Object[][] data = new Object[1][2];
        data[0][0] = userEmail;
        data[0][1] = password;

        return data;
    }
}