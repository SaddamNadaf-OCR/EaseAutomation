package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAirwayBillNumberTemplatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[@name='Search']";
	public static final String OCR_Add  = "//button[@name='Add']";
	public static final String OCR_Reset = "//button[@name='reset']";
	public static final String OCR_SBUCode = "//select[@id='searchAwbUniqueId_awbUniqueId_sbuCode']";
	public static final String OCR_BillType = "//select[@id='searchAwbUniqueId_awbUniqueId_billType']";
	public static final String OCR_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_FFCode = "//a[contains(text(),'Freight Forwarder Code')]";
	public static final String OCR_DestinationCode = "//a[contains(text(),'Destination Code')]";
	
	
	
	
	
/* ******************************* Constructor ****************************** */

	public SearchAirwayBillNumberTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */
	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SEARCH, "Click on Search button  :");
	}
	
	public void searchByParameter(String SbuCode, String BillType, String CarrierCode, String FFCode, String DestCode, String CreatedBy) {
		Wait.waitfor(2);
		if(SbuCode.length() > 0) {
		selectByVisibleText(driver, test, OCR_SBUCode, "Select SBU code : ", SbuCode);
		}
		if(BillType.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_BillType, "Select Bill Type : ", BillType);
		}
		if(CarrierCode.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CarrierCode, "CLick on Carrier Code link : ");
			typeText(driver, test, "//input[@id='searchForm_carrier_carrierCode']", "Enter Carrier Code : ", CarrierCode);
			clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search Carrier Code : ");
			clickElement(driver, test, "//td[contains(text(),'"+ CarrierCode +"')]",  CarrierCode);
			clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select carrier code : ");
		}
		if(FFCode.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_FFCode, "CLick on FF Code link : ");
			typeText(driver, test, "//input[@id='searchForm_freightForwarder_ffCode']", "Enter FF Code : ", FFCode);
			clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search FF Code : ");
			clickElement(driver, test, "//td[contains(text(),'"+ FFCode +"')]",  FFCode);
			clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select FF code : ");
		}
		if(DestCode.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_DestinationCode, "CLick on Destination Code link : ");
			typeText(driver, test, "//input[@id='searchForm_airport_destinationCode']", "Enter Destination Code : ", DestCode);
			clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search Destination Code : ");
			clickElement(driver, test, "//td[contains(text(),'"+ DestCode +"')]",  DestCode);
			clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select Destination code : ");
		}
		if(CreatedBy.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, "//select[@id='searchAwbUniqueId_awbUniqueId_createdBy']", "Select Created By : ", CreatedBy);
		}
	}
	
	public void addTemplateBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Add, "Click on Add template button : ");
	}
	
	public void resetBtn()
	{
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Reset, "Click on Reset Button : ");
	}
	
	
}
