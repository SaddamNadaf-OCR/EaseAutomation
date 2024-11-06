package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchMasterAirwayBillPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[contains(text(),'Search')]";
	public static final String OCR_RESET  =  "//button[@type='reset']";
	public static final String OCR_SBUCODE = "//select[@name='mawb.sbuCode']";
	public static final String OCR_MAWBNO = "//input[@name='mawb.mawbno']";
	public static final String OCR_ConsigneeCode = "//input[@name='mawb.consigneeId']";
	public static final String OCR_HomePage_AddNewMAWB = "(//button[@type='button'])[4]";
	
	
	/* ******************************* Constructor ****************************** */

	public SearchMasterAirwayBillPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
	}
	/* ******************************* Action ****************************** */
	//clicking on Search 
		public void search  () {
			clickElement(driver, test, OCR_SEARCH, "Click on Search");
		}
	// Clicking on Reset
		public void Reset () {
			clickElement(driver, test, OCR_RESET, "clicking on Reset button");
				}
	//clicking on Add New MAWB
				public void AddnewMAWB  () {
					clickElement(driver, test, OCR_HomePage_AddNewMAWB, "Click on ADDNEW MAWB");
				}
	//Search by parameter
		public void parameter (String Sbu, String MAWBNO, String ConsigneeCode) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Selecting Sbu", Sbu);
			typeText(driver, test, OCR_MAWBNO, "Enter MAWBNO", MAWBNO);
			typeText(driver, test, OCR_ConsigneeCode, "Enter ConsigneeCode ", ConsigneeCode);
		}
	
}
