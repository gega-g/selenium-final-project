import Data.Constants;
import Steps.HolidayPageSteps;
import Steps.LandingPageSteps;
import Steps.CommonSteps;
import org.testng.annotations.Test;

public class LandingPageTests extends TestBase{
    @Test
    public void activeCategoryTest(){
        LandingPageSteps landingPage = new LandingPageSteps(driver);
        CommonSteps commonSteps = new CommonSteps(driver);

        commonSteps.navigateToLandingPage();
        commonSteps.acceptCookies();
        landingPage.clickOnCategories()
                .hoverOnSport()
                .clickOnCarting()
                .urlMatcher(Constants.CARTINGURL)
                .colorChecker();
    }

    @Test
    public void logoTest(){
        LandingPageSteps landingPage = new LandingPageSteps(driver);
        HolidayPageSteps holidayPage = new HolidayPageSteps(driver);
        holidayPage.navigateToHoliday();
        landingPage.clickOnLogo()
                .urlMatcher(Constants.HOMEURL);
    }
}