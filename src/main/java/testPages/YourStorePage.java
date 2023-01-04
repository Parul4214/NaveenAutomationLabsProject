package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class YourStorePage extends TestBase {

	public YourStorePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=\"My Account\"]")
	WebElement myAccountText;

	@FindBy(xpath = "//a[text()=\"Register\"]")
	WebElement registerOption;

	@FindBy(xpath = "//a[text()=\"Login\"]")
	WebElement loginBtn;

	public String getMyAccountText() {
		myAccountText.click();
		return myAccountText.getText();

	}

	public AccountLogin clickLoginBtn() {
		getMyAccountText();
		loginBtn.click();
		return new AccountLogin();

	}

	public RegisterPage clickRegisterBtn() {
		registerOption.click();
		return new RegisterPage();

	}
	
	

}
