package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchOceanBillPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[contains(text(),'Search')]";
	public static final String OCR_RESET  =  "//button[@type='reset']";
	public static final String OCR_SBUCODE =  "//select[@name='obol.sbuCode']";
	public static final String OCR_OBOLNO = "//input[@name='obol.obolNo']";
	public static final String OCR_ExporterCode ="//input[@name='obol.exporterCode']";
	
	/* ******************************* Constructor ****************************** */

	public SearchOceanBillPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */
	//clicking on Search 
		public void search  () {
			clickElement(driver, test, OCR_SEARCH, "clicking on search button");

		}
		// Clicking on Reset
		public void Reset () {
			clickElement(driver, test, OCR_RESET, "clicking on Reset button");
		}
       //Search by parameter
		public void parameter (String sbu, String OBOLNO, String ExporterCode) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Selecting Sbu", sbu);
			typeText(driver, test, OCR_OBOLNO, "Enter OBOL NO", OBOLNO);
			typeText(driver, test, OCR_ExporterCode, "Enter ExporterCode ", ExporterCode);
		}
}
