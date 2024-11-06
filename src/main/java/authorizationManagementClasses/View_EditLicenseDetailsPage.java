package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class View_EditLicenseDetailsPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Save="//button[@name='Save']";
	public static final String Auth_Mana_BackToHeader="//button[@id='backToHeader']";
	
	public static final String Auth_Mana_TransactionType="//select[@name='licenseHeader.permanent']";
	public static final String Auth_Mana_licenseShippingTolerance="//input[@name='licenseHeader.licenseShippingTolerance']";
	public static final String Auth_Mana_tecc="//input[@name='licenseHeader.tecc']";
	public static final String Auth_Mana_originator="//input[@name='licenseHeader.originator']";
	public static final String Auth_Mana_GovtPOC="//input[@name='licenseHeader.govContact1']";
	public static final String Auth_Mana_govContact2="//input[@name='licenseHeader.govContact2']";
	public static final String Auth_Mana_multiUse="//input[@name='multiUse']";
	public static final String Auth_Mana_returnable="//input[@name='returnable']";
	public static final String Auth_Mana_returned="//input[@name='returned']";
	public static final String Auth_Mana_renewable="//input[@name='renewable']";
	public static final String Auth_Mana_returnableBy="//input[@name='returnableBy']";
	public static final String Auth_Mana_returnDate="//input[@name='returnDate']";
	public static final String Auth_Mana_ApplicantPOC="//input[@name='licenseHeader.applicantContact1']";
	public static final String Auth_Mana_PortofExit="//a[contains(text(),'Port of Exit')]";
	public static final String Auth_Mana_portId="//input[@name='ports.portId']";
	public static final String Auth_Mana_SearchPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopup="//button[@name='Ok']";
	public static final String Auth_Mana_ClosePopup="//button[@class='btn-close']";
	public static final String Auth_Mana_IssuedTo="//a[contains(text(),'Issued To')]";
	public static final String Auth_Mana_expCode="//input[@name='exporter.expCode']";
	public static final String Auth_Mana_issuedToTextBox="//input[@name='licenseHeader.issuedTo']";
	public static final String Auth_Mana_PortofEntry="//a[contains(text(),'Port of Entry')]";
	public static final String Auth_Mana_portIdPopUp="//input[@name='ports.portId']";
	public static final String Auth_Mana_portOfEntryTextBox="//input[@name='portOfEntry.licPortName']";
	public static final String Auth_Mana_unshipBalLicNo="//input[@name='licenseHeader.unshipBalLicNo']";
	public static final String Auth_Mana_firstExitDate="//input[@name='firstExitDate']";
	public static final String Auth_Mana_identicalLicNo="//input[@name='licenseHeader.identicalLicNo']";
	public static final String Auth_Mana_finalEntryDate="//input[@name='finalEntryDate']";
	public static final String Auth_Mana_otherIdentLicNo="//input[@name='licenseHeader.otherIdentLicNo']";
	public static final String Auth_Mana_hw="//input[@name='hw']";
	public static final String Auth_Mana_td="//input[@name='td']";
	
	//...................................Applicant/Supplier Details.......................................//
	public static final String Auth_Mana_Applicant_SupplierDetails="//label[contains(text(),'Applicant/Supplier Details')]";
	public static final String Auth_Mana_Applicant_Supplier="//a[contains(text(),'Applicant/Supplier')]";
	public static final String Auth_Mana_ExpCode="//input[@name='exporter.expCode']";
	public static final String Auth_Mana_Saveexporter_expCodeSave="//button[@name='Save']";
	public static final String Auth_Mana_Name="//input[@name='applicant.licAddrName']";
	public static final String Auth_Mana_Address="//input[@name='applicant.licAddrAddr1']";
	public static final String Auth_Mana_Address1="//input[@name='applicant.licAddrAddr2']";
	public static final String Auth_Mana_Address2="//input[@name='applicant.licAddrAddr3']";
	public static final String Auth_Mana_City="//input[@name='applicant.licAddrCity']";
	public static final String Auth_Mana_State="//input[@name='applicant.licAddrStateName']";
	public static final String Auth_Mana_Country="//input[@name='applicant.licAddrCountryName']";
	public static final String Auth_Mana_Zip="//input[@name='applicant.licAddrZip']";
	public static final String Auth_Mana_Phone="//input[@name='applicant.licAddrPhone']";
	public static final String Auth_Mana_hasSubsidiary="//input[@name='hasSubsidiary']";
	
	//..........................................Port.............................................//
	public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	public static final String Auth_Mana_AddPort="//button[@id='addPortBtn']";
	
	//........................................Country..............................................//
	public static final String Auth_Mana_CountryLabel="(//label[contains(text(),'Country')])[2]";
	public static final String Auth_Mana_addCountryBtn="//button[@id='addCountryBtn']";
	
	//.............................Item Label ......................................//
	public static final String Auth_Mana_ItemsLabel="//label[contains(text(),'Items')]";
	/*
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 * public static final String Auth_Mana_Port="//label[contains(text(),'Port')]";
	 */
	
	
	//..................................Constructors..................................//
	public View_EditLicenseDetailsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//....................................Authorization Details ...................................//
	public void authorizationDetails(String TransactionType, String LicenseTolerance, String TECC, String Originator, String GovtPOC, 
			String Returnabledate,String Returndate, String ApplicantPOC, String PortOfExit,String IssueTo, String PortOfEntry, 
			String UnshippedBalance, String FirstExitdate, String IdenticalLicNo, String FinalEntryDate, String OtherIdentLicNo,
			String Commodity) {
		
		selectByVisibleText(driver, test, Auth_Mana_TransactionType, "Selecting Transaction type :", TransactionType);
		typeText(driver, test, Auth_Mana_licenseShippingTolerance, "Entering License Tolerance :", LicenseTolerance);
		typeText(driver, test, Auth_Mana_tecc, "Entering TECC :", TECC);
		clickElement(driver, test, Auth_Mana_multiUse, "Clicking on Multiple Use CheckBox :");
		clickElement(driver, test, Auth_Mana_returnable, "Clicking on Returnable Checkox :");
		typeText(driver, test, Auth_Mana_originator, "Entering Originator :", Originator);
		clickElement(driver, test, Auth_Mana_returned, "Clicking on Returned :");
		clickElement(driver, test, Auth_Mana_renewable, "Clicking on Renewable :");
		typeText(driver, test, Auth_Mana_GovtPOC, "Entering Govt. POC :", GovtPOC);
		if(Returnabledate.length() > 0) {
			clickElement(driver, test, Auth_Mana_returnableBy, "Clicking on returnable By Date :");
			dateOfMonthName(driver, test, "Selecting Returnable By Date :", Returnabledate);
		}
		if(Returndate.length() > 0) {
			clickElement(driver, test, Auth_Mana_returnDate, "Clicking on return Date :");
			dateOfMonthName(driver, test, "Selecting Return Date :", Returndate);
		}
		typeText(driver, test, Auth_Mana_ApplicantPOC, "Entering Applicant POC :", ApplicantPOC);
		if(PortOfExit.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortofExit, "Clicking on Port Of Exit :");
			try {
				typeText(driver, test, Auth_Mana_portId, "Entering Port ID :", PortOfExit);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PortOfExit +"')]", "Selecting Port Of Exit :");
				clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close-Popup :");
			}
		}
		if(IssueTo.length() > 0) {
			clickElement(driver, test, Auth_Mana_IssuedTo, "Clicking on Issue To :");
			try {
				typeText(driver, test, Auth_Mana_expCode, "Entering Issue To :", IssueTo);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ IssueTo +"')]", "Selecting Issue To :");
				clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close-Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_issuedToTextBox, "Entering Isuue To into TextBox :", IssueTo);
		}
		if(PortOfEntry.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortofEntry, "Clicking on Port Of Entry :");
			try {
				typeText(driver, test, Auth_Mana_portIdPopUp, "Entering Port Of Entry :", PortOfEntry);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PortOfEntry +"')]", "Selecting Port Of Entry :");
				clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close-Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_portOfEntryTextBox, "Entering Port Of Entry into TextBox :", PortOfEntry);
		}
		scrollToBottom(driver);
		typeText(driver, test, Auth_Mana_unshipBalLicNo, "Entering Unshipped Balance :", UnshippedBalance);
		if(FirstExitdate.length() > 0) {
			clickElement(driver, test, Auth_Mana_firstExitDate, "Clicking on First Exit Date :");
			dateOfMonthName(driver, test, "Selecting First Exit Date :", FirstExitdate);
		}
		typeText(driver, test, Auth_Mana_identicalLicNo, "Entering Identical Commodity under Authorization No :", IdenticalLicNo);
		if(FinalEntryDate.length() > 0) {
			clickElement(driver, test, Auth_Mana_finalEntryDate, "Clicking on final Entry Date :");
			dateOfMonthName(driver, test, "Selecting final Entry Date :", FinalEntryDate);
		}
		typeText(driver, test, Auth_Mana_otherIdentLicNo, "Entering Identical Commodity to Other Countries Authorization No :", OtherIdentLicNo);
		if(Commodity.equalsIgnoreCase("HW")) {
			clickElement(driver, test, Auth_Mana_hw, "Clicking on HW :");
		}else {
			clickElement(driver, test, Auth_Mana_td, "Clicking on TD :");
		}
		scrollToBottom(driver);
	}
	
		//.....................................Applicant/Supplier Details.....................................//
		public void appicantDetails(String Applicant_Supplier, String Name, String Address, String Address1, String Address2, 
				String City, String State, String Country1, String ZipCode, String Phone) {
			
			clickElement(driver, test, Auth_Mana_Applicant_SupplierDetails, "Clicking on Applicant Suplier Details :");
			if(Applicant_Supplier.length() > 0) {
				clickElement(driver, test, Auth_Mana_Applicant_Supplier, "Clicking on Applicant Supplier :");
				try {
					typeText(driver, test, Auth_Mana_ExpCode, "Entering Export Code :", Applicant_Supplier);
					clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+Applicant_Supplier+"')]", "Selecting Applicant_Supplier :");
					clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Button :");
				}
				catch(Exception e) {
					testFailSshot(driver, test);
					e.printStackTrace();
					clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
				}
			}else {
				typeText(driver, test, Auth_Mana_Name, "Entering Name :", Name);
				typeText(driver, test, Auth_Mana_Address, "Entering Address :", Address);
				typeText(driver, test, Auth_Mana_Address1, "Entering Address 1 :", Address1);
				typeText(driver, test, Auth_Mana_Address2, "Entering Address 2 :", Address2);
				typeText(driver, test, Auth_Mana_City, "Entering City :", City);
				typeText(driver, test, Auth_Mana_State, "Entering State :", State);
				typeText(driver, test, Auth_Mana_Country, "Entering Country :", Country1);
				typeText(driver, test, Auth_Mana_Zip, "Entering Zip Code :", ZipCode);
				typeText(driver, test, Auth_Mana_Phone, "Entering Phone :", Phone);
			}
			scrollToBottom(driver);
		}
		
		//..................................Port......................................//
		public void port() {
			clickElement(driver, test, Auth_Mana_Port, "Clicking on Port :");
			clickElement(driver, test, Auth_Mana_AddPort, "Clicking on Add Port Button :");
		}
		
		//..................................Country ...................................//
		public void country() {
			clickElement(driver, test, Auth_Mana_CountryLabel, "Clicking on Country Label :");
			clickElement(driver, test, Auth_Mana_addCountryBtn, "Clicking on Add Country Button :");
		}
		
		//......................................Items ...................................//
		public void items() {
			clickElement(driver, test, Auth_Mana_ItemsLabel, "Clicking on item Label :");
		}
}
