package assignmentWeek18.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-sort")
	WebElement clickOnSortBy;

	@FindBy(xpath = "//option[text()='Rating (Highest)']")
	WebElement selectRatingHighToLow;

	@FindBy(css = "button[onclick=\"wishlist.add('46');\"]")
	WebElement addFirstItem;

	@FindBy(css = "button[onclick=\"wishlist.add('45');\"]")
	WebElement addSecondItem;

	@FindBy(css = "button[onclick=\"wishlist.add('44');\"]")
	WebElement addThirdItem;

	@FindBy(css = "div.alert.alert-success")
	WebElement successMsgAfterAddingToWishlist;

	@FindBy(xpath = "//span[text()=\"Wish List (3)\"]")
	WebElement wishListLink;

	public void addFirstThreeItemsToWishlist() {
		clickOnSortBy.click();
		selectRatingHighToLow.click();
		addFirstItem.click();
		sleep(2);
		addSecondItem.click();
		sleep(2);
		addThirdItem.click();
		sleep(2);
	}

	public String getSuccessAlertAfterAddingItems() {
		return successMsgAfterAddingToWishlist.getText();
	}

	public MyWishList clickOnWishListLink() {
		wishListLink.click();
		return new MyWishList();

	}

	public void sleep(int timer) {
		try {
			Thread.sleep(timer * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
