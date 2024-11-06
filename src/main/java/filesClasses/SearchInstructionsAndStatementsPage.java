package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchInstructionsAndStatementsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//---------------------------------Locators------------------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddInstructionsAndStatements = "(//button[@class='primary-btn'])[2]";
	public static final String OCR_HomePage_SBU = "//select[@name='instrcts.sbuCode']";
	public static final String OCR_HomePageInstructionsAndStatements = "//a[contains(text(),'Instructions & Statements')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_ProductReport = "(//a[contains(text(),'Product Report')])[1]";
	public static final String OCR_HomePage_InstructionId="//input[@name='instrcts.instructionsId']";
	public static final String OCR_Homepage_Type="//select[@name='instrcts.type']";
	public static final String OCR_HomePage_Description="//input[@name='instrcts.description']";
	public static final String OCR_HomePage_Country="//input[@name='instrcts.countryName']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchInstructionsAndStatementsPage(WebDriver driver, ExtentTest test) {
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
		
	//....................click on AddProgram button......................//
	public void addInstructionsAndStatements() {
		clickElement(driver, test, OCR_HomePage_AddInstructionsAndStatements, "clicking on search button :");
	}
				
	//.....................searchParameter...............................//
	public void searchbyParameters(String sbu, String InstructionId, String Type, String SortBy, String direction, String Country, String Description) {
	selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
	typeText(driver, test, OCR_HomePage_InstructionId, "Entering Code :", InstructionId);
	typeText(driver, test, OCR_HomePage_Description, "Entering Code :", Description);
	selectByVisibleText(driver, test, OCR_Homepage_Type, "selecting Status by dropdown :", Type );
	typeText(driver, test, OCR_HomePage_Country, "selecting Country by dropdown :", Country );
	selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortbBy dropdown :", SortBy );
	selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting direction by dropdown :", direction );
							
							
	}
		

}
