package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchLocationDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddLocationDetails = "//button[@name='addButton']";
	public static final String OCR_Search_page_CountryGroupCodes="//input[@name='comLocationDetailsValue.countryGroupCode']";
	public static final String OCR_Search_page_Description="//textarea[@name='comLocationDetailsValue.description']";
	public static final String OCR_Search_page_Status="//select[@name='comLocationDetailsValue.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchLocationDetailsPage(WebDriver driver, ExtentTest test) {
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
					
//....................click on Add Mode Of Payment button......................//
	public void AddLocationDetails() {
		clickElement(driver, test, OCR_HomePage_AddLocationDetails, "clicking on Add button :");
		}
		
//.....................searchParameter...............................//
	public void searchbyParameters(String CountryGroupCodes, String Description, String status) {
		if(CountryGroupCodes.length()>0) {
			typeText(driver, test, OCR_Search_page_CountryGroupCodes, "Entering CountryGroupCodes", CountryGroupCodes);
		}
		if(Description.length()>0) {
			typeText(driver, test, OCR_Search_page_Description, "Entering Description", Description);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}

					
						
			}
			

}
