package RegressionTestingEOUSScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemHazmatDetailsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewOrderItemSubComponentPage;
import globalExportClasses.CreateNewShipmentPage;
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
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class CreateNewShipmentUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateShipment", excel);
	}

	@Test(dataProvider = "getData")
	public void Shipment(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo, String UltDestination, 
			String DateOfExport, String SLIDate, String ProductFamily, String MotId, String DateofArrival, String ReportMonthAndYear, 
			String DutyReliefType, String ReliefAuthorizationNo, String ReliefActivityType, String DueDate, String ExporterCode, 
			String ConsigneeId, String FFCode, String IntConsigneePartyType, String TravelerUserFirstName, String TravelerName, 
			String TravelerEmail, String TravelerPhone, String FreightChargesPaidBY, String CustomDutiesPaidBy, String ForeignVatPaidBy, 
			String CostCeneterNo, String LineOfBusinessSupport, String EquipmentNo, String SealNo, String MarkingsContainerID, 
			String SealNumbers, String ConsolidatedPackNumber, String HazmatHazardous, String RadioActivityAmnt, String DryIce, 
			String GrossCartonWeight, String PackageType, String Model, String TareWeight, String DimensionUOM, String LenghtWidthHight, 
			String WeightUOM, String GrossNet, String SKUQuantity, String HazmatClass, String BOLText, String PartNo, String SourceSystemPartNumber, 
			String POLineNo, String ScheduleAgreement, String SerialNumbers, String PONumber, String CustomerPartNumber, 
			String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo, String Vendor, 
			String VendorPN, String NetOrderNo, String EngineLine, String WBS, String MTFNumber, String Remarks, String OrgPONo, 
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency, String RepairValue, 
			String DiscountRate, String WholesaleRate, String ControllingAgencycode, String ExportClassificationItem, String HtsAndPrimaryUMO, 
			String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM, String ImportHTS, String ImportUOM, String USExportECCN, 
			String StatisticalCode, String BISLicenseException, String AuthorisationNo, String AuthorisationItemNo, String InternalAuthNo, 
			String AuthorisationExpiryDate, String MLCategoryCode, String EUSNo, String SMEIndicator, String PrCoo, String BatchNumber, 
			String BatchInfoCountryOfOrigin, String BatchInfoQuantity, String BatchInfoExpiryDate, String BatchInfoSterilityDate, 
			String ImportShipmentType, String InbondCode, String EntryNo, String ItemNO, String RelDueDate, String PackNote, 
			String ContractNote, String OracleAttachment, String DelAttachment, String hazmatID, String Regulation, String RegOption, String KindOfPack, String Packgrp, String GrsWt, String Auth, String Techname, String SubRisk, String TransMode, String Cube, String NetWet, String SubCompNo, String ContainerId, String ParentProdID, String SubCOO, String SerialID, String PrimQty, String SubUnitPrice, String SubProdDesc, String VINProdID, String VINTitleNo, String VehicleTitleState, String CorrectionFlag, String TransportCountryOfOrigin, String TransportPortOfExport, String TransportPortOfUnlading, String TransportPortOfLoading, String TransportPlaceofDelivery, String TransportPortOfArrival, String TransportLoadingPier, String TransportVesselFlightNumber, String TransportAirportofFinalDest, String TransportDOCNumber, String PassengerandCargoAircraft, String CargoAircraftOnly, String BookingNo, String BillOfLadingNo, String MasterAWBNumber, String TrackingNo, String TransportRefNo, String BookingDateofArrival, String Prepaid, String CodeAmount, String Collect, String ContainsPersonalInfo, String CarnetNo, String SPIIssueDate, String ExpiryDate, String InsuranceAmount, String InsuranceRequired, String Insured, String Containerized)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		CreateNewOrderItemHazmatDetailsPage ItemHazmat = new CreateNewOrderItemHazmatDetailsPage(driver, test);
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

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Shipment.click_AddShipment();
					CreatShip.select_SBUcode(SBUcode);
					CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, DateOfExport, "", SLIDate, "",
							"", "", ProductFamily, MotId, DateofArrival, ReportMonthAndYear, DutyReliefType,
							ReliefAuthorizationNo, ReliefActivityType, DueDate);
					CreateNewShp.partiesToTheTransaction(ExporterCode, ConsigneeId, FFCode, IntConsigneePartyType);
					String shipmnetID = CreateNewShp.get_shipmentID();
					// String CEF = CreateNewShp.get_CountryShippedFrom();
					CreateNewShp.addTravelerDetails(TravelerUserFirstName, TravelerName, TravelerEmail, TravelerPhone);
					CreateNewShp.addMiscellaneousInfo(FreightChargesPaidBY, CustomDutiesPaidBy, ForeignVatPaidBy,
							CostCeneterNo, LineOfBusinessSupport);
					CreateNewShp.addEquipment(EquipmentNo, SealNo);
					CreateNewShp.addContainerPackingDetails(MarkingsContainerID, SealNumbers, ConsolidatedPackNumber,
							HazmatHazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType, Model,
							TareWeight, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity, HazmatClass,
							BOLText);
					CreateNewShp.validateContainerPackingDeatils(MarkingsContainerID);
					CreateNewShp.select_additems();
					ShipItem.click_AddItem();
					// NewItem.typeDesc(ProductDescription);
					NewItem.AddGeneralInformation(PartNo, SourceSystemPartNumber, POLineNo, ScheduleAgreement,
							SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNo, SalesOrderItemNo,
							DeliveryOrderNo, DeliveryOrderItemNo, Vendor, VendorPN, NetOrderNo, EngineLine, WBS,
							MTFNumber, Remarks, OrgPONo);
				//	NewItem.enterPrCoo(PrCoo);
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
			
					NewItem.addBatchInfo(BatchNumber, BatchInfoCountryOfOrigin, BatchInfoQuantity, BatchInfoExpiryDate,
							BatchInfoSterilityDate);
					NewItem.addReExportInfo(ImportShipmentType, InbondCode, EntryNo, ItemNO, RelDueDate);
					NewItem.notes(PackNote, ContractNote, OracleAttachment, DelAttachment);
					NewItem.click_SaveBtn();
					NewItem.select_HazmatDetails();
					ItemHazmat.hazmatInfo(hazmatID, Regulation, RegOption, KindOfPack, Packgrp, GrsWt, Auth, Techname,
							SubRisk, TransMode, Cube, NetWet);
					ItemHazmat.click_SaveItemHazmatDetails();
					Wait.waitfor(3);
					NewItem.select_SubComponent();
					ItemSubComponent.click_AddSubComponent();
					ItemSubComponent.addOrderItemSubCompUS(SubCompNo, ContainerId, ParentProdID, SubCOO, SerialID,
							PrimQty, SubUnitPrice, SubProdDesc);
					ItemSubComponent.navigateVehicleInfo();
		//		ItemSubComponent.click_CloseBtn();
					Wait.waitfor(3);
					ItemVehicleInfo.addExportVehicleBtn();
					ItemVehicleInfo.addExportvehiclePopUp(VINProdID, VINTitleNo, VehicleTitleState, CorrectionFlag);
					ItemVehicleInfo.exportVehiclesaveBtn();
					ItemVehicleInfo.exportvehicleCloseBtn();
					ItemVehicleInfo.vehicleInfoCloseBtn();
					ShipItem.click_BookingDetails();
					BookingDetails.addTransportInfo(TransportCountryOfOrigin, TransportPortOfExport,
							TransportPortOfUnlading, TransportPortOfLoading, TransportPlaceofDelivery,
							TransportPortOfArrival, TransportLoadingPier, TransportVesselFlightNumber,
							TransportAirportofFinalDest, TransportDOCNumber, PassengerandCargoAircraft,
							CargoAircraftOnly);
					BookingDetails.add_HearderInfo(BookingNo, BillOfLadingNo, MasterAWBNumber, TrackingNo,
							TransportRefNo, BookingDateofArrival);
					BookingDetails.addShippingPaymentInfo(Prepaid, CodeAmount, Collect, ContainsPersonalInfo, CarnetNo,
							SPIIssueDate, ExpiryDate, InsuranceAmount, InsuranceRequired, Insured, Containerized);
					BookingDetails.click_SaveBookingDetails();
					Wait.waitfor(3);
					BookingDetails.selectHazmatDetails();
//					HazmatDetails.addHazmatShipmentDetails(Hazardous, DestinationControlStatement,
//							ContainerAndVehicleNumber, SealNumber, ContainerVechileSize, TareMass, TotalGross,
//							Nameofthecompanypacking, NameStatusDeclarant, ContainerPlace, ConatinerDate,
//							NameoftheCompany, ShipperNameStatusDeclarant, ShipperPlace, ShipperDate, Radioactive,
//							HazmatloadsheetInstructions, CarrierInfo, EmergencyContactNo, TSCA, REACH,
//							ChemicalSubstance);
					HazmatDetails.click_SaveHazmatDetails();
					HazmatDetails.click_AdditionalDetails();
					Wait.waitfor(3);

//					Instruction.add_Instruction(SpecialInstructions, ShipmentSpecialInstructions, AttachedDocuments,
//							ExemptionStatementRoutingInfo, CustPONo, DestinationControlStatements, EEIHeader, EEIFooter,
//							EEIDOCHeader, EEIDOCFooter, EEIDOSHeader, EEIDOSFooter, ComplianceCertificateText);
//					Instruction.add_BookingDetailsandMisTerms(InstructIncoterm, IncoNamedForDestination, MasterAWBNum,
//							HouseAirwayBillNumber, NextFlightOut, ConsolidateShip, InsuranceReq, InsuranceAmt, prepaid,
//							collect, NoofPackages, Dimension, TotalShipmentWeight);
//					Instruction.click_Notes();
//					Instruction.addNotes(addNotes);
//					Instruction.click_save();
//					Wait.waitfor(3);
//					Instruction.select_LinkedOrder();
//					LinkedOrd.click_InvoiceNo(InvoiceNo);
//
//					
//					Invoice.addPartiesToTransaction(EntityType, AddPartyConsigneeID);
//					
//					Invoice.click_InvoiceSave();
//					Wait.waitfor(3);
//					Invoice.closeBtn();
//					LinkedOrd.click_ReviewerDetails();
//					ReviewerDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite,
//							ExportComplianceReviewer, ExportRegion, ExportSite, TransportGatekeeperExportOps,
//							TransRegion, TransSite);
//					ReviewerDetails.click_save();
//					ReviewerDetails.addTransaction();
					CreateNewShp.contactFullName();
//					CreateNewShp.changeStatusToShipReview(ShippingReviewStat);
					CreateNewShp.getShipNo();
					String shipNo = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();

					
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
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
}
