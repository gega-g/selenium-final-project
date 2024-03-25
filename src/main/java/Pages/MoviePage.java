package Pages;

import Data.Constants;
import Steps.Common;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MoviePage extends Pages.BasePage {
    public MoviePage(WebDriver driver) {
        super(driver);
    }
    Common common = new Common(driver);

    public void navigateToFirstMovie(){
        common.clickOn(driver.findElement(By.xpath("//li[@class='MoreCategories']/a[@href='/events']")));
        common.clickOn(driver.findElement(By.xpath("//div[@class='movies-deal'][1]")));
    }
    public void clickOnEastPoint() {
        WebElement eastPoint = driver.findElement(By.xpath("//a[@id='ui-id-5'][@class='ui-tabs-anchor']"));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, eastPoint);
        eastPoint.click();
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

    public void chooseLastDay() {
        List<WebElement> days = driver.findElements(By.cssSelector(Constants.CHOOSELASTDAYCSS));
        List<WebElement> displayedDays = new ArrayList<>();
        for (WebElement day : days) {
            if (day.isDisplayed()) {
                displayedDays.add(day);
            }
        }
        WebElement lastDay = displayedDays.get(displayedDays.size() - 1);
        lastDay.click();
    }
    public void clickOnLastSeance() {
        List<WebElement> visibleSeances = getVisibleSeances();
        if (!visibleSeances.isEmpty()) {
            WebElement lastSeance = visibleSeances.get(visibleSeances.size() - 1);
            lastSeance.click();
        } else {
            Assert.fail(Constants.THEREARENOELEMENTS);
        }
    }
    public void validateName(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='seat free']")));
        String name = driver.findElement(By.xpath("//p[@class='name']")).getText();
        String nameInPopup = driver.findElement(By.xpath("//p[@class='movie-title']")).getText();
        Assert.assertEquals(name,nameInPopup);
    }
    public void validateCinema(){
        String cinema = driver.findElement(By.id(Constants.UIID5)).getText();
        String cinemaInPopup = driver.findElement(By.xpath("//p[@class='movie-cinema'][1]")).getText();
        Assert.assertEquals(cinema,cinemaInPopup);
    }

    public void chooseSeatAndStartCreatingAccount(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='seat free']")));
        common.clickOn(driver.findElement(By.xpath("//div[@class='seat free']")));
        WebElement createNew = driver.findElement(By.xpath("//a[contains(text(), 'შექმენი')]"));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, createNew);
        common.clickOn(createNew);
    }
}