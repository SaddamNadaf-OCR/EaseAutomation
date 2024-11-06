package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewInvoicePage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditInvoiceCanadianCustomsDetailsPage;
import globalExportClasses.EditInvoiceInstructionsAndNotesPage;
import globalExportClasses.EditInvoiceItemsPage;
import globalExportClasses.EditInvoiceMiscellaneousDetailsPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoiceCreateNewOrderItemPage;
import globalExportClasses.InvoiceOrderItemHazmatDetailsPage;
import globalExportClasses.InvoiceOrderItemSubComponentPage;
import globalExportClasses.InvoiceOrderItemVehicleInformationPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyAddCopyDeleteDuplicateFeatureForInvCartonUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCopyDeleteDupInvCarton", excel);
	}

	@Test(dataProvider = "getData")
	public void AddCopyDupDelInvCarton(String Testcase, String RunMode, String SBU, String InvoiceNo, String workStatus) {

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
		ResultInvoiceOrderPage ResultInv = new ResultInvoiceOrderPage(driver, test);

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
					Create_NInv.ContDetails();
//					Inv.click_AddInvoiceBtn();
//					Create_Inv.select_SBUCode(SBUCode);
//					Create_NInv.invoice_Details(orderNo, AssignedTo, ExportDate, ultDest, ModeOfTransport);
//					Create_NInv.addOrderDetails(Program, Segment, Site, ChargeNo, ContractNo, OrderCategory, Priority,
//							RMANo, SalesOrderNo, SalesOrderDate, CustOrderNo, CustOrderDate, LOC, LOCExpiryDate,
//							NotifyParty);
//					Create_NInv.payment(Payment, PaymentText, Incoterms, IncotermPlace);
//					Create_NInv.addPartiesToTheTransaction(BillTo, BillToCode, BillStatus, ShipTo, ShipToCode,
//							ShipStatus, FreightForwarder, FrghtFwdCode, FFStatus);
//					Create_NInv.containerDetails(containerID, SealNo, ConsoPackNo, RadioActAmnt, DryIceQty, GrossCartWt,
//							PackType, Model, TareWt, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKU, Class,
//							BOLText);
//					Create_NInv.saveBtn();
//					Create_NInv.select_Items();
//					Edit_InvItem.addOrder_Items();
//					Invoice_Create_NO_Item.generalInformation(PartNo, PartNum, Desc, SourceSystemPartNumber, POLineNo,
//							ScheduleAgreement, SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNum,
//							SalesOrderItemNo, DeliveryOrderNo, DeliveryOrderItemNo, PartCOO, Vendor, VendorPN,
//							NetOrderNo, EngineLine, WBS, MTFNumber, Remarks, OrgPONo);
//					Invoice_Create_NO_Item.qytPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
//							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
//					Invoice_Create_NO_Item.classificationInfoUS(ControllingAgency, ExportClassification, HTS,
//							PrimaryUOM);
//					Invoice_Create_NO_Item.exportAuthInfo(AuthNo, AuthItemNo, AuthType, AuthTxnType, AuthExpiryDate,
//							SMEIndicator);
//					Invoice_Create_NO_Item.enterPartCOO(PartCOOrigin);
//					Invoice_Create_NO_Item.saveBtn();
//					Invoice_Create_NO_Item.closebtn();
//					Edit_InvItem.goToInvoiceOrderForm();
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
