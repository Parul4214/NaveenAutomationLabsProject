package assignmentWeek17.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignmentWeek17.Base.TestBase;
import assignmentWeek17.Pages.AccountCreatedPage;
import assignmentWeek17.Pages.AccountLogin;
import assignmentWeek17.Pages.RegisterPage;
import assignmentWeek17.Pages.YourStorePage;

public class AccountCreatedTest extends TestBase {

	SoftAssert sf;
	YourStorePage yourStorePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		yourStorePage = new YourStorePage();

	}

	@Test
	public void verifyUserIsAbleToRegister() {
		yourStorePage.getMyAccountText();
		// Page chaining
		RegisterPage registerPage = yourStorePage.clickRegisterBtn();
		AccountCreatedPage accountCreated = registerPage.signUp("Parul", "Verma", registerPage.randomEmail(),
				"9056169874", "test123", "test123");
		accountCreated.clickContinue();
		sf.assertEquals(driver.getTitle(), "Your Account Has Been Created!", " Title is invalid ");
		System.out.println("Registration successful. Your Account Has Been Created! ");
	}

	@Test

	public void verifyUserIsAbleToAccountLogin() {
		// page chaining
		AccountLogin accountLogin = yourStorePage.clickLoginBtn();
		accountLogin.loginWithValidCred("parul.verma421@gmail.com", "#elloWorld");
		sf.assertEquals(driver.getTitle(), "My Account", "No match for E-Mail Address and/or Password");
		System.out.println("Login successful. My Account");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
