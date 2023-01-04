package testPages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class RegisterPage extends TestBase {

	public RegisterPage() {
		PageFactory.initElements(driver, this);

	}

	// find Web elements for the following fields
	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(css = "#input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement phone;
	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement privacyPolicyChkBox;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement clickContinue;

	public AccountCreatedPage signUp(String fname, String lname, String email, String phn, String pswd, String cpswd) {

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		this.email.sendKeys(randomEmail());
		phone.sendKeys(phn);
		password.sendKeys(pswd);
		confirmPassword.sendKeys(cpswd);
		privacyPolicyChkBox.click();
		clickContinue.submit();

		return new AccountCreatedPage();

	}

	public String randomEmail() {

		Random random = new Random();
		int randomNum = random.nextInt(1000);
		String randomEmail = "test" + randomNum + "@test.com";
		return randomEmail;
	}

}
