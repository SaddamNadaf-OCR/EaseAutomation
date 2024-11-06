package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchContractsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//------------------------------------------Locators-------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddContracts = "//input[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='contract.sbuCode']";
	public static final String OCR_HomePageContracts = "//a[contains(text(),'Contracts')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_ContractNo="//input[@name='contract.contractNo']";
	public static final String OCR_HomePage_Status="//select[@name='contract.status']";
	
	/* ******************** Constructor ***************************** */

	public SearchContractsPage(WebDriver driver, ExtentTest test) {
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
		
		//....................click on AddContract button......................//
		public void addContract() {
		clickElement(driver, test, OCR_HomePage_AddContracts, "clicking on search button :");
		}
		
		//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String ContractNo, String Status) {
		selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
		typeText(driver, test, OCR_HomePage_ContractNo, "Entering Code :", ContractNo);
		selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
				
							
		}
			
			

}
