package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchCongressionalNotificationPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String SCN_Search="//button[contains(text(),'Search')]";
	public static final String SCN_AddCongressionalNotification="//button[contains(text(),'Add Congressional Notification')]";
	public static final String SCN_Reset="//button[contains(text(),'Reset')]";
	public static final String SCN_SBUCode="//select[@name='lesCongressionalNotification.sbuCode']";
	public static final String SCN_ReferanceNo="//input[@name='lesCongressionalNotification.refNo']";
	public static final String SCN_CongressionalNo="//input[@name='lesCongressionalNotification.congressionalNo']";
	public static final String SCN_CaseNo="//input[@name='lesCongressionalNotification.caseNo']";
	public static final String SCN_Status="//select[@name='lesCongressionalNotification.status']";
	public static final String SCN_submitDate="//input[@name='submitDate']";
	public static final String SCN_Segment="//a[contains(text(),'Segment :')]";
	public static final String SCN_SelectPopUp="//button[@name='Ok']";
	public static final String SCN_CloseIcon="//button[@class='btn-close']";
	public static final String SCN_segmentCode="//textarea[@name='lesCongressionalNotification.segmentCode']";
	public static final String SCN_commodity="//input[@name='lesCongressionalNotification.commodity']";
	public static final String SCN_countryName="//input[@name='lesCongressionalNotification.countryName']";
	public static final String SCN_value="//input[@name='lesCongressionalNotification.value']";
	public static final String SCN_dateToHill="//input[@name='dateToHill']";
	public static final String SCN_createdBy="//select[@name='lesCongressionalNotification.createdBy']";
	public static final String SCN_sortBy="//select[@name='sortBy']";
	public static final String SCN_direction="//select[@name='direction']";
	
	//.................................Constructor.....................................//
	public SearchCongressionalNotificationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.............................Click On Search Tab................................//
	public void search() {
		clickElement(driver, test, SCN_Search, "Clicking On Search Tab");
	}
	
	//...............................Click on Add Congressional number Tab..............................//
	public void addCongressionalNotification() {
		clickElement(driver, test, SCN_AddCongressionalNotification, "Clicking on Add Congressional number");
	}
	
	//................................Click on Reset Tab......................................//
	public void reset() {
		clickElement(driver, test, SCN_Reset, "Clicking on Reset Tab");
	}
	
	//...................................Search By Parameters.....................................//
	public void searchByParameters(String Sbu,String referenceNo,String congressionalNo, String CaseNo, 
			String Status, String Submitdate,String Segment, String Commodity, String Country, String Value,
			String DateOfHill,String CreatedBy, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, SCN_SBUCode, "Selecting SBU", Sbu);
		typeText(driver, test, SCN_ReferanceNo, "Typing Reference Number", referenceNo);
		typeText(driver, test, SCN_CongressionalNo, "Typing Congressional Number", congressionalNo);
		typeText(driver, test, SCN_CaseNo, "Entering Case No :", CaseNo);
		selectByVisibleText(driver, test, SCN_Status, "Selecting Status :", Status);
		if(Submitdate.length() > 0) {
			clickElement(driver, test, SCN_submitDate, "Clicking on Submit Date :");
			dateOfMonthName(driver, test, "Selecting Submit Date :", Submitdate);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, SCN_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, SCN_SelectPopUp, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, SCN_CloseIcon, "Clicking on Close Icon :");
			}
		}
		typeText(driver, test, SCN_commodity, "Entering Commodity :", Commodity);
		typeText(driver, test, SCN_countryName, "Entering Country :", Country);
		typeText(driver, test, SCN_value, "Entering Value :", Value);
		if(DateOfHill.length() > 0) {
			clickElement(driver, test, SCN_dateToHill, "Clicking on Date of Hill :");
			dateOfMonthName(driver, test, "Selecting Date Of Hill :", DateOfHill);
		}
		selectByVisibleText(driver, test, SCN_createdBy, "Selecting Of Crated By :", CreatedBy);
		selectByVisibleText(driver, test, SCN_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, SCN_direction, "Selecting Direcion :", Direction);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, SCN_countryName, "Getting Country First Value :");
	}
}
