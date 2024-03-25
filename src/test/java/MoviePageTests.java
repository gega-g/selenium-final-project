import Pages.CreateNewAccountPage;
import Steps.Common;
import Pages.MoviePage;
import org.testng.annotations.Test;

public class MoviePageTests extends TestBase {
    @Test
    public void moviePageTests(){
        Common common = new Common(driver);
        MoviePage moviePage = new MoviePage(driver);
        CreateNewAccountPage newAcc = new CreateNewAccountPage(driver);

        common.navigateToLandingPage();
        common.acceptCookies();
        moviePage.navigateToFirstMovie();
        moviePage.clickOnEastPoint();
        moviePage.getVisibleSeances();
        moviePage.chooseLastDay();
        moviePage.clickOnLastSeance();
        moviePage.validateName();
        moviePage.validateCinema();
        moviePage.chooseSeatAndStartCreatingAccount();

        newAcc.fillEmail();
        newAcc.fillPassword();
        newAcc.fillPasswordRepeat();
        newAcc.setGender();
        newAcc.fillName();
        newAcc.scrollToButton();
        newAcc.fillLastName();
        newAcc.scrollToButton();
        newAcc.chooseBirthDate();
        newAcc.fillPhoneNumber();
        newAcc.fillPhoneCode();
        newAcc.checkmarks();
        newAcc.scrollToButton();
        newAcc.submit();
        newAcc.emailMessage();
    }
}