package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewAirContractHeaderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultAirContractHeaderPage;
import globalExportClasses.SearchAirContractHeaderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class EditAirContract extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EditAirContract", excel);
	}
	
	@Test(dataProvider = "getData")
	public void editAirContract(String Testcase, String RunMode, String SBU, String ContractCode, String SubCode)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAirContractHeaderPage searchAC = new SearchAirContractHeaderPage(driver, test);
		CreateNewAirContractHeaderPage createAC = new CreateNewAirContractHeaderPage(driver, test);
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
					searchAC.contractCode(ContractCode);
					searchAC.search();
					resultAC.contractCodeEdit(ContractCode);
					createAC.subcode(SubCode);
					String cc =createAC.getcontractCode();
					createAC.saveandReturn();
					resultAC.newSearch();
					searchAC.contractCode(cc);
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
