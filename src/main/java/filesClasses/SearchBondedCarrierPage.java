package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchBondedCarrierPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//------------------------------------Locators---------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddBondedCarrier = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='comBondedCarrierDtlsValue.sbu']";
	public static final String OCR_HomePageBondedCarrierDetails = "//a[contains(text(),'Bonded Carrier Details')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_CarrierName="//input[@name='comBondedCarrierDtlsValue.carrierName']";
	public static final String OCR_Homepage_CarrierCode="//input[@name='comBondedCarrierDtlsValue.carrierCode']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchBondedCarrierPage(WebDriver driver, ExtentTest test) {
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
		
	//....................click on AddBondedCarrier button......................//
	public void addCarrierName() {
		clickElement(driver, test, OCR_HomePage_AddBondedCarrier, "clicking on Add button :");
	}
	
	//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String CarrierName, String CarrierCode, String SortBy, String direction) {
			selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
			typeText(driver, test, OCR_HomePage_CarrierName, "Entering Code :", CarrierName);
			typeText(driver, test, OCR_Homepage_CarrierCode, "Entering Code :", CarrierCode);
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
		}


}
