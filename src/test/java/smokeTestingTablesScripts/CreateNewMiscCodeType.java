package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.AgencyMiscCodeTypePage;
import tablesClasses.ControllingAgency;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class CreateNewMiscCodeType extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatNewMiscCodeType", excel);

	}

	@Test(dataProvider = "getData")
	public void AddContrllingAgency(String Testcase, String RunMode, String SBU, String CodeType, String CodeDescription, String ConutryCode) {
		
		
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		AgencyMiscCodeTypePage agmisc= new AgencyMiscCodeTypePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoControllingAgency();					
					Wait.waitfor(2);
					agmisc.addmiscagencytype();
					agmisc.AddbyParameters(ConutryCode,CodeType, CodeDescription );
					agmisc.savebutton();
					
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

	