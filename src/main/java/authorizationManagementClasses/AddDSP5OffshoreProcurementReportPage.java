package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.ScreenCapture;

import utilities.GenericMethods;
import utilities.Wait;

public class AddDSP5OffshoreProcurementReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DSP_5_AuthorizationNo="//a[contains(text(),'Authorization No')]";
	public static final String DSP_5_TransactionIDPopup="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String DSP_5_AuthorizationNoPopup="//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String DSP_5_Search="//button[@name='Search']";
	public static final String DSP_5_resetpopup="//button[@id='resetbtn']";
	public static final String DSP_5_cancel="//button[@name='Cancel']";
	public static final String DSP_5_select="//button[contains(text(),'Select')]";
	public static final String DSP_5_PopupClose="(//button[@class='btn-close'])[1]";
	public static final String DSP_5_CreateOffShoreButton="//button[contains(text(),'Create Offshore Procurement Report')]";
	public static final String DSP_5_Cancel="//button[contains(text(),'Cancel')]";
	
	//.................................Constructor.....................................//
	public AddDSP5OffshoreProcurementReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...........................Clicking on Authorization No..........................//
	public void authorizatioNOByTransactionID(String transactionID) {
		clickElement(driver, test, DSP_5_AuthorizationNo, "Clicking on Authorization No");
		try {
			typeText(driver, test, DSP_5_TransactionIDPopup, "Typing Transaction ID", transactionID);
			clickElement(driver, test, DSP_5_Search, "Clicking on Search Tab");
			Wait.waitfor(6);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+transactionID+"')]", "Selecting Transaction ID"+transactionID);
			Wait.waitfor(3);
			clickElement(driver, test, DSP_5_select, "Clicking on Select Tab");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, DSP_5_PopupClose, "Clicking on Close PopUp");
		}
	}
	
	//...........................Clicking on Authorization No..........................//
	public void authorizatioNOByAuthorizationNo(String authorizationID) {
		clickElement(driver, test, DSP_5_AuthorizationNo, "Clicking on Authorization No");
		try {
			typeText(driver, test, DSP_5_AuthorizationNoPopup, "Typing Transaction ID", authorizationID);
			clickElement(driver, test, DSP_5_Search, "Clicking on Search Tab");
			clickElement(driver, test, "//td[contains(text(),'"+authorizationID+"')]", "Selecting Transaction ID"+authorizationID);
			clickElement(driver, test, DSP_5_select, "Clicking on Select Tab");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, DSP_5_PopupClose, "Clicking on Close PopUp");
		}
	}
	
	//............................Click on Create OffShore Report......................//
	public void createoffShore() {
		clickElement(driver, test, DSP_5_CreateOffShoreButton, "Clicking on Create OffShore Report");
	}
	
	//............................Click on Cancel Button.............................//
	public void cancel() {
		clickElement(driver, test, DSP_5_Cancel, "Clicking on Cancel Button");
	}
}
