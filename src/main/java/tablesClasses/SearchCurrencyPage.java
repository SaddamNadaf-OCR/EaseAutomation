package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCurrencyPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCurrency = "//button[@name='Add']";
	public static final String OCR_Search_page_CurrencyCode="//input[@name='currency.currencyCode']";
	public static final String OCR_Search_page_CountryCode="//input[@name='currency.countryCode']";
	public static final String OCR_Search_page_Status="//select[@name='currency.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
	//--------------------Constructor------------------------------------//
	
		public SearchCurrencyPage(WebDriver driver, ExtentTest test) {
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
	public void addCurrency() {
			clickElement(driver, test, OCR_HomePage_AddCurrency, "clicking on Add button :");
			}
//.....................searchParameter...............................//
	public void searchbyParameters(String CurrencyCode, String CountryCode, String status, String SortBy, String direction) {
		if(CurrencyCode.length()>0) {
			typeText(driver, test, OCR_Search_page_CurrencyCode, "Entering CurrencyCode :", CurrencyCode);
		}
		if(CountryCode.length()>0) {
			typeText(driver, test, OCR_Search_page_CountryCode, "Entering CountryCode", CountryCode);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}
		if(SortBy.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		}
		if(direction.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
		}
		
			
			}

}
