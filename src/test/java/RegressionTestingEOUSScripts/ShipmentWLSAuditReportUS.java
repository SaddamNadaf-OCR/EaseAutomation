package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentWLSAuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ShipmentWLSAuditReportUS extends SeleniumTestBase{
	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShpWLSAuditReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShpWLSAuditReport(String Testcase, String RunMode, String SBU, String sbu, String ShpNo, String InvNo, 
			String DeliveryNo, String Exportcode, String CountryOfUltDest, String FromDate, String EndDate, String ExportFrom, 
			String ExportTo, String countryShippedFrom ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWLSAuditReportPage ShpWlsReport = new ShipmentWLSAuditReportPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.auditReports();
					HGExport.ShipWLSReport();
					ShpWlsReport.searchbyparametere (ShpNo,InvNo,DeliveryNo,Exportcode,CountryOfUltDest,FromDate,
							EndDate,ExportFrom,ExportTo,countryShippedFrom);
					ShpWlsReport.SearchBtn();
					ShpWlsReport.validateHeading();
					
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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}


}
