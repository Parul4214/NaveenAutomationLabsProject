package assignmentWeek17.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignmentWeek17.Base.TestBase;
import assignmentWeek17.Pages.AccountLogin;
import assignmentWeek17.Pages.LogOutPage;
import assignmentWeek17.Pages.MyAccountInformation;
import assignmentWeek17.Pages.MyAccountPage;
import assignmentWeek17.Pages.NewsletterVerificationPage;
import assignmentWeek17.Pages.YourStorePage;

public class MyAccountTest extends TestBase {

	SoftAssert sf;
	YourStorePage yourStorePage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		yourStorePage = new YourStorePage();
		yourStorePage.clickLoginBtn();
		AccountLogin accountLogin = new AccountLogin();
		accountLogin.loginWithValidCred();

	}

	@Test
	public void verifyUserIsAbleToChangePhoneNum() {
		MyAccountInformation myAccountInfo = new MyAccountInformation();
		myAccountPage = myAccountInfo.editAccountInfo();
		sf.assertEquals(myAccountPage.getSuccessMsgFromAlertBanner(),
				"Success: Your account has been successfully updated.", "Error message");

		System.out.println("Success: Your account has been successfully updated.");
		sf.assertEquals(driver.getTitle(), "My Account", "Something went wrong");
		System.out.println("Landed to page : " + driver.getTitle());
		sf.assertAll();

	}

	@Test
	public void verifySubscription() {
		NewsletterVerificationPage newletterSubscription = new NewsletterVerificationPage();
		newletterSubscription.subscriptionVerification();
		sf.assertEquals(newletterSubscription.successMsg(),
				" Success: Your newsletter subscription has been successfully updated!", "Wrong Error Message");
		System.out.println("Success: Your newsletter subscription has been successfully updated! ");

	}

	@Test
	public void verifyUserIsAbleToLogout() {
		myAccountPage = new MyAccountPage();
		LogOutPage accountLogout = myAccountPage.logoutFromAccount();
		accountLogout.clickLogout();
		sf.assertEquals(driver.getTitle(), "Your Store", "Try Again");
		System.out.println(driver.getTitle());
		sf.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
