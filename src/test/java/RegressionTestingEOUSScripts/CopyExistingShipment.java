package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Copy Existing Shipment
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
import globalExportClasses.CopyShipmentPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditOrderItemPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CopyExistingShipment extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyExistingShipment", excel);
	}

	@Test(dataProvider = "getData")
	public void copyExistingShipment(String Testcase, String RunMode, String SBU, String shipNum, String ShipWorkStatus, 
			String OrderNO, String RequestorReviewer, String ShippingDeptReviewer, String ExportComplianceReviewer, 
			String TransportGatekeeperExportOps, String ShippingReviewStat)	throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage shipmentpage = new ShipmentPage(driver,test);
		ResultShipmentPage resultpage = new ResultShipmentPage(driver, test);
		CopyShipmentPage copypage = new CopyShipmentPage(driver, test);
		EditShipmentItemsPage orderNo = new EditShipmentItemsPage(driver, test);
		EditOrderItemPage itemPage = new EditOrderItemPage(driver,test);
		EditShipmentReviewerDetailsPage review = new EditShipmentReviewerDetailsPage(driver,test);
		CreateNewShipmentPage create = new CreateNewShipmentPage(driver, test);

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
					shipmentpage.enter_ShpNo(shipNum);
					shipmentpage.shipworkStatus(ShipWorkStatus);
					shipmentpage.shipment_SearchBtn();
					resultpage.copyIcon();
					Wait.waitfor(3);
					copypage.save();
					copypage.ultimateDestination();
					copypage.additionalTransaction();
					copypage.itemsection();
					orderNo.click_OrderNo(OrderNO);
					itemPage.heading();
					itemPage.saveandreturn();
					copypage.additionalTransaction();
					Wait.waitfor(2);
					copypage.reviwerection();
					review.add_ShipReviewDetails(RequestorReviewer, ShippingDeptReviewer, ExportComplianceReviewer, TransportGatekeeperExportOps);
					review.click_save();
					copypage.additionalTransaction();
					copypage.shipmentFormSection();
					create.FTA();
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
