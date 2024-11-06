package dpssClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_ReturnPage = "//ul[@class='dropdown-menu']//a[contains(text(),'Learning Center')]";
	public static final String OCR_HomePage_WatchListScreening = "//ul[@class='dropdown-menu']//a[contains(text(),'Watch List Screening')]";
	public static final String OCR_HomePage_Features = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_HomePage_Reports = "//ul[@class='nav navbar-nav]/li[4]/a";
	public static final String OCR_HomePage_Files = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_HomePage_Tables = "//ul[@class='nav navbar-nav]/li[6]/a";
	public static final String OCR_HomePage_Tools = "//i[@class='fa fa-wrench']";
	public static final String OCR_HomePage_AdhocScreening = "//a[text()='Ad hoc Screening']";
	public static final String OCR_HomePage_UploadFile = "//a[text()='Upload File(s)']";
	public static final String OCR_HomePage_WLSDefaults = "//a[text()='Watch List Screening Defaults']";
	public static final String OCR_HomePage_Consignee = "//a[text()='Consignees']";
	public static final String OCR_HomePage_SBUConfig = "//a[text()='SBU Configuration']";
	public static final String OCR_HomePage_XML = "//body//dplhitsdetail//eachgivenname//code";
	public static final String OCR_HomePage_HostedServiceResults = "//div[contains(text(),'Hosted Service Results')]";
	public static final String OCR_HomePage_HitDigit = "//body[text()='4	 ']";
	public static final String OCR_HomePage_HitCharacter = "//body[text()='4 results found	 ']";

	/* ******************** Constructor ***************************** */

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to Watch list screening
	public void moveTo_ListScreening() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
	}

	// Return to Authorization Management page
	public void returnPage() {
		moveTo_ListScreening();
		Wait.fluwait(driver, OCR_HomePage_WatchListScreening);
		clickElement(driver, test, OCR_HomePage_WatchListScreening, "click on Watch List Screening");
	}

	// Click on Foreign Trade Zone
	public void click_WatchListScreening() throws InterruptedException {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_HomePage_WatchListScreening);
		clickElement(driver, test, OCR_HomePage_WatchListScreening, "Clicking on Watch List Screening");
	}

	// Move to features
	public void moveTo_Features() throws InterruptedException {
		mouseOver(driver, test, OCR_HomePage_Features, "Mouse over on Features");
	}

	// Move to Files
	public void moveTo_Files() throws InterruptedException {
		mouseOver(driver, test, OCR_HomePage_Files, "Mouse over on Files");
	}

	// Move to Tables
	public void moveTo_Tables() throws InterruptedException {
		mouseOver(driver, test, OCR_HomePage_Tables, "Mouse over on Tables");
	}

	// Move to Tools
	public void moveTo_Tools() throws InterruptedException {
		mouseOver(driver, test, OCR_HomePage_Tools, "Mouse over on Tools");
	}

	// Clicking on AdhocScreening
	public void click_AdhocScreening() throws InterruptedException {
		Wait.waitfor(1);
		clickElement(driver, test, OCR_HomePage_AdhocScreening, "Clicking on Adhoc Screening");
		Wait.waitfor(2);
	}

	// Clicking on Upload File(s)
	public void click_UploadFiles() throws InterruptedException {
		Wait.waitfor(1);
		clickElement(driver, test, OCR_HomePage_UploadFile, "Clicking on Upload File(s)");
		Wait.waitfor(2);
	}

	// Clicking on WLSDefaults
	public void click_WLSDefaults() throws InterruptedException {
		Wait.waitfor(1);
		clickElement(driver, test, OCR_HomePage_WLSDefaults, "Clicking on WLSDefaults");
		Wait.waitfor(2);
	}

	// Clicking on Consignee
	public void click_Consignee() throws InterruptedException {
		clickElement(driver, test, OCR_HomePage_Consignee, "Clicking on Consignee");
		Wait.waitfor(2);
	}

	// Clicking on SBU Configurations
	public void click_SBUConfig() throws InterruptedException {
		clickElement(driver, test, OCR_HomePage_SBUConfig, "Clicking on SBU Configurations");
		Wait.waitfor(2);
	}

	// Loading webquery
	public void load_webquery(String WebQuery) throws InterruptedException {
		driver.get(WebQuery);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "WebQuery Uploaded");
		driver.get("http://easerelease.ocr-inc.com");
	}

	// Loading EASE
	public void load_EASE() throws InterruptedException {
		driver.get("http://easerelease.ocr-inc.com");
		Wait.waitfor(2);
		test.log(LogStatus.PASS, "EASE Launched");
	}

	// Verify XML Page
	public void verify_XMLPage() throws InterruptedException {
		if (isDisplayed(driver, OCR_HomePage_XML)) {
			test.log(LogStatus.PASS, "XML Page Found");
		}
	}

	// Verify HTML Page
	public void verify_HTMLPage() throws InterruptedException {
		if (isDisplayed(driver, OCR_HomePage_HostedServiceResults)) {
			test.log(LogStatus.PASS, "HTML Page Found");
		}
	}

	// Verify hits in digit
	public void verify_HitDigit() throws InterruptedException {
		if (isDisplayed(driver, OCR_HomePage_HitDigit)) {
			test.log(LogStatus.PASS, "HitDigit Found");
		}
	}

	// Verify hits in character
	public void verify_HitCharacter() throws InterruptedException {
		if (isDisplayed(driver, OCR_HomePage_HitCharacter)) {
			test.log(LogStatus.PASS, "HitCharacter Found");
		}
	}

}