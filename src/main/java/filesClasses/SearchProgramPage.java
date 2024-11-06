package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchProgramPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchPage_search = "//button[@name='Search']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddProgram = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='programTab.sbuCode']";
	public static final String OCR_HomePageProgram = "//a[contains(text(),'Programs')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_ProgramCode="//input[@name='programTab.programCode']";
	public static final String OCR_Homepage_Description="//textarea[@name='programTab.description']";
	public static final String OCR_HomePage_Status="//select[@name='programTab.status']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='programTab.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	
	

	/* ******************** Constructor ***************************** */

	public SearchProgramPage(WebDriver driver, ExtentTest test) {
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
		
		//....................click on AddProgram button......................//
		public void addProgram() {
			clickElement(driver, test, OCR_HomePage_AddProgram, "clicking on search button :");
		}
		
		//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String ProgramCode, String Description, String Status, String CreatedBy, String SortBy, String direction) {
			selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
			typeText(driver, test, OCR_HomePage_ProgramCode, "Entering Code :", ProgramCode);
			typeText(driver, test, OCR_Homepage_Description, "Entering Code :", Description);
			selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
			selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
			
			
		}

}
