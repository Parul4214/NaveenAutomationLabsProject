package assignmentWeek18.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import assignmentWeek17.Base.TestBase;
import assignmentWeek18.Pages.AccountLogin;
import assignmentWeek18.Pages.LaptopsAndNotebooksPage;
import assignmentWeek18.Pages.MyAccountPage;
import assignmentWeek18.Pages.MyWishList;
import assignmentWeek18.Pages.MyWishList.myWishList;
import assignmentWeek18.Pages.YourStorePage;

public class LaptopsAndNotebooksTest extends TestBase {
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
	public void verifyLaptopsAndNoteBooksPage() {
		LaptopsAndNotebooksPage laptopsAndNotebooks = myAccount.clickOnShowAllLaptopsAndNotebooks();
		
		// validate title of the page after click on laptops and notebooks
		sf.assertEquals(driver.getTitle(), "Laptops & Notebooks", "Title doesn't match");
		System.out.println("Title matched: " + driver.getTitle());
		laptopsAndNotebooks.addFirstThreeItemsToWishlist();

		// validate text after adding items to wishlist
		sf.assertEquals(laptopsAndNotebooks.getSuccessAlertAfterAddingItems(),
				"Success: You have added MacBook Air to your wish list!\n×", "Alert Mismatched");
		System.out.println("Success Alert: " + laptopsAndNotebooks.getSuccessAlertAfterAddingItems());

		// validate title of page after click on wishlist link
		MyWishList myWishListPage = laptopsAndNotebooks.clickOnWishListLink();
		sf.assertEquals(driver.getTitle(), "My Wish List", "Title mismatched");
		System.out.println("Title after WishList link: " + driver.getTitle());

		// validate items added with the price and name of the item selected
		WebElement firstElementPrice = myWishListPage.getElementFromTheTable("MacBook Air", myWishList.UNIT_PRICE);
		sf.assertEquals(firstElementPrice.getText(), "$1,000.00", "Price doesn't match");

		WebElement firstElementName = myWishListPage.getElementFromTheTable("MacBook Air", myWishList.PRODUCT_NAME);
		sf.assertEquals(firstElementName.getText(), "MacBook Air", "product name doesn't match");

		WebElement secondElementPrice = myWishListPage.getElementFromTheTable("MacBook Pro", myWishList.UNIT_PRICE);
		sf.assertEquals(secondElementPrice.getText(), "$2,000.00", "Price doesn't match");

		WebElement secondElementName = myWishListPage.getElementFromTheTable("MacBook Pro", myWishList.PRODUCT_NAME);
		sf.assertEquals(secondElementName.getText(), "MacBook Pro", "product name doesn't match");

		WebElement thirdElementPrice = myWishListPage.getElementFromTheTable("Sony VAIO", myWishList.UNIT_PRICE);
		sf.assertEquals(thirdElementPrice.getText(), "$1,000.00", "Price doesn't match");

		WebElement thirdElementName = myWishListPage.getElementFromTheTable("Sony VAIO", myWishList.PRODUCT_NAME);
		sf.assertEquals(thirdElementName.getText(), "Sony VAIO", "product name doesn't match");

		System.out.println("Name: " + firstElementName.getText() + " and Price: " + firstElementPrice.getText());
		System.out.println("Name: " + secondElementName.getText() + " and Price: " + secondElementPrice.getText());
		System.out.println("Name: " + thirdElementName.getText() + " and Price: " + thirdElementPrice.getText());

		// delete last item from wishlist
		myWishListPage.deleteItem("Sony VAIO", myWishList.ACTION, By.cssSelector("a"));
		sf.assertEquals(myWishListPage.getSuccessTextAfterDeletion(), "Success: You have modified your wish list!\n×",
				"Error Message");
		System.out.println("Success Text message After deleting: " + myWishListPage.getSuccessTextAfterDeletion());

		myWishListPage.clickcontinueAfterRemovingItem();

		sf.assertAll();
		System.out.println("All Assertion Passed");
		
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
