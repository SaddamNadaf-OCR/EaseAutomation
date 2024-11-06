package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAirOceanCarrierPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//----------------------------------Locators-----------------------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCarrier = "//button[@name='Add']";
	public static final String OCR_HomePage_Code = "//input[@name='carrier.carrierCode']";
	public static final String OCR_HomePageAirOceanCarrier = "//a[contains(text(),'Air/Ocean Carrier')]";
	public static final String OCR_Search_page_Description="//textarea[@name='carrier.description']";
	public static final String OCR_Search_page_Status="//select[@name='carrier.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchAirOceanCarrierPage(WebDriver driver, ExtentTest test) {
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
//....................click on  Add Air/Ocean Carrier button......................//
	public void addCarrier() {
		clickElement(driver, test, OCR_HomePage_AddCarrier, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String Code, String Description, String status) {
		typeText(driver, test, OCR_HomePage_Code, "Entering Code :", Code);
		typeText(driver, test, OCR_Search_page_Description, "Entering Descriptions", Description);
		selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
	}
	
	public void add_OldCode(String OldCode) {
		typeText(driver, test, OCR_HomePage_Code, "Entering Code :", OldCode);
		}

			
							

}
