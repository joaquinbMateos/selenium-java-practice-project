package automationdemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    //Locators:
    By removeProduct1 = By.xpath("//a[@data-product-id='1']");
   
    //Constructor:
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Methods:
    public void removeProduct(){
        click(removeProduct1);
    }

    public void checkPresentAndRemovedProducts(By locator){
        if(elementIsDisplayed(locator))
            System.out.println("Element 1 is present and displayed");
        else
            System.out.println("Element 2 is present but not displayed"); 
    }

}

