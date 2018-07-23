package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.SyncUtil;

public class HotelSearchPage extends BasePage{

	public HotelSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	@FindBy(css=".autoComplete li")
	List<WebElement> suggestedLocations;

	public void searchHotel(String locality, String travels) {
		localityTextBox.sendKeys(locality);
		SyncUtil.waitFor(2000);
		WebElement location = selectLocationFromAutoComplete(locality);
		Assert.assertNotNull(location,"Location not found in auto complete list");
		location.click();
		// Skip date selections
		new Actions(driver).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		new Select(travellerSelection).selectByVisibleText(travels);
		this.click(searchButton);
	}

	private WebElement selectLocationFromAutoComplete(String locality) {
		for (WebElement webElement : suggestedLocations) {
			if(webElement.getText().toLowerCase().startsWith(locality.toLowerCase())){
				return webElement;
			}
		}
		return null;
	}
	
}
