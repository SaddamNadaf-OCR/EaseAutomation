package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchCorrectiveAction extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String SI_Search="//button[contains(text(),'Search')]";
	public static final String IM_CorrectiveAction_Search="(//button[@name='Search'])[1]";
	public static final String IM_CorrectiveAction_Reset="//button[@name='reset']";
	public static final String IM_CorrectiveAction_AddCorrectiveAction="//button[@name='addCorrectiveAction']";
	public static final String IM_CorrectiveAction_IncidentNoHyperlink="//a[contains(text(),'Incident No')]";
	public static final String IM_CorrectiveAction_IncidentNo="//input[@name='citCorrectiveActionValue.referenceNo']";
	public static final String IM_CorrectiveAction_SearchPopup="(//button[contains(text(),'Search')])[2]";
	public static final String IM_CorrectiveAction_Select="//button[contains(text(),'Select')]";
	public static final String IM_CorrectiveAction_ClosePopup="//button[@class='btn-close']";
	
	public static final String IM_Searchdata="//td[@aria-describedby='caGrid_referenceNo']";
	
	public SearchCorrectiveAction(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void searchTab() {
		clickElement(driver, test, IM_CorrectiveAction_Search, "Clickin On Search Tab");
	}
	
	public void resetTab() {
		clickElement(driver, test, IM_CorrectiveAction_Reset, "Clickin On Reset Tab");
	}
	
	public void addCorrectiveActionTab() {
		clickElement(driver, test, IM_CorrectiveAction_AddCorrectiveAction, "Clickin On Add Corrective Action Tab");
	}
	
	public void status(String status) {
		clickElement(driver, test, "//option[contains(text(),'"+status+"')]", "Select Status :"+status);
	}
	public void searchIncidentNo(String referanceno,String data) {
		clickElement(driver, test, IM_CorrectiveAction_IncidentNoHyperlink, "Clicking on Incident Number link");
		try {
			typeText(driver, test, "//input[@id='searchForm_referenceNo']", "Type the referance number", referanceno);
			clickElement(driver, test, IM_CorrectiveAction_SearchPopup, "Clicking on Search Tab");
		//	clickElement(driver, test, "//td[contains(text(),'"+data+"')]", "Entering Data :"+data);
		
		
mouseOverAndClick(driver, test, "//td[contains(text(),'"+ referanceno +"')]", "Selecting Data From table"+referanceno);
clickElement(driver, test, IM_CorrectiveAction_Select, "Clicking on Select Tab");
		//	clickElement(driver, test, IM_SelectButton, "Clicking On Select Button");
			clickElement(driver, test, SI_Search, "Clicking on Search");
			
			String sucessmesg = getText(driver, test, IM_Searchdata, "Get the Message : ");
			if (sucessmesg.equals(referanceno)) {
				test.log(LogStatus.PASS, "Search data displayed and search functionality working fine");
			} else {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Search data not displayed");
			}
			Wait.waitfor(2);
		
		
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, IM_CorrectiveAction_ClosePopup, "Closing the Popup Window");
		}
	}

}
