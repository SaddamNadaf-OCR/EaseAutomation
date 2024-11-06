package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchConfidenceLevelPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------------Locators------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddConfidenceLevel = "(//button[@class='primary-btn ocr-cache-search-dynamic-class'][2])";
	public static final String OCR_HomePage_ConfidenceLevelpar = "//select[@name='level']";
	public static final String OCR_HomePage_ConfidenceLevelVal = "//input[@name='confidenceLevel.levelCode']";
	public static final String OCR_HomePageConfidenceLevel = "//a[contains(text(),'Confidence Level')]";
	public static final String OCR_HomePage_Name = "//input[@name='confidenceLevel.levelName']";
	public static final String OCR_Search_page_Status="//select[@name='confidenceLevel.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
//--------------------Constructor------------------------------------//
	
	public SearchConfidenceLevelPage(WebDriver driver, ExtentTest test) {
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
			
//....................click on Add Confidence Level button......................//
	public void addConfidenceLevel() {
		clickElement(driver, test, OCR_HomePage_AddConfidenceLevel, "clicking on Add Confidence Level button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String ConfidenceLevelpar, String ConfidenceLevelVal, String Name, String status, String SortBy, String direction) {
		selectByVisibleText(driver, test, OCR_HomePage_ConfidenceLevelpar, "Selecting ConfidenceLevelpar by dropdown :", ConfidenceLevelpar);
		typeText(driver, test, OCR_HomePage_ConfidenceLevelVal, "Entering ConfidenceLevelVal", ConfidenceLevelVal);
		typeText(driver, test, OCR_HomePage_Name, "Entering Name", Name);
		selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
									
			}

		

}
