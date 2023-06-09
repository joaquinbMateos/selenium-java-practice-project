package automationdemo.tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import automationdemo.pages.HomePage;
import automationdemo.pages.CartPage;

public class CartTest extends BaseTest{
    private static String homeUrl = "https://automationexercise.com/";
    private static String cartUrl = "https://automationexercise.com/view_cart";

    //Locators:
    By modalBtn = By.xpath("//button[text()='Continue Shopping']");
    By product1 = By.xpath("//tr[@id='product-1']");
    By product2 = By.xpath("//tr[@id='product-2']");

    @Test()
        public void removeProduct(){
            homePage = new HomePage(driver);
            cartPage = new CartPage(driver);
            driver.get(homeUrl);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.urlToBe(homeUrl));
            homePage.addProduct1();
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalBtn));
            homePage.continueShoppingBtn();
            homePage.addProduct2();
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalBtn));
            homePage.continueShoppingBtn();
            homePage.clickCart();
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, cartUrl);
            cartPage.removeProduct();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(product1));
            cartPage.checkPresentAndRemovedProducts(product1);
            cartPage.checkPresentAndRemovedProducts(product2);
        }   
}
