package incident_Management;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddCorrectiveAction extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	
	public static final String IM_CorrectiveActionTab="(//a[contains(text(),'Corrective Actions')])[2]";
	
	public static final String IM_AddCorrectiveActionBtn = "//button[@id='addCorrectiveAction']";
	
	public static final String IM_CorrectiveActionTabAddUserLink="//a[contains(text(),'Add User')]";
	
	public static final String IM_CorrectiveActionTabAddUserSearch="//input[@id='searchForm_userProfile_userFirstname']";
	public static final String IM_CorrectiveActionTabAddUserSearchBtn="(//button[contains(text(),'Search')])[1]";
	
	public static final String IM_CorrectiveActionTabAddUserSelectBtn="(//button[contains(text(),'Select')])[1]";
	
	public static final String IM_addincident="//input[@placeholder='Select Incident No.']";
	public static final String IM_addincidentdata="//div[@class=\"ms-res-item ms-res-item-active\"]";
	//div[@class="ms-res-item ms-res-item-active"]
	
	public static final String IM_CorrectiveAction="//a[@onclick='incidentNoPopUp()']";
	public static final String IM_CorrectiveActionSaveBtn="//button[@id='save']";
	
	
	public static final String IM_Searchdata="//td[@aria-describedby='caGrid_referenceNo']";
	
	public static final String IM_CADepartmentLink = "//a[contains(text(),'Department')]";
	public static final String IM_CADepartmentTxtFil = "//textarea[@id='department']";
	
	
	public static final String IM_CASiteLink = "//a[contains(text(),'Site')]";
	public static final String IM_CASiteTxtFil = "//textarea[@id='site']";
	
	public static final String IM_CATitleLink = "//a[contains(text(),'Title')]";
	public static final String IM_CATitleTxtFil = "//input[@id='editCitCorrectiveAction_citCorrectiveActionValue_title']";
	
	
	
    public static final String IM_CorrectiveActionDescription = "//textarea[@id='editCitCorrectiveAction_citCorrectiveActionValue_description']";
	public static final String IM_CARequiredbyDate = "//input[@id='editCitCorrectiveAction_actionRequiredDate']";
	public static final String IM_CARequiredbyDateToday = "//button[contains(text(),'Today')]";
	public static final String IM_CARemark = "//textarea[@id='editCitCorrectiveAction_citCorrectiveActionValue_remark']";
	public static final String IM_CARootCauseTxtFil = "//textarea[@id='editCitCorrectiveAction_citCorrectiveActionValue_rootCause']";
	
	public static final String IM_CASaveReturn = "//button[@id='saveReturnCA']";
	
     
			
	public AddCorrectiveAction(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void addCorrectiveAction()
	{
	clickElement(driver, test, IM_AddCorrectiveActionBtn, "Click on Add Corrective Action Button");

	}
	
	public void addincidentno(String incidentno)
	{
	typeText(driver, test, IM_addincident, "Type the incidentno number:", incidentno);
//	selectByVisibleText(driver, test, IM_addincidentdata,"Select the incidentno dropdown :", incidentno);
	clickElement(driver, test, IM_addincidentdata, "Click on incident no data ");
	}	
	
	//..................................Corrective Action  Form................................SK//
	public void AddCorrectiveAction(String department,String site,String title, String description,String remark,String correctiveactionno, String rootcause) {
		Wait.waitfor(5);
		typeText(driver, test, IM_CADepartmentTxtFil, "Typing Corrective Action Department  :", department);
		Wait.waitfor(2);
		
		typeText(driver, test, IM_CASiteTxtFil, "Typing Corrective Action Site  :", site);
		Wait.waitfor(2);
	
	//	typeText(driver, test, IM_CATitleTxtFil, "Typing Corrective Action Title  :", title);

		Wait.waitfor(2);
		
		
		
		typeText(driver, test, IM_CorrectiveActionDescription, "Typing Corrective Action Description :", description);
		scrollToBottom(driver);
		scrollToBottom(driver);
		clickElement(driver, test, IM_CARequiredbyDate, "Click on Corrective Action Required by Date ");
		clickElement(driver, test, IM_CARequiredbyDateToday, "Click on Corrective Action Required by Date Today");
		
		
		typeText(driver, test, IM_CARemark, "Typing Corrective Action Remark :", remark);
		Wait.waitfor(2);
		
//		typeText(driver, test, IM_CARootCauseTxtFil, "Typing Corrective Action RootCause :", rootcause);
//		Wait.waitfor(2);
		scrollToTop(driver);
		scrollToTop(driver);
		clickElement(driver, test, IM_CASaveReturn, "Click on Save Return Button");
		
		Wait.waitfor(2);
		
	}
	

	//..................................Edit Corrective Action  Form................................SK//
	public void EditCorrectiveAction(String department,String site,String title, String description,String remark,String correctiveactionno, String rootcause) {
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, "//a[contains(text(),'"+ correctiveactionno +"')]", "Selecting Data From table"+correctiveactionno);
       	Wait.waitfor(2);
       	clearText(driver, test, IM_CADepartmentTxtFil, "Clear old Corrective Action Department");
       	Wait.waitfor(2);
		typeText(driver, test, IM_CADepartmentTxtFil, "Typing Corrective Action Department  :", department);
		Wait.waitfor(2);
		clearText(driver, test, IM_CASiteTxtFil, "Clear old Corrective Action Site");
		Wait.waitfor(2);
		typeText(driver, test, IM_CASiteTxtFil, "Typing Corrective Action Site  :", site);
		Wait.waitfor(2);
	//	clearText(driver, test, IM_CATitleTxtFil, "Clear old Corrective Action Title");
	//	Wait.waitfor(2);
	//	typeText(driver, test, IM_CATitleTxtFil, "Typing Corrective Action Title  :", title);

		Wait.waitfor(2);
		
		
		clearText(driver, test, IM_CorrectiveActionDescription, "Clear old Corrective Action Description");
		Wait.waitfor(2);
		typeText(driver, test, IM_CorrectiveActionDescription, "Typing Corrective Action Description :", description);
		
		clickElement(driver, test, IM_CARequiredbyDate, "Click on Corrective Action Required by Date ");
		clickElement(driver, test, IM_CARequiredbyDateToday, "Click on Corrective Action Required by Date Today");
		
		clearText(driver, test, IM_CARemark, "Clear old Corrective Action Remark");
		Wait.waitfor(2);
		typeText(driver, test, IM_CARemark, "Typing Corrective Action Remark :", remark);
		Wait.waitfor(2);
//		clearText(driver, test, IM_CARootCauseTxtFil, "Clear old Corrective Action Title");
//		Wait.waitfor(2);
//		typeText(driver, test, IM_CARootCauseTxtFil, "Typing Corrective Action RootCause :", rootcause);
//		Wait.waitfor(2);
		scrollToTop(driver);
		scrollToTop(driver);
		clickElement(driver, test, IM_CASaveReturn, "Click on Save Return Button");
		
		Wait.waitfor(2);
		
	
	}
	
	
	

	
	
}
