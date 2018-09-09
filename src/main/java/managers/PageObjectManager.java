package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BookFlightPage;
import pageObjects.FlightFinderPage;
import pageObjects.HomePage;
import pageObjects.SelectFlightPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private FlightFinderPage flightFinderPage;
	private SelectFlightPage selectFlightPage;
	private BookFlightPage bookFlightPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public FlightFinderPage getFlightFinderPage() {
		return (flightFinderPage == null) ? flightFinderPage = new FlightFinderPage(driver) : flightFinderPage;
	}

	public SelectFlightPage getSelectFlightPage() {
		return (selectFlightPage == null) ? selectFlightPage = new SelectFlightPage(driver) : selectFlightPage;
	}

	public BookFlightPage getBookFlightPage() {
		return (bookFlightPage == null) ? bookFlightPage = new BookFlightPage(driver) : bookFlightPage;
	}

}
