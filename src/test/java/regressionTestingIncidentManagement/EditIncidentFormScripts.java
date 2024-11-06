package regressionTestingIncidentManagement;

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
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class EditIncidentFormScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("EditIncidentFormData", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void searchIncidentPage(String TestCases,String RunMode,String SBU,String referanceno,String data,String segment,String productFamily,String	productLine,String department,String uploadfileName,String notes,String DocumentType,String firstName) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchIncident inc=new SearchIncident(driver,test);
		QuestionnaireIM qim=new QuestionnaireIM(driver,test);
		AddIncident ai=new AddIncident(driver,test);
		GeneralInfoIM gie=new GeneralInfoIM(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
			//		homePage.sbuSelection(SBU);
					Wait.waitfor(2);
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForIncidentForm();
					Wait.waitfor(2);
					inc.searchIncidentNo(referanceno, data);
					Wait.waitfor(2);
					qim.clickonSearchdata();
					Wait.waitfor(2);
					gie.disablelockbutton();
					Wait.waitfor(2);
					ai.editincidentdetails(segment, productFamily, productLine, department);
					
				//	homePage.select();
				
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
