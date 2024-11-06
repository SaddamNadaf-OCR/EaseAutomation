package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AdhocScreeningPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Adhoc_NameField="//input[@id='searchGivenNameScreening_screenName']";
	public static final String OCR_Adhoc_AddressField= "//input[@id='searchGivenNameScreening_screenAddress1']";
	public static final String OCR_Adhoc_Address2Field= "//input[@id='searchGivenNameScreening_screenAddress2']";
	public static final String OCR_Adhoc_CountryField= "//input[@id='searchGivenNameScreening_screenCountryName']";
	public static final String OCR_Adhoc_Screen="(//button[text()='Screen'])[1]";
	
	
	public static final String OCR_Adhoc_ChooseSearchCriteria = "//label[contains(text(),'Choose Search Criteria')]";
	public static final String OCR_Adhoc_EntitySearchType = "//select[@id='searchGivenNameScreening_searchConsideration']";
	public static final String OCR_Adhoc_SearchMethod = "//select[@id='searchMethod']";
	public static final String OCR_Adhoc_Score = "//input[@id='scoreDisp']";
	public static final String OCR_Adhoc_EntityType = "//select[@id='entityType']";
	public static final String OCR_Adhoc_UseSearch = "//select[@id='useMethodDisp']";
	public static final String OCR_Adhoc_EntireCountryRestriction = "//input[@name='ecrFlag']";
	
	public static final String OCR_Adhoc_DPLUpdatedasof = "//label[contains(text(),'DPL Updated as of : ')]";
	
	/* ******************** Constructor ***************************** */
	
	public AdhocScreeningPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	
	// Enter Name
	public void enter_Name(String Name){
		typeText( driver, test, OCR_Adhoc_NameField ,"Entering Name",Name);
	}
	
	// Enter Address
		public void enter_Address(String Address){
			typeText( driver, test, OCR_Adhoc_AddressField ,"Entering Address",Address);
		}
		
	// Enter City State zip
		public void enter_CityStateZip(String City){
			typeText( driver, test, OCR_Adhoc_Address2Field ,"Entering City State zip ",City);
		}
		
	// Enter Country
		public void enter_Country(String Country){
			typeText( driver, test, OCR_Adhoc_CountryField ,"Entering Country ",Country);
		}		
		
		
	// Click on Screen
	public void click_Screen() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test,OCR_Adhoc_Screen , "Clicking on Screen");
	}
	
	// Click on Choose Search Criteria
		public void click_ChooseSearchCriteria() throws InterruptedException {
			clickElement(driver, test,OCR_Adhoc_ChooseSearchCriteria , "Clicking on Choose Search Criteria secion");
			Wait.waitfor(1);
	}		
	
	// Select option from Entity Search Type 
		public void select_EntitySearchType(String SearchType ) {
			selectByVisibleText(driver,test,OCR_Adhoc_EntitySearchType ,"Select Entity Search Type :",SearchType);
		}
			
	// Select option from  Search Method
		public void select_SearchMethod(String SearchMethod) {
			selectByVisibleText(driver,test,OCR_Adhoc_SearchMethod ,"Select Search Method :",SearchMethod);
		}	
						
		
	// Select option from  Entity Types
		public void select_EntityType(String EntityType) {
			 deSelectAll( driver, test,OCR_Adhoc_EntityType,"Deselecting all options");
			selectByVisibleText(driver,test,OCR_Adhoc_EntityType ,"Select Entity  Type :",EntityType);
		}	
					
		
	// Select option from Use Search 
		public void select_UseSearch(String UseSearch) {
			selectByVisibleText(driver,test,OCR_Adhoc_UseSearch ,"Select Use Search :",UseSearch);
		}	
	
	// Click on entire country restriction checkbox
		public void click_EntireCountryRestrictionCheckox() throws InterruptedException {
			clickElement(driver, test,OCR_Adhoc_EntireCountryRestriction , "Clicking on entire country restriction checkbox");
			Wait.waitfor(1);
		}		
	
	// Reading text in DPLUpdatedasof
		public String get_DPLUpdatedasof() throws InterruptedException {
			return getText( driver, test,OCR_Adhoc_DPLUpdatedasof,"Verify the text in DPLUpdatedasof field ");
			}			
		
		
}
