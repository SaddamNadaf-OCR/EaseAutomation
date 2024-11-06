package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqImportIntoAgreementPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']"; 
	public static final String OCR_LicenseType= "//select[@id='licenseTypeId']";
	public static final String OCR_Button_UseRequestId="//button[contains(text(),'Use Request Id')]";
	public static final String OCR_Button_ImportAll="//button[contains(text(),'Import All')]";
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";
	
	public  AgreementReqImportIntoAgreementPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	//Select License Type
	public void select_licensetype(String LicenseType) {
		selectByVisibleText(driver, test, OCR_LicenseType,"Selecting License Type: ", LicenseType);		
	}
	//Click on Use Request Id Button
	public void userequestid() {
	clickElement(driver, test, OCR_Button_UseRequestId,"Clicking on Use Request Id Button: ");		
	}
	//Click on Import All Button
	public void importall() {
		clickElement(driver, test, OCR_Button_ImportAll, "Clicking on Import All Button: ");
		driver.switchTo().alert().accept();
		Wait.waitfor(3);
	}
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");
	}
	
	//Getting value of License Transaction Id
	public String get_licensetransactionid() {
		WebElement value = driver.findElement(By.xpath("//input[@id='editImportAgg_exportRequestValue_licenseTransactionId']"));
		String licenseid = value.getAttribute("value");
		return licenseid;		
	}
}
