package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchSpecialInstructionNotesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//--------------------------------------Locators-----------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@name='Search']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddNotes = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='notes.sbuCode']";
	public static final String OCR_HomePageSpecialInstructionNotes = "//a[contains(text(),'Special Instructions Notes')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_Topic="//input[@name='notes.topic']";
	public static final String OCR_Homepage_Category="//input[@name='notes.category']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='notes.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	//-------------------------------Constructor-------------------------------------//
	
	public SearchSpecialInstructionNotesPage(WebDriver driver, ExtentTest test) {
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
	
	//....................click on AddNotes button......................//
	public void addNotes() {
		clickElement(driver, test, OCR_HomePage_AddNotes, "clicking on Add Notes button :");
		}
	//--------------------------SearchByParameter---------------------------------//
			
	public void searchbyParameters(String sbu, String Topic, String Category, String CreatedBy, String SortBy, String direction) {
		selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
		typeText(driver, test, OCR_HomePage_Topic, "Entering Topic :", Topic);
		typeText(driver, test, OCR_Homepage_Category, "Entering Code :", Category);
		selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
		selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting direction by dropdown :", direction );
				
				
			}
			
			


}
