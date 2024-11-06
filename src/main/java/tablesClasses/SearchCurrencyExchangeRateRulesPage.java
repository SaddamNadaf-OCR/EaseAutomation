package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCurrencyExchangeRateRulesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//--------------------------------------Locators----------------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddNewRule = "//button[@name='Add']";
	public static final String OCR_Search_page_CustomsCountry="//input[@name='currencyExchangeRates.countryCode']";
	public static final String OCR_Search_page_Status="//select[@name='currencyExchangeRates.status']";
	public static final String OCR_Search_page_Type="//select[@name='currencyExchangeRates.action']";
	
//--------------------Constructor------------------------------------//
	
	public SearchCurrencyExchangeRateRulesPage(WebDriver driver, ExtentTest test) {
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
			
//....................click on Add CurrencyRules button......................//
	public void addCurrencyRules() {
			clickElement(driver, test, OCR_HomePage_AddNewRule, "clicking on Add button :");
			}

//.....................searchParameter...............................//
	public void searchbyParameters(String CustomsCountry, String status, String Type) {
		if(CustomsCountry.length()>0) {
			typeText(driver, test, OCR_Search_page_CustomsCountry, "Entering CustomsCountry :", CustomsCountry);
		}
		
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}
		if(Type.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Type, "selecting Type by dropdown :", Type );
		}
			
				
			}

	

}
