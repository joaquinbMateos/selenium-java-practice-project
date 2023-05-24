package automationdemo.tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import automationdemo.pages.HomePage;
import automationdemo.pages.ContactPage;

public class ContactTest extends BaseTest{
    private static String homeUrl = "https://automationexercise.com/";
    private static String expectedContactTitle = "GET IN TOUCH";

    @Test(dataProvider = "msgInfo")
        public void formContact(String name, String email, String subject, String msg, String file){
            homePage = new HomePage(driver);
            contactPage = new ContactPage(driver);
            driver.get(homeUrl);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.urlToBe(homeUrl));
            homePage.clickContact();
            String contactTitle = contactPage.getContactTitle();
            Assert.assertEquals(contactTitle, expectedContactTitle);
            contactPage.typeName(name);
            contactPage.typeEmail(email);
            contactPage.typeSubject(subject);
            contactPage.typeMsg(msg);
            contactPage.addFile(file);
            contactPage.clickSubmit();
            driver.switchTo().alert().accept();
            contactPage.getSuccessMsg();
            contactPage.clickHome();
            wait.until(ExpectedConditions.urlToBe(homeUrl));
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, homeUrl);
        }   
    @DataProvider(name = "msgInfo")
        public Object[][] getCredentials(){
        return new Object[][]{
            {"agus",
            "agus@mail.com",
             "213523", 
             "213523", 
             "C://Users//Agustin//Downloads//tc1.png"}
        };
    }
}

