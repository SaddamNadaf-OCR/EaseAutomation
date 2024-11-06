package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchGroundCarrierPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	//--------------------Locator---------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@name='Search']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddGroundCarrier = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='groundCarrier.sbuCode']";
	public static final String OCR_HomePageGroundCarrier = "//a[contains(text(),'Ground Carrier')]";
	public static final String OCR_Search_page_Code="//input[@name='groundCarrier.grCarrierCode']";
	public static final String OCR_Search_page_Name="//input[@name='groundCarrier.grCarrierName']";
	public static final String OCR_Search_page_Status="//select[@name='groundCarrier.status']";
	public static final String OCR_Search_page_Createdby="//select[@name='groundCarrier.createdBy']";
	public static final String OCR_Search_page_SortBy="//select[@name='sortBy']";
	public static final String OCR_Search_page_Direction="//select[@name='direction']";
	
	//--------------------Constructor------------------------------------//
	
	public SearchGroundCarrierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	
	}
	
	//....................click on search button......................//
		public void searchbutton() {
			clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
		
		//....................click on reset button......................//
		public void resetbutton() {
			clickElement(driver, test, OCR_SearchPage_reset, "clicking on search button :");
				}
		
		//....................click on Add GroundCarrier button......................//
				public void addGroundCarrier() {
					clickElement(driver, test, OCR_HomePage_AddGroundCarrier, "clicking on search button :");
				}
		//.....................searchParameter...............................//
				public void searchbyParameters(String sbu, String Code, String Name, String status, String Createdby, String SortBy, String direction) {
					selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu );
					typeText(driver, test, OCR_Search_page_Code, "Entering Code :", Code);
					typeText(driver, test, OCR_Search_page_Name, "Entering Name", Name);
					selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
					selectByVisibleText(driver, test, OCR_Search_page_Createdby, "selecting Createdby by dropdown :", Createdby );
					selectByVisibleText(driver, test, OCR_Search_page_SortBy, "selecting SortBy by dropdown :", SortBy );
					selectByVisibleText(driver, test, OCR_Search_page_Direction, "selecting direction by dropdown :", direction );
					
				}

				
				

}
