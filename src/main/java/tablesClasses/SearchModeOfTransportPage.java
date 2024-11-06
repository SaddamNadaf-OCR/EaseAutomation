package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchModeOfTransportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddModeOfTransport = "(//button[@type='button'])[3]";
	public static final String OCR_Search_page_MOTCode="//input[@name='mot.motCode']";
	public static final String OCR_Search_page_Country="//select[@name='mot.country']";
	public static final String OCR_Search_page_Status="//select[@name='mot.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchModeOfTransportPage(WebDriver driver, ExtentTest test) {
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
						
//....................click on Add Mode Of Transport button......................//
	public void AddMOT() {
		clickElement(driver, test, OCR_HomePage_AddModeOfTransport, "clicking on Add button :");
		}
			
//.....................searchParameter...............................//
	public void searchbyParameters(String MOTCode, String Country, String status) {
		if(MOTCode.length()>0) {
			typeText(driver, test, OCR_Search_page_MOTCode, "Entering MOTCode", MOTCode);
		}
		if(Country.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Country, "selecting Country by dropdown :", Country );
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}


}
	}
	

