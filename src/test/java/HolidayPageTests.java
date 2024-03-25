import Pages.HolidayPage;
import org.testng.annotations.Test;

public class HolidayPageTests extends TestBase {

    @Test
    public void descendingOrderTest() {
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToHoliday();
        holidayPage.sortByDescending();
        holidayPage.mostExpensive();
    }

    @Test
    public void ascendingOrderTest() {
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToHoliday();
        holidayPage.sortByAscending();
        holidayPage.leastExpensive();
    }

    @Test
    public void filterTest() {
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToHoliday();
        holidayPage.filteredByKoteji();
        holidayPage.sortByAscending();
        holidayPage.leastExpensive();
    }

    @Test
    public void priceRangeTest() {
        HolidayPage holidayPage = new HolidayPage(driver);
        holidayPage.navigateToHoliday();
        holidayPage.priceRange();
        holidayPage.searchAndAssert();
    }
}