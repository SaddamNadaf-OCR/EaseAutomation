package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCorrectiveActionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//---------------------------------------Locators-------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCorrectiveAction = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='correctiveAction.sbuCode']";
	public static final String OCR_HomePageCorrectiveAction = "(//a[contains(text(),'Corrective Action')])[5]";
	public static final String OCR_HomePage_Report = "(//a[@data-hover='dropdown'])[4]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_Code="//input[@name='correctiveAction.code']";
	public static final String OCR_HomePage_Status="//select[@name='correctiveAction.status']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchCorrectiveActionPage(WebDriver driver, ExtentTest test) {
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
			clickElement(driver, test, OCR_HomePage_AddCorrectiveAction, "clicking on Add button :");
		}
		
	//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String Code, String Status, String SortBy, String direction) {
			selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
			typeText(driver, test, OCR_HomePage_Code, "Entering Code :", Code);
			selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
		}

}
