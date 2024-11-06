package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ListInBondCodePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ListInBondCodePage_AddInbondCodeBtn = "//button[contains(text(),'Add InBond')]";
	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public ListInBondCodePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void click_AddInBond() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListInBondCodePage_AddInbondCodeBtn, "Click on Add InBond Code button : ");
	}
	
	public void validateInBondCode(String inBondCode) {
		Wait.waitfor(2);
		try {
			if(isDisplayed(driver, "//a[contains(text(),'"+ inBondCode +"')]")) {
				test.log(LogStatus.PASS, "Added InBond Code is displayed :" +inBondCode);
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added InBond Code is not displayed :" +inBondCode);
		}
		
	}
	
	public void copy_inBondCode() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//i[@class='fa fa-copy'])[1]", "Click on Copy icon:");
	}
}
