package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {

	@FindBy(name = "passFirst0")
	WebElement firstName;

	@FindBy(name = "passLast0")
	WebElement lastName;

	@FindBy(name = "creditnumber")
	WebElement creditCardNumber;

	@FindBy(name = "buyFlights")
	WebElement securePurchaseButton;

	public BookFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void enterCreditCardNumber(int cardNumber) {
		this.creditCardNumber.clear();
		this.creditCardNumber.sendKeys(String.valueOf(cardNumber));
	}

	public void clickBookFlightButton() {
		securePurchaseButton.click();
	}
}
