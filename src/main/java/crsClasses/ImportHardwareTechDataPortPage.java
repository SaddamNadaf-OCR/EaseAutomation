package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportHardwareTechDataPortPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Port_SavBtn = "//input[@name='save']";
	public static final String OCR_Port_SaveAndReturnBtn = "//input[@name='OK']";
	public static final String OCR_Port_PortLink = "(//a[contains(text(),'Port')])[3]";
	public static final String OCR_Port_PortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_Port_SearchBtn = "//button[@name='Search']";
	public static final String OCR_Port_SelectBtn = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_Port_PopClose = "//button[@class='close']";
	public static final String OCR_Port_PortDisableField = "//input[@id='editExportPort_exportPort_portCode']";
	public static final String OCR_Port_PortType = "//select[@id='editExportPort_exportPort_portType']";
	public static final String OCR_Port_CancleBtn = "//input[@name='Cancel']";

	/* ******************** Constructor ***************************** */

	public ImportHardwareTechDataPortPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save button
	public void click_ItemSaveBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Port_SavBtn, "click on Save button");
	}

	// Click on Save and return button
	public void click_ItemSaveAndReturnBtn() {
		click_ItemSaveBtn();
		clickElement(driver, test, OCR_Port_SaveAndReturnBtn, "Clicking on Save And Return Button");
	}

	// Add ports details by using port link
	public void addport(String PortID, String PortType) {
		clickElement(driver, test, OCR_Port_PortLink, "Click on Port link");
		try {
			typeText(driver, test, OCR_Port_PortID, "Enter Port ID", PortID);
			clickElement(driver, test, OCR_Port_SearchBtn, "Click on Search button");
			String portId = "//td[contains(text(),'" + PortID + "')]";
			clickElement(driver, test, portId, "Select the port ID : " + PortID);
			clickElement(driver, test, OCR_Port_SelectBtn, "Click on Search button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Port_PopClose, "Click on Pop up close button");
		}
		selectByVisibleText(driver, test, OCR_Port_PortType, "Select the port type : ", PortType);
	}

	// Error message in Port
	public void validationPort() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter a Port Name')]")) {
					test.log(LogStatus.INFO, "Please Enter a Port Name");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter a Port Code.')]")) {
					test.log(LogStatus.INFO, "Please Enter a Port Code.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE & Return button in Port");
		}
	}

	// Click on Cancle button
	public void click_CanclePortBtn() {
		clickElement(driver, test, OCR_Port_CancleBtn, "Click on Cancle button");
	}

}
