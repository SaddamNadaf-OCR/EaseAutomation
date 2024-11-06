package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddShipmentAndEEITransactionsFromInvoiceUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddEEIFromInvoice", excel);
	}

	@Test(dataProvider = "getData")
	public void AddEEITransactionFromInv(String Testcase, String RunMode, String SBU, String InvoiceNo,	String workStatus, 
			String SBUcode, String InvShipmntNo, String ReliefAuthorNo, String RfDueDate, String ReliefActType,
			String ExporterCode, String OrderNO, String dutyReliefAuth, String dutyReliefType, String ShippingDeptReviewer, 
			String ShipRegion, String ShipSite, String ExportComplianceReviewer, String ExportRegion, String ExportSite, 
			String TransportGatekeeperExportOps, String TransRegion, String TransSite, String ShippingReviewStat, String ExportApproved, 
			String ShipmentApproved, String Booked, String AES, String Shipped) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		ResultInvoiceOrderPage ResultInv = new ResultInvoiceOrderPage(driver, test);
		EditInvoiceOrderFormPage EditInvoiceOrder = new EditInvoiceOrderFormPage(driver, test);
		CreatShipmentPage CreateShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShip = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipmentItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage Orderitem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage reviewDetails = new EditShipmentReviewerDetailsPage(driver, test);
		EditElectronicExportInformationTransactionsPage EditEEI = new EditElectronicExportInformationTransactionsPage(
				driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.approvedInvoice(InvoiceNo, workStatus);
					Inv.click_SearchButton();
					ResultInv.clickInvoiceNo();
					EditInvoiceOrder.addShipment();
					CreateShip.selectSBUcode(SBUcode);
					CreateShip.create_Shp();
					CreateNewShip.enter_ShipNo(InvShipmntNo);
					CreateNewShip.dutyReliefAuth_Invoice(ReliefAuthorNo, RfDueDate, ReliefActType);
					CreateNewShip.addExporterDetails(ExporterCode);
					CreateNewShip.click_SaveBtn();
					CreateNewShip.select_additems();
					ShipmentItem.click_OrderNo(OrderNO);
					Orderitem.enter_DutyReliefDetails(dutyReliefAuth, dutyReliefType);
					ShipmentItem.click_AdditionalTransacDetails();
					reviewDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite,
							ExportComplianceReviewer, ExportRegion, ExportSite, TransportGatekeeperExportOps,
							TransRegion, TransSite);
					reviewDetails.click_save();
					reviewDetails.addTransaction();
					CreateNewShip.changeStatusToShipReview(ShippingReviewStat);
					Wait.waitfor(20);
					CreateNewShip.customFilingView();

					/*EditEEI.EEIHeading();
					EditEEI.AESStatus();
					EditEEI.AdditionalTransaction();
					EditEEI.ShipDetails();*/
					CreateNewShip.changeStatusToExportApproved(ExportApproved);
					CreateNewShip.changeStatusToShipmentApproved(ShipmentApproved);
					CreateNewShip.changeStatusToBooked(Booked);
					/*CreateNewShip.select_CustomsFilingView();
					EditEEI.verifyBookedStatus();
					EditEEI.AES(AES);
					EditEEI.SaveBtn();*/
					EditEEI.AdditionalTransaction();
					EditEEI.ShipDetails();
					CreateNewShip.changeStatusToShipped(Shipped);
					CreateNewShip.select_CustomsFilingView();
				//	EditEEI.AESReported();

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
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}