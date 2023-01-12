package assignmentWeek19.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class EditAccountInfoPage extends TestBase {

	public EditAccountInfoPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[name='firstname']")
	WebElement firstName;

	@FindBy(css = "input[name='lastname']")
	WebElement lastName;

	@FindBy(css = "input[name='email']")
	WebElement emailInput;

	@FindBy(id = "input-telephone")
	WebElement phoneInput;

	@FindBy(css = "input[type='submit']")
	WebElement clickcontinue;

	public String editFirstName() {
		return firstName.getAttribute("firstname");
	}

	public String editLastName() {
		return firstName.getAttribute("lastname");
	}

	public String editEmail() {
		return firstName.getAttribute("email");
	}

	public String editPhone() {
		return firstName.getAttribute("phone");
	}

//	public MyAccountPage editAccountInfo(String fName, String lName, String email, String phnInput) {
//		myAccount.click();
//		editAccInfo.click();
//		editFirstName(fName);
//		editSecondtName(lName);
//		editEmail(email);
//		editPhone(phnInput);
//		clickcontinue.click();
//
//		return new MyAccountPage();
//
//	}

}
