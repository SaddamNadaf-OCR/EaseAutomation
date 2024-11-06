package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewInvoicePage;
import globalExportClasses.EditInvoiceCanadianCustomsDetailsPage;
import globalExportClasses.EditInvoiceInstructionsAndNotesPage;
import globalExportClasses.EditInvoiceItemsPage;
import globalExportClasses.EditInvoiceMiscellaneousDetailsPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoiceCreateNewOrderItemPage;
import globalExportClasses.InvoiceOrderItemHazmatDetailsPage;
import globalExportClasses.InvoiceOrderItemSubComponentPage;
import globalExportClasses.InvoiceOrderItemVehicleInformationPage;
import globalExportClasses.InvoicePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyDPLScreeningFunctionalityInvOrderUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifyDPLScreeningINV", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyDPLScreeningInvOrder(String Testcase, String RunMode, String SBU, String SBUCode, String orderNo,
			String AssignedTo, String ExportDate, String ultDest, String ModeOfTransport, String Program,
			String Segment, String Site, String ChargeNo, String ContractNo, String OrderCategory, String Priority,
			String RMANo, String SalesOrderNo, String SalesOrderDate, String CustOrderNo, String CustOrderDate,
			String LOC, String LOCExpiryDate, String NotifyParty, String Payment, String PaymentText, String Incoterms,
			String IncotermPlace, String EntityType, String entityCode, String Status, String ShipTo, String ShipToCode, String ShipStatus) {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		CreateInvoicePage Create_Inv = new CreateInvoicePage(driver, test);
		CreateNewInvoicePage Create_NInv = new CreateNewInvoicePage(driver, test);
		EditInvoiceItemsPage Edit_InvItem = new EditInvoiceItemsPage(driver, test);
		InvoiceCreateNewOrderItemPage Invoice_Create_NO_Item = new InvoiceCreateNewOrderItemPage(driver, test);
		InvoiceOrderItemHazmatDetailsPage HazmatDetails = new InvoiceOrderItemHazmatDetailsPage(driver, test);
		InvoiceOrderItemSubComponentPage SubCompDetails = new InvoiceOrderItemSubComponentPage(driver, test);
		InvoiceOrderItemVehicleInformationPage VehicleInfoDetails = new InvoiceOrderItemVehicleInformationPage(driver,
				test);
		EditInvoiceMiscellaneousDetailsPage MiscelleneousDetails = new EditInvoiceMiscellaneousDetailsPage(driver,
				test);
		EditInvoiceCanadianCustomsDetailsPage CanadianCustDetails = new EditInvoiceCanadianCustomsDetailsPage(driver,
				test);
		EditInvoiceInstructionsAndNotesPage InvoiceInstructionDetails = new EditInvoiceInstructionsAndNotesPage(driver,
				test);
		EditInvoiceOrderFormPage orderForm = new EditInvoiceOrderFormPage(driver, test);

		// ResultInvoiceOrderPage ResultIO = new ResultInvoiceOrderPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.click_AddInvoiceBtn();
					Create_Inv.select_SBUCode(SBUCode);
					Create_NInv.invoice_Details(orderNo, AssignedTo, ExportDate, ultDest, ModeOfTransport);
					Create_NInv.addOrderDetails(Program, Segment, Site, ChargeNo, ContractNo, OrderCategory, Priority,
							RMANo, SalesOrderNo, SalesOrderDate, CustOrderNo, CustOrderDate, LOC, LOCExpiryDate,
							NotifyParty);
					Create_NInv.payment(Payment, PaymentText, Incoterms, IncotermPlace);
					Create_NInv.addPartiesToTheTransaction(EntityType, entityCode, Status);
					Create_NInv.EntityScreenStatusOnHold();
					Create_NInv.addShipDetailsPartiesToTheTransaction(ShipTo, ShipToCode, ShipStatus);
					Create_NInv.EntityScreenStatusApproved();

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
