package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchSystemGeneratedNumberPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//------------------------------------------Locator----------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'])[1]";
	public static final String OCR_SearchPage_reset = "//button[@class='ocr-cache-search-dynamic-class']";
	public static final String OCR_HomePage_AddSystemGeneratedNumbers = "//button[@class='primary-btn'][2]";
	public static final String OCR_HomePage_SBU = "//select[@name='uniqueId.sbuCode']";
	public static final String OCR_HomePageSystemGeneratedNumber = "(//a[contains(text(),'System Generated Numbers')])";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_DatabaseName="//select[@name='uniqueId.templateId']";
	public static final String OCR_Homepage_Template="//input[@name='uniqueId.templateName']";
	public static final String OCR_HomePage_defaultFlag="//select[@name='uniqueId.defaultFlag']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='uniqueId.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_Direction="//select[@name='direction']";
	
	//-----------------------------Constructor--------------------------------------------//
	
	public SearchSystemGeneratedNumberPage(WebDriver driver, ExtentTest test) {
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
				
				//....................click on AddSGN button......................//
		public void addShipper() {
				clickElement(driver, test, OCR_HomePage_AddSystemGeneratedNumbers, "clicking on AddSystemGeneratedNumbers button :");
				}
		
		//.....................searchParameter...............................//
				public void searchbyParameters(String sbu, String DatabaseName, String Template, String defaultFlag, String CreatedBy, String SortBy, String Direction ) {
						selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
						selectByVisibleText(driver, test, OCR_HomePage_DatabaseName, "Entering Name :", DatabaseName);
						typeText(driver, test, OCR_Homepage_Template, "Entering Country :", Template);
						selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting Status by dropdown :", CreatedBy );
						selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortBy by dropdown :", SortBy );
						selectByVisibleText(driver, test, OCR_HomePage_Direction, "selecting Direction by dropdown :", Direction );
						selectByVisibleText(driver, test, OCR_HomePage_defaultFlag, "selecting CreatedBy by dropdown :", defaultFlag );
						
				}
		

}
