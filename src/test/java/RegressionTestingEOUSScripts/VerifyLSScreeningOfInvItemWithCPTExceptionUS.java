package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewInvoicePage;
import globalExportClasses.EditInvoiceItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoiceCreateNewOrderItemPage;
import globalExportClasses.InvoicePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyLSScreeningOfInvItemWithCPTExceptionUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifyLSCPTExpInv", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyInvItemLicenseScreeningCPTExecption(String Testcase, String RunMode, String SBU, String SBUCode,
			String orderNo, String AssignedTo, String ExportDate, String ultDest, String ModeOfTransport, String BillTo,
			String BillToCode, String BillStatus, String ShipTo, String ShipToCode, String ShipStatus,
			String FreightForwarder, String FrghtFwdCode, String FFStatus, String PartNo, String PartNum, String Desc,
			String SourceSystemPartNumber, String POLineNo, String ScheduleAgreement, String SerialNumbers,
			String PONumber, String CustomerPartNumber, String SalesOrderNum, String SalesOrderItemNo,
			String DeliveryOrderNo, String DeliveryOrderItemNo, String PartCOO, String Vendor, String VendorPN,
			String NetOrderNo, String EngineLine, String WBS, String MTFNumber, String Remarks, String OrgPONo,
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency,
			String RepairValue, String DiscountRate, String WholesaleRate, String BIS, String LicenseExp) {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		CreateInvoicePage Create_Inv = new CreateInvoicePage(driver, test);
		CreateNewInvoicePage Create_NInv = new CreateNewInvoicePage(driver, test);
		EditInvoiceItemsPage Edit_InvItem = new EditInvoiceItemsPage(driver, test);
		InvoiceCreateNewOrderItemPage Invoice_Create_NO_Item = new InvoiceCreateNewOrderItemPage(driver, test);

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
					// Create_NInv.addOrderDetails(Program, Segment, Site, ChargeNo, ContractNo,
					// OrderCategory, Priority,
					// RMANo, SalesOrderNo, SalesOrderDate, CustOrderNo, CustOrderDate, LOC,
					// LOCExpiryDate,
					// NotifyParty);
					// Create_NInv.payment(Payment, PaymentText, Incoterms, IncotermPlace);
					Create_NInv.addPartiesToTheTransaction(BillTo, BillToCode, BillStatus, ShipTo, ShipToCode,
							ShipStatus, FreightForwarder, FrghtFwdCode, FFStatus);
					Create_NInv.skipExportAuthToNo();
					// Create_NInv.additionalCharge(ChargeDesc, Amount, ChargingAccnt, GLA);
					// Create_NInv.containerDetails(containerID, SealNo, ConsoPackNo, RadioActAmnt,
					// DryIceQty, GrossCartWt,
					// PackType, Model, TareWt, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet,
					// SKU, Class,
					// BOLText);
					// Create_NInv.returnPack(PackId, ContainerID, NoOfPack, TypeOfPack, UnitPrice,
					// COO);
					String InvOrderNo = Create_NInv.gettingInvoiceOrderNo();
					Create_NInv.saveBtn();
					// Create_NInv.validate_Icons();
					Create_NInv.select_Items();
					Edit_InvItem.addOrder_Items();
					Invoice_Create_NO_Item.generalInformation(PartNo, PartNum, Desc, SourceSystemPartNumber, POLineNo,
							ScheduleAgreement, SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNum,
							SalesOrderItemNo, DeliveryOrderNo, DeliveryOrderItemNo, PartCOO, Vendor, VendorPN,
							NetOrderNo, EngineLine, WBS, MTFNumber, Remarks, OrgPONo);
					Invoice_Create_NO_Item.qytPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
					// Invoice_Create_NO_Item.classificationInfoUS(ControllingAgency,
					// ExportClassification);
					// Invoice_Create_NO_Item.exportAuthInfo(AuthNo, AuthItemNo, AuthType,
					// AuthTxnType, AuthExpiryDate,
					// SMEIndicator);
					Invoice_Create_NO_Item.selectBISLicenseExp(BIS);
					Invoice_Create_NO_Item.selectLicenseException(LicenseExp);
					Invoice_Create_NO_Item.saveBtn();
					Invoice_Create_NO_Item.verifyLicenseException();
					Invoice_Create_NO_Item.closebtn();
					Edit_InvItem.validateItemGrid(InvOrderNo);

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
