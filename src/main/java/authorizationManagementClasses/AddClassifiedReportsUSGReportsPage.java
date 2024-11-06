package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AddClassifiedReportsUSGReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String CR_CreateClassifiedReport="//button[contains(text(),'Create Classified License Report')]";
	public static final String CR_Cancel="//button[contains(text(),'Cancel')]";
	public static final String CR_Search="(//button[contains(text(),'Search')])[1]";
	public static final String CR_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String CR_CancelPopUp="(//button[contains(text(),'Cancel')])[2]";
	public static final String CR_LicanceNo="//a[contains(text(),'License No.')]";
	public static final String CR_TransactionID="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String CR_Select="//button[contains(text(),'Select')]";
	public static final String CR_ClosePopUp="(//button[@class='btn-close'])[1]";
	
	//.................................Constructor.....................................//
	public AddClassifiedReportsUSGReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.............................Add Classified Report Details..........................//
	public void addClassifiedReport(String transactionID) {
		clickElement(driver, test, CR_LicanceNo, "Clicking on Licance No");
		try {
			typeText(driver, test, CR_TransactionID, "Entering Transaction ID", transactionID);
			clickElement(driver, test, CR_Search, "Clicking on Search Tab");
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+ transactionID+"')]", "Selecting the data from Table"+transactionID);
			clickElement(driver, test, CR_Select, "Clicking on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, CR_ClosePopUp, "Clicking on Close PopUp");
		}
	}
	
	//.........................Add Create Classified Licance Report.......................//
	public void addcreateClssifiedButton() {
		clickElement(driver, test, CR_CreateClassifiedReport, "Clicking on Add Create Button");
	}
	
	//........................Click on Cancel button...........................//
	public void cancel() {
		clickElement(driver, test, CR_Cancel, "Clicking on Cancel Tab");
	}


}
