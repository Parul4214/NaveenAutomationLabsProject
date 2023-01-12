package assignmentWeek19.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		// re-initializing elements to avoid stale element reference exception
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement clickLogin;

	public void enterEmailInputField(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPasswordInputField(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage loginWithValidCred(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		clickLogin.click();
		return new MyAccountPage();

	}

}
