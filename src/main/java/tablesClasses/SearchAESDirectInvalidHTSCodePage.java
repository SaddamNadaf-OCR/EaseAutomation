package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAESDirectInvalidHTSCodePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//----------------------------------------Locators--------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AESInvalidHTS = "//button[@name='Add']";
	public static final String OCR_HomePage_HTSNo = "//input[@name='aesInvalidHts.htsNo']";
	public static final String OCR_HomePageAESDirectInvalidHTSCodes = "//a[contains(text(),'AES Direct Invalid HTS Codes')]";
	public static final String OCR_Search_page_Description="//textarea[@name='aesInvalidHts.htsDesc']";
	public static final String OCR_Search_page_Status="//select[@name='aesInvalidHts.status']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
//--------------------Constructor------------------------------------//
	
	public SearchAESDirectInvalidHTSCodePage(WebDriver driver, ExtentTest test) {
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
//....................click on Add AES InvalidHTS button......................//
	public void addAESInvalidHTS() {
		clickElement(driver, test, OCR_HomePage_AESInvalidHTS, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String HTSNo, String Description, String status, String SortBy, String direction) {
		typeText(driver, test, OCR_HomePage_HTSNo, "Entering HTSNo :", HTSNo);
		typeText(driver, test, OCR_Search_page_Description, "Entering Descriptions", Description);
		selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
						
		}

}
