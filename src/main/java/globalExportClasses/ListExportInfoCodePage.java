package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ListExportInfoCodePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ListExportInfoCodePage_NewExportInfoCodeBtn  ="//button[contains(text(),'New Export Info Code')]";
	public static final String OCR_ListExportInfoCodePage_Copy = "(//i[@class='fa fa-copy'])[1]";
	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public ListExportInfoCodePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void create_NewExportInfoCode() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListExportInfoCodePage_NewExportInfoCodeBtn, "Click on new Export Info Code button : ");
	}
	
	public void validateExportCode(String exportCode) {
		Wait.waitfor(2);
		try {
			if(isDisplayed(driver, "//a[contains(text(),'"+ exportCode +"')]")) {
				test.log(LogStatus.PASS, "Added Export Info Code is displayed :" +exportCode);
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added Export Info Code is not displayed :" +exportCode);
		}
		
	}
	
	public void copyExportCode() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListExportInfoCodePage_Copy, "Click on Copy icon :");
	}
}
