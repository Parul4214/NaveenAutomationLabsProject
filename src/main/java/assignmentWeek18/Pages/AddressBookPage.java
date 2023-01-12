package assignmentWeek18.Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignmentWeek17.Base.TestBase;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = " #column-right div a:nth-of-type(4)")
	WebElement adressBookOption;

	public WebElement getElementFromTable(String postalCode) {
		adressBookOption.click();

		List<WebElement> totalRows = driver.findElements(By.cssSelector("#content div.table-responsive tbody tr"));
		for (int i = 0; i < totalRows.size(); i++) {
			List<WebElement> cells = totalRows.get(i).findElements(By.cssSelector(" td"));
			String getTextFromcell = cells.get(0).getText();

			String[] splitTextFromEachLine = getTextFromcell.split("\n");

			for (int j = 0; j < splitTextFromEachLine.length; j++) {
				System.out.println("Splitted text " + splitTextFromEachLine[j]);

				String[] findPostalCode = splitTextFromEachLine[j].split(" ");
				
				
							
//
//				for(String splitWords : findPostalCode) 
//						if(splitWords.equals(postalCode)) {
//					System.out.println("here are the word " + splitWords);
//
//						return cells.get(1);
//					}
					
				}
			}
		return null;

		}
}

// 
//		for (int i = 0; i < totalRows.size(); i++) {
//			List<WebElement> cells = totalRows.get(i).findElements(By.cssSelector(" td"));
//			String getTextFromcell = cells.get(0).getText();
//			System.out.println("text from cell " + getTextFromcell);
//			
//			for (WebElement cells : cells) {
//				
//			}

//		List<WebElement> noOfRows = driver.findElements(By.xpath("//div[@class='table-responsive']//tr"));
//		List<WebElement> noOfcolumns = driver.findElements(By.xpath("//div[@class='table-responsive']//tr//td"));
//
//		System.out.println("Number of Rows are " + noOfRows.size());
//		System.out.println("Number of Columns are " + noOfcolumns.size());
//
//		String xPathBefore = "//div[@class='table-responsive']//tr[";
//		String xPathathAfter = "]//td[";
//		
//		for(int i=1;i<noOfRows.size();i++) {
//			for (int j = 1; j < noOfcolumns.size(); j++) {
//				WebElement element=driver.findElement(By.xpath("//div[@class='table-responsive']//tr["+i+"]//td["+j+ "]"));
//				if(element.getText().equals("L6T 3R5")) {
//					System.out.println("found");
//					
//				}else {
//				System.out.println("not found");
//				}
//				}
//				
//				
//				
//			}
//		}
//
//		// div[@class="table-responsive"]//tr[1]//td[1]
//
//	}
