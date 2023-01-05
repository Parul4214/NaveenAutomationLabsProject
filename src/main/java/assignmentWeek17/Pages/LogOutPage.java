package assignmentWeek17.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class LogOutPage extends TestBase {

	public LogOutPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#content h1")
	WebElement logoutMsg;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement clickContinueAfterLogout;

	
	public YourStorePage clickLogout() {
		clickContinueAfterLogout.click();
		return new YourStorePage();

	}

}
