package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewOrderItemSubComponentPage;
import globalExportClasses.CreateNewPackingListItemPage;
import globalExportClasses.CreateNewPackingListPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.CreatePackingListPage;
import globalExportClasses.EditInvoiceInstructionsAndNotesPage;
import globalExportClasses.EditInvoiceMiscellaneousDetailsPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.EditOrderItemVehicleInformationPage;
import globalExportClasses.EditShipmentAssociatedLinkedOrdersPage;
import globalExportClasses.EditShipmentBookingDeatilsPage;
import globalExportClasses.EditShipmentHazmatDetailsPage;
import globalExportClasses.EditShipmentInstructionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyPLFromShipmentWithApprovedStatusUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePLFromShipApprovedStatus", excel);
	}

	@Test(dataProvider = "getData")
	public void PLFromShipStatusApproved(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo,
			String UltDestination, String DateOfExport, String SLIDate, String ProductFamily, String MotId,
			String DateofArrival, String ReportMonthAndYear, String DutyReliefType, String ReliefAuthorizationNo,
			String ReliefActivityType, String DueDate, String ExporterCode, String ConsigneeId, String FFCode,
			String IntConsigneePartyType, String PartNo, String SourceSystemPartNumber, String POLineNo,
			String ScheduleAgreement, String SerialNumbers, String PONumber, String CustomerPartNumber,
			String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo,
			String Vendor, String VendorPN, String NetOrderNo, String EngineLine, String WBS, String MTFNumber,
			String Remarks, String OrgPONo, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate,
			String ControllingAgencycode, String ExportClassificationItem, String HtsAndPrimaryUMO,
			String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM, String ImportHTS, String ImportUOM,
			String USExportECCN, String StatisticalCode, String BISLicenseException, String AuthorisationNo,
			String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode,
			String EUSNo, String SMEIndicator, String PrCoo, String SpecialInstructions,
			String ShipmentSpecialInstructions, String AttachedDocuments, String ExemptionStatementRoutingInfo,
			String CustPONo, String DestinationControlStatements, String EEIHeader, String EEIFooter,
			String EEIDOCHeader, String EEIDOCFooter, String EEIDOSHeader, String EEIDOSFooter,
			String ComplianceCertificateText, String InvoiceNo, String EntityType, String AddPartyConsigneeID,
			String ShippingDeptReviewer, String ShipRegion, String ShipSite, String ExportComplianceReviewer,
			String ExportRegion, String ExportSite, String TransportGatekeeperExportOps, String TransRegion,
			String TransSite, String ShippingReviewStat, String ExportApproved, String ShipmentApproved) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);

		CreateNewOrderItemSubComponentPage ItemSubComponent = new CreateNewOrderItemSubComponentPage(driver, test);
		EditOrderItemVehicleInformationPage ItemVehicleInfo = new EditOrderItemVehicleInformationPage(driver, test);
		EditShipmentBookingDeatilsPage BookingDetails = new EditShipmentBookingDeatilsPage(driver, test);
		EditShipmentHazmatDetailsPage HazmatDetails = new EditShipmentHazmatDetailsPage(driver, test);
		EditShipmentInstructionsPage Instruction = new EditShipmentInstructionsPage(driver, test);
		EditInvoiceOrderFormPage Invoice = new EditInvoiceOrderFormPage(driver, test);
		EditInvoiceMiscellaneousDetailsPage Misc = new EditInvoiceMiscellaneousDetailsPage(driver, test);
		EditInvoiceInstructionsAndNotesPage Instructions = new EditInvoiceInstructionsAndNotesPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		EditShipmentAssociatedLinkedOrdersPage LinkedOrd = new EditShipmentAssociatedLinkedOrdersPage(driver, test);
		EditShipmentReviewerDetailsPage ReviewerDetails = new EditShipmentReviewerDetailsPage(driver, test);
		EditShipmentItemsPage EditShipItem = new EditShipmentItemsPage(driver, test);
		
		PackingListPage PL = new PackingListPage(driver, test);
		CreatePackingListPage Create_PL = new CreatePackingListPage(driver, test);
		CreateNewPackingListPage Create_NewPL = new CreateNewPackingListPage(driver, test);
		ResultPackingListPage ResultPL = new ResultPackingListPage(driver, test);
		CreateNewPackingListItemPage PLItem = new CreateNewPackingListItemPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
//					Shipment.sbu_code(SBUcode);
//					Shipment.workStatus(ShipmentWorkStatus);
//					Shipment.click_Search();
//					result.click_ShipmentNo(ShipmentNO);
//					CreateNewShp.get_shipmentID();
//					String shipId = CreateNewShp.get_shipmentID();
//					CreateNewShp.ShipPagecloseBtn();
//					HGExport.return_ExportHome();
//					HGExport.OCR_HomePage_PackingList();
//					PL.shipNum(shipmentNum);
//					PL.search();
					
					
					Shipment.click_AddShipment();
					CreatShip.select_SBUcode(SBUcode);
					CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, DateOfExport, "", SLIDate, "", "", "",
							ProductFamily, MotId, DateofArrival, ReportMonthAndYear, DutyReliefType,
							ReliefAuthorizationNo, ReliefActivityType, DueDate);
					CreateNewShp.partyToTheTransaction(ExporterCode, AddPartyConsigneeID, FFCode,
							IntConsigneePartyType);
					String shipmnetID = CreateNewShp.get_shipmentID();
					// String CEF = CreateNewShp.get_CountryShippedFrom();
					// CreateNewShp.addTravelerDetails(TravelerUserFirstName, TravelerName,
					// TravelerEmail, TravelerPhone);
					// CreateNewShp.addMiscellaneousInfo(FreightChargesPaidBY, CustomDutiesPaidBy,
					// ForeignVatPaidBy,
					// CostCeneterNo, LineOfBusinessSupport);
					// CreateNewShp.addEquipment(EquipmentNo, SealNo);
					// CreateNewShp.addContainerPackingDetails(MarkingsContainerID, SealNumbers,
					// ConsolidatedPackNumber,
					// HazmatHazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType,
					// Model,
					// TareWeight, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity,
					// HazmatClass,
					// BOLText);
					// CreateNewShp.validateContainerPackingDeatils(MarkingsContainerID);
					CreateNewShp.select_additems();
					ShipItem.click_AddItem();
					// NewItem.typeDesc(ProductDescription);
					NewItem.AddGeneralInformation(PartNo, SourceSystemPartNumber, POLineNo, ScheduleAgreement,
							SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNo, SalesOrderItemNo,
							DeliveryOrderNo, DeliveryOrderItemNo, Vendor, VendorPN, NetOrderNo, EngineLine, WBS,
							MTFNumber, Remarks, OrgPONo);
					// NewItem.enterPrCoo(PrCoo);
					NewItem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
					NewItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN,
							StatisticalCode);
					NewItem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo, AuthorisationItemNo,
							InternalAuthNo, AuthorisationExpiryDate, MLCategoryCode, EUSNo, SMEIndicator);
					NewItem.click_SaveBtn();
					NewItem.enterPrCoo(PrCoo);
					NewItem.click_SaveBtn();
					NewItem.click_Close();
					EditShipItem.click_InstructionDetails();
					Instruction.add_Instruction(SpecialInstructions, ShipmentSpecialInstructions, AttachedDocuments,
							ExemptionStatementRoutingInfo, CustPONo, DestinationControlStatements, EEIHeader, EEIFooter,
							EEIDOCHeader, EEIDOCFooter, EEIDOSHeader, EEIDOSFooter, ComplianceCertificateText);
					// Instruction.add_BookingDetailsandMisTerms(InstructIncoterm,
					// IncoNamedForDestination, MasterAWBNum,
					// HouseAirwayBillNumber, NextFlightOut, ConsolidateShip, InsuranceReq,
					// InsuranceAmt, prepaid,
					// collect, NoofPackages, Dimension, TotalShipmentWeight);
					// Instruction.click_Notes();
					// Instruction.addNotes(addNotes);
					Instruction.click_save();
					Wait.waitfor(3);
					Instruction.select_LinkedOrder();
					LinkedOrd.click_InvoiceNo(InvoiceNo);

					Invoice.addPartiesToTransaction(EntityType, AddPartyConsigneeID);

					Invoice.click_InvoiceSave();
					Wait.waitfor(3);
					Invoice.closeBtn();
					LinkedOrd.click_ReviewerDetails();
					ReviewerDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite,
							ExportComplianceReviewer, ExportRegion, ExportSite, TransportGatekeeperExportOps,
							TransRegion, TransSite);
					ReviewerDetails.click_save();
					ReviewerDetails.addTransaction();
					// CreateNewShp.contactFullName();
					CreateNewShp.changeStatusToShipReview(ShippingReviewStat);
					Wait.waitfor(20);
					CreateNewShp.changeStatusToExportApproved(ExportApproved);
					Wait.waitfor(20);
					CreateNewShp.changeStatusToShipmentApproved(ShipmentApproved);
					Wait.waitfor(20);
//					CreateNewShp.changeStatusToFreightForwarder(FrieghtForwarder);
//					Wait.waitfor(20);
//					CreateNewShp.changeStatusToShipped(Shipped);
//					Wait.waitfor(10);
					CreateNewShp.get_shipmentID();
					String shipId = CreateNewShp.get_shipmentID();
					Wait.waitfor(2);
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();

					// CreateNewShp.getShipNo();
					// String shipNo = CreateNewShp.getShipNo();
					// CreateNewShp.get_shipmentStatus();
					// String shipStatus = CreateNewShp.get_shipmentStatus();

					Wait.waitfor(3);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.shipNum(shipId);
					PL.searchBtn();
					ResultPL.packingListResult();
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
