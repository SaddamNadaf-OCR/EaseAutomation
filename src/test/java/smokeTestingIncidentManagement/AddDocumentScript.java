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
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddDocumentScript extends SeleniumTestBase {

	//.....................................Data-Provider...................................//
		@DataProvider
		public Object[][] getdata() {
			return Utility.getData("AddDocument", excel);
		}
		
		//.....................................Test Method.......................................//
		@Test(dataProvider="getdata")
		public void addDocument(String TestCases,String RunMode,String SBU,String referanceno,String data,String uploadfileName,String DocumentType ) {
			
			HomePageIM homePage=new HomePageIM(driver,test);
			//SearchIncident inc=new SearchIncident(driver,test);
			SearchIncident inc=new SearchIncident(driver,test);
			QuestionnaireIM que=new QuestionnaireIM(driver,test);
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
								que.clickonSearchdata();
								Wait.waitfor(2);
								que.QuestionnaireTab();
								que.addDocument(uploadfileName, DocumentType);
							//	que.addNotes(notes);
							//	homePage.select();
								Wait.waitfor(2);
							//	inc.search();
							
						Wait.waitfor(20);
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
