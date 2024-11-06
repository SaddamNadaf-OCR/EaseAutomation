package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchIncident;
import incident_Management.SearchInvestigation;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchInvestigationsFormScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("InvestigationsForm", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void searchIncidentPage(String TestCases,String RunMode,String SBU,String referanceno,String data,String blanksearch,String invalidsearch,String investigationId,String status,String shortby,String direction ) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchInvestigation sin=new SearchInvestigation(driver,test);
		SearchIncident inc=new SearchIncident(driver,test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
				//	homePage.sbuSelection(SBU);
					Wait.waitfor(2);
				
					if(referanceno.length() > 0) {
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					sin.searchIncidentNoinv(referanceno, data,blanksearch,invalidsearch);
				}else if(investigationId.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForInvestigations();
						Wait.waitfor(3);
						sin.searchIncidentbyInvestigationId(investigationId);
				}else if(status.length() > 0) {
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					inc.searchIncidentbyStatus(status);
			    }else if(shortby.length() > 0) {
			    	homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					inc.searchIncidentbyShortBy(shortby);
			    }else if(direction.length() > 0) {
			    	homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForInvestigations();
					Wait.waitfor(3);
					inc.searchIncidentbyDirection(direction);
			    }else {
					
				//	status
				//	classificationClassName
				//	inc.searchIncidentbyProductLine(productline);
				}}else {
						test.log(LogStatus.SKIP, "Please check the run mode");
						throw new SkipException("Skipping the test");
					}
				}}
			catch (SkipException s) {
				// s.printStackTrace();
				test.log(LogStatus.SKIP, "Please check the run mode");
				throw s;
			} catch (Exception e) {
				e.printStackTrace();
				testFail();
				
				Assert.assertTrue(false);
			}
		}
	}
					
//			}
//		}
//		}
//			catch (Exception e) {
//			e.printStackTrace();
//			testFail();
//			homePage.logOut();
//			Assert.assertTrue(false);
//		}
//	}


