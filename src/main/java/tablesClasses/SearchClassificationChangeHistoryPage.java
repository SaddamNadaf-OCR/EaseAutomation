package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchClassificationChangeHistoryPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------------Locators--------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_CountryGroupCode = "//input[@name='country']";
	public static final String OCR_HomePage_ClassificationType = "//select[@name='comClassChangeHistoryValue.classificationType']";
	public static final String OCR_HomePageClassificationCH = "//a[contains(text(),'Classification Change History')]";
	public static final String OCR_Search_page_Classification="//input[@name='comClassChangeHistoryValue.classification']";
	public static final String OCR_Search_page_ActionType="//select[@name='comClassChangeHistoryValue.action']";
	public static final String OCR_Search_page_Status="//select[@name='comClassChangeHistoryValue.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
//--------------------Constructor------------------------------------//
	
	public SearchClassificationChangeHistoryPage(WebDriver driver, ExtentTest test) {
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
		

//.....................searchParameter...............................//
	public void searchbyParameters(String CountryGroupCode, String Classification, String ClassificationType, String ActionType, String status, String SortBy, String direction) {
			typeText(driver, test, OCR_HomePage_CountryGroupCode, "Entering CountryGroupCode :", CountryGroupCode);
			typeText(driver, test, OCR_Search_page_Classification, "Entering Classification", Classification);
			selectByVisibleText(driver, test, OCR_HomePage_ClassificationType,"selecting ClassificationType by dropdown", ClassificationType);
			selectByVisibleText(driver, test, OCR_Search_page_ActionType, "selecting ActionType by dropdown :", ActionType );
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
			selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
								
			}


}
