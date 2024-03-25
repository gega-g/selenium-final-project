import Data.Constants;
import Pages.HolidayPage;
import Pages.LandingPage;
import Steps.Common;
import org.testng.annotations.Test;

public class LandingPageTests extends TestBase{
    @Test
    public void activeCategoryTest(){
        LandingPage landingPage = new LandingPage(driver);
        Common common = new Common(driver);

        common.navigateToLandingPage();
        common.acceptCookies();
        landingPage.clickOnCategories();
        landingPage.hoverOnSport();
        landingPage.clickOnCarting();
        landingPage.urlMatcher(Constants.CARTINGURL);
        landingPage.colorChecker();
    }

    @Test
    public void logoTest(){
        LandingPage landingPage = new LandingPage(driver);
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToHoliday();
        landingPage.clickOnLogo();
        landingPage.urlMatcher(Constants.HOMEURL);
    }
}