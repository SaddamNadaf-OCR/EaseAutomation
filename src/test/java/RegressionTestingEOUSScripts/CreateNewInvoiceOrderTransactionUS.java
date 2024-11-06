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
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewInvoiceOrderTransactionUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewInvoiceOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void InvoiceOrder(String Testcase, String RunMode, String SBU, String SBUCode, String orderNo, String ExportDate, String ultDest, 
			String ModeOfTransport, String Program, String Segment, String Site, String ChargeNo, String ContractNo, String OrderCategory, 
			String Priority, String RMANo, String SalesOrderNo, String SalesOrderDate, String CustOrderNo, String CustOrderDate, String LOC, 
			String LOCExpiryDate, String NotifyParty, String Payment, String PaymentText, String Incoterms, String IncotermPlace, String BillTo, 
			String BillToCode, String BillStatus, String ShipTo, String ShipToCode, String ShipStatus, String FreightForwarder, String FrghtFwdCode, 
			String FFStatus, String ChargeDesc, String Amount, String ChargingAccnt, String GLA, String containerID, String SealNo, 
			String ConsoPackNo, String RadioActAmnt, String DryIceQty, String GrossCartWt, String PackType, String Model, String TareWt, 
			String DimensionUOM, String LenghtWidthHight, String WeightUOM, String GrossNet, String SKU, String Class, String BOLText, 
			String PackId, String ContainerID, String NoOfPack, String TypeOfPack, String UnitPrice, String COO, String PartNo, String PartNum, 
			String Desc, String SourceSystemPartNumber, String POLineNo, String ScheduleAgreement, String SerialNumbers, String PONumber, 
			String CustomerPartNumber, String SalesOrderNum, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo,
			String PartCOO, String Vendor, String VendorPN, String NetOrderNo, String EngineLine, String WBS, String MTFNumber, String Remarks, 
			String OrgPONo, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency, String RepairValue, 
			String DiscountRate, String WholesaleRate, String ControllingAgency, String ExportClassification, String HTS, String PrimaryUOM,
			String AuthNo, String AuthItemNo, String AuthType, String AuthTxnType, String AuthExpiryDate, String SMEIndicator, String AdditionalAuthNo, 
			String AdditionalAuthItemNo, String AuthTransType, String AddAuthType, String ControlAgency, String CountryOfIssue, String HUContainerID, 
			String HUNo, String HSLevel, String GrossWt, String NetWt, String MarkNos, String Dimension, String UOM, String NoPack, String AltUOM, 
			String Skids, String length, String width, String height, String Factor, String Cubic, String BatchNo, String BatchCOO, String BatchQty, 
			String BatchExpiryDate, String BatchSterilityDate, String ImportShipType, String ImportInvNo, String ImportIDNo, String DueDate, 
			String DutyReliefType, String inboundType, String ItemNo, String ReliefActivityType, String PackNote, String ContractNote, 
			String OracleAttachment, String DelAttachment, String hazmatID, String Regulation, String RegOption, String KindOfPack, String Packgrp, 
			String GrsWt, String Auth, String Techname, String SubRisk, String TransMode, String Cube, String NetWet, String SubCompNo, 
			String ContainerId, String ParentProdID, String SubCOO, String SerialID, String PrimQty, String SubUnitPrice, String SubProdDesc, 
			String VINProdID, String VINTitleNo, String VehicleTitleState, String CorrectionFlag, String ShippingPoint, String AirwayBillNumber, 
			String BillOfLading, String MaterialGroup, String Hazardous, String InBondCode, String BondNumber, String GrossWeight, String NetWeight, 
			String RoutingCode1, String RoutingCode2, String ShipmentType, String CertificateofRegistration, String Specify, String TransactionSMECode,
			String RegisterNo, String GLACode, String SourceCode, String ExporterCode, String OriginatorCode, String InvoiceInstructions, 
			String InvoiceInstNote, String InvoiceItemHeader, String InvoiceItemFooter, String InvoicePackingDetails, String InvoicePackingSheetNo, 
			String InvoiceNumberofPackingSheets, String IRequestorUserName, String IRequestorUserTitle, String IRequestorTelephone, 
			String IRequestorEmail, String IRequestorPickedBy, String IRequestorLoadedBy, String IRequestorCustomerServiceRep, String INNotes) {

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
					Create_NInv.invoice_Details(orderNo, "", ExportDate, ultDest, ModeOfTransport);
					Create_NInv.addOrderDetails(Program, Segment, Site, ChargeNo, ContractNo, OrderCategory, Priority,
							RMANo, SalesOrderNo, SalesOrderDate, CustOrderNo, CustOrderDate, LOC, LOCExpiryDate,
							NotifyParty);
					Create_NInv.payment(Payment, PaymentText, Incoterms, IncotermPlace);
					Create_NInv.addPartiesToTheTransaction(BillTo, BillToCode, BillStatus, ShipTo, ShipToCode,
							ShipStatus, FreightForwarder, FrghtFwdCode, FFStatus);
					Create_NInv.additionalCharge(ChargeDesc, Amount, ChargingAccnt, GLA);
					Create_NInv.containerDetails(containerID, SealNo, ConsoPackNo, RadioActAmnt, DryIceQty, GrossCartWt,
							PackType, Model, TareWt, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKU, Class,
							BOLText);
					 Create_NInv.returnPack(PackId, ContainerID, NoOfPack, TypeOfPack, UnitPrice,
					 COO);
					// String InvOrderNo = Create_NInv.gettingInvoiceOrderNo();
					Create_NInv.saveBtn();
					Create_NInv.validate_Icons();
					Create_NInv.select_Items();
					Edit_InvItem.addOrder_Items();
					Invoice_Create_NO_Item.generalInformation(PartNo, PartNum, Desc, SourceSystemPartNumber, POLineNo,
							ScheduleAgreement, SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNum,
							SalesOrderItemNo, DeliveryOrderNo, DeliveryOrderItemNo, PartCOO, Vendor, VendorPN,
							NetOrderNo, EngineLine, WBS, MTFNumber, Remarks, OrgPONo);
					Invoice_Create_NO_Item.qytPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
					Invoice_Create_NO_Item.classificationInfoUS(ControllingAgency, ExportClassification, HTS,
							PrimaryUOM);
					Invoice_Create_NO_Item.exportAuthInfo(AuthNo, AuthItemNo, AuthType, AuthTxnType, AuthExpiryDate,
							SMEIndicator);
					Invoice_Create_NO_Item.saveBtn();

					// Invoice_Create_NO_Item.classificationInfoSaveBtn();

					Invoice_Create_NO_Item.additionalAuthInfo(AdditionalAuthNo, AdditionalAuthItemNo, AuthTransType,
							AddAuthType, ControlAgency, CountryOfIssue);

					Invoice_Create_NO_Item.packingInfo(HUContainerID, HUNo, HSLevel, GrossWt, NetWt, MarkNos, Dimension,
							UOM, NoPack, AltUOM, Skids, length, width, height, Factor, Cubic);
					Invoice_Create_NO_Item.batchInfo(BatchNo, BatchCOO, BatchQty, BatchExpiryDate, BatchSterilityDate);
					Invoice_Create_NO_Item.customFilingInfo();
					Invoice_Create_NO_Item.tempExportInfo(ImportShipType, ImportInvNo, ImportIDNo, DueDate,
							DutyReliefType, inboundType, ItemNo, ReliefActivityType);
					Invoice_Create_NO_Item.notes(PackNote, ContractNote, OracleAttachment, DelAttachment);
					Invoice_Create_NO_Item.saveBtn();
					Invoice_Create_NO_Item.hazmatDetails();

					HazmatDetails.hazmatInfo(hazmatID, Regulation, RegOption, KindOfPack, Packgrp, GrsWt, Auth,
							Techname, SubRisk, TransMode, Cube, NetWet);
					HazmatDetails.hazmatSaveBtn();
					HazmatDetails.subComponentDetails();
					SubCompDetails.addSubCompBtn();
					SubCompDetails.addOrderItemSubCompUS(SubCompNo, ContainerId, ParentProdID, SubCOO, SerialID,
							PrimQty, SubUnitPrice, SubProdDesc);

					// SubCompDetails.closeSubCompBtn();

					SubCompDetails.vehicleInfoDetails();
					VehicleInfoDetails.addExportVehicleBtn();
					VehicleInfoDetails.addExportvehiclePopUp(VINProdID, VINTitleNo, VehicleTitleState, CorrectionFlag);
					VehicleInfoDetails.exportVehiclesaveBtn();
					VehicleInfoDetails.exportvehicleCloseBtn();
					VehicleInfoDetails.vehicleInfoCloseBtn();
					Edit_InvItem.additionalTransBtn();
					// Edit_InvItem.canadianCustoms();
					MiscelleneousDetails.addShipmentDetails(ShippingPoint, AirwayBillNumber, BillOfLading,
							MaterialGroup, Hazardous, InBondCode, BondNumber, GrossWeight, NetWeight, RoutingCode1,
							RoutingCode2, ShipmentType);
					MiscelleneousDetails.addCertificateOfReg(CertificateofRegistration, Specify);
					MiscelleneousDetails.addAccountingInfo(TransactionSMECode, RegisterNo, GLACode, SourceCode);
					MiscelleneousDetails.click_SaveMiscellaneousDetails();
					MiscelleneousDetails.canadianCustoms();
					 CanadianCustDetails.canadianCustDetails(ExporterCode, OriginatorCode);
					// CanadianCustDetails.saveBtn();
					 CanadianCustDetails.select_InvoiceInstructionsNotes();
					 InvoiceInstructionDetails.addInstructions(InvoiceInstructions,
					 InvoiceInstNote, InvoiceItemHeader,
					 InvoiceItemFooter, InvoicePackingDetails, InvoicePackingSheetNo,
					 InvoiceNumberofPackingSheets, IRequestorUserName, IRequestorUserTitle,
					 IRequestorTelephone,
					IRequestorEmail, IRequestorPickedBy, IRequestorLoadedBy,
					 IRequestorCustomerServiceRep,
					 INNotes);
					 InvoiceInstructionDetails.click_SaveInstructionAndNote();
					 InvoiceInstructionDetails.orderForm();
					 orderForm.getInvoiceNo();
					 String invoiceNo = orderForm.getInvoiceNo();
					 System.out.println("The invoice order number is : " +invoiceNo );
					 orderForm.getInvoiceStatus();
					 String invoiceStatus = orderForm.getInvoiceStatus();
					 System.out.println("The invoice order Status is : " +invoiceStatus );
					// Edit_InvItem.closeBtn();

					HGExport.return_ExportHome();

					// HGExport.OCR_HomePage_Invoice_Order();
					// * Inv.enter_InvoiceOrderNo(InvOrderNo);
					// Inv.click_SearchButton();
					// * ResultIO.click_InvoiceOrderNo(InvOrderNo);
					// */

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
