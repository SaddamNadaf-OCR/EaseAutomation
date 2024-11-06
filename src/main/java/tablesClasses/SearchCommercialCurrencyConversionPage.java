package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCommercialCurrencyConversionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------------Locators-------------------------------------------------------//
	public static final String OCR_SearchPage_NewSearch = "//button[@name='Back']";
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCommercialCurrencyConversionRate = "//button[@name='Add']";
	public static final String OCR_Search_page_Currency="//select[@name='conversionBusinessValue.countryCode']";
	public static final String OCR_Search_page_Status="//select[@name='conversionBusinessValue.status']";
	
//--------------------Constructor------------------------------------//
		
	public SearchCommercialCurrencyConversionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
								
}
	//....................click on New search button......................//
		public void NewSearchbutton() {
			clickElement(driver, test, OCR_SearchPage_NewSearch, "clicking on New Search button :");
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
	public void addCommercialCurrencyConversion() {
		clickElement(driver, test, OCR_HomePage_AddCommercialCurrencyConversionRate, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String Currency, String Status) {
		if(Currency.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Currency, "selecting Country by dropdown :", Currency );
			}
		if(Status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", Status );
			}
						
							
		}

}