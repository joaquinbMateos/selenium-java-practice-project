package automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{
    //Locators:
    By contactTitle = By.xpath("//h2[text()='Get In Touch']");
    By nameInput = By.xpath("//input[@name='name']");
    By emailInput = By.xpath("//input[@name='email']");
    By subjectInput = By.xpath("//input[@name='subject']");
    By textAreaMsg = By.xpath("//textarea[@name='message']");
    By inputFile = By.xpath("//input[@name='upload_file']");
    By btnSubmit = By.xpath("//input[@name='submit']");
    By successMsg = By.xpath("//div[@class='status alert alert-success']");
    By homeBtn = By.xpath("//a[@href='/']");



    //Constructor:
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    //Methods:

    public String getContactTitle(){
        return text(contactTitle);
    }
    public void typeName(String text){
        type(nameInput, text);
    }
    public void typeEmail(String text){
        type(emailInput, text);
    }
    public void typeSubject(String text){
        type(subjectInput, text);
    }
    public void typeMsg(String text){
        type(textAreaMsg, text);
    }
    public void addFile(String text){
        type(inputFile, text);
    }
    public void clickSubmit(){
        click(btnSubmit);
    }
    public String getSuccessMsg(){
        return text(successMsg);
    }
    public void clickHome(){
        click(homeBtn);
    }
}
