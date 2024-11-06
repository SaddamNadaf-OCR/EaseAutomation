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
import utilities.Wait;

public class AddAirCantract extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddAirContract", excel);
	}
	
	@Test(dataProvider = "getData")
	public void addAirContract(String Testcase, String RunMode, String SBU, String ContractCode, String SubCode, String DepartureCode, 
			String DestinationCode, String FreightForwarder, String CarrierCode, String CombineWeight)throws Exception {

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
					searchAC.addAirContract();
					createAC.titleisDisplayed();
					createAC.addParameters(ContractCode, SubCode, DepartureCode, DestinationCode, FreightForwarder, CarrierCode, CombineWeight);
					Wait.waitfor(2);
					String cc =createAC.getcontractCode();
					createAC.saveandReturn();
					searchAC.addAirContract();
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