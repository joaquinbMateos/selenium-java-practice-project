package automationdemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //Locators:
    By emailInput = By.xpath("//div[@class='login-form']/form/input[@type='email']");
    By passInput = By.xpath("//div[@class='login-form']/form/input[@type='password']");
    By loginSbmt = By.xpath("//div[@class='login-form']/form/button[@type='submit']");
    By loginTitle = By.xpath("//h2[text()='Login to your account']");
    By invalidCredentialsMsg = By.xpath("//p[text()='Your email or password is incorrect!']");
    //Constructor:
    public LoginPage(WebDriver driver) {
        super(driver);
    }
            //Methods:
    public String getLoginTitle(){
        return text(loginTitle);
    }
    public String getInvalidCredentialsMsg(){
        return text(invalidCredentialsMsg);
    }
    public void typeEmail(String text){
        type(emailInput, text);
    }
    public void typePassword(String text){
        type(passInput, text);
    }
    public void clickLogin(){
        click(loginSbmt);
    }



}

