package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCommodityTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------------Locators------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCommodityType = "//button[@name='Add']";
	public static final String OCR_HomePage_CommodityTypeCode = "//input[@name='commodityType.commodityCode']";
	public static final String OCR_HomePageCommodityType = "//a[contains(text(),'Commodity Type')]";
	public static final String OCR_HomePage_CommodityTypeDescription = "//input[@name='commodityType.commodityDesc']";
	public static final String OCR_Search_page_TechDataType="//select[@name='commodityType.techDataType']";
	public static final String OCR_Search_page_Status="//select[@name='commodityType.status']";
	public static final String OCR_Search_page_CreatedBy="//select[@name='commodityType.createdBy']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
	//--------------------Constructor------------------------------------//
	
	public SearchCommodityTypePage(WebDriver driver, ExtentTest test) {
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
		
//....................click on Add Commodity Type button......................//
	public void addCommodityType() {
		clickElement(driver, test, OCR_HomePage_AddCommodityType, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String CommodityTypeCode, String CommodityTypeDescription, String TechDataType, String status, String CreatedBy, String SortBy, String direction) {
		typeText(driver, test, OCR_HomePage_CommodityTypeCode, "Entering CommodityTypeCode :", CommodityTypeCode);
		typeText(driver, test, OCR_HomePage_CommodityTypeDescription, "Entering CommodityTypeDescription", CommodityTypeDescription);
		selectByVisibleText(driver, test, OCR_Search_page_TechDataType,"selecting TechDataType by dropdown", TechDataType);
		selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		selectByVisibleText(driver, test, OCR_Search_page_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
		selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
								
		}

	

}
