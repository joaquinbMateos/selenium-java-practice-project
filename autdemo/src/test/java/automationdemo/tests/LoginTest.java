package automationdemo.tests;
import org.testng.annotations.Test;

import automationdemo.pages.HomePage;

public class LoginTest extends BaseTest{
    private static String homeUrl = "https://automationexercise.com/";
    
    @Test
    public void loginTest(){
        homePage = new HomePage(driver);
        driver.get(homeUrl);
        homePage.clickLogin();
    }
}
