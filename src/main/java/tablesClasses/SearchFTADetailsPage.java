package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchFTADetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddFTADetails = "//button[@name='Ok']";
	public static final String OCR_Search_page_Country="//input[@name='country']";
	public static final String OCR_Search_page_FTACode="//input[@name='ftaDetailsValue.ftaCode']";
	public static final String OCR_Search_page_Status="//select[@name='ftaDetailsValue.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchFTADetailsPage(WebDriver driver, ExtentTest test) {
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
				
//....................click on Add Export Items button......................//
	public void AddFTADetails() {
		clickElement(driver, test, OCR_HomePage_AddFTADetails, "clicking on Add button :");
		}
	
//.....................searchParameter...............................//
	public void searchbyParameters(String Country, String FTACode, String status) {
		if(Country.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Country, "selecting Country by dropdown :", Country );
		}
		if(FTACode.length()>0) {
			typeText(driver, test, OCR_Search_page_FTACode, "Entering FTACode", FTACode);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}

				
					
				}
		

}
