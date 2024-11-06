package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchShipmentSummaryBySiteReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_SBUCode = "//select[@id='selectSbu']";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_CountryUltDest ="//input[@id='resultShipmentSummaryBySiteReport_shipment_countryOfUltDest']";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_SelectCountry = "//select[@id='encryptedCountryCode']";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_SelectSite = "//select[@id='resultShipmentSummaryBySiteReport_selectSite']";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_SearchBtn = "//button[@id='btnsearch']";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_ValidateHeading = "//h3[contains(text(),'SHIPMENT SUMMARY BY SITE REPORT')]";
	public static final String OCR_MISReport_ShipmentSummaryBySiteReport_ResetBtn = "(//button[contains(text(),'Reset')])[1]";
	
	public static final String OCR_CountryofUltConsLink = "//a[contains(text(),'Ultimate Consignee Name')]";
	public static final String OCR_CountryofUltConsLinkEnter = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_CountryofUltConsLinkSearchBtn = "//button[@name='Search']";
	public static final String OCR_CountryofUltConsLinkSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CountryofUltConsLinkCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_CountryofIntConsLink = "//a[contains(text(),'Intermediate Consignee Name')]";
	public static final String OCR_CountryofForwardAgentLink = "//a[contains(text(),'Forwarding Agent Name')]";
	public static final String OCR_CountryofForwardAgentLinkEnter = "//input[@id='searchForm_freightForwarder_ffCode']";
	public static final String OCR_CountryofForwardAgentLinkSearch = "//button[@name='Search']";
	public static final String OCR_CountryofForwardAgentLinkSelectbtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreatedFromDate = "//input[@id='resultShipmentSummaryBySiteReport_fromCreatedDate']";
	public static final String OCR_DateToday = "//button[contains(text(),'Today')]";
	public static final String OCR_CreatedToDate = "//input[@id='resultShipmentSummaryBySiteReport_toCreatedDate']";
	public static final String OCR_ExportFromDate = "//input[@id='resultShipmentSummaryBySiteReport_fromDateOfExport']";
	public static final String OCR_ExportToDate = "//input[@id='resultShipmentSummaryBySiteReport_toDateOfExport']";
	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public SearchShipmentSummaryBySiteReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SBUCode) {
	Wait.waitfor(2);
	selectByVisibleText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SBUCode, "Select SBU Code : ", SBUCode);
	Wait.waitfor(2);
	}
	
	 public void selectCountry(String country) {
		 Wait.waitfor(2);
	 //deSelectAll(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SelectCountry, "Deselect All the options from Country");
		selectByVisibleText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SelectCountry, "Select Country : ", country); 
		
	 }
	 
	 public void UltDestCountry(String UltDest) {
		 Wait.waitfor(2);
		 typeText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_CountryUltDest, "Enter Country of Ultimate Destination : ", UltDest);
	 }
	 
	 public void selectSite(String Site) {
		 Wait.waitfor(2);

		// deSelectAll(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SelectSite, "Deselect All the options from Site");
			selectByVisibleText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SelectSite, "Select Site : ", Site); 
			
	 }
	 
	 public void searchBtn() {
		 Wait.waitfor(2);
		 clickElement(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SearchBtn, "Click on Search Button");
	 }
	 
	 public void validateHeading()
	 {
		 Wait.waitfor(3);
			isDisplayed(driver, OCR_MISReport_ShipmentSummaryBySiteReport_ValidateHeading);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "SHIPMENT SUMMARY BY SITE REPORT page is Displayed");
			Wait.waitfor(3);
		 
		 }

	public void resetBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_ResetBtn, "Click on Reset button : ");
	}
	
	public void searchByParameters(String SbuCode, String country, String UltConsName, String IntConsName,
			String FwdAgentName, String Region, String Site, String CountryofUltDest, String CreatedFrom,
			String CreatedTo, String ExportFrom, String ExportTo) {
		if(SbuCode.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_SBUCode, "Select Sbu Code", SbuCode);
		}
		if(country.length() > 0) {
			deSelectAll(driver, test, "//select[@id='encryptedCountryCode']", country);
		selectByVisibleText(driver, test, "//select[@id='encryptedCountryCode']", "Select Country : ", country);
		}
		Wait.waitfor(2);
		try {
			if (UltConsName.length() > 0) {
				clickElement(driver, test, OCR_CountryofUltConsLink, "Click on Ultimate Consignee Link : ");
				typeText(driver, test, OCR_CountryofUltConsLinkEnter, "Enter Ultimate COnsignee Code : ", UltConsName);
				clickElement(driver, test, OCR_CountryofUltConsLinkSearchBtn, "CLick on Search button :");
				clickElement(driver, test, "//td[contains(text(),'" + UltConsName + "')]", UltConsName);
				clickElement(driver, test, OCR_CountryofUltConsLinkSelectBtn, "Click on Select button :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CountryofUltConsLinkCloseBtn, "Click on Close Pop up");
		}

		try {
			if (IntConsName.length() > 0) {
				clickElement(driver, test, OCR_CountryofIntConsLink, "Click on Intermediate Consignee Link : ");
				typeText(driver, test, OCR_CountryofUltConsLinkEnter, "Enter Intermediate COnsignee Code : ",
						IntConsName);
				clickElement(driver, test, OCR_CountryofUltConsLinkSearchBtn, "CLick on Search button :");
				clickElement(driver, test, "//td[contains(text(),'" + IntConsName + "')]", IntConsName);
				clickElement(driver, test, OCR_CountryofUltConsLinkSelectBtn, "Click on Select button :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CountryofUltConsLinkCloseBtn, "Click on Close Pop up");
		}

		try {
			if (FwdAgentName.length() > 0) {
				clickElement(driver, test, OCR_CountryofForwardAgentLink, "Click on Forward Agent name Link : ");
				typeText(driver, test, OCR_CountryofForwardAgentLinkEnter, "Enter Forward Agent name Code : ",
						FwdAgentName);
				clickElement(driver, test, OCR_CountryofForwardAgentLinkSearch, "CLick on Search button :");
				clickElement(driver, test, "//td[contains(text(),'" + FwdAgentName + "')]", FwdAgentName);
				clickElement(driver, test, OCR_CountryofForwardAgentLinkSelectbtn, "Click on Select button :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CountryofUltConsLinkCloseBtn, "Click on Close Pop up");
		}
		if(Region.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultShipmentSummaryBySiteReport_selectRegion']", Region);
		selectByVisibleText(driver, test, "//select[@id='resultShipmentSummaryBySiteReport_selectRegion']", "Select Region", Region);
		}
		if(Site.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultShipmentSummaryBySiteReport_selectSite']", Site);
		selectByVisibleText(driver, test, "//select[@id='resultShipmentSummaryBySiteReport_selectSite']", "Select site : ", Site);
		}
		if(CountryofUltDest.length() > 0) {
		typeText(driver, test, OCR_MISReport_ShipmentSummaryBySiteReport_CountryUltDest, "Select Ult Dest Country", CountryofUltDest);
		}
		if (CreatedFrom.length() > 0) {
			clickElement(driver, test, OCR_CreatedFromDate, "Clicking on Created On From Date :");
			try {
				if (CreatedFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", CreatedFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (CreatedTo.length() > 0) {
			clickElement(driver, test, OCR_CreatedToDate, "Clicking on Created On From Date :");
			try {
				if (CreatedTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", CreatedTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportFrom.length() > 0) {
			clickElement(driver, test, OCR_ExportFromDate, "Clicking on Created On From Date :");
			try {
				if (ExportFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", ExportFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportTo.length() > 0) {
			clickElement(driver, test, OCR_ExportToDate, "Clicking on Created On To Date :");
			try {
				if (ExportTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", ExportTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

	}

	
	
}
