package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=\"Subscribe / unsubscribe to newsletter\"]")
	WebElement newsletterSubscription;

	@FindBy(css = "div.alert-success")
	WebElement successAlertAfterPhoneChange;

	@FindBy(css = "div.list-group a:last-of-type")
	WebElement logoutOption;

	public String getSuccessMsgFromAlertBanner() {
		return successAlertAfterPhoneChange.getText();

	}

	public NewsletterVerificationPage newsletter() {
		newsletterSubscription.click();
		return new NewsletterVerificationPage();

	}

	public LogOutPage logoutFromAccount() {
		logoutOption.click();
		return new LogOutPage();

	}

}
