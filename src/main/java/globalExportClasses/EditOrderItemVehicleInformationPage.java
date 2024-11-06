package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditOrderItemVehicleInformationPage extends GenericMethods{
	

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_AddVehicleBtn = "//button[contains(text(),'Add Export Vehicle')]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINProdID = "//input[@name='exportVehicleInfo.vinProdId']";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleNo = "//input[@id='editTabbedExportVehicleInfo_exportVehicleInfo_vehicleTitleNumber']";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleState = "//a[contains(text(),'Vehicle Title State')]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleStateSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINCorrectionFlag = "//select[@id='editTabbedExportVehicleInfo_exportVehicleInfo_vehicleCorrectionFlag']";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleStateClosePopUp ="(//button[@class='btn-close'])[1]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleSaveBtn = "(//button[contains(text(),'Save')] [@class='primary-btn'])[1]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleSaveReturnBtn = "//button[@id='expVehicleSaveReturn']";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleCloseBtn =  "(//button[@class='btn-close'])[1]";
	public static final String OCR_EditOrderItemvehicleInfoPage_Regres_VehicleInfoCloseBtn = "//button[@id='cancelInvoiceItem']";
	
	/* ******************************* Constructor ****************************** */

	public EditOrderItemVehicleInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void addExportVehicleBtn() {
		clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_AddVehicleBtn, "Click on Add Export Vehicle Button : ");
	}
	
	public void addExportvehiclePopUp(String VINProdID, String VINTitleNo, String VehicleTitleState, String CorrectionFlag) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINProdID, "Enter Vehicle Product ID : ", VINProdID);
		typeText(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleNo, "Enter Title Number : ", VINTitleNo);
		
		
		if (VehicleTitleState.length() > 0) {
			try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleState, "Click on Vehicle Title State");
			
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + VehicleTitleState + "')]", "Select the vehicle Title State : " + VehicleTitleState);
				clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleStateSelectBtn, "Click on Select button");
				Wait.waitfor(2);
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINTitleStateClosePopUp,
						"Click on Close popup icon");
				
			}
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VINCorrectionFlag, "Select Correction Flag : ", CorrectionFlag);
		
		}
		
	}
	
	public void exportVehiclesaveBtn() {
		clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleSaveBtn, "Click on Save Button :");
		Wait.waitfor(2);
	}
	
	public void exportVehicleSaveReturnBtn() {
		clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleSaveReturnBtn, "Click on Save and Return Button :");
		Wait.waitfor(2);
	}
	
	public void exportvehicleCloseBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_ExportVehicleCloseBtn, "Click on CLose button :");
	}
	
	public void vehicleInfoCloseBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_EditOrderItemvehicleInfoPage_Regres_VehicleInfoCloseBtn, "Click on Close Button of Vehicle Information :");
	}


}
