import Steps.CreateNewAccountPageSteps;
import Steps.CommonSteps;
import Steps.MoviePageSteps;
import org.testng.annotations.Test;

public class MoviePageTests extends TestBase {
    @Test
    public void moviePageTests(){
        CommonSteps commonSteps = new CommonSteps(driver);
        MoviePageSteps moviePage = new MoviePageSteps(driver);
        CreateNewAccountPageSteps createNewAccountPageSteps = new CreateNewAccountPageSteps(driver);

        commonSteps.navigateToLandingPage();
        commonSteps.acceptCookies();
        moviePage.navigateToFirstMovie()
                .clickOnEastPoint()
                .getVisibleSeances();
        moviePage.chooseLastDay()
                .clickOnLastSeance()
                .validateName()
                .validateCinema()
                .chooseSeatAndStartCreatingAccount();

        createNewAccountPageSteps.fillEmail()
                .fillPassword()
                .fillPasswordRepeat()
                .setGender()
                .fillName()
                .scrollToButton()
                .fillLastName()
                .scrollToButton()
                .chooseBirthDate()
                .fillPhoneNumber()
                .fillPhoneCode()
                .checkmarks()
                .scrollToButton()
                .submit()
                .emailMessage();
    }
}