package Steps;

import Data.Constants;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateNewAccountPageSteps extends BasePageSteps {

    public CreateNewAccountPageSteps(WebDriver driver) {
        super(driver);
    }
    CommonSteps commonSteps = new CommonSteps(driver);

    public CreateNewAccountPageSteps fillEmail(){
        WebElement emailField = driver.findElement(By.id(Constants.EMAIL));
        commonSteps.clickAndFill(emailField,Constants.NOTEMAIL);
        return this;
    }
    public CreateNewAccountPageSteps fillPassword(){
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        commonSteps.clickAndFill(password, Constants.PASSWORD);
        return this;
    }
    public CreateNewAccountPageSteps fillPasswordRepeat(){
        WebElement passwordRepeat = driver.findElement(By.id(Constants.PASSWORDRETYPE));
        commonSteps.clickAndFill(passwordRepeat, Constants.PASSWORD);
        return this;
    }
    public CreateNewAccountPageSteps setGender(){
        commonSteps.clickOn(driver.findElement(By.xpath("//span[contains(text(), 'მდედრობითი')]")));
        return this;
    }
    public CreateNewAccountPageSteps fillName(){
        WebElement firstName = driver.findElement(By.cssSelector("input[type='text'][name='firstname'][placeholder='სახელი']"));
        commonSteps.clickAndFill(firstName,Constants.NAME);
        return this;
    }
    public CreateNewAccountPageSteps fillLastName(){
        WebElement lastName = driver.findElement(By.cssSelector("input[type='text'][name='lastname'][placeholder='გვარი']"));
        commonSteps.clickAndFill(lastName,Constants.LASTNAME);
        return this;
    }
    public CreateNewAccountPageSteps scrollToButton() {
        WebElement submitButton = driver.findElement(By.id(Constants.REGISTRATIONBUTTON));
        wait.until((ExpectedCondition<Boolean>) driver -> js.executeScript("return document.readyState").equals(Constants.COMPLETE));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        return this;
    }
    public CreateNewAccountPageSteps chooseBirthDate(){
        WebElement dropDown = driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']"));
        commonSteps.clickOn(dropDown);
        WebElement year = driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--selectable']"));
        commonSteps.clickOn(year);
        return this;
    }
    public CreateNewAccountPageSteps fillPhoneNumber(){
        WebElement phoneNumber = driver.findElement(By.id(Constants.PHONE));
        commonSteps.clickAndFill(phoneNumber, 514222222);
        return this;
    }
    public CreateNewAccountPageSteps fillPhoneCode(){
        WebElement phoneCode = driver.findElement(By.id(Constants.PHONECODE));
        commonSteps.clickAndFill(phoneCode, 1234);
        return this;
    }
    public CreateNewAccountPageSteps checkmarks(){
        List<WebElement> checkmarks = driver.findElements(By.xpath("//span[@class='checkmark'][1]"));
        for(WebElement checkmark:checkmarks){
            checkmark.click();
        }
        return this;
    }
    public CreateNewAccountPageSteps submit(){
        WebElement submitButton = driver.findElement(By.id(Constants.REGISTRATIONBUTTON));
        commonSteps.clickOn(submitButton);
        return this;
    }
    public CreateNewAccountPageSteps emailMessage(){
        String emailMessage = driver.findElement(By.id(Constants.INPUTERRORMAIL)).getText();
        Assert.assertEquals(emailMessage,Constants.MAILISINCORRECT);
        return this;
    }


}


