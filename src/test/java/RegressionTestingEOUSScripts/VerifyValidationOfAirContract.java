package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Verify Validation Of Air Contract
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewAirContractHeaderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchAirContractHeaderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyValidationOfAirContract extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AirContractValidation", excel);
	}
	
	@Test(dataProvider = "getData")
	public void validateErrorMsgAirContract(String Testcase, String RunMode, String SBU)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAirContractHeaderPage searchAC = new SearchAirContractHeaderPage(driver, test);
		CreateNewAirContractHeaderPage createAC = new CreateNewAirContractHeaderPage(driver, test);

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
					createAC.save();
					createAC.errorValidation();
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