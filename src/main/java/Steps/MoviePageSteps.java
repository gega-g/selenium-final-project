package Steps;

import Data.Constants;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MoviePageSteps extends BasePageSteps {
    public MoviePageSteps(WebDriver driver) {
        super(driver);
    }
    CommonSteps commonSteps = new CommonSteps(driver);

    public MoviePageSteps navigateToFirstMovie(){
        commonSteps.clickOn(driver.findElement(By.xpath("//li[@class='MoreCategories']/a[@href='/events']")));
        commonSteps.clickOn(driver.findElement(By.xpath("//div[@class='movies-deal'][1]")));
        return this;
    }
    public MoviePageSteps clickOnEastPoint() {
        WebElement eastPoint = driver.findElement(By.xpath("//a[@id='ui-id-5'][@class='ui-tabs-anchor']"));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, eastPoint);
        eastPoint.click();
        return this;
    }


    public List<WebElement> getVisibleSeances() {
        List<WebElement> seances = driver.findElements(By.cssSelector(Constants.VISIBLESEANSESCSS));
        List<WebElement> visibleSeances = new ArrayList<>();
        for (WebElement seance : seances) {
            if (seance.isDisplayed()) {
                visibleSeances.add(seance);
                String cinemaTitleText = seance.getText();
                Assert.assertTrue(cinemaTitleText.contains(Constants.CAVEAEASTPOINT));
            }
        }
        return visibleSeances;
    }

    public MoviePageSteps chooseLastDay() {
        List<WebElement> days = driver.findElements(By.cssSelector(Constants.CHOOSELASTDAYCSS));
        List<WebElement> displayedDays = new ArrayList<>();
        for (WebElement day : days) {
            if (day.isDisplayed()) {
                displayedDays.add(day);
            }
        }
        WebElement lastDay = displayedDays.get(displayedDays.size() - 1);
        lastDay.click();
        return this;
    }
    public MoviePageSteps clickOnLastSeance() {
        List<WebElement> visibleSeances = getVisibleSeances();
        if (!visibleSeances.isEmpty()) {
            WebElement lastSeance = visibleSeances.get(visibleSeances.size() - 1);
            lastSeance.click();
        } else {
            Assert.fail(Constants.THEREARENOELEMENTS);
        }
        return this;
    }
    public MoviePageSteps validateName(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='seat free']")));
        String name = driver.findElement(By.xpath("//p[@class='name']")).getText();
        String nameInPopup = driver.findElement(By.xpath("//p[@class='movie-title']")).getText();
        Assert.assertEquals(name,nameInPopup);
        return this;
    }
    public MoviePageSteps validateCinema(){
        String cinema = driver.findElement(By.id(Constants.UIID5)).getText();
        String cinemaInPopup = driver.findElement(By.xpath("//p[@class='movie-cinema'][1]")).getText();
        Assert.assertEquals(cinema,cinemaInPopup);
        return this;
    }

    public MoviePageSteps chooseSeatAndStartCreatingAccount(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='seat free']")));
        commonSteps.clickOn(driver.findElement(By.xpath("//div[@class='seat free']")));
        WebElement createNew = driver.findElement(By.xpath("//a[contains(text(), 'შექმენი')]"));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, createNew);
        commonSteps.clickOn(createNew);
        return this;
    }
}