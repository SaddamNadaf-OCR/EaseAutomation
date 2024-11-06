package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddVTemplatePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String OCR_VRTemplate_AddTemplate="//button[contains(text(),'Add Template')]";
	public static final String OCR_VRTemplate_Save="(//button[@class='primary-btn auto-savable ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_VRTemplate_NextButtonIcon="//button[@id='next-btn-upper']";
	public static final String OCR_VRTemplate_VisitorRequestTemplate="(//a[contains(text(),'Standard Request Template')])";
	public static final String OCR_VRTemplate_Exit="(//button[@name='cancel'])[1]";
	public static final String OCR_VRTemplate_NoButton="//button[@id='no']";
	public static final String OCR_VRTemplate_YesButton="//button[@id='yesButton']";

	//---------------------------------------------Visit Information---------------
	
	public static final String OCR_VRTemplate_TemplateName="//input[@id='VMM_FLD_188']";
	public static final String OCR_VRTemplate_TemplateRequestID="//input[@id='VMM_FLD_189']";
	public static final String OCR_VRTemplate_HostSBU="//select[@id='VMM_FLD_1']";
	public static final String OCR_VRTemplate_MeetingLocationSBU="//select[@id='VMM_FLD_2']";
	public static final String OCR_VRTemplate_VisitRequestFrom="//input[@id='VMM_FLD_4']";
	public static final String OCR_VRTemplate_VisitRequestTo="//input[@id='VMM_FLD_5']";
	public static final String OCR_VRTemplate_StartTime="//select[@id='VMM_FLD_7']";
	public static final String OCR_VRTemplate_EndTime="//select[@id='VMM_FLD_8']";
	public static final String OCR_VRTemplate_RequestDate="//input[@id='VMM_FLD_3']";
	public static final String OCR_VRTemplate_AllDayAccess="//input[@id='VMM_FLD_10']";
	public static final String OCR_VRTemplate_247Access="//input[@id='VMM_FLD_11']";
	public static final String OCR_VRTemplate_WeekendAccess="//input[@id='VMM_FLD_12']";
	
	//--------------------------------------Host Details--------------------------------
	public static final String OCR_VRTemplate_LocalHost="//input[@id='sameLocalHost']";
	public static final String OCR_VRTemplate_PrimaryHost="//input[@id='sameRequestor']";
	public static final String OCR_VRTemplate_AdministrativeContact="//input[@id='sameAdministrative']";
	
	//------------Location  Details---------------------
	public static final String OCR_VRTemplate_SiteArrow="(//div[@class='ms-trigger-ico'])[1]";
	public static final String OCR_VRTemplate_BuildingName="(//input[@type='text'])[18]";
	public static final String OCR_VRTemplate_AddSite="//button[@id='saveLocation']";
	
	//-----------------------------Meeting Information-------------------------
	
	public static final String OCR_VRTemplate_ClassificationLevel="//select[@id='VMM_FLD_24']";
	public static final String OCR_VRTemplate_VisitPurpose="//select[@id='VMM_FLD_26']";
	public static final String OCR_VRTemplate_DiscriptionOfVisit="//textarea[@id='VMM_FLD_27']";
	public static final String OCR_VRTemplate_MeetingCategory="(//div[@class='ms-trigger-ico'])[5]";
	
	
	
	public AddVTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;	
}
	public void Click_Exit() {
		clickElement(driver, test, OCR_VRTemplate_Exit, "click on exit button");
		Wait.waitfor(2);
	}
	public void Click_Yes() {
		clickElement(driver, test, OCR_VRTemplate_YesButton, "Click on Yes button");
	}
	
	public void Click_NoButton() {
		clickElement(driver, test, OCR_VRTemplate_NoButton, "Click on No button");
	}
	
	public void select_VisitorRequestTemplate() {
		clickElement(driver, test, OCR_VRTemplate_VisitorRequestTemplate, "Click on Visitor Request Template");
	
	}
	public void Click_AddTemplate(){
		clickElement(driver, test, OCR_VRTemplate_AddTemplate, "Click On Add Template");
	}
	
	public void Click_SaveButton() {
		clickElement(driver, test, OCR_VRTemplate_Save, "click on Save button");
		Wait.waitfor(2);
		scrollToElement(driver, OCR_VRTemplate_SiteArrow);
	}
	
	public void Add_TemplateName(String TemplateName) {
		typeText(driver, test, OCR_VRTemplate_TemplateName, "Add Template Name", TemplateName);
	}
	public void Add_TemplateRequestId(String TemplateRequestd) {
		typeText(driver, test, OCR_VRTemplate_TemplateRequestID, "Add Template Request Id", TemplateRequestd);
	}
	
	public void Select_HostSBU(String HostSBU) {
		selectByVisibleText(driver, test, OCR_VRTemplate_HostSBU, "Select Host SBU from Dropdown", HostSBU);
	}
	
	public void Select_MeetinglocationSBU(String MeetinglocationSBU) {
		selectByVisibleText(driver, test, OCR_VRTemplate_MeetingLocationSBU, "Select Host SBU from Dropdown", MeetinglocationSBU);
	}
	
	public void Add_VisitDates(String StartDate, String EndDate) {
		clickElement(driver, test, OCR_VRTemplate_VisitRequestFrom, "Add start date");
		date(driver, test, "Select the Start date : " , StartDate);
		clickElement(driver, test, OCR_VRTemplate_VisitRequestTo, "Add End date");
		date(driver, test, "Select the End date : " , EndDate);
	}
	
	public void Add_VisitTime(String StartTime, String EndTime) {
		typeText(driver, test, OCR_VRTemplate_StartTime, "Add Start time", StartTime);
		typeText(driver, test, OCR_VRTemplate_EndTime, "Add End time", EndTime);
	}
	
	public void Add_RequestDate(String RequestDate) {
		clickElement(driver, test, OCR_VRTemplate_RequestDate, "Add request date");
		date(driver, test, "Select the Request date : " , RequestDate);
	}
	
	public void Click_AddDayAccess() {
		clickElement(driver, test, OCR_VRTemplate_AllDayAccess, "Click checkBox for all day access");
	}
	
	public void Click_247Access() {
		clickElement(driver, test, OCR_VRTemplate_247Access, "Click od 24/7 access");
	}
	public void Click_WeekendAccess() {
		clickElement(driver, test, OCR_VRTemplate_WeekendAccess, "Click on Weekend Access");
	}
	
	
	public void Click_LocalHost() {
		clickElement(driver, test, OCR_VRTemplate_LocalHost, "Click on Local Host");
	}
	
	public void Click_PrimaryHost() {
		clickElement(driver, test, OCR_VRTemplate_PrimaryHost, "Click on Primary Host");
	}
	public void Click_AdministrativeContact() {
		clickElement(driver, test, OCR_VRTemplate_AdministrativeContact, "Click on Administrative contact");
	}
	
	public void select_Site(String Site) {
		GenericMethods.scrollToElement(driver, "(//a[@class='accordion-toggle'])[2]");
		Wait.waitfor(3);
		if (Site.length() > 0) {
			clickElement(driver, test, OCR_VRTemplate_SiteArrow, "click on Site");
			String site = "//div[contains(text(),'" + Site.trim() + "')]";
			clickElement(driver, test, site, "Select the site : " + Site);
		}
	}
	
	// Enter Building Name
	public void type_BuildingName(String BuildingName) throws Exception {
		if (BuildingName.length() > 0) {
			clickElement(driver, test, OCR_VRTemplate_BuildingName, "Click on building arrow");
			typeText(driver, test, OCR_VRTemplate_BuildingName, "Enter building Name : ", BuildingName);
			Wait.waitfor(2);
		}
	}

	public void clickAddSite() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VRTemplate_AddSite, "Click on ADD Site button");
	}
	
	public void Add_MeetingInformation(String ClassificationLevel, String VisitPurpose) {
		selectByVisibleText(driver, test, OCR_VRTemplate_ClassificationLevel, "Add Classification Level", ClassificationLevel);
		selectByVisibleText(driver, test, OCR_VRTemplate_VisitPurpose, "Add Visit Purpose", VisitPurpose);
		
		scrollToTop(driver);
		
		
	}
	public void select_MeetingCategory(String MeetingCategory) {
		clickElement(driver, test, "(//div[@class='ms-trigger-ico'])[5]", "Click on  MeetingCategory");
		Wait.waitfor(2);
		typeText(driver, test, "//input[@placeholder='Please select Category...']", "Enter the MeetingCategory : ",
				MeetingCategory);
		Wait.waitfor(3);
		clickElement(driver, test, "(//div/em[contains(text(),'" + MeetingCategory + "')])[1]",
				"Select the MeetingCategory : " + MeetingCategory);
	}
}
