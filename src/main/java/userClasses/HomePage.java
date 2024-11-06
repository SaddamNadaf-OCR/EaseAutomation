package userClasses;
/* 
 * Module : User
 * Author  : Afsha Hamid
 * created date : April 2024
 * Descriptions : Create View/User 
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBUSelection = "//ul[@class='nav navbar-nav']/li[1]/a";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_LogOut = "//i[@class='fa fa-sign-out']";
	public static final String OCR_HomePage_Tools = "//li[@title='Tools']";
	public static final String OCR_HomePage_CommodityClassification = "(//a[contains(text(),'Commodity Classification')])[1]";
	public static final String OCR_HomePage_CommodityClassification_features="(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_CommodityClassification_SearchCommodityRequest="//b[contains(text(),'Search Commodity Classification Request')]";
	public static final String OCR_HomePage_CommodityClassification_CommodityClassificationRequest="(//a[contains(text(), 'Commodity Classification Request')])[1]";
	public static final String OCR_HomePage_CommodityClassification_AuthorizationFail="//b[contains(text(),'Authorization Failed')]";
	
	public static final String OCR_HomePage_helpbutton ="//i[@class=\"fa fa-question-circle\"]";
	public static final String OCR_HomePage_WhoAmI="//a[contains(text(),'Who Am I?')]";
	public static final String OCR_HomePage_USERID="(//table[@class='table table-condensed table-bordered table-striped']/tbody/tr/td)[1]";
	public static final String OCR_HomePage_USERFirstname="(//table[@class='table table-condensed table-bordered table-striped']/tbody/tr/td)[5]";
	public static final String OCR_HomePage_USERLastname="(//table[@class='table table-condensed table-bordered table-striped']/tbody/tr/td)[4]";
	public static final String OCR_HomePage_USERLWhoIamCLoseButton="//button[@class='btn-close']";
	
	
	
	/* ******************** Constructor ***************************** */

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBUSelection, "Mouse over on SBU Selections");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(4);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Module Selection");
		Wait.waitfor(2);
	}

	// Click on Cancle button on popup
	public void click_CancelIcon() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_USERLWhoIamCLoseButton, "Clicking on cancel button");
	}
	
	// Click on Tools
		public void click_Tools() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_HomePage_Tools, "Clicking on Tools");
		}
		

	// Return to visitor management page
	public void returnPage() {
		
		scrollToElement(driver, OCR_HomePage_ListScreening);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_HomePage_CommodityClassification, "click on Commodity Classification");
	}

	// Click on LOG Out Icon
	public void clickLogOut() {
		clickElement(driver, test, OCR_HomePage_LogOut, "Click on Log Out");
	}

	// Click on LOG Out icon and click on log out
	public void click_LogOutPortal() {
		clickElement(driver, test, OCR_HomePage_LogOut, "Click on Log Out Icon");
		clickElement(driver, test, "//a[contains(text(),'Sign out')]", "Click on Log Out");
	}
	
	
	public void click_help()
	{
		clickElement(driver,test,OCR_HomePage_helpbutton,"Click on Help Button");
	}
	public void click_WhoAMI()
	{
		clickElement(driver,test,OCR_HomePage_WhoAmI,"Click on Help Button");
	}
	public String get_Userid()
	{
	
		    scrollToTop(driver);
			Wait.wait(driver,OCR_HomePage_USERID);
			return getTextfromTextbox(driver, test, OCR_HomePage_USERID,"Get the UserId :");

	}
	public String get_UserFirstname()
	{
	
		    scrollToTop(driver);
			Wait.wait(driver,OCR_HomePage_USERFirstname);
			return getText(driver, test, OCR_HomePage_USERFirstname,"Get the UserFirstname :");

	}
	public String get_UserLastname()
	{
	
		    scrollToTop(driver);
			Wait.wait(driver,OCR_HomePage_USERLastname);
			return getText(driver, test, OCR_HomePage_USERLastname,"Get the UserLastname :");

	}

	public void SelectCommodityClassification()
	{
		scrollToTop(driver);
		Wait.wait(driver,OCR_HomePage_CommodityClassification);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		Wait.waitfor(1);
		clickElement(driver, test, OCR_HomePage_CommodityClassification, "click on Commodity Classification");	
		
		Wait.waitfor(5);
		clickElement(driver, test, OCR_HomePage_CommodityClassification_features, "Commodity Classification features");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_CommodityClassification_CommodityClassificationRequest, "Click Commodity classification Request");
		
	}	
	
	//Title Validation
	public void titleValidation() {
		try {
			if(isDisplayed(driver, OCR_HomePage_CommodityClassification_SearchCommodityRequest)) {
				test.log(LogStatus.PASS, "Commodity Classification Request Search Page is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.INFO, "Search Page is Not Displayed :");
		}
	}


//Title Validation
public void AuthorizationFailed() {
	try {
		if(isDisplayed(driver, OCR_HomePage_CommodityClassification_AuthorizationFail)) {
			test.log(LogStatus.PASS, "Authorization Failed :");
		}
	}catch(Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Page is displayed :");
	}
}
}

