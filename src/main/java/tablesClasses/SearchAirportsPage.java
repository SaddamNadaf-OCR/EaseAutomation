package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAirportsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddAirport = "//button[@name='Add']";
	public static final String OCR_HomePage_AirportCode = "//input[@name='airport.destinationCode']";
	public static final String OCR_HomePageAirports = "//a[contains(text(),'Airports')]";
	public static final String OCR_Search_page_AirportName="//textarea[@name='airport.destinationName']";
	public static final String OCR_Search_page_CountryCode="//select[@name='airport.countryGroupCode']";
	public static final String OCR_Search_page_Status="//select[@name='airport.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
//--------------------Constructor------------------------------------//
	
	public SearchAirportsPage(WebDriver driver, ExtentTest test) {
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
	
//....................click on Add Airports button......................//
	public void addAirports() {
		clickElement(driver, test, OCR_HomePage_AddAirport, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String AirportCode, String AirportName, String CountryCode, String status, String SortBy, String direction) {
			typeText(driver, test, OCR_HomePage_AirportCode, "Entering AirportCode :", AirportCode);
			typeText(driver, test, OCR_Search_page_AirportName, "Entering AirportName", AirportName);
			typeText(driver, test, OCR_Search_page_CountryCode,"selecting CountryCode by dropdown", CountryCode);
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
			selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
							
			}


}
