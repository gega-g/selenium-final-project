import Steps.HolidayPageSteps;
import org.testng.annotations.Test;

public class HolidayPageTests extends TestBase {

    @Test
    public void descendingOrderTest() {
        HolidayPageSteps holidayPage = new HolidayPageSteps(driver);
        holidayPage.navigateToHoliday()
                .sortByDescending()
                .mostExpensive()
                .isDescending();
    }

    @Test
    public void ascendingOrderTest() {
        HolidayPageSteps holidayPage = new HolidayPageSteps(driver);
        holidayPage.navigateToHoliday()
                .sortByAscending()
                .leastExpensive()
                .isAscending();
    }

    @Test
    public void filterTest() {
        HolidayPageSteps holidayPage = new HolidayPageSteps(driver);
        holidayPage.navigateToHoliday()
                .filteredByKoteji()
                .sortByAscending()
                .leastExpensive();
    }

    @Test
    public void priceRangeTest() {
        HolidayPageSteps holidayPage = new HolidayPageSteps(driver);
        holidayPage.navigateToHoliday()
                .priceRange()
                .searchAndAssert();
    }
}