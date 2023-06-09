package automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    //Locators:
    By loginBtn = By.xpath("//a[@href='/login']");
    By contactBtn = By.xpath("//a[@href='/contact_us']");
    By cartBtn = By.xpath("//li/a[@href='/view_cart']");
    By loggedUser = By.xpath("//a[i[contains(@class, 'fa fa-user')]]/b[text()='testAutomation']");
    By product1 = By.xpath("//div[@class='productinfo text-center']/a[@data-product-id='1']");
    By product2 = By.xpath("//div[@class='productinfo text-center']/a[@data-product-id='2']");
    By continueShoppingBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");  
    
    //Constructor:
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Methods:
    public void clickLogin(){
        click(loginBtn);
    }

    public void clickContact(){
        click(contactBtn);
    }
    
    public void clickCart(){
        click(cartBtn);
    }

    public void addProduct1(){
        click(product1);
    }

    public void addProduct2(){
        click(product2);
    }
    
    public void continueShoppingBtn(){
        click(continueShoppingBtn);
    }

    public WebElement getLoggedUser() {
        return find(loggedUser);
    }
}
