package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultAirContractHeaderPage;
import globalExportClasses.SearchAirContractHeaderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAirContract extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchAirContract", excel);
	}

	@Test(dataProvider = "getData")
	public void searchAirContract(String Testcase, String RunMode, String SBU, String SBUCode, String contractCode, 
			String DepartureCode, String DestinationCode, String FreightForwarder, String CarrierCode, String CreatedBy, 
			String SortBy, String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAirContractHeaderPage searchAC = new SearchAirContractHeaderPage(driver, test);
		ResultAirContractHeaderPage resultAC = new ResultAirContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.airContract();
					searchAC.searchbyParameters(SBUCode, contractCode, DepartureCode, DestinationCode, FreightForwarder, CarrierCode, CreatedBy, SortBy, Direction);
					searchAC.search();
					resultAC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
