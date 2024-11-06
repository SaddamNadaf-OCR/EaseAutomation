package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LogisticsAndShippingAdvanceTrackingPage;
import globalExportClasses.LogisticsAndShippingBookedPackagesPage;
import globalExportClasses.LogisticsAndShippingPackagesAndRatesPage;
import globalExportClasses.LogisticsAndShippingPage;
import globalExportClasses.LogisticsAndShippingShipmentDetailsPage;
import globalExportClasses.LogisticsAndShippingSpecialServicesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateLogisticsAndShipping extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("Logistics", excel);
	}

	@Test(dataProvider = "getData")
	public void lodisticsAndShipment(String Testcase, String RunMode, String SBU, String FedExPackageType,
			String DHLPackageType) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LogisticsAndShippingPage lship = new LogisticsAndShippingPage(driver, test);
		LogisticsAndShippingShipmentDetailsPage LSDetails = new LogisticsAndShippingShipmentDetailsPage(driver, test);
		LogisticsAndShippingSpecialServicesPage LSSServices = new LogisticsAndShippingSpecialServicesPage(driver, test);
		LogisticsAndShippingPackagesAndRatesPage LSPacking = new LogisticsAndShippingPackagesAndRatesPage(driver, test);
		LogisticsAndShippingBookedPackagesPage LSBooked = new LogisticsAndShippingBookedPackagesPage(driver, test);
		LogisticsAndShippingAdvanceTrackingPage LSTracking = new LogisticsAndShippingAdvanceTrackingPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.clickLogistic();
				//	lship.clickShipNo();
					LSDetails.selctFDPT(FedExPackageType, DHLPackageType);
					LSDetails.clickSave();
					LSDetails.clickSService();
					LSSServices.titleDisplayedLSSS();
					LSSServices.clickPackingRate();
					LSPacking.titleDisplayedPacking();
					LSPacking.clickBooked();
					LSBooked.titleDisplayedLSBookingDetails();
					LSBooked.clickTracking();
					LSTracking.titleDisplayedLSTracking();
					LSTracking.clickDashBoardICon();

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
