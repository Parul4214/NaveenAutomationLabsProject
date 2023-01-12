package assignmentWeek18.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignmentWeek17.Base.TestBase;
import assignmentWeek18.Pages.AccountLogin;
import assignmentWeek18.Pages.AddressBookPage;
import assignmentWeek18.Pages.MyAccountPage;
import assignmentWeek18.Pages.YourStorePage;

public class AddressBookTest extends TestBase {

	SoftAssert sf;
	YourStorePage yourStore;
	MyAccountPage myAccount;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		yourStore = new YourStorePage();
		AccountLogin accountLogin = yourStore.accountLogin();
		accountLogin = new AccountLogin();
		myAccount = new MyAccountPage();
		accountLogin.loginWithValidCred();
	
		

	}

	@Test
	public void verification() {
		AddressBookPage addressBookPageTest=new AddressBookPage();
		addressBookPageTest.getElementFromTable("L6T 3R5");
	
		
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
