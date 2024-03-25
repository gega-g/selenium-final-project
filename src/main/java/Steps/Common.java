package Steps;

import Data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common extends Pages.BasePage {

    public Common(WebDriver driver) {
        super(driver);
    }
    public void clickOn(WebElement element){
        element.click();
    }
    public void navigateToLandingPage(){
        driver.get(Constants.HOMEURL);
    }

    public void clickAndFill(WebElement element, int num) {
        element.click();
        element.sendKeys(String.valueOf(num));
    }

    public void clickAndFill(WebElement element, String key){
        element.click();
        element.sendKeys(key);
    }

    public void acceptCookies(){
        clickOn(driver.findElement(By.xpath("//div[@class='acceptCookie']")));
    }
}
