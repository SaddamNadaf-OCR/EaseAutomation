package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditEEITransactionsItemsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EditEEITransactionsItemsPage_Item1 = "(//a[contains(text(),'1')])[2]";
	public static final String OCR_EditEEITransactionsItemsPage_Item2 = "(//a[contains(text(),'2')])[3]";
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public EditEEITransactionsItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//validate items are in sequential order
	public void itemOrder() {
		Wait.waitfor(2);
		try {
			if(isDisplayed(driver, OCR_EditEEITransactionsItemsPage_Item1)) {
				test.log(LogStatus.PASS, "Item 1 is displayed first");
			}
			
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Items are not displayed in order :");
		}
		
		
		
	}
}
