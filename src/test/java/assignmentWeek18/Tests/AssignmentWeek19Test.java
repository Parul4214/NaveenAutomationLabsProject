package assignmentWeek18.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignmentWeek17.Base.TestBase;
import assignmentWeek17.Pages.AccountLogin;
import assignmentWeek17.Pages.YourStorePage;
import assignmentWeek19.Pages.EditAccountInfoPage;
import assignmentWeek19.Pages.MyAccountPage;
import assignmentWeek19.Utils.ExcelUtils;

public class AssignmentWeek19Test extends TestBase {

	SoftAssert sf;
	YourStorePage yourStorePage;

	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		yourStorePage = new YourStorePage();
		myAccountPage = new MyAccountPage();

	}

//	@Test(dataProvider = "LoginDataProvider")
//	public void validatePreFilledDetails(String fName, String lName, String email, String phnInput) {
//		AccountLogin accountLogin = yourStorePage.clickLoginBtn();
//		accountLogin.loginWithValidCred("parul.verma421@gmail.com", "#elloWorld");
//		editLoginInfo.editAccountInfo(fName, lName, email, phnInput);
//
//	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyUserIsAbleToAccountLogin(String username, String password) {
		// page chaining
		AccountLogin accountLogin = yourStorePage.clickLoginBtn();
		accountLogin.loginWithValidCred(username, password);
		sf.assertEquals(driver.getTitle(), "My Account", "No match for E-Mail Address and/or Password");
		System.out.println("Login successful. My Account");

	}

	@Test(dataProvider = "EditInformationDataprovider")
	public void validateInformationIsPrefilled(String username, String password, String firstName, String lastName,
			String email, String phnInput) {
		AccountLogin accountLogin = yourStorePage.clickLoginBtn();
		accountLogin.loginWithValidCred(username, password);
		EditAccountInfoPage editAccountInfo = myAccountPage.clickOnEditAccountInfo();
		sf.assertEquals(editAccountInfo.editFirstName(), firstName, "First name is not filled yet");
		sf.assertEquals(editAccountInfo.editLastName(), lastName, "Last name is not filled yet");
		sf.assertEquals(editAccountInfo.editEmail(), email, "Email is not filled yet");
		sf.assertEquals(editAccountInfo.editPhone(), phnInput, "Phone Num is not filled yet");
		sf.assertAll();

	}

	// it got executed first
	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);

		// using two dim array for rows and column
		// from actual sheet created virtual actual sheet ans aved in two dim array
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				// virtual sheet
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@DataProvider(name = "EditInformationDataprovider")
	public String[][] providePreFilledLoginData() throws IOException {
		String filePath = "./Test Data\\EditAccountInformation.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);

		// using two dim array for rows and column
		// from actual sheet created virtual actual sheet saved in two dim array
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				// virtual sheet
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
