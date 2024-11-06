package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class IncotermReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_IncotermReportPage_SBUCode = "//select[@id='shipment.sbuCode']";
	public static final String OCR_IncotermReportPage_ShipToOrg = "//a[contains(text(),'Ship To Organization')]";
	public static final String OCR_IncotermReportPage_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_IncotermReportPage_SelectPopUp = "(//button[@name='Ok'])[1]";
	public static final String OCR_IncotermReportPage_ClosePopUp ="(//button[@class='btn-close'])[1]";
	public static final String OCR_IncotermReportPage_ShipToOrgText = "//input[@id='searchIncotermReport_shipToName']";
	public static final String OCR_IncotermReportPage_SoldToOrg = "//a[contains(text(),'Sold To Organization')]";
	public static final String OCR_IncotermReportPage_SoldToOrgText = "//input[@id='searchIncotermReport_soldToName']";
	public static final String OCR_IncotermReportPage_IncotermsLink = "(//a[contains(text(),'Incoterms')])[2]";
	public static final String OCR_IncotermReportPage_IncotermsText= "//input[@id='searchIncotermReport_incoTerms']";
	public static final String OCR_IncotermReportPage_SearchBtn= "//button[@id='submit']";
	public static final String OCR_IncotermReportPage_ValidateHeading = "//h3[contains(text(),'Incoterm Report')]";

	/* ******************************* Constructor ****************************** */

	public IncotermReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_IncotermReportPage_SBUCode, "Select SBU : ", SbuCode);

	}

	public void ShipToOrg(String ShipToOrgLink, String ShipToOrg) {
		Wait.waitfor(2);
		if(ShipToOrgLink.length() > 0) {
			try {
				clickElement(driver, test, OCR_IncotermReportPage_ShipToOrg, "Click on Ship To Organization Link ");
				typeText(driver, test, "//input[@id='searchForm_consignee_consigneeId']", "Enter Consignee Code : ", ShipToOrgLink);
				clickElement(driver, test, OCR_IncotermReportPage_SearchPopUp, "Click on Search Button Pop Up");
				clickElement(driver, test, "//td[contains(text(),'"+ ShipToOrgLink +"')]", "Select Consignee ID/Code : " +ShipToOrgLink);
				clickElement(driver, test, OCR_IncotermReportPage_SelectPopUp, "Click on Select pop Up Button");
			}
			catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_IncotermReportPage_ClosePopUp, "Click on Close popup icon");
			}
		  }else {
			  typeText(driver, test, OCR_IncotermReportPage_ShipToOrgText, "Enter Ship To Organization Name : ", ShipToOrg);
		  }
			
			}
	
	
	public void SoldToOrg(String SoldToOrgLink, String SoldToOrg) {
		Wait.waitfor(2);
		if(SoldToOrgLink.length() > 0) {
			try {
				clickElement(driver, test, OCR_IncotermReportPage_SoldToOrg, "Click on Sold To Organization Link ");
				clickElement(driver, test, OCR_IncotermReportPage_SearchPopUp, "Click on Search Button Pop Up");
				clickElement(driver, test, "//td[contains(text(),'"+ SoldToOrgLink +"')]", "Select Consignee ID/Code : " +SoldToOrgLink);
				clickElement(driver, test, OCR_IncotermReportPage_SelectPopUp, "Click on Select pop Up Button");
			}
			catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_IncotermReportPage_ClosePopUp, "Click on Close popup icon");
			}
		  }else {
			  typeText(driver, test, OCR_IncotermReportPage_SoldToOrgText, "Enter Sold To Organization Name : ", SoldToOrg);
		  }
			
			}
	
			public void Incoterm(String IncotermsLink, String Incoterms) {
				Wait.waitfor(2);
				if(IncotermsLink.length() > 0) {
					try {
						clickElement(driver, test, OCR_IncotermReportPage_IncotermsLink, "Click on Incoterms Link ");
						clickElement(driver, test, "//td[contains(text(),'"+ IncotermsLink +"')]", "Select Incoterms code : " +IncotermsLink);
						clickElement(driver, test, OCR_IncotermReportPage_SelectPopUp, "Click on Select pop Up Button");
					}
					catch (Exception e) {
						testFailSshot(driver, test);
						clickElement(driver, test, OCR_IncotermReportPage_ClosePopUp, "Click on Close popup icon");
					}
				  }else {
					  typeText(driver, test, OCR_IncotermReportPage_IncotermsText, "Enter Incoterms : ", Incoterms);
				  }
					
					}
			
			public void SearchBtn() {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_IncotermReportPage_SearchBtn, "Click on Search button");
			}
				
			public void validateHeading() {
				Wait.waitfor(2);
				isDisplayed(driver, OCR_IncotermReportPage_ValidateHeading);
				Wait.waitfor(3);
				test.log(LogStatus.PASS, "Incoterm Report Page is Displayed");
				
			}
				}
			
		
	
	


