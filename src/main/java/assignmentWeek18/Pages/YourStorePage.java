package assignmentWeek18.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class YourStorePage extends TestBase {

	Actions action = new Actions(driver);

	public YourStorePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=\"My Account\"]")
	WebElement myAccountOption;

	@FindBy(xpath = "//a[text()=\"Login\"]")
	WebElement loginBtn;

	public AccountLogin accountLogin() {
		myAccountOption.click();
		loginBtn.click();
		return new AccountLogin();
	}

}
