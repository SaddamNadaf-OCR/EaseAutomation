package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class USGASRTAASalesReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGAR_Save="(//button[@name='Save'])[1]";
	public static final String USGAR_SaveAndReturn="(//button[@name='Ok'])[1]";
	public static final String USGAR_Cancel="(//button[@name='Cancel'])[1]";
	public static final String USGAR_POC="//input[@name='mlaSalesReportValue.mlaPoc']";
	public static final String USGAR_Telephone="//input[@name='mlaSalesReportValue.mlaPocPhoneNo']";
	public static final String USGAR_Email="//input[@name='mlaSalesReportValue.mlaPocEmail']";
	
	//.................................Constructor.....................................//
	public USGASRTAASalesReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	//...............................Click on Save Button..............................//
	public void save() {
		clickElement(driver, test, USGAR_Save, "Clicking on Save Button");
	}
	//..............................Click on Save and Return Button....................//
	public void saveAndReturn() {
		clickElement(driver, test, USGAR_SaveAndReturn, "Clicking on Save And Return Button");
	}
	//...............................Click on Cancel Button............................//
	public void cancel() {
		clickElement(driver, test, USGAR_Cancel, "Clicking on Cancel Button");
	}
	//..............................salesReport Data..................................//
	public void salesReportData(String poc,String telephone, String email) {
		
		typeText(driver, test, USGAR_POC, "Click on POC Number :", poc);
		Wait.waitfor(3);
		typeText(driver, test, USGAR_Telephone, "Click on Telephone number :", telephone);
		Wait.waitfor(3);
		typeText(driver, test, USGAR_Email, "Clicking on Email Id :", email);
	}

}
