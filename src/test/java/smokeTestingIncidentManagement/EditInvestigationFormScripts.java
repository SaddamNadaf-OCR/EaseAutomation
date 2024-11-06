package smokeTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.AddIncident;
import incident_Management.GeneralInfoIM;
import incident_Management.HomePageIM;
import incident_Management.QuestionnaireIM;
import incident_Management.SearchIncident;
import incident_Management.SearchInvestigation;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class EditInvestigationFormScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("EditInvestigationsDetails", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void EditInvestigationFormdetails(String TestCases,String RunMode,String SBU,String data, String referanceno,String investigationId, String matterName, String matterDescription,String  investigationScope,String  methodology,String agencyCaseNo) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchIncident inc=new SearchIncident(driver,test);
		AddIncident ai=new AddIncident(driver,test);
        SearchInvestigation sin=new SearchInvestigation(driver,test);
        QuestionnaireIM qim=new QuestionnaireIM(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
//					homePage.sbuSelection(SBU);
					Wait.waitfor(2);
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					sin.searchIncidentNo(referanceno, data);
					Wait.waitfor(2);
					
					sin.editInvestigationdetails(investigationId,matterName, matterDescription, investigationScope, methodology, agencyCaseNo);
					
			//		homePage.logOut();
				
			}
		}
		}
			catch (Exception e) {
			e.printStackTrace();
			testFail();
			homePage.logOut();
			Assert.assertTrue(false);
		}
	}

}
