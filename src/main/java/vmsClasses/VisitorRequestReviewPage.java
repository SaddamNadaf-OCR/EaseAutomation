package vmsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class VisitorRequestReviewPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorReq_ReviewRequest = "(//button[contains(text(),'Review Request')])[1]";
	public static final String OCR_VisitorReq_Cancle = "(//button[contains(text(),'Cancel')])[1]";

	/* ******************** Constructor ***************************** */

	public VisitorRequestReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on  Reviewer Request
	public void clickReviewerRequest(){
		Wait.waitfor(2);
		clickElement(driver, test, OCR_VisitorReq_ReviewRequest, "Click on Reviewer Request");
	}	

	//Click on Cancle button
	public void click_Cancle() {
		clickElement(driver, test, OCR_VisitorReq_Cancle, "Click on Cancle button");
	}
	
	
}
