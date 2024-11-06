package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FileAttachToShipment extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FileAttachToShipment", excel);
	}

	@Test(dataProvider = "getData")
	public void searchshipmentResult(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo,
			String ExporterCountry, String ShipmentWorkStatus, String UltDestination, String DateOfExportFrom,
			String ModeofTransport, String LSStatus, String DocType, String DocDesc, String UploadfileName,
			String SendTo, String EmailCC, String EmailSubject, String EmailBody) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		ResultShipmentPage resultShip = new ResultShipmentPage(driver, test);
		ShipmentPage shpPage = new ShipmentPage(driver, test);
		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Wait.waitfor(2);
					shpPage.sbu_code(SBUcode);
					Wait.waitfor(2);

					Shipment.searchShipmentDetails(ShipmentNo, ExporterCountry, ShipmentWorkStatus, UltDestination,
							DateOfExportFrom, ModeofTransport, LSStatus);
					Shipment.click_Search();
					Wait.waitfor(3);
					resultShip.shipmentResult();
					Wait.waitfor(2);
					resultShip.uploadfileicon();
					Wait.waitfor(2);
					resultShip.add_DocumentandClickEmail(DocType, DocDesc, UploadfileName);
					Wait.waitfor(2);
					resultShip.uploadsuccessmessage();
					Wait.waitfor(2);
					resultShip.emailrelfilebtn();
					Wait.waitfor(2);
					resultShip.sendemail(SendTo, EmailCC, EmailSubject, EmailBody);
					resultShip.emailsendsuccessmsg();
					Wait.waitfor(2);
					resultShip.deleteAttachFilebtn();
					Wait.waitfor(1);
					driver.switchTo().alert().accept();
					Wait.waitfor(1);
					resultShip.delFilemsgCapture();
					Wait.waitfor(1);
					resultShip.popupclose();

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
