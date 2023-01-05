package assignmentWeek18.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import assignmentWeek17.Base.TestBase;

public class MyWishList extends TestBase {

	public MyWishList() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content div.table-responsive tbody tr:nth-of-type(3) td:nth-of-type(6) a")
	WebElement deleteLastItemFromWishlist;

	@FindBy(xpath = "//a[text()=\"Continue\"]")
	WebElement clickContinueAfterdeletingItem;

	@FindBy(css = "div.alert-success")
	WebElement successtextAfterDeleting;
	
	public void deleteLastItem() {
		deleteLastItemFromWishlist.click();
	}

	public MyAccountPage clickcontinueAfterRemovingItem() {
		clickContinueAfterdeletingItem.click();
		return new MyAccountPage();
	}

	public String getSuccessTextAfterDeletion() {
		
		System.out.println("Text: "+successtextAfterDeleting.getText());
		return successtextAfterDeleting.getText();
	}

	// to handle webtable
	public WebElement getElementFromTheTable(String productName, myWishList column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String orderIdText = cells.get(1).getText();
			if (orderIdText.equals(productName)) {
				return cells.get(columnIndex);
			}

		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(myWishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}

		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum myWishList {
		IMAGE("Image"), 
		PRODUCT_NAME("Product Name"), 
		MODEL("Model"), 
		STOCK("Stock"), 
		UNIT_PRICE("Unit Price"),
		ACTION("Action");

		String name;

		private myWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	public void sleep(int timer) {
		try {
			Thread.sleep(timer * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
