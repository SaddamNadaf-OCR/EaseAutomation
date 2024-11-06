package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ENCExceptionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_selectsbu = "//select[@id='searchEncEncryption_selectSbu']";
	public static final String OCR_workstatus="//select[@id='selectShipmentWorkStatus']";
	public static final String OCR_exportercode="//input[@id='searchEncEncryption_shipment_exporterCode']";
	public static final String OCR_shipmentno="//input[@id='searchEncEncryption_shipment_shipmentNo']";
	public static final String OCR_productfamily="//textarea[@id='searchEncEncryption_shipment_productFamilyName']";
	public static final String OCR_program="//textarea[@id='searchEncEncryption_shipment_programDesc']";
	public static final String OCR_ultimateconsignee="//input[@id='searchEncEncryption_shipment_ultConsName']";
	public static final String OCR_cntryofultDestntn="//select[@id='searchEncEncryption_selectCountryOfUltDest']";
	public static final String OCR_region="//select[@id='searchEncEncryption_selectRegion']";
	public static final String OCR_site="//select[@id='searchEncEncryption_selectSite']";
	public static final String OCR_partno="//input[@id='searchEncEncryption_partNo']";
	public static final String OCR_ITARExemptionReportPage_Searchbtn="//button[@name='Search']";
	public static final String 	OCR_ENCReportPageValidateHeading="//h3[contains(text(),'ENC EXCEPTION REPORT')]";
	
			
			
			

			/* ******************************* Constructor ****************************** */

			public ENCExceptionPage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
			}

			/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_selectsbu, "Deselecting All SBUs");
		selectByVisibleText(driver, test, OCR_selectsbu, "Select SBu Code : ", sbu);
		
		
	}
	public void selectWorkstatus(String workstatus) {
		if(workstatus.length() > 0) {
			Wait.waitfor(2);
			deSelectAll(driver, test, OCR_workstatus, "Deselecting workstatus");
			selectByVisibleText(driver, test, OCR_workstatus, "Select workstatus : ", workstatus);
		}
	}
	public void selectUltDestination(String UltDestination) {
		if(UltDestination.length() > 0) {
			Wait.waitfor(2);
			deSelectAll(driver, test, OCR_cntryofultDestntn, "Deselecting All ultimate destination");
			selectByVisibleText(driver, test, OCR_cntryofultDestntn, "Select ultimate destination : ", UltDestination);
		}
	}
		
	public void selectSite(String Site) {
		if(Site.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_site, "Select site : ", Site);
		}
	}
	public void selectregion(String Region) {
		if(Region.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_region, "Select Region : ", Region);
		}
	}
	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ITARExemptionReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_ENCReportPageValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "ENC EXCEPTION REPORT page is Displayed");
		Wait.waitfor(3);

	}
}
		
		
		
		
		
		
		
		
		
		
		