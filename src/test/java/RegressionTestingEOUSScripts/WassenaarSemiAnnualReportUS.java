package RegressionTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.SearchWassenaarSemiAnnualReportPage;
import authorizationManagementClasses.WASSENAARSEMIANNUALREPORTPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WassenaarSemiAnnualReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("WassenaarSemiAnnualReport", excel);
	}

	@Test(dataProvider = "getData")
	public void wassenaarSemiAnnualReport(String TestCases, String RunMode, String SBU, String SBUCode,
			String ShipmentWorkStatus, String shipmentNo, String ExporterCode, String DateOfExportFrom,
			String DateOfExportTo, String ECCNCategory, String Exemption, String ProductFamily, String Program,
			String UltimateConsignee, String CountrysOfUltDestination, String Region, String Site) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		// HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchWassenaarSemiAnnualReportPage search = new SearchWassenaarSemiAnnualReportPage(driver, test);
		WASSENAARSEMIANNUALREPORTPage report = new WASSENAARSEMIANNUALREPORTPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_WassenaarReports();
					search.wassenaarSearchCriteria(SBUCode, ShipmentWorkStatus, shipmentNo, ExporterCode,
							DateOfExportFrom, DateOfExportTo, ECCNCategory, Exemption, ProductFamily, Program,
							UltimateConsignee, CountrysOfUltDestination, Region, Site);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
					//report.IconsDisplay();
					Wait.waitfor(2);
					HGExport.return_ExportHome();
				} else {
					testFail();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			HGExport.return_ExportHome();
			testFail();
		}
	}
}