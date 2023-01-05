package assignmentWeek18.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import assignmentWeek17.Base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	WebElement hoverMouseTolaptopAndNotebooks;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebooks;

	public LaptopsAndNotebooksPage clickOnShowAllLaptopsAndNotebooks() {
		hoverMouseTolaptopAndNotebooks.click();
		showAllLaptopsAndNotebooks.click();
		return new LaptopsAndNotebooksPage();

	}

}
