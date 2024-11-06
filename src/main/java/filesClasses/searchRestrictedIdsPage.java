package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class searchRestrictedIdsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//-----------------------------------Locator-----------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@name='Search']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddRestrictedIds = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='restrictedValueTab.userSbuCode']";
	public static final String OCR_HomePageDataBaseName = "//select[@name='sortByDatabaseName']";
	public static final String OCR_Search_page_CreatedBy="//select[@name='restrictedValueTab.createdBy']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	
	//------------------------------Constructor-------------------------------------//
	
	public searchRestrictedIdsPage(WebDriver driver, ExtentTest test) {
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
			
			//------------------------Click on Add Restricted Ids--------------//
			
			public void addRestrictedIds() {
				clickElement(driver, test, OCR_HomePage_AddRestrictedIds, "clicking on search button :");
			}
			
			//----------------------------Search Parameter-----------------------//
			
			public void searchbyParameters(String sbu,String DataBaseName, String CreatedBy, String SortBy) {
				selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu );
				selectByVisibleText(driver, test, OCR_HomePageDataBaseName, "selecting DataBaseName by dropdown :", DataBaseName );
				selectByVisibleText(driver, test, OCR_Search_page_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
				selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
				
	
	
	

}
}
