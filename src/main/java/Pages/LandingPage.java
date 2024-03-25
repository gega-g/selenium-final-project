package Pages;

import Data.Constants;
import Steps.Common;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


public class LandingPage extends Pages.BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    Common common = new Common(driver);
    public void clickOnCategories(){
        common.clickOn(driver.findElement(By.xpath("//p[@class='categoriesTitle'][contains(text(), 'კატეგორიები')]")));
    }
    public void clickOnCarting(){
        common.clickOn(driver.findElement(By.xpath("//a[@href='/category/2058/sporti/kartingi']")));
    }

    public void hoverOnSport() {
        WebElement sport = driver.findElement(By.xpath("//li[@cat_id='CatId-6']/a[@href='/category/110/sporti']"));
        js.executeScript(Constants.JSHOVERONSPORT, sport);
    }

    public void urlMatcher(String string) {
        Assert.assertEquals(string, driver.getCurrentUrl());
    }

    public void colorChecker() {
        WebElement blueCarting = driver.findElement(By.xpath("//div[@class='clearfix']//span[contains(text(), 'კარტინგი')]"));
        String color = blueCarting.getCssValue(Constants.COLOR);
        Color actualColor = Color.fromString(color);
        Assert.assertEquals(actualColor.asHex().toUpperCase(), Constants.COLORCODE);
    }
    public void clickOnLogo(){
        common.clickOn(driver.findElement(By.xpath("//a[@class='Newlogo']")));
    }

}

