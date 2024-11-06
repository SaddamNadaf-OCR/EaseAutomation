package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewCongressionalNotificationPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String CNCN_Save="(//button[contains(text(),'Save')])[1]";
	public static final String CNCN_SaveAndReturn="(//button[contains(text(),'Save')])[2]";
	public static final String CNCN_Cancel="//button[contains(text(),'Cancel')]";
	public static final String CNCN_ReferanceNo="//input[@name='lesCongressionalNotification.refNo']";
	public static final String CNCN_CongressinalNo="//input[@name='lesCongressionalNotification.congressionalNo']";
	public static final String CNCN_CaseNo="//input[@name='lesCongressionalNotification.caseNo']";
	public static final String CNCN_Status="//select[@id='editLesCongressionalNotification_lesCongressionalNotification_status']";
	public static final String CNCN_SubmitDate="//input[@name='submitDate']";
	public static final String CNCN_SegementHyperlink="//a[contains(text(),'Segment:')]";
	public static final String CNCN_Select="(//button[@name='Ok'])[1]";
	public static final String CNCN_ClosePopup="//button[@class='btn-close']";
	public static final String CNCN_Segement="//textarea[@name='lesCongressionalNotification.segmentCode']";
	public static final String CNCN_Commodity="//input[@name='lesCongressionalNotification.commodity']";
	public static final String CNCN_CountryName="//input[@name='lesCongressionalNotification.countryName']";
	public static final String CNCN_Value="//input[@name='value']";
	public static final String CNCN_DateToHill="//input[@name='dateToHill']";
	public static final String CNCN_AssociatedLiecance="//input[@name='lesCongressionalNotification.assctdLic']";
	public static final String CNCN_AssociatedNotifiedLiecance="//input[@name='lesCongressionalNotification.assctdNotifiedLic']";
		
	//.................................Constructor.....................................//
	public CreateNewCongressionalNotificationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...........................Click on Save Button............................//
	public void save() {
		clickElement(driver, test, CNCN_Save, "Clicking on Save Button");
	}
	
	//..........................Click on Save And Return Button......................//
	public void saveAndReturn() {
		clickElement(driver, test, CNCN_SaveAndReturn, "Clicking on Save and Return Button");
	}
	
	//..........................Click on Cancel Button..............................//
	public void cancel() {
		clickElement(driver, test, CNCN_Cancel, "Clicking on Cancel Button");
	}
	
	//.....................Adding Data into Congressional Notification.................//
	public void addDataIntoCN(String referenaceNo,String congressionalNo,String caseNo,String Status,
			String submitDate,String segementNo,String commodityNo,String countryName,String value,
			String dateOfHill,String associatedLiecance,String assoiciatedNL) {
		
		typeText(driver, test, CNCN_ReferanceNo, "Typing the Reference Number", referenaceNo+randomnumbers());
		Wait.waitfor(3);
		typeText(driver, test, CNCN_CongressinalNo, "Typing Congressinal number", congressionalNo+randomnumbers());
		Wait.waitfor(3);
		typeText(driver, test, CNCN_CaseNo, "Typing Case Number", caseNo+randomnumbers());
		Wait.waitfor(3);
		selectByVisibleText(driver, test, CNCN_Status, "Selecting Status from DropDown", Status);
		Wait.waitfor(3);
		if(submitDate.length() > 0) {
			clickElement(driver, test, CNCN_SubmitDate, "Clicking on submit Date"+submitDate);
			dateOfMonthName(driver, test, "Selecting submit Date",submitDate);
		}
		Wait.waitfor(3);
		if(segementNo.length() > 0) {
			clickElement(driver, test, CNCN_SegementHyperlink, "Clicking on Segment Link");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+segementNo+"')]", "Selecting Data from Table :"+segementNo);
				clickElement(driver, test, CNCN_Select, "Clicking on Select Tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CNCN_ClosePopup, "Closing the PopUp");
			}
		}else {
			typeText(driver, test, CNCN_Segement, "Typing Segement Number", segementNo);
		}
		Wait.waitfor(3);
		typeText(driver, test, CNCN_Commodity, "Typing Commodity Number", commodityNo);
		Wait.waitfor(3);
		clickElement(driver, test, CNCN_CountryName, "Clicking On Country Tab");
		Wait.waitfor(3);
		typeText(driver, test, CNCN_CountryName, "Selecting Country Name", countryName);
		Wait.waitfor(3);
		typeText(driver, test, CNCN_Value, "Typing The Value", value);
		Wait.waitfor(3);
		if(dateOfHill.length() > 0) {
			clickElement(driver, test, CNCN_DateToHill, "Clicking on Date To Hill"+dateOfHill);
			dateOfMonthName(driver, test, "Selecting Date Of Hill",dateOfHill);
		}
		Wait.waitfor(3);
		typeText(driver, test, CNCN_AssociatedLiecance, "Typing Associated Liecance", associatedLiecance);
		Wait.waitfor(3);
		typeText(driver, test, CNCN_AssociatedNotifiedLiecance, "Typing the ANL Number", assoiciatedNL);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, CNCN_CountryName, "Getting Country First Value :");
	}

}
