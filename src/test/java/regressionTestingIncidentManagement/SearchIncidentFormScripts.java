package regressionTestingIncidentManagement;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import incident_Management.HomePageIM;
import incident_Management.SearchIncident;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchIncidentFormScripts extends SeleniumTestBase{
	
	//.....................................Data-Provider...................................//
	@DataProvider
	public Object[][] getdata() {
		return Utility.getData("IncidentForm", excel);
	}
	
	//.....................................Test Method.......................................//
	@Test(dataProvider="getdata")
	public void searchIncidentPage(String TestCases,String RunMode,String SBU,String referanceno,String data,String segment, String productline,String productfamily,String site,String classificationClassName,String status,String formtype,String reportedByname,String businessUnit,String programme,String contactName,String investigationId,String shortby,String direction) {
		
		HomePageIM homePage=new HomePageIM(driver,test);
		SearchIncident inc=new SearchIncident(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
			//		homePage.sbuSelection(SBU);
					Wait.waitfor(2);
					
					if(referanceno.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentNo(referanceno, data);
					} else if(segment.length() > 0) {
						inc.newsearch();
						inc.searchIncidentbySegment(segment);
					}else if(productline.length() > 0) {
						inc.newsearch();
						inc.searchIncidentbyProductLine(productline);
					
					}else if(productfamily.length() > 0) {
						inc.newsearch();
						inc.searchIncidentbyProductFamily(productfamily);
					
					}else if(productfamily.length() > 0) {
						inc.newsearch();
						inc.searchIncidentbyProductFamily(productfamily);
					
					}else if(site.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentbySite(site);
					
					}else if(classificationClassName.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentbyClassification(classificationClassName);
					
					}else if(status.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentbyStatus(status);
					
					}else if(formtype.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentbyFormType(formtype);
					}else if(reportedByname.length() > 0) {
							homePage.moduleSelection();
							Wait.waitfor(2);
							homePage.featurSelectionForIncidentForm();
							Wait.waitfor(2);
							inc.searchIncidentbyReportedBy(reportedByname);
					}else if(businessUnit.length() > 0) {
						homePage.moduleSelection();
						Wait.waitfor(2);
						homePage.featurSelectionForIncidentForm();
						Wait.waitfor(2);
						inc.searchIncidentbyBusinessUnit(businessUnit);
				}else if(programme.length() > 0) {
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.featurSelectionForIncidentForm();
					Wait.waitfor(2);
					inc.searchIncidentbyProgramme(programme);
			}else if(contactName.length() > 0) {
				homePage.moduleSelection();
				Wait.waitfor(2);
				homePage.featurSelectionForIncidentForm();
				Wait.waitfor(2);
				inc.searchIncidentbyContactName(contactName);
		}else if(investigationId.length() > 0) {
			homePage.moduleSelection();
			Wait.waitfor(2);
			homePage.featurSelectionForIncidentForm();
			Wait.waitfor(2);
			inc.searchIncidentbyInvestigationId(investigationId);
	}else if(shortby.length() > 0) {
		homePage.moduleSelection();
		Wait.waitfor(2);
		homePage.featurSelectionForIncidentForm();
		Wait.waitfor(2);
		inc.searchIncidentbyShortBy(shortby);
    }else if(direction.length() > 0) {
		homePage.moduleSelection();
		Wait.waitfor(2);
		homePage.featurSelectionForIncidentForm();
		Wait.waitfor(2);
		inc.searchIncidentbyDirection(direction);
    }else {
						
					//	status
					//	classificationClassName
					//	inc.searchIncidentbyProductLine(productline);
					}
			}
				
				
				else {
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
		
		
		

