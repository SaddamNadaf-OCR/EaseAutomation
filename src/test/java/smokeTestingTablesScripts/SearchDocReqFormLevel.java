package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.DocumentTypePage;
import tablesClasses.DocumentationReqFormLevel;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchDocReqFormLevel extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDocReqFormLevel", excel);

	}

	@Test(dataProvider = "getData") 
	public void searchReqDocumentFormLevel(String Testcase, String RunMode, String SBU, String Country, String Status, String Module, String Form, String DocumentId, String sortby, String direction) {
		
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage sr = new ResultAirportsPage(driver, test);
		DocumentationReqFormLevel doc = new DocumentationReqFormLevel(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
//					homepage.movetoDocumentationReqFormLevel();
					Wait.waitfor(2);
					doc.searchbyParameters(Country, Status, Module, Form, DocumentId, sortby, direction);
					doc.searchbutton();
					Wait.waitfor(2);
					sr.searchresultIsDisplayed();
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
