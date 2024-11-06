package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class GeneralInfoIM extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String IM_GI_IncidentNumber="//a[@onclick='incidentNoPopUp()']";
	public static final String IM_GI_IncidentNumberText="//input[@name='citGeneralInfoValue.referenceNo']";
	public static final String IM_GI_SearchPopup="(//button[contains(text(),'Search')])[1]";
	public static final String IM_GI_SelectPopup="(//button[contains(text(),'Select')])[1]";
	public static final String IM_GI_NewSearchPopup="(//button[contains(text(),'New Search')])[1]";	
	public static final String IM_GI_CancelPopup="(//button[contains(text(),'Cancel')])[4]";
	public static final String IM_GI_BusinessUnit="//select[@id='sbuCode']";
	public static final String IM_GI_Save="(//button[contains(text(),'Save')])[1]";
	public static final String IM_GI_Save_Return="(//button[contains(text(),'Save')])[2]";
	public static final String IM_GI_Cancel="(//button[contains(text(),'Cancel')])[1]";
	public static final String IM_GI_IncidentDiscoveryDate="//input[@name='incidentDiscDate']";
	public static final String IM_GI_Program="//a[contains(text(),'Program')]";
	public static final String IM_GI_Segment="//a[contains(text(),'Segment')]";
	public static final String IM_GI_Site="(//a[contains(text(),'Site')])[2]";
	public static final String IM_GI_ProductFamily="(//a[contains(text(),'Product Family')])[2]";
	public static final String IM_GI_ProductLine="(//a[contains(text(),'Product Line')])[2]";
	public static final String IM_GI_Department="//a[contains(text(),'Department')]";
	
	public static final String IM_AddIncident="//button[contains(text(),'Add Incident')]";
	public static final String IM_GenInfLockbutton="//i[@id='lockIcon']";
	
	public GeneralInfoIM(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void incidentNo(String incidentNumber) {
		typeText(driver, test, IM_GI_IncidentNumberText, "Typing Incident No", incidentNumber);
	}
	public void businessUnit(String businessSbu) {
		selectByVisibleText(driver, test, IM_GI_BusinessUnit, "Select Business SBU", businessSbu);
	}
	public void incidentDiscoveryDate(String incidentDate) {
		clickElement(driver, test, IM_GI_IncidentDiscoveryDate, "Clicking on Incident Discovery Date");
		date(driver, test, "Select the IncidentDate :", incidentDate);
	}

	public void disablelockbutton() {
		clickElement(driver, test, IM_GenInfLockbutton, "Clicking on General Info LocK button Disable");
	}
	
	
}
