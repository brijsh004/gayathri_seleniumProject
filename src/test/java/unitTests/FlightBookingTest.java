package unitTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.WebDriverManager;
import selenium.SeleniumActions;

public class FlightBookingTest {

	PageObjectManager objectManager;
	WebDriverManager driverManager;
	SeleniumActions seleniumActions;

	@BeforeClass
	public void setUp() {
		driverManager = new WebDriverManager();
		objectManager = new PageObjectManager(driverManager.getDriver());
		seleniumActions = new SeleniumActions(driverManager.getDriver());
	}

	@Test
	public void successReturnFlightTicketBooking() {

		seleniumActions.navigateToURL("http://newtours.demoaut.com");

		Assert.assertEquals(seleniumActions.getPageTitle(), "Welcome: Mercury Tours");
		objectManager.getHomePage().enterUserName("test1");
		objectManager.getHomePage().enterPassword("test1");
		objectManager.getHomePage().clickSignIn();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Find a Flight: Mercury Tours:");
		objectManager.getFlightFinderPage().selectRoundTrip();
		objectManager.getFlightFinderPage().selectPassengers(1);
		objectManager.getFlightFinderPage().selectDepartFrom("Frankfurt");
		objectManager.getFlightFinderPage().selectFromMonth("October");
		objectManager.getFlightFinderPage().selectFromDay("2");
		objectManager.getFlightFinderPage().selectArrivingIn("Paris");
		objectManager.getFlightFinderPage().selectToMonth("October");
		objectManager.getFlightFinderPage().selectToDay("20");
		objectManager.getFlightFinderPage().selectBusinessClass();
		objectManager.getFlightFinderPage().searchFlights();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Select a Flight: Mercury Tours");
		objectManager.getSelectFlightPage().clickReserveSelectedFlight();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Book a Flight: Mercury Tours");
		objectManager.getBookFlightPage().enterFirstName("Test");
		objectManager.getBookFlightPage().enterLastName("User");
		objectManager.getBookFlightPage().enterCreditCardNumber(1234567890);
		objectManager.getBookFlightPage().clickBookFlightButton();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Flight Confirmation: Mercury Tours");
	}

	@AfterClass
	public void tearDown() {
		driverManager.quitDriver();
	}
}
