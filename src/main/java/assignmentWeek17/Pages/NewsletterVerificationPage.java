package assignmentWeek17.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class NewsletterVerificationPage extends TestBase {
	public NewsletterVerificationPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement newsletterSubscribeUnsubscriveText;

	@FindBy(xpath = "//input[@value=\"1\"]")
	WebElement subscribeYes;

	@FindBy(css = "input.btn-primary")
	WebElement clickContinueAfterVerifyingSubscription;

	@FindBy(css = "div.alert-success")
	WebElement successMsgForNewsletter;

	public MyAccountPage subscriptionVerification() {
		newsletterSubscribeUnsubscriveText.click();
		subscribeYes.click();
		clickContinueAfterVerifyingSubscription.submit();
		return new MyAccountPage();

	}

	public String successMsg() {
		return successMsgForNewsletter.getText();
	}

}
