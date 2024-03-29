package Steps;

import Data.Constants;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


public class LandingPageSteps extends BasePageSteps {

    public LandingPageSteps(WebDriver driver) {
        super(driver);
    }

    CommonSteps commonSteps = new CommonSteps(driver);
    public LandingPageSteps clickOnCategories(){
        commonSteps.clickOn(driver.findElement(By.xpath("//p[@class='categoriesTitle'][contains(text(), 'კატეგორიები')]")));
        return this;
    }
    public LandingPageSteps clickOnCarting(){
        commonSteps.clickOn(driver.findElement(By.xpath("//a[@href='/category/2058/sporti/kartingi']")));
        return this;
    }

    public LandingPageSteps hoverOnSport() {
        WebElement sport = driver.findElement(By.xpath("//li[@cat_id='CatId-6']/a[@href='/category/110/sporti']"));
        js.executeScript(Constants.JSHOVERONSPORT, sport);
        return this;
    }

    public LandingPageSteps urlMatcher(String string) {
        Assert.assertEquals(string, driver.getCurrentUrl());
        return this;
    }

    public LandingPageSteps colorChecker() {
        WebElement blueCarting = driver.findElement(By.xpath("//div[@class='clearfix']//span[contains(text(), 'კარტინგი')]"));
        String color = blueCarting.getCssValue(Constants.COLOR);
        Color actualColor = Color.fromString(color);
        Assert.assertEquals(actualColor.asHex().toUpperCase(), Constants.COLORCODE);
        return this;
    }
    public LandingPageSteps clickOnLogo(){
        commonSteps.clickOn(driver.findElement(By.xpath("//a[@class='Newlogo']")));
        return this;
    }

}

