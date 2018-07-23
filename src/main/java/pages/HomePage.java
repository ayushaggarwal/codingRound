package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;
	
	public HotelSearchPage openHotelSearchpage() {
		hotelLink.click();
		return PageFactory.initElements(driver, HotelSearchPage.class);
	}
}
