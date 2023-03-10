package assignmentWeek17.Pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class MyAccountInformation extends TestBase {

	public MyAccountInformation() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div.list-group a:first-of-type")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()=\"Edit your account information\"]")
	WebElement editAccInfo;

	@FindBy(css = "input[name='firstname']")
	WebElement firstName;

	@FindBy(css = "input[name='lastname']")
	WebElement lastName;

	@FindBy(css = "input[name='email']")
	WebElement emailInput;

	@FindBy(id = "input-telephone")
	WebElement phoneInput;

	@FindBy(css = "input[type='submit']")
	WebElement clickcontinueAfterPhoneChange;

	public MyAccountPage editAccountInfo() {
		myAccount.click();
		editAccInfo.click();
		phoneInput.clear();
		phoneInput.sendKeys(randomPhoneNum());
		clickcontinueAfterPhoneChange.click();

		return new MyAccountPage();

	}

	public String randomPhoneNum() {

		Random random = new Random();
		int randomNum = random.nextInt(100000);
		String randomPhoneNumber = "28945" + randomNum;
		return randomPhoneNumber;

	}

}
