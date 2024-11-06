package RegressionTestingEOUSScripts;

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
import utilities.Utility;
import utilities.Wait;

public class CreateShipFromAuthAndSubmitForShipmentReviewUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipmentFrmAuthNo", excel);
	}

	@Test(dataProvider = "getData")
	public void createShipmentFromAuthUntilShipReview(String Testcase, String RunMode, String SBU, String SBUcode,
			String AuthorizationNo, String shipNum, String Item, String CustomsInvoiceQuantity, String HtsAndPrimaryUMO,
			String hazmatID, String Regulation, String RegOption, String KindOfPack, String Packgrp, String GrsWt,
			String Auth, String Techname, String SubRisk, String TransMode, String Cube, String NetWet,
			String SubCompNo, String ContainerId, String ParentProdID, String SubCOO, String SerialID, String PrimQty,
			String SubUnitPrice, String SubProdDesc, String VINProdID, String VINTitleNo, String VehicleTitleState,
			String CorrectionFlag, String TransportCountryOfOrigin, String TransportPortOfExport,
			String TransportPortOfUnlading, String TransportPortOfLoading, String TransportPlaceofDelivery,
			String TransportPortOfArrival, String TransportLoadingPier, String TransportVesselFlightNumber,
			String TransportAirportofFinalDest, String TransportDOCNumber, String PassengerandCargoAircraft,
			String CargoAircraftOnly, String BookingNo, String BillOfLadingNo, String MasterAWBNumber,
			String TrackingNo, String TransportRefNo, String BookingDateofArrival, String Prepaid, String CodeAmount,
			String Collect, String ContainsPersonalInfo, String CarnetNo, String SPIIssueDate, String ExpiryDate,
			String InsuranceAmount, String InsuranceRequired, String Insured, String Containerized, String Hazardous,
			String DestinationControlStatement, String ContainerAndVehicleNumber, String SealNumber,
			String ContainerVechileSize, String TareMass, String TotalGross, String Nameofthecompanypacking,
			String NameStatusDeclarant, String ContainerPlace, String ConatinerDate, String NameoftheCompany,
			String ShipperNameStatusDeclarant, String ShipperPlace, String ShipperDate, String Radioactive,
			String HazmatloadsheetInstructions, String CarrierInfo, String EmergencyContactNo, String TSCA,
			String REACH, String ChemicalSubstance, String SpecialInstructions, String ShipmentSpecialInstructions,
			String AttachedDocuments, String ExemptionStatementRoutingInfo, String CustPONo,
			String DestinationControlStatements, String EEIHeader, String EEIFooter, String EEIDOCHeader,
			String EEIDOCFooter, String EEIDOSHeader, String EEIDOSFooter, String ComplianceCertificateText,
			String InstructIncoterm, String IncoNamedForDestination, String MasterAWBNum, String HouseAirwayBillNumber,
			String NextFlightOut, String ConsolidateShip, String InsuranceReq, String InsuranceAmt, String prepaid,
			String collect, String NoofPackages, String Dimension, String TotalShipmentWeight, String addNotes,
			String InvoiceNo, String EntityType, String AddPartyConsigneeID, String ShippingDeptReviewer,
			String ShipRegion, String ShipSite, String ExportComplianceReviewer, String ExportRegion, String ExportSite,
			String TransportGatekeeperExportOps, String TransRegion, String TransSite, String ShippingReviewStat)
			throws Exception {

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
					CreatShip.selectSBUcode(SBUcode);
					Wait.waitfor(2);
					CreatShip.createshipmentwithAuthorization();
					Wait.waitfor(2);
					CreatShip.authorizationno(AuthorizationNo);
					Wait.waitfor(2);
					CreatShip.create_Shp();
					Wait.waitfor(2);
					CreateNewShp.shipNum(shipNum);
					CreateNewShp.scrollToExporterDetails();
					CreateNewShp.scrollToUltConsigneeDetails();
					CreateNewShp.scrollToIntConsigneeDetails();
					CreateNewShp.scrollToEndUserDetails();
					CreateNewShp.scrollToFFDetails();
					CreateNewShp.click_SaveBtn();
					CreateNewShp.select_additems();
					String ShipmentID = CreateNewShp.get_shipmentID();
					// ShipItem.click_OrderNo(OrderNO);
					NewItem.click_InvItem(Item);
					NewItem.addQuantityAndPricingInfo(CustomsInvoiceQuantity);
					NewItem.addClassifacationInfo(HtsAndPrimaryUMO);
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
					// ItemSubComponent.click_CloseBtn();
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
					HazmatDetails.addHazmatShipmentDetails(Hazardous, DestinationControlStatement,
							ContainerAndVehicleNumber, SealNumber, ContainerVechileSize, TareMass, TotalGross,
							Nameofthecompanypacking, NameStatusDeclarant, ContainerPlace, ConatinerDate,
							NameoftheCompany, ShipperNameStatusDeclarant, ShipperPlace, ShipperDate, Radioactive,
							HazmatloadsheetInstructions, CarrierInfo, EmergencyContactNo, TSCA, REACH,
							ChemicalSubstance);
					HazmatDetails.click_SaveHazmatDetails();
					HazmatDetails.click_AdditionalDetails();
					Wait.waitfor(3);

					Instruction.add_Instruction(SpecialInstructions, ShipmentSpecialInstructions, AttachedDocuments,
							ExemptionStatementRoutingInfo, CustPONo, "", EEIHeader, EEIFooter, EEIDOCHeader,
							EEIDOCFooter, EEIDOSHeader, EEIDOSFooter, ComplianceCertificateText);
					Instruction.add_BookingDetailsandMisTerms(InstructIncoterm, IncoNamedForDestination, MasterAWBNum,
							HouseAirwayBillNumber, NextFlightOut, ConsolidateShip, InsuranceReq, InsuranceAmt, prepaid,
							collect, NoofPackages, Dimension, TotalShipmentWeight);
					Instruction.click_Notes();
					Instruction.addNotes(addNotes);
					Instruction.click_save();
					Wait.waitfor(3);
					Instruction.select_LinkedOrder();
					LinkedOrd.click_InvoiceNo(InvoiceNo);

					Invoice.addPartiesToTransaction(EntityType, AddPartyConsigneeID);
					// Invoice.addAdditionalCharges(AdditionalCharges, TansAmount, ChargingAccount,
					// GLACode,
					// WholesalerCharge, PrintonDocuments);
					// Invoice.addContainerPackingDetails(MarkingsContainerID, SealNumbers,
					// ConsolidatedPackNumber,
					// HazmatHazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType,
					// Model,
					// TareWeight, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity,
					// HazmatClass,
					// "BOLText");
					// Invoice.addReturnablePackage(PackageID, HUNoContainerId, ReturnNoOfPkgs,
					// TypeOfPacking,
					// ReturnNetWeight, TotalNetWeight, UnitPrice, TotalPrice, CountryofOrigin);
					Invoice.click_InvoiceSave();
					Wait.waitfor(3);
					Invoice.closeBtn();
					LinkedOrd.click_ReviewerDetails();
					ReviewerDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite,
							ExportComplianceReviewer, ExportRegion, ExportSite, TransportGatekeeperExportOps,
							TransRegion, TransSite);
					ReviewerDetails.click_save();
					ReviewerDetails.addTransaction();
					CreateNewShp.contactFullName();
					CreateNewShp.changeStatusToShipReview(ShippingReviewStat);
					CreateNewShp.getShipNo();
					String shipNo = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();

					// ShipItem.click_OrderNo(shipmnetID);
					// NewItem.click_SaveAndReturn();
					// CreateNewShp.select_ShipmentForm();
					// Wait.waitfor(3);
					// ArrayList<String> status = GenericMethods.stringtoken(Status);
					// for (int i = 0; i < status.size(); i++) {
					// CreateNewShp.click_ChangeStatusUS(status.get(i));
					// Wait.waitfor(2);
					// if (status.get(i).equalsIgnoreCase(CreateNewShp.get_shipmentStatus())) {
					// test.log(LogStatus.PASS, "Shipment Status : " +
					// CreateNewShp.get_shipmentStatus());
					// } else {
					// test.log(LogStatus.FAIL, "Shipment Status : " +
					// CreateNewShp.get_shipmentStatus());
					// testFail();
					// }
					// }
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
			Assert.assertTrue(false);
		}
	}
}
