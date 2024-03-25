package Pages;

import Data.Constants;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HolidayPage extends Pages.BasePage {

    public HolidayPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHoliday() {
        driver.get(Constants.HOMEURL);
        WebElement holiday = driver.findElement(By.xpath("//li[@class='MoreCategories']/a[@href='/category/24/dasveneba']"));
        holiday.click();
    }

    public List<Integer> numericValue(List<WebElement> priceElements) {
        List<Integer> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceAsText = priceElement.getAttribute(Constants.INNERTEXT).trim();
            String numbersFromText = priceAsText.replaceAll("[^\\d]", "");
            int finalPrice = Integer.parseInt(numbersFromText);
            prices.add(finalPrice);
        }
        return prices;
    }

    public void nextPage() {
        WebElement nextPage = driver.findElement(By.xpath("//a[img[@src='/Images/NewDesigneImg/categoryIn/arrow-01.png']]/parent::*"));
        if (hasNextPage()) {
            nextPage.click();
        }
    }

    public boolean hasNextPage() {
        WebElement nextPage = driver.findElement(By.xpath("//a[img[@src='/Images/NewDesigneImg/categoryIn/arrow-01.png']]"));
        return !nextPage.getAttribute(Constants.STYLE).contains(Constants.OPACITY);
    }

        public void clickAndFill(WebElement element, int num) {
        element.click();
        element.sendKeys(String.valueOf(num));
    }

        public void wordValidation() {
        List<WebElement> allElements = driver.findElements(By.xpath("//section/div[@class='special-offer']"));
        List<WebElement> elementsContainingKoteji = driver.findElements(By.xpath("//p/a[contains(text(), 'კოტეჯი')]"));
        if (allElements.size() > elementsContainingKoteji.size()) {
            Assert.fail(Constants.WORDVALIDATIONERRORMESSAGE);
        }
    }

    public void searchAndAssert() {
        WebElement search = driver.findElement(By.xpath("//div[@id='sidebar-container']//div[@class='submit-button']"));
        search.click();
        wait.until(ExpectedConditions.urlContains(Constants.MINPRICE));
        Comparator(Constants.PRICERANGETEST, 200, 450);
    }

        public void sortBy(String string) {
        WebElement sort = driver.findElement(By.id(Constants.SORT));
        wait.until(ExpectedConditions.elementToBeClickable(sort));
        sort.click();
        int num = 0;
        switch (string) {
            case Constants.ASCENDING:
                num = 2;
                break;
            case Constants.DESCENDING:
                num = 1;
                break;
            default:
                Assert.fail(Constants.SORTERRORMESSAGE);
        }
        WebElement order = driver.findElement(By.xpath("//select[@id='sort']/option[@value='" + num + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(order));
        order.click();
        wait.until(ExpectedConditions.urlContains(Constants.SORT));
    }
//    public int numericValue() {
//        wait.until(ExpectedConditions.urlContains(Constants.SORT));
//        WebElement firstElement = driver.findElement(By.xpath("//div[@style='float:left;']/p[@class='deal-voucher-price' and not(@style='text-decoration: line-through;')]"));
//        String priceAsText = firstElement.getAttribute(Constants.INNERTEXT).trim();
//        String numbersFromText = priceAsText.replaceAll("[^\\d]", "");
//        int finalPriceOfFirst = Integer.parseInt(numbersFromText);
//        return finalPriceOfFirst;
//    }

        public void Comparator(String comparatorType, int minPrice, int maxPrice) {
        List<Integer> allPrices = new ArrayList<>();
        while (hasNextPage()) {
            List<WebElement> priceElements = driver.findElements(By.xpath("//div[@style='float:left;']/p[@class='deal-voucher-price'" +
                    " and not(@style='text-decoration: line-through;')]"));
            List<Integer> prices = numericValue(priceElements);
            allPrices.addAll(prices);
            nextPage();
        }
        switch (comparatorType) {
            case Constants.LEASTEXPENSIVE:
                Collections.sort(allPrices);
//                Assert.assertEquals(numericValue(),(int) allPrices.get(0));
                Assert.assertEquals(allPrices.get(allPrices.size() - 1), Collections.min(allPrices));
                break;
            case Constants.MOSTEXPENSIVE:
                Collections.sort(allPrices);
//                Assert.assertEquals(numericValue(),(int) allPrices.get(allPrices.size() - 1));

                Assert.assertEquals(allPrices.get(0), Collections.max(allPrices));
                break;
            case Constants.ISASCENDING:
                for (int i = 1; i < allPrices.size(); i++) {
                    if (allPrices.get(0) < allPrices.get(i)) {
                        Assert.fail(Constants.ISASCENDINGERROR);
                    }
                }
                break;
            case Constants.ISDESCENDING:
                for (int i = 1; i < allPrices.size(); i++) {
                    if (allPrices.get(0) > allPrices.get(i)) {
                        Assert.fail(Constants.ISDESCENDINGERROR);
                    }
                }
                break;
            case Constants.PRICERANGETEST:
                for (Integer price : allPrices) {
                    if (price < minPrice || price > maxPrice) {
                        Assert.fail(Constants.PRICERANGEERROR);
                    }
                }
                break;

            default:
                Assert.fail(Constants.INVALIDCOMPARATOR);
        }
    }
    public void filterBy(String string){
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='sidebar-container']//label[text()='კოტეჯი']"));
        checkbox.click();
        wait.until(ExpectedConditions.urlContains(Constants.ARRANGEMENTS));
        sortBy(Constants.ASCENDING);
            wordValidation();
    }

    public void setPriceRange(int minimum, int maximum){
        WebElement min = driver.findElement(By.xpath("//div[@id='sidebar-container']//input[@id='minprice']"));
        WebElement max = driver.findElement(By.xpath("//div[@id='sidebar-container']//input[@id='maxprice']"));
        js.executeScript(Constants.JSSCROLLTOMIDDLE, min);
        clickAndFill(min,minimum);
        clickAndFill(max,maximum);
    }
    public void sortByDescending(){
        sortBy(Constants.DESCENDING);
    }
    public void mostExpensive(){
        Comparator(Constants.MOSTEXPENSIVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public void sortByAscending(){
        sortBy(Constants.ASCENDING);
    }
    public void leastExpensive(){
        Comparator(Constants.LEASTEXPENSIVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void filteredByKoteji(){
        filterBy(Constants.KOTEJI);
    }
    public void priceRange(){
        setPriceRange(200, 450);
    }
}