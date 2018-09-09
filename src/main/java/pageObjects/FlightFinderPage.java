package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

	@FindBy(linkText = "Flights")
	WebElement flightPageLink;

	@FindBy(xpath = "//input[@value=\"roundtrip\"]")
	WebElement roundTrip;

	@FindBy(xpath = "//input[@value=\"oneway\"]")
	WebElement oneWay;

	@FindBy(name = "passCount")
	WebElement passengers;

	@FindBy(name = "fromPort")
	WebElement departingFrom;

	@FindBy(name = "fromMonth")
	WebElement fromMonth;

	@FindBy(name = "fromDay")
	WebElement fromDay;

	@FindBy(name = "toPort")
	WebElement arrivingIn;

	@FindBy(name = "toMonth")
	WebElement toMonth;

	@FindBy(name = "toDay")
	WebElement toDay;

	@FindBy(xpath = "//input[@value=\"Coach\"]")
	WebElement economyClass;

	@FindBy(xpath = "//input[@value=\"Business\"]")
	WebElement businessClass;

	@FindBy(xpath = "//input[@value=\"First\"]")
	WebElement firstClass;

	@FindBy(name = "airline")
	WebElement airline;

	@FindBy(name = "findFlights")
	WebElement ContinueButton;

	public FlightFinderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickFlightPageLink() {
		flightPageLink.click();
	}

	public void selectRoundTrip() {
		roundTrip.click();
	}

	public void selectOneWayTrip() {
		oneWay.click();
	}

	public void selectPassengers(int noOfPassengers) {
		new Select(passengers).selectByValue(String.valueOf(noOfPassengers));
	}

	public void selectDepartFrom(String departPlace) {
		new Select(departingFrom).selectByVisibleText(departPlace);
	}

	public void selectFromMonth(String month) {
		new Select(fromMonth).selectByVisibleText(month);
	}

	public void selectFromDay(String day) {
		new Select(fromDay).selectByVisibleText(day);
	}

	public void selectArrivingIn(String arrivePlace) {
		new Select(arrivingIn).selectByVisibleText(arrivePlace);
	}

	public void selectToDay(String day) {
		new Select(toDay).selectByVisibleText(day);
	}

	public void selectToMonth(String month) {
		new Select(toMonth).selectByVisibleText(month);
	}

	public void selectEconomyClass() {
		economyClass.click();
	}

	public void selectBusinessClass() {
		businessClass.click();
	}

	public void selectFirstClass() {
		firstClass.click();
	}

	public void searchFlights() {
		ContinueButton.click();
	}
}
