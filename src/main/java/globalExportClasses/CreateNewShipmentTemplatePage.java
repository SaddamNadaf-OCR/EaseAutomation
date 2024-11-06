package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewShipmentTemplatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewShipmentTemplatePage_Templatename  = "//input[@id='editShipment_shipment_shipmentNo']";
	public static final String OCR_CreateNewShipmentTemplatePage_TemplateIDLink = "//a[@id='templateId-popup']";
	public static final String OCR_CreateNewShipmentTemplatePage_TemplateSearch = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_CreateNewShipmentTemplatePage_TemplateClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewShipmentTemplatePage_UltDestination = "//input[@id='editShipment_shipment_countryOfUltDest']";
	
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter = "//table[@id='entityTable']//a[contains(text(),'Exporter')]";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_ExpSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_ExpCode = "//input[@id='searchForm_popupValue_code']";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_ExpSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipmentTemplatePage_Exporter_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee = "//a[contains(text(),'Ult. Consignee')]";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_ID = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipmentTemplatePage_UltConsignee_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewShipmentTemplatePage_EndUserLink = "//a[contains(text(),'End User')]";
	public static final String OCR_CreateNewShipmentTemplatePage_FreightForwarder = "//table[@id='entityTable']//a[contains(text(),'Freight Forwarder')]";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipmentTemplatePage_FF_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	
	
	
	
	

	/* ******************************* Constructor ****************************** */

	public CreateNewShipmentTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void select_TemplateIDLink(String templateIDLink) {
		Wait.waitfor(2);
		try {
			 if(templateIDLink.length() > 0) {
				 Wait.waitfor(2);
				 clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_TemplateIDLink, "Click on Template ID Link : ");
				clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_TemplateSearch, "Click on Search button : ");
				clickElement(driver, test, "//td[contains(text(),'"+ templateIDLink +"')]", templateIDLink);
				clickElement(driver, test, "(//button[@name='Ok'])[1]", "Click on Select button :");
				 	  }	 
		 }catch(Exception e) {
			 testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_TemplateClosePopUp, "Click on Close popup icon"); 
		 }
	}
	
	public void enter_TemplateName(String TemplateName) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewShipmentTemplatePage_Templatename, "Enter Template name : ", TemplateName + randomnumbers());
	}
	
	public void enter_Destination(String UltDest) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewShipmentTemplatePage_UltDestination, "Enter Ulimate destination  : ", UltDest);
	}
	
	public void PartiesToTheTransaction(String ExporterCode, String ConsigneeId, String FFCode) {
		 
		 scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
			Wait.waitfor(3);
			if (ExporterCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter, "click on Exporter link");
				try {
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_Code, "click on exporter code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(5);
					typeText(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_ExpCode, "Enter Exporter Code : ", ExporterCode);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_ExpSearch, "Click On Search");
					String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
					clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_ExpSelect, "Click on Select");
					Wait.waitfor(2);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_Save, "Click on Save");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_Exporter_PopupClose, "Click on Cancel popup icon");
				}
			}
			if (ConsigneeId.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee, "Click on Ult Consignee Link");
				try {
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_Code, "Click on Ult Consignee Code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_ID, "Enter Consignee Id : ", ConsigneeId);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_Search, "Click On Search Button");
					String ConsCode = "//td[contains(text(),'" + ConsigneeId.trim() + "')]";
					clickElement(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_Save, "Click on Save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_UltConsignee_PopupClose, "Click on cancel popup icon");
				}
			}
			if (FFCode.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FreightForwarder, "Click on Freight Forwarder Link");
				try {
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FF_Code, "Click on Freight forwarder code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipmentTemplatePage_FF_FFCode, "Enter FF Code : ", FFCode);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FF_Search, "Click On Search Button");
					String FFCodeSel = "//td[contains(text(),'" + FFCode.trim() + "')]";
					clickElement(driver, test, FFCodeSel, "Select FF Code : " + FFCode);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FF_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FF_Save, "Click on save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipmentTemplatePage_FF_PopupClose, "Click on Cancel popup icon");
				}
			}
			
		}
	
	// click on save button
			public void click_SaveBtn() {
				scrollToElement(driver, "(//button[contains(text(),'Save')])[1]");
				scrollToTop(driver);
				clickElement(driver, test, "(//button[contains(text(),'Save')])[1]", "Click on Save button");
			}
	
			public String getShipMentTemplateID() {
				Wait.waitfor(2);
				return getAttribute(driver, test, "(//span[@class='additional-value'])[1]", "innerText", "Get the Shipment template number :");
				
			}
			
			public void validateMandatoryChecks() {
				Wait.waitfor(2);
				String errorMsg = getText(driver, test, "//h4[contains(text(),'Error!')]", "Error message is displayed");
				
				try {
					if(errorMsg.equalsIgnoreCase("Error!")) {
						test.log(LogStatus.PASS, "Error message displays to enter mandatory fields before saving a record.");
					}
				}catch(Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Error message is not displayed.");
				}
			}
			
			public void closeBtn() {
				Wait.waitfor(2);
				clickElement(driver, test, "//button[@id='cancelBtn']", "Click on Close button :");
			}
			
	
}
