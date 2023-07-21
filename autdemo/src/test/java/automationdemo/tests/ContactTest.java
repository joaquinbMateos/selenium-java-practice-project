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
    //private static String relativePath = "\\src\\test\\java\\automationdemo\\utils\\tc1.png";
    private static String relativePath2 = "/src/test/java/automationdemo/utils/tc1.png";

    @Test(dataProvider = "msgInfo")
        public void formContact(String name, String email, String subject, String msg){
            homePage = new HomePage(driver);
            contactPage = new ContactPage(driver);
            driver.get(homeUrl);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.urlToBe(homeUrl));
            homePage.clickContact();
            String contactTitle = contactPage.getContactTitle();
            Assert.assertEquals(contactTitle, expectedContactTitle);
            contactPage.typeName(name);
            contactPage.typeEmail(email);
            contactPage.typeSubject(subject);
            contactPage.typeMsg(msg);
            String basePath = System.getProperty("user.dir");
            //String filePath = basePath + relativePath;
            String filePath2 = basePath + relativePath2;
            contactPage.addFile(filePath2);
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
             "213523"}
        };
    }
}

