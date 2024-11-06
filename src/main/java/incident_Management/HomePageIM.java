package incident_Management;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageIM extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String IM_DemoSelection="(//a[@class='nav-link dropdown-item'])[1]";
	public static final String IM_ModuleSelection="//li[@class='nav-item dropdown active-mod']";
	public static final String IM_IncidentManagement="(//a[contains(text(),'Incident Management')])[1]";
	public static final String IM_Features="(//a[@class='nav-link dropdown-item'])[3]";
	//public static final String IM_Incident="//i[@class='fa fa-minus-square']";
	public static final String IM_Incident="(//a[contains(text(),'Incident')])[3]";
	
	public static final String IM_WorkQueuef="//a[contains(text(),'Work Queue')]";
	
	
	public static final String IM_CorrectiveAction="(//a[contains(text(),'Corrective Action')])[1]";
	public static final String IM_IncidentForm="(//a[contains(text(),'Incident Form')])[1]";
	public static final String IM_Investigations="(//a[contains(text(),'Investigations')])[1]";
	public static final String IM_WorkQueue="(//a[contains(text(),'Work Queue')])[1]";
	public static final String IM_Logout="//i[@class=\"fa fa-sign-out\"]";
	
	public static final String IM_SelectButton="//button[@class='primary-btn recordFromPopup']";
	public static final String IM_formHeading="//*[@class='page-heading']";
	
	public static final String IM_RefreshButton="//span[@class='ui-icon ui-icon-refresh']";
	
	
	
	//.....................................Constructor............................................//
	public HomePageIM(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.....................................SBU Selection..........................................//
	public void sbuSelection(String SBU) {
		mouseOverAndClick(driver, test, IM_DemoSelection, "Mouse Over and Click");
		Wait.waitfor(12);
		clickElement(driver, test, "//label[contains(text(),'" +SBU+ "')]", "Clicking on SBU :" +SBU);
	}
	
	//....................................Module Selecttion.......................................//
	public void moduleSelection() {
		mouseOverAndClick(driver, test, IM_ModuleSelection, "Mouse over and Click on Module");
		Wait.waitfor(3);
		clickElement(driver, test, IM_IncidentManagement, "Clicking on Module");
		Wait.waitfor(3);
	}
		
	//..................................Corrective Action in Features............................//
	public void featurSelectionForCorrectiveAction() {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(4);
		clickElement(driver, test, IM_Incident, "Clicking on Incident");
		Wait.waitfor(3);
		clickElement(driver, test, IM_CorrectiveAction, "Clicking on Corrective Action Form");
	}
	
	//..................................Incident Form in Features................................//
	public void featurSelectionForIncidentForm() {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		clickElement(driver, test, IM_Incident, "Clicking on Incident");
		clickElement(driver, test, IM_IncidentForm, "Clicking on Incident Form");
	}
	
	//.................................Investigation in Features.................................//
	public void featurSelectionForInvestigations() {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(3);
		clickElement(driver, test, IM_Incident, "Clicking on Incident");
		Wait.waitfor(4);
		clickElement(driver, test, IM_Investigations, "Clicking on Investigations Form");
	}
	
	public void featurSelectionForInvestigationsb() {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(3);
		clickElement(driver, test, IM_Incident, "Clicking on Incident");
		Wait.waitfor(4);
		clickElement(driver, test, IM_Investigations, "Clicking on Investigations Form");
	}
	
	//..................................Work Queue in Features...................................//
	public void featurSelectionForWorkQueue() {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		clickElement(driver, test, IM_WorkQueue, "Clicking on Work Queue Tab");
	}
	
	//..................................For Select Button Click........................................//
	public void select() {
		clickElement(driver, test, IM_SelectButton, "Clicking On Select Button");
	}
	//span[@class='ui-icon ui-icon-refresh']
	
	//..................................For Select Button Click........................................//
		public void refresh() {
			clickElement(driver, test, IM_RefreshButton, "Clicking On Refresh Button");
		}
	//..................................For Logout Click........................................//
	public void logOut() {
		clickElement(driver, test, IM_Logout, "Clicking On LogOut");
	}
	
	
	


	
	
	
	
	
	
	//..................................For form heading Click........................................//
public void formHeading(String CorrectiveAction,String Heading,String Incident,String Investigations) {
	
	
	if (CorrectiveAction.length() > 0) {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(3);
		clickElement(driver, test, IM_Incident, "Clicking on Incident");
		Wait.waitfor(3);
		
		clickElement(driver, test, IM_CorrectiveAction, "Clicking on Incident Form");
		
		clickElement(driver, test, IM_formHeading, "Get the form heading ");
		String sucessmesg = getText(driver, test, IM_formHeading, "Get the Message : ");
		
			if (sucessmesg.equals(Heading)) {
			test.log(LogStatus.PASS, "Form heading  displayed ");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Form heading is incorrect or not displayed");
		}

}

 if (Incident.length() > 0) {
	 
	 mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(3);
	 Wait.waitfor(3);
		clickElement(driver, test, IM_IncidentForm, "Clicking on Incident Form");
		Wait.waitfor(3);
		clickElement(driver, test, IM_formHeading, "Get the form heading ");
		String sucessmesg = getText(driver, test, IM_formHeading, "Get the Message : ");
		
			if (sucessmesg.equals(Heading)) {
			test.log(LogStatus.PASS, "Form heading  displayed ");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Form heading is incorrect or not displayed");
		}
}
 
 
 
if (Investigations.length() > 0) {
	 
	 mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		Wait.waitfor(3);
	 Wait.waitfor(3);
	 clickElement(driver, test, IM_Investigations, "Clicking on Investigations Form");
		Wait.waitfor(3);
		clickElement(driver, test, IM_formHeading, "Get the form heading ");
		String sucessmesg = getText(driver, test, IM_formHeading, "Get the Message : ");
		
			if (sucessmesg.equals(Heading)) {
			test.log(LogStatus.PASS, "Form heading  displayed ");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Form heading is incorrect or not displayed");
		}
}

}}
	
//	
//	
//	clickElement(driver, test, IM_formHeading, "Get the form heading ");
//		String sucessmesg = getText(driver, test, IM_formHeading, "Get the Message : ");
//		
//			if (sucessmesg.equals(Heading)) {
//			test.log(LogStatus.PASS, "Form heading displayed ");
//		} else {
//			testFailSshot(driver, test);
//			test.log(LogStatus.FAIL, "Form heading not displayed");
//		}
//
//		
//		
//	}
	
//}
	//..................................For form heading Click........................................//
//		public void formHeading(CorrectiveAction,Incident,Investigations,Heading) {
//			clickElement(driver, test, IM_formHeading, "Get the form heading ");
//			String sucessmesg = getText(driver, test, IM_formHeading, "Get the Message : ");
////			if (sucessmesg.equals(Heading)) {
////				test.log(LogStatus.PASS, "Form heading displayed ");
////			} else {
////				testFailSshot(driver, test);
////				test.log(LogStatus.FAIL, "Form heading not displayed");
////			}
//		}

