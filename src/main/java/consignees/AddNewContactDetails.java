package consignees;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddNewContactDetails extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ConsigneeContactCode = "//input[@id='editConsContactTable_consContactTable_contactName']";
	public static final String OCR_ConsigneeFirstName = "//input[@id='editConsContactTable_consContactTable_firstName']";
	public static final String OCR_ConsigneeMiddlename = "//input[@id='editConsContactTable_consContactTable_middleName']";
	public static final String OCR_ConsigneeLastName = "//input[@id='editConsContactTable_consContactTable_lastName']";
	public static final String OCR_ConsigneeAddress = "//input[@id='editConsContactTable_consContactTable_addr1']";
	public static final String OCR_ConsigneeCity = "//input[@id='editConsContactTable_consContactTable_city']";
	public static final String OCR_ConsigneeState = "//input[@id='editConsContactTable_consContactTable_state']";
	public static final String OCR_ConsigneeZip = "//input[@id='editConsContactTable_consContactTable_zip']";
	public static final String OCR_ConsigneeCountry = "//input[@id='editConsContactTable_consContactTable_consCountryName']";
	public static final String OCR_ConsigneePhone = "//input[@id='editConsContactTable_consContactTable_contactPhone']";
	public static final String OCR_ConsigneeEmail = "//input[@id='editConsContactTable_consContactTable_EMail']";
	public static final String OCR_ConsigneeFax = "//input[@id='editConsContactTable_consContactTable_fax']";
	public static final String OCR_ConsigneeLanguage = "//select[@id='editConsContactTable_consContactTable_sourceLanguage']";
	public static final String OCR_AddConsignee_Save = "//button[@name='Save']";
	public static final String OCR_AddContactDetailsButton = "(//button[@type='button'])[4]";

	/*
	 * ****************************** Constructor *********************************
	 */
	public AddNewContactDetails(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void Addcontactdetails(String ContactCode, String FirstName, String Middlename, String LastName,
			String Address, String City, String State, String Zip, String Country, String Language, String phone,
			String Email, String Fax)

	{
		typeText(driver, test, OCR_ConsigneeContactCode, "Enter contact code", ContactCode);
		typeText(driver, test, OCR_ConsigneeFirstName, "Enter first name", FirstName);
		typeText(driver, test, OCR_ConsigneeMiddlename, "enter middle name", Middlename);
		typeText(driver, test, OCR_ConsigneeLastName, "Enter last name", LastName);
		typeText(driver, test, OCR_ConsigneeAddress, "enter address", Address);
		typeText(driver, test, OCR_ConsigneeCity, "enter city", City);
		typeText(driver, test, OCR_ConsigneeState, "enter state", State);
		typeText(driver, test, OCR_ConsigneeZip, "enter zip", Zip);
		typeText(driver, test, OCR_ConsigneeCountry, "enter country", Country);
		typeText(driver, test, OCR_ConsigneePhone, "enter phone", phone);
		typeText(driver, test, OCR_ConsigneeEmail, "enter email ", Email);
		typeText(driver, test, OCR_ConsigneeFax, "enter fax", Fax);
		typeText(driver, test, OCR_ConsigneeLanguage, "select language", Language);

	}

	// Click on Save Button
	public void Click_ConsigneeSave() {
		Wait.waitfor(3);

		clickElement(driver, test, OCR_AddConsignee_Save, "Click on Save Button");

	}

	// click on add contact details button
	public void Click_addContactButton() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddContactDetailsButton, "click on add contact detail button");

	}
}