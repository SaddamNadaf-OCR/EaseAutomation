package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchExportItemsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddExportItems = "//button[@name='Add']";
	public static final String OCR_Search_page_Country="//select[@name='country']";
	public static final String OCR_Search_page_ExportClassification="//input[@name='productClazz.prodClassification']";
	public static final String OCR_Search_page_Status="//select[@name='productClazz.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchExportItemsPage(WebDriver driver, ExtentTest test) {
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
	public void AddExportItems() {
		clickElement(driver, test, OCR_HomePage_AddExportItems, "clicking on Add button :");
		}
//.....................searchParameter...............................//
	public void searchbyParameters(String Country, String ExportClassification, String status) {
		if(Country.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Country, "selecting Country by dropdown :", Country );
		}
		if(ExportClassification.length()>0) {
			typeText(driver, test, OCR_Search_page_ExportClassification, "Entering ExportClassification", ExportClassification);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}

			
				
				}

	
		

}
