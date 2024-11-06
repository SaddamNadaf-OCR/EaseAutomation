package consignees;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomepageConsignee extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_WathchlistScreening="(//a[contains(text(),'Watch List Screening')])[2]";
	public static final String OCR_HomePage_Files = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePage_Consignee="(//a[contains(text(),'Consignees')])[1]";
	public static final String OCR_AddConsignee = "//button[contains(text(),'Add Consignee')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomepageConsigneeSummaryReport="//a[contains (text(),'Consignee Summary Report')]";
	public static final String OCR_Homepage_Logout="//i[@class='fa fa-sign-out']";
	public static final String OCRHomepage_alertGotIt="(//button[@id='enhanced-search-info-gotit'])[1]";
public static final String OCRHomePage_FreightForwarders="(//a[contains(text(),'Freight Forwarders')])[4]";

	/* ******************** Constructor ***************************** */


	public HomepageConsignee(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
//handle alert
	
	//public void alertHandle() {
		/*scrollToBottom(driver);
		clickElement(driver, test, OCRHomepage_alertGotIt, "click on got it");
		scrollToBottom(driver);*/
		
	
	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "move to SBU selection");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_WathchlistScreening, "Click on watchlist screening  Module");
	}


	// Click on Files
	public void movetoFiles() {
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Consignee, "mousehover on consignee");
		clickElement(driver, test, OCR_HomePage_Consignee, "Click on consignee");
	}
		public void ClickOnAddConsingee() {
			clickElement(driver, test, OCR_AddConsignee, "Click on add Consignee");
		}
	
	public void returnToSearchConsigneePage() {
		mouseOver(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Consignee, "Click on consignee");
	}
	// Click on Files freight forwarders
			public void movetoFilesfreightforwarders() {
				mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
				Wait.waitfor(3);
				mouseOver(driver, test, OCRHomePage_FreightForwarders, "mousehover on freight forwarders");
				clickElement(driver, test, OCRHomePage_FreightForwarders, "Click onfreight forwarders");
			
			}
	
	
	public void logout() {
		clickElement(driver, test, OCR_Homepage_Logout, "click on logout");
		
	}
		
		public void scrollto() {
			scrollToTop(driver);
		}
		
		
		
		
		
		
		
		
		
		
	

	
}
