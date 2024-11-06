package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchProductLinesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//-----------------------------------------Locators-----------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddProductLines = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='dosProdLine.sbuCode']";
	public static final String OCR_HomePageProductLines = "//a[contains(text(),'Product Lines')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_ProductLineId="//input[@name='dosProdLine.prodLineId']";
	public static final String OCR_Homepage_ProductLineName="//textarea[@name='dosProdLine.prodLineName']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='dosProdLine.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchProductLinesPage(WebDriver driver, ExtentTest test) {
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
		
	//....................click on AddProductLine button......................//
		public void addProductLines() {
			clickElement(driver, test, OCR_HomePage_AddProductLines, "clicking on search button :");
		}
				
	//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String ProductLineId, String ProductLineName, String CreatedBy, String SortBy, String direction) {
		selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
		typeText(driver, test, OCR_HomePage_ProductLineId, "Entering Code :", ProductLineId);
		typeText(driver, test, OCR_Homepage_ProductLineName, "Entering Code :", ProductLineName);
		selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
		selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
							
							
		}


}
