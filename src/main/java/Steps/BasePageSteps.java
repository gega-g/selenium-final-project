package Steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePageSteps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }
}
