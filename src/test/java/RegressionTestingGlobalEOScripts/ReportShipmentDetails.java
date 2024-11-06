package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportShipmentDetailsPage;
import globalExportClasses.ResultShipmentReportDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentDetails extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentDetails (String Testcase ,String RunMode,String Sbu, String ShipmentNo, String WorkStatus, String UltDestination, 
			String AESStatus, String Invoice_No) throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentDetailsPage search = new ReportShipmentDetailsPage (driver, test);
		ResultShipmentReportDetailsPage result = new ResultShipmentReportDetailsPage (driver, test);
		
		// **********Test steps execution ***************************
				try {
					if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
						throw new SkipException("Skipping the test");
					} else {
						if (RunMode.equalsIgnoreCase("y")) {
							test.log(LogStatus.INFO, Testcase);
							Wait.waitfor(2);
							HGExport.moduleselection();
							Wait.waitfor(2);
							HGExport.ReportShipment();
							Wait.waitfor(2);
							search.parameter(Sbu,ShipmentNo,WorkStatus,UltDestination,AESStatus,Invoice_No);
							Wait.waitfor(2);
							search.search();
							Wait.waitfor(2);
							result.titleIsDisplayed();
							Wait.waitfor(2);
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


