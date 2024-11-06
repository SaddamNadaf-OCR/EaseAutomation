package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.AddNewMasterAirwayBillPage;
import globalExportClasses.HomeGExportPage;

import globalExportClasses.SearchMasterAirwayBillPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddMasterAirwaybill extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddMasterAirwaybill", excel);
	}
	@Test(dataProvider = "getData")
	public void addMasterAirwaybill (String Testcase, String RunMode, String MAWBNO, String FFCODE, String ConsigneeCode, String CarrierCode) throws Exception { 
		HomeGExportPage HGExport = new HomeGExportPage (driver, test);
		SearchMasterAirwayBillPage search = new SearchMasterAirwayBillPage (driver, test);
		AddNewMasterAirwayBillPage Add = new AddNewMasterAirwayBillPage (driver, test);
		
		
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
					search.AddnewMAWB();
					Wait.waitfor(3);
					Add.mawbADD(MAWBNO, FFCODE, ConsigneeCode);
					Wait.waitfor(3);
					Add.carrier(CarrierCode);
					Wait.waitfor(3);
				    Add.charges();
				  
				    
					
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



