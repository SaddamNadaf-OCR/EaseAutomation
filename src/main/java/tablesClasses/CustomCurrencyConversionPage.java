package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CustomCurrencyConversionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------------Locators-------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCustomCurrencyConversion = "//button[@name='Add']";
	public static final String OCR_Search_page_Country="//select[@name='conversionCustomsValue.countryCode']";
	public static final String OCR_Search_page_RateType="//select[@name='conversionCustomsValue.rateType']";
	public static final String OCR_Search_page_Status="//select[@name='conversionCustomsValue.status']";
	
//--------------------Constructor------------------------------------//
	
	public CustomCurrencyConversionPage(WebDriver driver, ExtentTest test) {
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
					
//....................click on Add Custom Currency Conversion  button......................//
	public void addCustomCurrencyConversion() {
		clickElement(driver, test, OCR_HomePage_AddCustomCurrencyConversion, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String Country, String RateType, String Status) {
		if(Country.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Country, "selecting Country by dropdown :", Country );
		}
				
		if(RateType.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_RateType, "selecting RateType by dropdown :", RateType );
		}
		if(Status.length()>0) {
				selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", Status );
		}
					
						
	}

		

}
