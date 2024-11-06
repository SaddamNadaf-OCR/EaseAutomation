package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Copy Ocean Contract 
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
import globalExportClasses.CreateNewOceanContractHeaderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultOceanContractPage;
import globalExportClasses.SearchOceanContractPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyCopyOceanContract extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyOceanContract", excel);
	}
	
	@Test(dataProvider = "getData")
	public void copyOceanContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchOceanContractPage searchGC = new SearchOceanContractPage(driver, test);
		ResultOceanContractPage resultGC = new ResultOceanContractPage(driver, test);
		CreateNewOceanContractHeaderPage createGC = new CreateNewOceanContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.oceanContract();
					searchGC.contractCode(ContractCode);
					searchGC.search();
					resultGC.copyIcon();
					createGC.contractCodeEdit(ContractCode);
					String CC=createGC.getcontractCode();
					createGC.saveandReturn();
					resultGC.newSearch();
					searchGC.contractCode(CC);
					searchGC.search();
					resultGC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
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
