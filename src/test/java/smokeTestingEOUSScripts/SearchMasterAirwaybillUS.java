package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultMasterAirwayBillPage;
import globalExportClasses.SearchMasterAirwayBillPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchMasterAirwaybillUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchMasterAirwayBill", excel);
	}
	@Test(dataProvider = "getData")
	public void OceanBills (String Testcase, String RunMode, String sbu, String MAWBNO, String ConsigneeCode) throws Exception { 
		HomeGExportPage HGExport = new HomeGExportPage (driver, test);
		SearchMasterAirwayBillPage search = new SearchMasterAirwayBillPage (driver, test);
		ResultMasterAirwayBillPage result = new ResultMasterAirwayBillPage (driver, test);
		
		
		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
				
					HGExport.moduleselection();
					HGExport.MasterAirwaybill();
					Wait.waitfor(3);
					search.parameter(sbu, MAWBNO, ConsigneeCode);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					result.titleIsDisplayed();
					Wait.waitfor(3);
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
