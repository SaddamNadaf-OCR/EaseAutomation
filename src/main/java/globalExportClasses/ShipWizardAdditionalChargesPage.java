
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardAdditionalChargesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipAdditionalCharges_AddMoreCharges = "//button[@id='addChargesBtn']";
	public static final String OCR_ShipAdditionalCharges_ChargeDescription = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargeDesc']";
	public static final String OCR_ShipAdditionalCharges_Amount = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargeAmount']";
	public static final String OCR_ShipAdditionalCharges_ChargingAccount = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargingAccount']";
	public static final String OCR_ShipAdditionalCharges_GLACode = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_glaCode']";
	public static final String OCR_ShipAdditionalCharges_ChargeToCustomer = "//input[@id='editTabbedInvoiceCharges_chargeToCustomer']";
	public static final String OCR_ShipAdditionalCharges_WholesalerCharge = "//input[@id='editTabbedInvoiceCharges_chargeToCustomer']";
	public static final String OCR_ShipAdditionalCharges_PrintOnDocuments = "//input[@id='editTabbedInvoiceCharges_printOnForm']";
	public static final String OCR_ShipAdditionalCharges_Submit = "//button[@id='invChargesSubmit']";
	public static final String OCR_ShipAdditionalCharges_PopUpClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_ShipAdditionalCharges_AddAdditionalCharges ="//i[@class='fa fa-percent fa-2x']";
	public static final String OCR_ShipmentAdditionalCharges_AddChargesCopyicon ="//i[@class='fa fa-copy']";
	public static final String OCR_ShipmentAdditionalCharges_AddChargesDeleteicon ="//i[@class='fa fa-trash-o']";
	/* ******************************* Constructor ****************************** */

	public ShipWizardAdditionalChargesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Add More Charges
	public void clickAddMoreChargesBtn() {
		clickElement(driver, test, OCR_ShipAdditionalCharges_AddMoreCharges, "Click on Add More Charges Btn");
	}
	// click on Add Additional charges tab ---- Added By Deva
		public void clickAddAdditionalCharges() {
			clickElement(driver, test, OCR_ShipAdditionalCharges_AddAdditionalCharges, "click on Add Additional charges tab ");
		}

	// click on add charges grid Copy icon --------Added by Deva
	public void click_ItemCopyIcon() {
		clickElement(driver, test, OCR_ShipmentAdditionalCharges_AddChargesCopyicon, " click on  Additional Charges Copy icon ");
		test.log(LogStatus.PASS, "Clicked on  Additional Charges Copy icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipAdditionalCharges_PopUpClose, "Click on PopUp close Icon");
	}

	// click on add charges grid Delete Icon -----Added by Deva
	public void click_ItemDeleteIcon() {
		clickElement(driver, test, OCR_ShipmentAdditionalCharges_AddChargesDeleteicon,
				"click on Additional Charges Delate Icon");
		Wait.waitfor(2);
		AlertPopUp(driver, test, "Are you sure you wish to delete?");
		Wait.waitfor(2);
		test.log(LogStatus.PASS, "Clicked on Additional Charges Delate Icon");
	}
				
	// Adding the Additional Charges
	public void addAdditionalCharges(String ChargeDescription, String Amount, String ChargingAccount, String GLACode,
			String ChargeToCustomer,String WholesalerCharge,String PrintOnDocuments) {
		try {
			typeText(driver, test, OCR_ShipAdditionalCharges_ChargeDescription, "Enter the Charge Description : ",
					ChargeDescription);
			typeText(driver, test, OCR_ShipAdditionalCharges_Amount, "Enter the Amount : ", Amount);
			typeText(driver, test, OCR_ShipAdditionalCharges_ChargingAccount, "Enter the Charging Account : ",
					ChargingAccount);
			typeText(driver, test, OCR_ShipAdditionalCharges_GLACode, "Enter the GLA Code : ", GLACode);
			if (ChargeToCustomer.equalsIgnoreCase("Yes")) {
				clickElement(driver, test, OCR_ShipAdditionalCharges_ChargeToCustomer,
						"Click on Charge To Customer Check box");
			}
			if(WholesalerCharge.equalsIgnoreCase("Yes")) {
				clickElement(driver, test, OCR_ShipAdditionalCharges_WholesalerCharge, "Click on Wholesaler Charge Check BOX");
			}
			if(PrintOnDocuments.equalsIgnoreCase("Yes")) {
				clickElement(driver, test, OCR_ShipAdditionalCharges_PrintOnDocuments, "Click on Print On Documents Check Box");
			}
			clickElement(driver, test, OCR_ShipAdditionalCharges_Submit, "Click on Submit button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipAdditionalCharges_PopUpClose, "Click on PopUp close Icon");
		}
	}
	
	//Click on Submit Button
	public void submit() {
		clickElement(driver, test, OCR_ShipAdditionalCharges_Submit, "Click on Submit button");
	}

}
