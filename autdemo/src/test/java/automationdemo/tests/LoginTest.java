package automationdemo.tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import automationdemo.pages.HomePage;
import automationdemo.pages.LoginPage;
public class LoginTest extends BaseTest{
    private static String homeUrl = "https://automationexercise.com/";
    private static String expectedUrl = "https://automationexercise.com/login";
    private static String expectedLoginTitle = "Login to your account";
    
    @Test
    public void loginTest(){
        homePage = new HomePage(driver);
        driver.get(homeUrl);
        homePage.clickLogin();
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
    public Object[][] getCredentials(){
        return new Object[][]{
            {"agust@mail.com","213523"}
        };
    }
}