package Pages;

import Data.Constants;
import Steps.Common;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateNewAccountPage extends Pages.BasePage {

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }
    Common common = new Common(driver);

    public void fillEmail(){
        WebElement emailField = driver.findElement(By.id(Constants.EMAIL));
        common.clickAndFill(emailField,Constants.NOTEMAIL);
    }
    public void fillPassword(){
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        common.clickAndFill(password, Constants.PASSWORD);
    }
    public void fillPasswordRepeat(){
        WebElement passwordRepeat = driver.findElement(By.id(Constants.PASSWORDRETYPE));
        common.clickAndFill(passwordRepeat, Constants.PASSWORD);
    }
    public void setGender(){
        common.clickOn(driver.findElement(By.xpath("//span[contains(text(), 'მდედრობითი')]")));
    }
    public void fillName(){
        WebElement firstName = driver.findElement(By.cssSelector("input[type='text'][name='firstname'][placeholder='სახელი']"));
        common.clickAndFill(firstName,Constants.NAME);
    }
    public void fillLastName(){
        WebElement lastName = driver.findElement(By.cssSelector("input[type='text'][name='lastname'][placeholder='გვარი']"));
        common.clickAndFill(lastName,Constants.LASTNAME);
    }
    public void scrollToButton() {
        WebElement submitButton = driver.findElement(By.id(Constants.REGISTRATIONBUTTON));
        wait.until((ExpectedCondition<Boolean>) driver -> js.executeScript("return document.readyState").equals(Constants.COMPLETE));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    }
    public void chooseBirthDate(){
        WebElement dropDown = driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']"));
        common.clickOn(dropDown);
        WebElement year = driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--selectable']"));
        common.clickOn(year);
    }
    public void fillPhoneNumber(){
        WebElement phoneNumber = driver.findElement(By.id(Constants.PHONE));
        common.clickAndFill(phoneNumber, 514222222);
    }
    public void fillPhoneCode(){
        WebElement phoneCode = driver.findElement(By.id(Constants.PHONECODE));
        common.clickAndFill(phoneCode, 1234);
    }
    public void checkmarks(){
        List<WebElement> checkmarks = driver.findElements(By.xpath("//span[@class='checkmark'][1]"));
        for(WebElement checkmark:checkmarks){
            checkmark.click();
        }
    }
    public void submit(){
        WebElement submitButton = driver.findElement(By.id(Constants.REGISTRATIONBUTTON));
        common.clickOn(submitButton);
    }
    public void emailMessage(){
        String emailMessage = driver.findElement(By.id(Constants.INPUTERRORMAIL)).getText();
        Assert.assertEquals(emailMessage,Constants.MAILISINCORRECT);
    }


}


