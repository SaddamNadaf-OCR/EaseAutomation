package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CompanyDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CD_Company = "//a[contains(text(),'Company')]";
	public static final String OCR_CD_EStatus = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_CD_ESearch = "//button[@name='Search']";
	public static final String OCR_CD_EExporterSelect = "//button[contains(text(),'Select')]";
	public static final String OCR_CD_Save = "//input[@id='validateCertificationForm']";
	public static final String OCR_CD_CountriesIcon = "//i[@class='fa fa-globe']";

	/* ******************************* Constructor ****************************** */

	public CompanyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void add_Company(String Status, String ExporterCode) {
		clickElement(driver, test, OCR_CD_Company, "Click on Company :");
		try {
			selectByVisibleText(driver, test, OCR_CD_EStatus, "Select Status as : ", Status);
			typeText(driver, test, "//input[@name='exporter.expCode']", "Entering Exporter Code :", ExporterCode);
			clickElement(driver, test, OCR_CD_ESearch, "Click on search button :");
			String Ecode = "//td[contains(text(),'" + ExporterCode + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, Ecode, "Select Exporter : " + ExporterCode);
			clickElement(driver, test, OCR_CD_EExporterSelect, "Click on Select Button :");
			typeText(driver, test, "//input[@id='editCompanyDetails_authorisationAddressValue_licAddrGovtValue1']", "",
					"676784");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CD_EExporterSelect, "Click on Select Button :");
		}
	}

	public void click_Save() {
		clickElement(driver, test, OCR_CD_Save, "click on Save in Company Details :");
	}
	
	public void click_Countries() {
		clickElement(driver, test, OCR_CD_CountriesIcon, "Click on Countries ICON :");
	}

}
