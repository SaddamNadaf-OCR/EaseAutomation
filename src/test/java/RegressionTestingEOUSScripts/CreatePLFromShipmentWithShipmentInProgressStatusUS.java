package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewPackingListPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreatePLFromShipmentWithShipmentInProgressStatusUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePLShipInProgressStatus", excel);
	}

	@Test(dataProvider = "getData")
	public void PLFromShipStatusApproved(String Testcase, String RunMode, String SBU, String ShipWorkStatus, String emailID) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		PackingListPage PL = new PackingListPage(driver, test);
		CreateNewPackingListPage Create_NewPL = new CreateNewPackingListPage(driver, test);
		ResultPackingListPage ResultPL = new ResultPackingListPage(driver, test);
		ShipmentPage ShipPage = new ShipmentPage(driver, test);
		ResultShipmentPage ResultShipPage = new ResultShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(3);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.addPLFromShipment();
					// ShipPage.enterShipNo(shipmnetID);
					ShipPage.shipworkStatus(ShipWorkStatus);
					ShipPage.shipment_SearchBtn();
					ResultShipPage.select_ShipmentNo();
					ResultShipPage.select_SysGenNum();
					ResultShipPage.createPLFromSelectedShipmentBtn();
					String successPL =	ResultShipPage.fetch_PLFromSelectedShipNum();
					ResultShipPage.closePopUp();
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.enter_PackingListNo(successPL);
					PL.search();
					ResultPL.click_PLNo(successPL);
					Create_NewPL.entityScreeningIcon();
					Create_NewPL.generateDocIcon();
					Create_NewPL.sendEmailWithLink(emailID);
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
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
