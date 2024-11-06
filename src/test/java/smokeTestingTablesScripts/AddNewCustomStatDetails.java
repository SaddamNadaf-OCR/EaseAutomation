package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.AgencyMiscCode;
import tablesClasses.CustomStatisticalDetailsPage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddNewCustomStatDetails  extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("Addcustomstatdetail", excel);

	}

	@Test(dataProvider = "getData") 
	public void addcustumstatdetail(String Testcase, String RunMode, String SBU, String Description, String Language, String Country) {
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		CustomStatisticalDetailsPage cust= new CustomStatisticalDetailsPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
//					homepage.movetocustomstatDetails();				
					Wait.waitfor(2);
					cust.addbutton();
					cust.ADDbyParameters( Description, Language,Country);
					cust.savebtn();
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


	
	