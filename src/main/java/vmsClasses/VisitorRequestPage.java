package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class VisitorRequestPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_VR_Title = "//h3[@class='page-heading']";
	public static final String OCR_VR_Copy ="(//tr[@id='1']/following::i[@class='fa fa-copy'])[1]";
	
	/* ******************** Constructor ***************************** */

	public VisitorRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Get the title of the page
	public String getVRTitle() {
		return getText(driver, test, OCR_VR_Title, "Title of the Page : ");
	}
	
	//click on Copy request
	public void copyrequest() {
		clickElement(driver, test, OCR_VR_Copy,"Clicking on Copy icon");
	}
	
	//click on Visitor ID
	public void click_visitorID(String VisitorID) {
		clickElement(driver, test, "//a[contains(text(),'"+VisitorID+"')]", "Click on Visitor ID : "+VisitorID);
	}
}
