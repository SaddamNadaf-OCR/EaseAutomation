package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Result Invoice Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class ResultInvoicePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	// Search Criteria based on Invoice Item
	public static final String OCR_ResultResultInvoicePage_Heading = "//h3[@class='page-heading']";
	public static final String OCR_ResultResultInvoicePage_NewSearch = "//button[contains(text(),'New Search')]";
	public static final String OCR_ResultResultInvoicePage_AddInvoice = "//button[contains(text(),'Add')]";
	public static final String OCR_ResultResultInvoicePage_ResultGrid = "//div[@id='gbox_grid']";
	public static final String OCR_ResultResultInvoicePage_CopyIcon = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_ResultResultInvoicePage_DeleteIcon = "(//i[@class='fa fa-trash-o'])[1]";
	
	/* ******************************* Constructor ****************************** */

	public ResultInvoicePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//Validate Heading
	public void headingValidation() {
		try {
			if(isDisplayed(driver, OCR_ResultResultInvoicePage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}
	}
	
	//Click on New Search Button
	public void newSearch() {
		clickElement(driver, test, OCR_ResultResultInvoicePage_NewSearch, "Clicking on New Search Button :");
	}
	
	//Click on Add Invoice Button
	public void addInvoice() {
		clickElement(driver, test, OCR_ResultResultInvoicePage_AddInvoice, "Clicking on Add Invoice Button :");
	}
	
	//Click on InvoiceNo
	public void clickInvoiceNo(String InvOrderNo) {
		Wait.waitfor(3);
		clickElement(driver, test, "//a[contains(text(),'"+InvOrderNo+"')]", "Clicking on Invoice No :");
	}
	
	//Validate Result Grid 
	public void resultGrid() {
		try {
			if(isDisplayed(driver, OCR_ResultResultInvoicePage_ResultGrid)) {
				test.log(LogStatus.PASS, "Result Grid is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Grid is Not Displayed :");
		}
	}
	
	//Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_ResultResultInvoicePage_CopyIcon, "Clicking on Copy Icon :");
	}
	
	//Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, OCR_ResultResultInvoicePage_DeleteIcon, "Clicking on Delete Icon :");
	}
}
