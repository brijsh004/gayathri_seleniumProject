package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {

	@FindBy(name = "reserveFlights")
	WebElement continueButton;

	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickReserveSelectedFlight() {
		continueButton.click();
	}
}
