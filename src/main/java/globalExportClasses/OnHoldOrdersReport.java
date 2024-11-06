package globalExportClasses;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class OnHoldOrdersReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchOnHoldReport", excel);
	}

	@Test(dataProvider = "getData")
	public void onholdreport (String Testcase, String RunMode, String SBU, String Sbu, String InvoiceNo, String ShipmentNo, String CountryofultDest, String PartNo, String partytype) 
		throws Exception {

			HomeGExportPage HGExport = new HomeGExportPage(driver, test);
			ReportInvoiceOnHoldPage reponhld=new ReportInvoiceOnHoldPage(driver, test);
			ResultInvoiceReportOnHoldPage rsltonhld=new ResultInvoiceReportOnHoldPage(driver, test);
			

			// **********Test steps execution ***************************
			try {
				if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
					throw new SkipException("Skipping the test");
				} else {
					if (RunMode.equalsIgnoreCase("y")) {
						test.log(LogStatus.INFO, Testcase);
						HGExport.moveTo_SBUSelection(SBU);
						HGExport.moveToReports();
						HGExport.ReportInvoiceOnHold();
						Wait.waitfor(2);
						reponhld.parameter(Sbu, InvoiceNo, ShipmentNo, CountryofultDest, PartNo, partytype);
						Wait.waitfor(2);
						reponhld.search();
						Wait.waitfor(5);
						rsltonhld.titleIsDisplayed();

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

	