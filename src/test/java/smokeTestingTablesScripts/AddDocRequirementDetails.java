package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.DataEntryCentrePage;
import tablesClasses.DocumentationRequiremntPage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddDocRequirementDetails extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDocumentReqDetails", excel);

	}

	@Test(dataProvider = "getData") 
	public void AddDocreq(String Testcase, String RunMode, String SBU, String Country, String EffectiveDate, String status, String EffectiveStatus, String ShipmentType, String DocumentId, String Languagecode, String DocumentName) {
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		DocumentationRequiremntPage doc= new DocumentationRequiremntPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
//					homepage.movetoDocumentationRequirement();	
					Wait.waitfor(2);
					doc.addbutton();
					doc.AddbyParameters(Country, status, EffectiveDate, DocumentId, EffectiveStatus, ShipmentType,Languagecode,DocumentName);
					doc.savebtn();
					Wait.waitfor(2);
					homepage.returnToGExportHomePage();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homepage.returnToGExportHomePage();
			Assert.assertTrue(false);
		}
	}



	}


	
