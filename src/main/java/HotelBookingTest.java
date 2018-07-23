import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HotelSearchPage;

public class HotelBookingTest extends BaseTest{
	

	@Test
	public void shouldBeAbleToSearchForHotels() {
		setDriverPath();
		
		driver.get("https://www.cleartrip.com/");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		HotelSearchPage hotelSearchPage =  homePage.openHotelSearchpage();
		hotelSearchPage.searchHotel("Indiranagar, Bangalore","1 room, 2 adults");
		// Ayush : Add some assertion, tets is incomplete without assertion
		driver.quit();

	}

	

}
