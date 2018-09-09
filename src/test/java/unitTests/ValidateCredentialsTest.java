package unitTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.WebDriverManager;
import selenium.SeleniumActions;

public class ValidateCredentialsTest {

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
	public void validateCorrectCrendentials() {
		seleniumActions.navigateToURL("http://newtours.demoaut.com");

		Assert.assertEquals(seleniumActions.getPageTitle(), "Welcome: Mercury Tours");
		objectManager.getHomePage().enterUserName("test1");
		objectManager.getHomePage().enterPassword("test1");
		objectManager.getHomePage().clickSignIn();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Find a Flight: Mercury Tours:");
	}

	@Test
	public void validateInvalidCrendentials() {
		seleniumActions.navigateToURL("http://newtours.demoaut.com");

		Assert.assertEquals(seleniumActions.getPageTitle(), "Welcome: Mercury Tours");
		objectManager.getHomePage().enterUserName("invalid");
		objectManager.getHomePage().enterPassword("invalid");
		objectManager.getHomePage().clickSignIn();

		Assert.assertEquals(seleniumActions.getPageTitle(), "Sign-on: Mercury Tours");
	}

	@AfterClass
	public void tearDown() {
		driverManager.quitDriver();
	}

}
