package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewInvoiceTemplatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewInvoiceTemplatePage_TemplateName  = "//input[@id='editInvoice_invoice_invoiceNo']";
	public static final String OCR_CreateNewInvoiceTemplatePage_TemplateIDLink = "//a[contains(text(),'Template Id')]";
	public static final String OCR_CreateNewInvoiceTemplatePage_TemplateIDSearch = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_CreateNewInvoiceTemplatePage_TemplateIDSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_CreateNewInvoiceTemplatePage_UltDestination = "//input[@name='invoice.countryOfUltDest']";
	
	
	public static final String OCR_CreateNewInvoiceTemplatePage_AddPartyBtn = "//button[@id='addPartyBtn']";
	public static final String OCR_CreateNewInvoiceTemplatePage_SelectEntityType = "//select[@id='selectedParty']";
	public static final String OCR_CreateNewInvoiceTemplatePage_EntityCode = "//a[contains(@name,'entityCodeLink')]";
	public static final String OCR_CreateNewInvoiceTemplatePage_Status = "//select[@name='popupValue.status']";
	public static final String OCR_CreateNewInvoiceTemplatePage_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewInvoiceTemplatePage_SearchConsignee = "//button[@name='Search']";
	public static final String OCR_CreateNewInvoiceTemplatePage_SelectConsignee = "//button[@name='Ok']";
	public static final String OCR_CreateNewInvoiceTemplatePage_CloseBtnConsignee = "//button[@class='btn-close']";
	public static final String OCR_CreateNewInvoiceTemplatePage_AddPartySaveBtn = "//button[@id='entitySave']";
	public static final String OCR_CreateNewInvoiceTemplatePage_AddMorePartiesBtn = "//button[@id='addPartyBtn']";
	public static final String OCR_CreateNewInvoiceTemplatePage_Regres_ShipToCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewInvoiceTemplatePage_Regres_BillToCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";

	
	/* ******************************* Constructor ****************************** */

	public CreateNewInvoiceTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void templatename(String tempName) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewInvoiceTemplatePage_TemplateName, "Enter Invoice template name : ", tempName);
		typeText(driver, test, OCR_CreateNewInvoiceTemplatePage_TemplateName, "Enter  Random Invoice no : ", randomnumbers());
	}
	
	public void selectTemplateID(String templateID) {
		Wait.waitfor(2);
		try {
			if(templateID.length() > 0) {
		clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_TemplateIDLink, "Click on Template ID hyperlink : ");
		clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_TemplateIDSearch, "Click on Search button : ");
		clickElement(driver, test, "//td[contains(text(),'"+ templateID +"')]", templateID);
		clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_TemplateIDSelect, "Click on Select button : ");
	}
		}catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Click on Cancel popup icon");
		}
	}
	
	public void enterUltDestination(String UltDest) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewInvoiceTemplatePage_UltDestination, "Enter Ultimate destination : ", UltDest);
	}
	
	// Adding the Parties to the Transaction for Regression US
		public void addPartiesToTheTransaction(String BillTo, String BillToCode, String BillStatus, String ShipTo,
				String ShipToCode, String ShipStatus) {

			scrollToElement(driver, OCR_CreateNewInvoiceTemplatePage_AddPartyBtn);

			clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_AddPartyBtn, "Click on Add Party Button");

			// Select Entity Type -> Bill To
			selectByVisibleText(driver, test, OCR_CreateNewInvoiceTemplatePage_SelectEntityType, "Select Entity Type : ", BillTo);

			if (BillToCode.length() > 0) {
				try {
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_EntityCode, "Click on Entity Code");
					selectByVisibleText(driver, test, OCR_CreateNewInvoiceTemplatePage_Status, "Select Status : ", BillStatus);
					typeText(driver, test, OCR_CreateNewInvoiceTemplatePage_Regres_BillToCode, "Enter Bill To Code : ", BillToCode);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_SearchConsignee, "Click on Search Button");
					clickElement(driver, test, "//td[contains(text(),'" + BillToCode + "')]",
							"Select the Consignee : " + BillToCode);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_SelectConsignee, "Click on Select button");
					scrollToBottom(driver);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_AddPartySaveBtn, "Click on Save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_CloseBtnConsignee, "Click on Close popup icon");
				}

			}
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewInvoiceTemplatePage_AddMorePartiesBtn);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_AddMorePartiesBtn, "Click on Add More Parties Button :");
			Wait.waitfor(2);
			// Select Entity Type -> Ship To
			selectByVisibleText(driver, test, OCR_CreateNewInvoiceTemplatePage_SelectEntityType, "Select Entity Type : ", ShipTo);
			Wait.waitfor(2);

			if (ShipToCode.length() > 0) {
				try {
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_EntityCode, "Click on Entity Code");
					selectByVisibleText(driver, test, OCR_CreateNewInvoiceTemplatePage_Status, "Select Status : ", ShipStatus);
					typeText(driver, test, OCR_CreateNewInvoiceTemplatePage_Regres_ShipToCode, "Enter Ship To Code : ", ShipToCode);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_SearchConsignee, "Click on Search Button");
					clickElement(driver, test, "//td[contains(text(),'" + ShipToCode + "')]",
							"Select the Consignee : " + ShipToCode);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_SelectConsignee, "Click on Select button");
					scrollToBottom(driver);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_AddPartySaveBtn, "Click on Save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewInvoiceTemplatePage_CloseBtnConsignee, "Click on Close popup icon");
				}

			}	
		}
			
			public void saveBtn() {
				Wait.waitfor(2);
				scrollToElement(driver, "(//button[contains(text(),'Save')])[1]");
				clickElement(driver, test, "(//button[contains(text(),'Save')])[1]", "Click on Save button : ");
			}
			
			public String getInvTemplateID() {
				Wait.waitfor(2);
				return getAttribute(driver, test, "(//span[@class='additional-value'])[1]", "innerText", "Get the invoice order template number :");
				
			}

		}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

