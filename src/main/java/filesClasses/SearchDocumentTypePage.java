package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchDocumentTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//--------------------------------------------Locators------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddDocumentType = "//button[@name='Add']";
	public static final String OCR_HomePage_DocumentTypeCode = "//input[@name='documentType.docTypeCode']";
	public static final String OCR_HomePageDocumentType = "(//a[contains(text(),'Document Type')])[1]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_SetID="//select[@name='documentType.setId']";
	public static final String OCR_HomePage_Status="//select[@name='documentType.status']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchDocumentTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	
	}
	
	//....................click on search button......................//
		public void searchbutton() {
			clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
		
		//....................click on reset button......................//
		public void resetbutton() {
			clickElement(driver, test, OCR_SearchPage_reset, "clicking on search button :");
		}
			
		//....................click on AddCorrectiveAction button......................//
		public void addCode() {
			clickElement(driver, test, OCR_HomePage_AddDocumentType, "clicking on Add button :");
		}
		
	//.....................searchParameter...............................//
		public void searchbyParameters(String DocumentTypeCode, String SetID, String Status, String SortBy, String direction) {
			
			typeText(driver, test, OCR_HomePage_DocumentTypeCode, "Entering Code :", DocumentTypeCode);
			selectByVisibleText(driver, test, OCR_HomePage_SetID, "selecting SetID by dropdown :", SetID );
			selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
		}


}
