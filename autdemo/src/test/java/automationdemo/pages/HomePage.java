package automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    //Locators:
    By loginBtn = By.xpath("//a[@href='/login']");
    By contactBtn = By.xpath("//a[@href='/contact_us']");
    By loggedUser = By.xpath("//a[i[contains(@class, 'fa fa-user')]]/b[text()='testAutomation']");
   
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

    public WebElement getLoggedUser() {
        return find(loggedUser);
    }
}
