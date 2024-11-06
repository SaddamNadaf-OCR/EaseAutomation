package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ReportMisShipmentSummaryByRegionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "//button[contains(text(),'Search')]";
	public static final String OCR_RESET = "//button[@type='reset']";
	public static final String OCR_SBUCODE = "//select[@name='selectSbu']";
	public static final String OCR_Region = "//select[@name='selectRegion']";
	public static final String OCR_CountryofUltDest = "//input[@name='shipment.countryOfUltDest']";
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
	public static final String OCR_CreatedFromDate = "//input[@id='resultShipmentSummaryByRegionReport_fromCreatedDate']";
	public static final String OCR_DateToday = "//button[contains(text(),'Today')]";
	public static final String OCR_CreatedToDate = "//input[@id='resultShipmentSummaryByRegionReport_toCreatedDate']";
	public static final String OCR_ExportFromDate = "//input[@id='resultShipmentSummaryByRegionReport_fromDateOfExport']";
	public static final String OCR_ExportToDate = "//input[@id='resultShipmentSummaryByRegionReport_toDateOfExport']";

	// * ******************************* Constructor ******************************
	// *//

	public ReportMisShipmentSummaryByRegionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Search by parameter
	public void parameter(String Sbu, String Region, String CountryofUltDest) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu Code", Sbu);
		selectByVisibleText(driver, test, OCR_Region, "Select Region", Region);
		typeText(driver, test, OCR_CountryofUltDest, "Select Ult Dest Country", CountryofUltDest);
		scrollToElement(driver, OCR_SEARCH);
	}

	public void searchByParameters(String SbuCode, String country, String UltConsName, String IntConsName,
			String FwdAgentName, String Region, String Site, String CountryofUltDest, String CreatedFrom,
			String CreatedTo, String ExportFrom, String ExportTo) {
		Wait.waitfor(2);
		if(SbuCode.length() > 0) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu Code", SbuCode);
		}
		if(country.length() > 0) {
			selectByVisibleText(driver, test, "//option[contains(text(),'" + country + "')]", "Select Country : ", country);
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
		selectByVisibleText(driver, test, "//option[contains(text(),'"+ Region +"')]", "Select Region", Region);
		}
		if(Site.length() > 0) {
		//	clickElement(driver, test, "//select[@id='resultShipmentSummaryByRegionReport_selectSite']", "Select all site :");
			deSelectAll(driver, test, "//select[@id='resultShipmentSummaryByRegionReport_selectSite']", Site);
			selectByVisibleText(driver, test, "//select[@id='resultShipmentSummaryByRegionReport_selectSite']", "Select Site : ", Site);
		//	selectByVisibleText(driver, test, "//select[@id='resultShipmentSummaryByRegionReport_selectSite']", Site);
		}
		if(CountryofUltDest.length() > 0) {
		typeText(driver, test, OCR_CountryofUltDest, "Select Ult Dest Country", CountryofUltDest);
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
