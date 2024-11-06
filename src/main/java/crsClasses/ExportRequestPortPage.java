package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestPortPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/********************************** Locators ********************************/
	public static final String OCR_ExportRequest_PortPopUpLink = "(//a[contains(text(),'Port')])[3]";
	public static final String OCR_ExportRequest_PortPopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_PortPopUpSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_PortSaveandreturnBtn = "//input[@name='OK']";
	public static final String OCR_ExportRequest_PortSourceManufacturerClick = "//span[contains(text(),'Source /Manufacturer')]";
	public static final String OCR_ExportRequest_PortSourceManufacturerSaveBtn = "//input[@name='save']";
	public static final String OCR_ExportRequest_PortSourceManufacturerCloseBtn = "//button[@class='close']";
	public static final String OCR_ExportRequest_PortSourcePortTypeDrpDown = "//select[@id='editExportPort_exportPort_portType']";
	public static final String OCR_ExportRequest_PortSourcePortIdTextBox = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_ExportRequest_PortSourceCancelBtn = "//input[@name='Cancel']";

	/* ******************** Constructor ***************************** */
	public ExportRequestPortPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save button
	public void click_PortSaveBtn() {
		clickElement(driver, test, OCR_ExportRequest_PortSourceManufacturerSaveBtn, "click on Save button");
	}

	// Click on Save and return button
	public void click_PortSaveAndReturnBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_PortSaveandreturnBtn, "Clicking on Save And Return Button");
	}

	// Add ports details by using port link
	public void addport(String PortID, String PortType) {
		clickElement(driver, test, OCR_ExportRequest_PortPopUpLink, "Click on Port link");
		try {
			typeText(driver, test, OCR_ExportRequest_PortSourcePortIdTextBox, "Enter Port ID : ", PortID);
			clickElement(driver, test, OCR_ExportRequest_PortPopUpSearchBtn, "Click on Search button");
			String portId = "//td[contains(text(),'" + PortID + "')]";
			clickElement(driver, test, portId, "Select the port ID : " + PortID);
			clickElement(driver, test, OCR_ExportRequest_PortPopUpSelectBtn, "Click on Search button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportRequest_PortSourceManufacturerCloseBtn,
					"Click on Pop up close button");
		}
		selectByVisibleText(driver, test, OCR_ExportRequest_PortSourcePortTypeDrpDown, "Select the port type : ",
				PortType);
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

	// Click on Cancel button
	public void click_CancelPortBtn() {
		clickElement(driver, test, OCR_ExportRequest_PortSourceCancelBtn, "Click on Cancel button");
	}

}
