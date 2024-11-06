package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchChargesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//-----------------------------------Locators---------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddCharges = "//button[@name='Ok']";
	public static final String OCR_HomePage_SBU = "//select[@name='chargeDetailsValue.sbuCode']";
	public static final String OCR_HomePageCharges = "//a[contains(text(),'Charges')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_ChargeCode="//input[@name='chargeDetailsValue.chargeCode']";
	public static final String OCR_HomePage_Status="//select[@name='chargeDetailsValue.status']";
	public static final String OCR_HomePage_ChargeType="//select[@name='chargeDetailsValue.chargeType']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchChargesPage(WebDriver driver, ExtentTest test) {
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
		
	//....................click on AddCharges button......................//
	public void addChargeCode() {
		clickElement(driver, test, OCR_HomePage_AddCharges, "clicking on AddCharges button :");
	}
				
	//.....................searchParameter...............................//
	public void searchbyParameters(String sbu, String ChargeCode, String Status, String ChargeType, String direction) {
		selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
		typeText(driver, test, OCR_HomePage_ChargeCode, "Entering Code :", ChargeCode);
		selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
		selectByVisibleText(driver, test, OCR_HomePage_ChargeType, "selecting CreatedBy by dropdown :", ChargeType );
		selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
	}


}
