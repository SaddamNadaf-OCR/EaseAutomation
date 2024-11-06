package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchECCNUSMLMappingPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddECCNUSMLMapping = "//button[@name='Add']";
	public static final String OCR_Search_page_USML="//input[@name='eccnUsmlMapping.usml']";
	public static final String OCR_Search_page_ECCN="//input[@name='eccnUsmlMapping.eccn']";
	public static final String OCR_Search_page_Status="//select[@name='eccnUsmlMapping.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	
	
	//--------------------Constructor------------------------------------//
	
	public SearchECCNUSMLMappingPage(WebDriver driver, ExtentTest test) {
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
		
//....................click on Add ECCN USML Mapping button......................//
	public void ECCNUSMLMapping() {
			clickElement(driver, test, OCR_HomePage_AddECCNUSMLMapping, "clicking on Add button :");
			}
//.....................searchParameter...............................//
	public void searchbyParameters(String USML, String ECCN, String status, String SortBy) {
		if(USML.length()>0) {
			typeText(driver, test, OCR_Search_page_USML, "Entering USML :", USML);
		}
		if(ECCN.length()>0) {
			typeText(driver, test, OCR_Search_page_ECCN, "Entering CountryCode", ECCN);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}
		if(SortBy.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		}
		
			
			}

}
