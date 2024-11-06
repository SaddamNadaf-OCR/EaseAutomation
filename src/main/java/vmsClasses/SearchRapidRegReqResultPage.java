package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchRapidRegReqResultPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SRapidRegReq_Title = "//h3[@class='page-heading']";
	public static final String OCR_SearchRapid_RequestId = "//table[@id='grid']/tbody/tr[2]/td[2]/a"; 

	/* ******************** Constructor ***************************** */

	public SearchRapidRegReqResultPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Get title of the page
	public String getSRapidRRRTitle() {
		return getText(driver, test, OCR_SRapidRegReq_Title, "Title of the Page : ");
	}

	//Clicking on Request id Search Rapid page
	public void click_SearchRapidRequestId() throws InterruptedException {
		Wait.waitfor(5);
		Wait.fluwait(driver, OCR_SearchRapid_RequestId);
		clickElement(driver, test, OCR_SearchRapid_RequestId,"Clicking on Request id Search Rapid result page");
	}

}
