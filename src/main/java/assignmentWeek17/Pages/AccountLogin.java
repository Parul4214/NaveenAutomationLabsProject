package assignmentWeek17.Pages;

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

	public MyAccountPage loginWithValidCred() {
		emailInput.sendKeys("parul.verma421@gmail.com");
		passwordInput.sendKeys("#elloWorld");
		clickLogin.click();
		return new MyAccountPage();

	}

}
