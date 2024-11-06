
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ShipWizardScreeningStatusPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ScreeningStatus_Toggle = "//a[@class='accordion-toggle']";

	/* ******************************* Constructor ****************************** */

	public ShipWizardScreeningStatusPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Toggle
	public void click_Toggle() {
		clickElement(driver, test, OCR_ScreeningStatus_Toggle, "Click on Expand Toggle");
	}

	// Getting the ship validation text
	public String getshipvalidate() {
		String shipValidate = "//table[@class='table table-condensed table-bordered']//tr/td/b[contains(text(),'Ship to Details are required.')]/../../td[2]";
		return getText(driver, test, shipValidate, "Get the ship to details Status : ");
	}

	// validating Part Number Screening status
	public String getPartNumberStatus() {
		String partNo = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Missing or Incomplete Part Number details.')]/../../td[2]";
		return getText(driver, test, partNo, "Get the Part Number Status : ");
	}

	// Validating Incomplete HTS/ScheduleB Number details
	public String getHTSNumber() {
		String hts = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Missing or Incomplete HTS')]/../../td[2]";
		return getText(driver, test, hts, "Get the Incomplete HTS/ScheduleB Number details : ");
	}

	// validating the Primary Unit is missing on Screening Status screen
	public String getPrimaryUnits() {
		String primaryUnits = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Primary Unit is missing.')]/../../td[2]";
		return getText(driver, test, primaryUnits, "Get the Primary Unit on Screening Status : ");
	}

	// validating USML/ECCN is missing on Screening Status screen
	public String getECCN() {
		String ECCN = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'USML')]/../../td[2]";
		return getText(driver, test, ECCN, "Get the USML/ECCN on Screening Status : ");
	}

	// validating US ECCN is missing on Screening Status screen
	public String getUSECCN() {
		String ECCN = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'US ECCN is missing.')]/../../td[2]";
		return getText(driver, test, ECCN, "Get the US ECCN on Screening Status : ");
	}

}
