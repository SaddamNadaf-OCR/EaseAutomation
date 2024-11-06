package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchPriorityPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//------------------------------------Locators--------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddPriority = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='priority.sbuCode']";
	public static final String OCR_HomePagepriority = "(//a[contains(text(),'Priority')])[1]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_PriorityType="//input[@name='priority.priorityType']";
	public static final String OCR_HomePage_PriorityName="//input[@name='priority.priorityName']";
	public static final String OCR_HomePage_Status="//select[@name='priority.status']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='priority.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchPriorityPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	
	}
	
	//....................click on search button......................//
		public void searchbutton() {
			clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
		
		//....................click on reset button......................//
		public void resetbutton() {
			clickElement(driver, test, OCR_SearchPage_reset, "clicking on reset button :");
		}
			
		//....................click on AddPriority button......................//
		public void addPriority() {
			clickElement(driver, test, OCR_HomePage_AddPriority, "clicking on Add Priority button :");
		}
		
		//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String PriorityType, String PriorityName, String Status, String CreatedBy, String SortBy, String direction) {
			selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
			typeText(driver, test, OCR_HomePage_PriorityType, "Entering Priority Type :", PriorityType);
			typeText(driver, test, OCR_HomePage_PriorityName, "Entering Priority Name :", PriorityName);
			selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
			selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
		}

}
