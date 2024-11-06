package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFItemDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ISFItemDetails_ISFDetailsBtn = "//button[contains(text(),'Security Filing (ISF) Details')]";
	public static final String OCR_ISFItemDetails_AddBillOfLadingBtn = "//button[@id='addBol']";
	public static final String OCR_ISFItemDetails_ClkContainerDetailstab = "//b[contains(text(),'Container Details')]";
	public static final String OCR_ISFItemDetails_AddContainerDeatilsBtn = "//button[@id='addContainer']";
	public static final String OCR_ISFItemDetails_EquipmentTypeLink = "//a[@id='equipmentType-Popup']";
	public static final String OCR_ISFItemDetails_Select = "//button[contains(text(),'Select')][1]";
	public static final String OCR_ISFItemDetails_EquipmentInitial = "//body/div[@id='content-cont']/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[6]/div[1]/div[2]/input[1]";
	public static final String OCR_ISFItemDetails_EquipmentNo = "//body/div[@id='content-cont']/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[7]/div[1]/div[2]/input[1]";
	public static final String OCR_ISFItemDetails_ClosePopUp = "//button[@class='close']";
	public static final String OCR_ISFItemDetails_SaveAndReturn = "//button[contains(text(),'Save and Return')]";
	public static final String OCR_ISFItemDetails_AddItemsBtn = "//button[@id='addItems']";
	public static final String OCR_ISFItemDetails_SubmitTab = "//a[contains(text(),'Submit')]";
	public static final String OCR_ISFItemDetails_ClickAlert = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_ISFItemDetails_CloseAlert = "//button[@class='close']";
	public static final String OCR_ISFItemDetails_ClickItem1 = "//a[contains(text(),'1')]";

	/* ******************** Constructor ***************************** */
	public ISFItemDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Click on Security Filing (ISF) Details Button
	public void iSFDetails() {
		clickElement(driver, test, OCR_ISFItemDetails_ISFDetailsBtn, "Click on Security Filing (ISF) Details Button");
	}
	
	//Click on Submit Tab
	public void clickSubmitTab() {
		clickElement(driver, test, OCR_ISFItemDetails_SubmitTab, "Click on Submit Tab");
	}
	
	
	//Click on Add BOL Button
	public void addBOIButton() {
		clickElement(driver, test, OCR_ISFItemDetails_AddBillOfLadingBtn, "Click on Add BOL Button");
	}
	
	//Click on Container Details Tab
	public void containerDeatilsTab() {
		clickElement(driver, test, OCR_ISFItemDetails_ClkContainerDetailstab, "Click on Container Details Tab");
	}
	
	//Click on Add Container Details
	public void addContainerDetails() {
		clickElement(driver, test, OCR_ISFItemDetails_AddContainerDeatilsBtn, "Click on Add Container Details");
	}
	
	//Container Details PopUp
	public void containerDetails(String EquipmentType, String EquipmentInitial, String EquipmentNo) {
		if (EquipmentType.length() > 0) {
			clickElement(driver, test, OCR_ISFItemDetails_EquipmentTypeLink, "Click on EquipmentType Link");
			try {
				String Equipment = "//div[contains(text(),'" + EquipmentType + "')]";
				Wait.waitfor(4);
				clickElement(driver, test, Equipment, "Select Equipment Type :" + EquipmentType);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_ISFItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Equipment Type");
				clickElement(driver, test, OCR_ISFItemDetails_ClosePopUp, "Click on Close");
			}
		}
		typeText(driver, test, OCR_ISFItemDetails_EquipmentInitial, "Add Equipment Initial ", EquipmentInitial);
		typeText(driver, test, OCR_ISFItemDetails_EquipmentNo, "Add Equipment No", EquipmentNo);
		clickElement(driver, test, OCR_ISFItemDetails_SaveAndReturn, "Click on Save And Return");
	}
	
	//Click on Add items Button
	public void addItem() {
		clickElement(driver, test, OCR_ISFItemDetails_AddItemsBtn, "Click on Add items Button");
	}
	
	//Click on Alert icon
	public void clickAlert() {
		clickElement(driver, test, OCR_ISFItemDetails_ClickAlert, "Click on Alert icon");
	}
	
	//Click on Item No 1
	public void clickItemOne() {
		clickElement(driver, test, OCR_ISFItemDetails_ClickItem1, "Click On Item No 1");
	}
	
	//Click on Close Alert
	public void closeAlert() {
		clickElement(driver, test, OCR_ISFItemDetails_CloseAlert, "Close Alert PopUp");
	}
	
	// Validation for Bill of Lading Details
		public void validationBillOfLading() {
			try {
				if (isDisplayed(driver, "//td[contains(text(),'At-least one Bill of lading is required')]")) {
					test.log(LogStatus.INFO, "At-least one Bill of lading is required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			}
		}
		
	// Validation for House Bill Of Lading or Ocean Bill of Lading Details
		public void validationHouseBill() {
			try {
				if (isDisplayed(driver, "//td[contains(text(),'Atlease one House Bill Of Lading or Ocean Bill of ')]")) {
					test.log(LogStatus.INFO, "Atlease one House Bill Of Lading or Ocean Bill of Lading is Required.");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			}
		}
	
	// Validation for Item Details
		public void validationItemDetails() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'At-least one Line Item is required')]")) {
					test.log(LogStatus.INFO, "At-least one Line Item is required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			}
		}	
		
	// Validation for Associated Supplier/Manufacture details in line item
		public void validationSupplierManufacture() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Associated Supplier/Manufacture details Missing fo')]")) {
					test.log(LogStatus.INFO, "Associated Supplier/Manufacture details Missing for Line item");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			}
		}	
}
