package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCountryPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------------Locators------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCountry = "(//button[@class='primary-btn ocr-cache-search-dynamic-class'][2])";
	public static final String OCR_HomePage_CountryCode = "//input[@name='country.countryCode']";
	public static final String OCR_HomePage_CountryName = "//input[@name='country.countryName']";
	public static final String OCR_HomePageCountry = "(//a[contains(text(),'Country')])[3]";
	public static final String OCR_HomePage_ISOCode = "//input[@name='country.isoCode']";
	public static final String OCR_HomePage_DosCode = "//input[@name='country.dosCode']";
	public static final String OCR_Search_page_Status="//select[@name='country.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
//--------------------Constructor------------------------------------//
	
	public SearchCountryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
						
	}

//....................click on search button......................//
	public void searchbutton() {
		scrollToElement(driver, OCR_SearchPage_search);
		clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
							
//....................click on reset button......................//
	public void resetbutton() {
		clickElement(driver, test, OCR_SearchPage_reset, "clicking on reset button :");
			}
				
//....................click on Add Country  button......................//
	public void addCountry() {
		clickElement(driver, test, OCR_HomePage_AddCountry, "clicking on Add Country button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String CountryCode, String CountryName, String ISOCode, String DosCode, String status, String SortBy, String direction) {
		typeText(driver, test, OCR_HomePage_CountryCode, "Entering CountryCode", CountryCode);
		typeText(driver, test, OCR_HomePage_CountryName, "Entering CountryName", CountryName);
		typeText(driver, test, OCR_HomePage_ISOCode, "Entering ISOCode", ISOCode);
		typeText(driver, test, OCR_HomePage_DosCode, "Entering DosCode", DosCode);
		selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
										
		}

	

}
