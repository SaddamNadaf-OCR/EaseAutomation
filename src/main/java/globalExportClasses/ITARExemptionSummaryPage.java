package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ITARExemptionSummaryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ITARSummarySBUCode ="//select[@id='resultItarExemptionSummaryReport_selectSbu']";
	public static final String OCR_ITARSummaryshipWorkStatus="//select[@id='selectShipmentWorkStatus']";
	public static final String OCR_ITARSummaryExemption="//input[@id='resultItarExemptionSummaryReport_itarExemptionNo']";
	public static final String OCR_ITARSummaryExempDescription="//input[@id='resultItarExemptionSummaryReport_itarExemptionName']";
	public static final String OCR_ITARSummaryDtofExFrom="//input[@id='resultItarExemptionSummaryReport_fromDateOfExport']";
	public static final String OCR_ITARSummaryDtOfExpTO="//input[@id='resultItarExemptionSummaryReport_toDateOfExport']";
	public static final String OCR_ITARSummaryExpCode="resultItarExemptionSummaryReport_shipment_exporterCode";
	public static final String OCR_ITARSummaryExpName="//input[@id='resultItarExemptionSummaryReport_shipment_exporterContactName']";
	public static final String OCR_ITARSummaryShiNo="//input[@id='resultItarExemptionSummaryReport_shipment_shipmentNo']";
	public static final String OCR_ITARSummarysalesorderno="//input[@id='resultItarExemptionSummaryReport_orderNo']";
	public static final String OCR_ITARSummaryusmlCategry="//input[@id='resultItarExemptionSummaryReport_usmlCategoryCode']";
	public static final String OCR_ITARSummarycntryofUltDestntn="//select[@id='resultItarExemptionSummaryReport_selectCountryOfUltDest']";
	public static final String OCR_ITARSummarytransctionType="//select[@id='resultItarExemptionSummaryReport_transactionType']";
	public static final String OCR_ITARSummaryvaliateheading="//h3[contains (text(),'EXPORTS UNDER ITAR EXEMPTIONS - SUMMARY')]";
	public static final String OCR_ITARSummarysrchbutton="//button[contains(text(),'Search')]";
	
			/* ******************************* Constructor ****************************** */

	public ITARExemptionSummaryPage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
			}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARSummarySBUCode, "Deselecting All SBUs");
		selectByVisibleText(driver, test, OCR_ITARSummarySBUCode, "Select SBu Code : ", sbu);

	}

	public void selectWorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARSummaryshipWorkStatus, "Deselecting All Statuses");
		selectByVisibleText(driver, test, OCR_ITARSummaryshipWorkStatus, "Select Work Status : ",
				WorkStatus);
	}

	public void selectContryOfUltDestination(String ContryOfUltDestination) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARSummarycntryofUltDestntn, "De selectcountry of ultimate destination");
		selectByVisibleText(driver, test, OCR_ITARSummarycntryofUltDestntn,
				"Select Canadian Exemption : ", ContryOfUltDestination);
	}

	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ITARSummarysrchbutton, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_ITARSummaryvaliateheading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "EXPORTS UNDER ITAR EXEMPTIONS - SUMMARY page is Displayed");
		Wait.waitfor(3);

	}
	public void otherfields(String Description, String ShipmentNo, String SalesOrderNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_ITARSummaryExempDescription, "Enter Exemption description ", Description);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ITARSummaryShiNo, "Enter shipment no ", ShipmentNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ITARSummarysalesorderno, "Enter sales order no. ", SalesOrderNo);
	}
}
