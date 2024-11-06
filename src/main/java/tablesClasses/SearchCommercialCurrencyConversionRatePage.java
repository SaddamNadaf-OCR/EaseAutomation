package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCommercialCurrencyConversionRatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//----------------------------------------Locators--------------------------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCommercialCurrencyConversionRate = "//button[@name='Add']";
	public static final String OCR_Search_page_Currency="//select[@name='conversionBusinessValue.countryCode']";
	public static final String OCR_Search_page_Status="//select[@name='conversionBusinessValue.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	

//--------------------Constructor------------------------------------//
	
	public SearchCommercialCurrencyConversionRatePage(WebDriver driver, ExtentTest test) {
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
			
//....................click on Add Currency button......................//
	public void addCommercialCurrency() {
			clickElement(driver, test, OCR_HomePage_AddCommercialCurrencyConversionRate, "clicking on Add button :");
			}
//.....................searchParameter...............................//
	public void searchbyParameters(String Currency, String status, String SortBy) {
		if(Currency.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Currency, "selecting Currency by dropdown :", Currency );
			}
			
			if(status.length()>0) {
				selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
			}
			if(SortBy.length()>0) {
				selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
			}
			
}
}
