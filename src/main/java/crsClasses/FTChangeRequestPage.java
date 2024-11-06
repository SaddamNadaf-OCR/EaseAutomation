package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class FTChangeRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddChangeRequest = "//button[contains(text(),'Add Change Request')]";
	public static final String OCR_ReasonForChange = "//textarea[@id='editChangeRequest_foreignTravelChangeRequestsValue_reasonForChange']";
	public static final String OCR_ModifyTravelDate = "//input[@id='editChangeRequest_foreignTravelChangeRequestsValue_changeTypeD']";
	public static final String OCR_ModifyTravellerInformation = "//input[@id='editChangeRequest_foreignTravelChangeRequestsValue_changeTypeG']";
	public static final String OCR_ModifyTravellerQuestionnairre = "//input[@id='editChangeRequest_foreignTravelChangeRequestsValue_changeTypeQ']";
	public static final String OCR_Button_Submit = "//button[contains(text(),'Submit')]"; 

	/* ******************************** Constructor ******************************** */
	public FTChangeRequestPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

	public void click_addchangerequest() {
		clickElement(driver, test, OCR_Button_AddChangeRequest, "Click on Add Change Request Button: ");
	}
	
	public void enter_reasonforchange(String ReasonForChange) {
		typeText(driver, test,  OCR_ReasonForChange,"Enter Reason for Change", ReasonForChange);
	}
	
	public void  select_modifytraveldate() {
		clickElement(driver, test, OCR_ModifyTravelDate,"Select Modify Travel Date Radio Button: ");				
	}
	
	public void select_modifytravellerinformation() {
		clickElement(driver, test, OCR_ModifyTravellerInformation, "Select Modify Traveller Information: ");
	}
	
	public void select_modifyquestionnairre() {
		clickElement(driver, test, OCR_ModifyTravellerQuestionnairre,"Select Modify Traveller Questionnairre: ");
	}
	
	public void submit() {
		clickElement(driver, test, OCR_Button_Submit, "Click on Submit Button");
	}
}
