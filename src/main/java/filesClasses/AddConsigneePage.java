package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddConsigneePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddConsignee = "//button[contains(text(),'Add Consignee')]";
	public static final String OCR_consigneeIdlink = "//a[contains(text(),'Id')]";
	public static final String OCR_AddConsigneeIDinput = "//input[@id='editConsignee_consignee_consigneeId']";
	public static final String OCR_AddConsgnees_militiaryGoods = "//input[@id='searchConsignee_useForDos']";
	public static final String OCR_AddConsignees_dualUse = "//input[@id='searchConsignee_useForDoc']";
	public static final String OCR_AddConsigness_AES = "//input[@id='searchConsignee_useForDoc']";
	public static final String OCR_addConsigneeName = "//input[@id='editConsignee_consignee_consigneeName']";
	public static final String OCR_AddConsigneeAddress = "//input[@id='editConsignee_consignee_consigneeAddr1']";
	public static final String OCR_AddConsigneeCity = "//input[@id='editConsignee_consignee_consigneeCity']";
	public static final String OCR_AddConsigneeState = "//input[@id='editConsignee_consignee_consigneeStateName']";
	public static final String OCR_AddConsigneeCountry = "//input[@id='editConsignee_consignee_consigneeCountryName']";
	public static final String OCR_AddConsigneeZip = "//input[@id='editConsignee_consignee_zip']";
	public static final String OCR_AddConsigneePhone1 = "//input[@id='editConsignee_consignee_phone']";
	public static final String OCR_AddConsigneeFax = "//input[@id='editConsignee_consignee_fax']";
	public static final String OCR_AddConsigneeEmail = "//input[@id='editConsignee_consignee_email']";
	public static final String OCR_AddConsigneeAssurenceGiven = "//select[@id='editConsignee_consignee_assurance']";
	public static final String OCR_AddConsigneemiliEndUser = "//select[@id='editConsignee_consignee_meuser']";
	public static final String OCR_AddConsigneeRemarks = "//textarea[@id='editConsignee_consignee_remarks']";
	public static final String OCR_AddConsigneeMT = "(//input[@id='editConsignee_mt'])[1]";
	public static final String OCR_AddConsigneeCB = "(//input[@id='editConsignee_cb'])[1]";
	public static final String OCR_AddConsigneeNS = "(//input[@id='editConsignee_ns'])[1]";
	public static final String OCR_AddConsigneeNP = "(//input[@id='editConsignee_np'])[1]";
	public static final String OCR_AddConsigneeRS = "(//input[@id='editConsignee_rs'])[1]";
	public static final String OCR_AddConsigneeCC = "(//input[@id='editConsignee_cc'])[1]";
	public static final String OCR_AddConsigneeAT1 = "(//input[@id='editConsignee_at'])[1]";
	public static final String OCR_AddConsigneeFC = "(//input[@id='editConsignee_fc'])[1]";
	public static final String OCR_AddConsigneeRelated = "(//input[@id='editConsignee_related'])[1]";
	public static final String OCR_AddConsigneeSalesPerson = "(//input[@id='editConsignee_consignee_salesPerson'])[1]";
	public static final String OCR_AddConsigneeEndUserDate = "//input[@id='transDate']";
	public static final String OCR_AddConsigneeConsigneeTypefrAES = "(//select[@id='editConsignee_consignee_type'])[1]";
	public static final String OCR_AddConsigneeSTALetRequired = "(//input[@id='editConsignee_staLetterRequired'])[1]";
	public static final String OCR_AddConsigneeSTALetterObtained = "(//input[@id='editConsignee_staLetterObtained'])[1]";
	public static final String OCR_AddConsigneeDateObtained = "(//input[@id='editConsignee_staDateObtained'])[1]";
	public static final String OCR_AddConsigneeTemplate = "//input[@id='searchForm_uniqueId_templateName']";
	public static final String OCR_AddConsigneeSearchgrid = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_AddConsignee_Save = "//button[@type='submit']";
	public static final String OCR_SearchConsignee_Select = "(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String OCR_SearchConsignee_popupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchConsigneeContactDetail = "//button[@name='contact']";

	// Shipment/Form Profile//

	public static final String OCR_AddConsigneeIntermidCnsignee = "//a[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_AddConsigneeFreightForwrCode = "//a[contains(text(),'Freight Forwarder Code')]";
	public static final String OCR_AddConsigneebillToPurchaser = "//a[contains(text(),'Sold To/Bill To:/Purchaser')]";
	public static final String OCR_AddConsigneeMarkFor = "//a[contains(text(),'Mark For')]";
	public static final String OCR_AddConsigneeEndUser = "//a[contains(text(),'End User')]";
	public static final String OCR_AddConsigneeTypeOfConsignee1 = "//select[@id='editConsignee_consignee_typeOfConsignee']";
	public static final String OCR_AddConsigneepatiallyOrfullyOwnedBygvt = "//select[@id='editConsignee_consignee_ownedByGovt']";
	public static final String OCR_AddConsigneeIntractWithGovt = "//select[@id='editConsignee_consignee_interactWithGovt']";
	public static final String OCR_AddConsigneeavimiliEnduse = "//select[@id='editConsignee_consignee_aviationMilNucEndUse']";
	public static final String OCR_AddConsigneeOrgContactForConsignee = "//input[@id='editConsignee_consignee_contact']";
	public static final String OCR_AddConsignePoOrSgnedcontract = "//select[@id='editConsignee_consignee_signedContract']";
	public static final String OCR_AddConsigneeOrgContact = "//input[@id='editConsignee_consignee_estimatedSalesSpendsUSD']";
	// Additional Information//

	public static final String OCR_AddConsigneeSrcSystmID = "//input[@id='editConsignee_consignee_sourceSystemId']";
	public static final String OCR_AddConsigneeSrcSystmPartyID = "//input[@id='editConsignee_consignee_sourceSystemPartyId']";

	/*
	 * ****************************** Constructor *********************************
	 */
	public AddConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	public void AddConsigneeDetails(String InputId, String ConsigneeName, String ID) {
		//clearText(driver, test, OCR_AddConsigneeIDinput, "clearing previous data");
		Wait.waitfor(3);
		typeText(driver, test, OCR_AddConsigneeIDinput, "Enter consignee Id", InputId);
		typeText(driver, test, OCR_addConsigneeName, "Enter Consignee Name", ConsigneeName);

		if (ID.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_consigneeIdlink, "click on Created By");
			try {
				typeText(driver, test, OCR_AddConsigneeTemplate, "Enter user : ", ID);
				clickElement(driver, test, OCR_AddConsigneeSearchgrid, "Click on search button");
				Wait.waitfor(3);
				String User1 = "//td[contains(text(),'" + ID + "')]";
				System.out.println(User1);
				clickElement(driver, test, User1, "Click User :" + ID);
				clickElement(driver, test, OCR_SearchConsignee_Select, "Click on search user Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Created By ");
				clickElement(driver, test, OCR_SearchConsignee_popupClose, "Close the popup");
			}
		}
	}

	// Click on Save Button
	public void Click_ConsigneeSave() {
		Wait.waitfor(3);

		clickElement(driver, test, OCR_AddConsignee_Save, "Click on Save Button");

	}

	// click on contact details
	public void Click_ContactDetails() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchConsigneeContactDetail, "click on contact details");

	}
}