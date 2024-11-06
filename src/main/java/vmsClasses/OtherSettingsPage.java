package vmsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class OtherSettingsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_OS_SBUCode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_OS_Search = "//input[@id='search']";
	public static final String OCR_VMCT_OS_Edit = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_OS_VisitFrom = "//select[@id='editOtherSettings_visitTimeFrom']";
	public static final String OCR_VMCT_OS_VisitTo = "//select[@id='editOtherSettings_visitTimeTo']";
	public static final String OCR_VMCT_OS_Update = "//button[@class='primary-btn']";

	/* ******************** Constructor ***************************** */

	public OtherSettingsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Select SBU Code
	public void select_OS_SBUCode(String SBU) {		
		selectByVisibleText(driver, test, OCR_VMCT_OS_SBUCode,"Select SBU Code ", SBU);		
	}

	// Clicking on Search button
	public void click_OS_Search(){		
		clickElement(driver, test, OCR_VMCT_OS_Search, "Clicking on Search button");				
	}

	// Clicking on Edit button
	public void click_OS_Edit(){		
		clickElement(driver, test, OCR_VMCT_OS_Edit, "Clicking on Edit button");				
	}	

	public void get_visitFrom(String SelectList){
		selectByVisibleText(driver, test, OCR_VMCT_OS_VisitFrom, "selected From Date: ", SelectList);		
	}

	//Get text of visit To date
	public void get_visitTo(String SelectList){
		selectByVisibleText(driver, test, OCR_VMCT_OS_VisitTo, "selected To Date: ", SelectList);
	}

	// Clicking on Edit button
	public void click_OS_Update(){		
		scrollToElement(driver, OCR_VMCT_OS_Update);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VMCT_OS_Update, "Clicking on Update button");				
	}


}
