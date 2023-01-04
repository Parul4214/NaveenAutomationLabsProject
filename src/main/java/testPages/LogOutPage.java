package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

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
