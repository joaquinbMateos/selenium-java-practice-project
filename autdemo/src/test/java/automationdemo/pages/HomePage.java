package automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //Locators:
    By loginBtn = By.xpath("//a[@href='/login']");
    By contactBtn = By.xpath("//a[@href='/contact_us']");
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

}
