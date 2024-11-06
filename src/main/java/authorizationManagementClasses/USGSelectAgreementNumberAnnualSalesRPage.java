package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class USGSelectAgreementNumberAnnualSalesRPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGAN_Agreement="//a[contains(text(),'Agreement No.')]";
	public static final String USGAN_Search="//button[@id='searchAgreementNoPopUp']";
	public static final String USGAN_AgreementNo="//input[@id='searchForm_dosGeneralInfoDTO_licenseNo']";
	public static final String USGAN_Select="//button[contains(text(),'Select')]";
	public static final String USGAN_ClosePopUp="(//button[@class='btn-close'])[1]";
	public static final String USGAN_CreateReport="//button[contains(text(),'Create Report')]";
	public static final String USGAN_Cancel="//button[contains(text(),'Cancel')]";
	public static final String USGAN_MLARadioButton="//input[@id='createNewMlaSalesReport_mlaSalesReportValue_reportTypeM']";
	public static final String USGAN_TAARadioButton="//input[@id='createNewMlaSalesReport_mlaSalesReportValue_reportTypeT']";
	public static final String USGAN_WDARadioButton="//input[@id='createNewMlaSalesReport_mlaSalesReportValue_reportTypeW']";
	
	//.................................Constructor.....................................//
	public USGSelectAgreementNumberAnnualSalesRPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//........................Agreement Number BY MLA POPUP..................................//
	public void agreementNumberMLA(String agreementNo) {
		clickElement(driver, test, USGAN_MLARadioButton, "Clicking on MLA Radio Button");
		Wait.waitfor(2);
		clickElement(driver, test, USGAN_Agreement, "Clicking on Agreement Number");
		try {
			typeText(driver, test, USGAN_AgreementNo, "Clicking on Agreement Number", agreementNo);
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Search, "Clicking on Search Button");
			Wait.waitfor(2);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Click on Agreement Number");
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Select, "Clicking on Select Button");
		} catch (Exception e) {
			clickElement(driver, test, USGAN_ClosePopUp, "Clicking on Close PopUp");
		}clickElement(driver, test, USGAN_CreateReport, "Clicking on Create Report");
	}
	
	//........................Agreement Number BY TAA POPUP..................................//
	public void agreementNumberTAA(String agreementNo) {
		clickElement(driver, test, USGAN_TAARadioButton, "Clicking on MLA Radio Button");
		Wait.waitfor(2);
		clickElement(driver, test, USGAN_Agreement, "Clicking on Agreement Number");
		try {
			typeText(driver, test, USGAN_AgreementNo, "Clicking on Agreement Number", agreementNo);
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Search, "Clicking on Search Button");
			Wait.waitfor(6);
			//mouseOverAndClick(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Click on Agreement Number");
			clickElement(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Click on Agreement Number"+agreementNo);
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Select, "Clicking on Select Button");
		} catch (Exception e) {
			clickElement(driver, test, USGAN_ClosePopUp, "Clicking on Close PopUp");
		}clickElement(driver, test, USGAN_CreateReport, "Clicking on Create Report");
	}
	
	//........................Agreement Number BY WDA POPUP..................................//
	public void agreementNumberWDA(String agreementNo) {
		clickElement(driver, test, USGAN_WDARadioButton, "Clicking on MLA Radio Button");
		Wait.waitfor(2);
		clickElement(driver, test, USGAN_Agreement, "Clicking on Agreement Number");
		try {
			typeText(driver, test, USGAN_AgreementNo, "Clicking on Agreement Number", agreementNo);
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Search, "Clicking on Search Button");
			Wait.waitfor(2);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Click on Agreement Number");
			Wait.waitfor(2);
			clickElement(driver, test, USGAN_Select, "Clicking on Select Button");
		} catch (Exception e) {
			clickElement(driver, test, USGAN_ClosePopUp, "Clicking on Close PopUp");
		}clickElement(driver, test, USGAN_CreateReport, "Clicking on Create Report");
	}

}
