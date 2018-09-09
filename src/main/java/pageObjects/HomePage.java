package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(name = "userName")
	WebElement userNameTextBox;

	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(name = "login")
	WebElement signInButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		userNameTextBox.clear();
		userNameTextBox.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}

	public void clickSignIn() {
		signInButton.click();
	}
}
