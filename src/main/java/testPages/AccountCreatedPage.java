package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AccountCreatedPage extends TestBase {
	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()=\"Continue\"]")
	WebElement clickContinueBtn;
	
	public void clickContinue() {
		clickContinueBtn.click();
		
	}
	

}
