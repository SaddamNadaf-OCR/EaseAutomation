package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.AddIncident;
import incident_Management.GeneralInfoIM;
import incident_Management.HomePageIM;
import incident_Management.SearchIncident;
import incident_Management.QuestionnaireIM;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddIncidentScript extends SeleniumTestBase {

	//.....................................Data-Provider...................................//
		@DataProvider
		public Object[][] getdata() {
			return Utility.getData("AddIncidentnew", excel);
		}
		
		//.....................................Test Method.......................................//
		@Test(dataProvider="getdata")
		public void addIncidentPagedetails(String TestCases,String RunMode,String SBU, String incidentNumber,String templateName,String segment,String productFamily,String	productLine,String department,String uploadfileName,String notes,String DocumentType,String firstName) {
			
			HomePageIM homePage=new HomePageIM(driver,test);
			//SearchIncident inc=new SearchIncident(driver,test);
			AddIncident ai=new AddIncident(driver,test);
			QuestionnaireIM qim=new QuestionnaireIM(driver,test);
			
			
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
						ai.addincidentdetails(incidentNumber,templateName,segment,productFamily,productLine,department);
						Wait.waitfor(2);
						qim.QuestionnaireTab();
						Wait.waitfor(2);
						qim.addQuestionnaire();
						qim.addDocument(uploadfileName,DocumentType);
						Wait.waitfor(4);
						qim.addNotes(notes);
						Wait.waitfor(3);
						ai.submitInfo(firstName);
						Wait.waitfor(3);
						
						
						
						
						
						
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
