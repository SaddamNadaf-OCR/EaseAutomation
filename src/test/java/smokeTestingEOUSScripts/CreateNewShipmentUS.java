package smokeTestingEOUSScripts;

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
import globalExportClasses.EditShipmentBookingDeatilsPage;
import globalExportClasses.EditShipmentHazmatDetailsPage;
import globalExportClasses.EditShipmentInstructionsPage;
import globalExportClasses.EditShipmentItemsPage;
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
	public void Shipment(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo,
			String UltDestination, String ModeOfTransport, String ExporterCode, String ConsigneeId,
			String MarkingsContainerID, String SealNumber, String ConsolidatedPackNumber, String Hazardous,
			String RadioActivityAmnt, String DryIce, String GrossCartonWeight, String PackageType, String Model,
			String TareWeight, String DimensionUOM, String LenghtWidthHight, String WeightUOM, String GrossNet,
			String SKUQuantity, String Class, String ProductDescription, String ManufacturerID, String CountryOfOrigin,
			String CountryOfOriginType, String FTAApplicable, String NetworkOrderNumber, String EngineLine,
			String MTFNumber, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate,
			String ControllingAgencycode, String ExportClassificationItem, String HtsAndPrimaryUMO,
			String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM, String ImportHTS, String ImportUOM,
			String USExportECCN, String StatisticalCode, String BISLicenseException, String AuthorisationNo,
			String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode,
			String EUSNo,String SMEIndicator, String AdditionalAuthorisationNo, String AdditionalAuthorisationItemNo, String PackingInfo,
			String HUNoContainerID, String HUNoSubLevel, String GrossWeight, String NetWeight, String Markings,
			String Dimensions, String NoOfPkgs, String AlternateUOM, String Skids, String Length, String Width,
			String Height, String Weight, String ExtendedWeight, String Factor, String Cubic, String M_TypeOfPacking,
			String M_QuantityUOM, String M_AlternateUOM, String BatchNumber, String BatchInfoCountryOfOrigin,
			String BatchInfoQuantity, String BatchInfoExpiryDate, String BatchInfoSterilityDate,
			String ImportShipmentType, String InbondCode, String EntryNo, String ItemNO, String ImportIdentificationNo,
			String RateofYield, String ReExportReliefAuthorizationNo, String SearchHazardClassorDivision,
			String HazmatIdentifactionNumber, String HazmatClass, String HazmatDivision, String HazmatGroup,
			String HazmatPackingInstruction, String HazmatAuthorisation, String HazmatNoAndKindOfPack,
			String HazmatGrossWeight, String HazmatNetWeight, String HazmatCube, String SubcomponentItemNo,
			String ProductNo, String TransportCountryOfOrigin, String TransportPortOfExport,
			String TransportPortOfUnlading, String TransportPortOfLoading, String TransportPlaceofDelivery,
			String TransportPortOfArrival, String TransportLoadingPier, String TransportVesselFlightNumber,
			String TransportAirportofFinalDest, String TransportDOCNumber, String PassengerandCargoAircraft,
			String CargoAircraftOnly, String BookingNo, String BillOfLadingNo, String MasterAWBNumber,
			String TrackingNo, String TransportRefNo, String BookingDateofArrival, String Prepaid, String CodeAmount,
			String Collect, String ContainsPersonalInfo, String CarnetNo, String SPIIssueDate, String ExpiryDate,
			String InsuranceAmount, String InsuranceRequired, String Insured, String Containerized,
			String HazmatHazardous, String Destination, String ContainerAndVehicleNumber, String SealNumbers,
			String ContainerVechileSize, String TareMass, String TotalGross, String Nameofthecompanypacking,
			String NameStatusDeclarant, String ContainerPlace, String ConatinerDate, String NameoftheCompany,
			String ShipperNameStatusDeclarant, String ShipperPlace, String ShipperDate, String Radioactive,
			String EmergencyContactNo, String SpecialInstructions, String ShipmentSpecialInstructions,
			String AttachedDocuments, String ExemptionStatementRoutingInfo, String DestinationControlStatement,
			String ComplianceCertificateText,  String SkipWatchListScreening,
			String SubcomponentScreening, String SkipExportAuthScreening, String InvoiceChargeNo,
			String InvoiceContractNo, String InoviceOrderCategory, String InovicePriority, String InoviceSalesOrderNo,
			String InoviceSalesOrderDate, String InvoiceCustomerOrderNo, String InoviceCustomerOrderNo,
			String InvoiceLetterofCredit, String InoviceLetterofCreditExpiryDate, String InoviceNotifyPartyInstructions,
			String PaymentID, String IncotermCode, String IncotermPlace, String EntityType, String AddPartyConsigneeID,
			String AdditionalCharges, String TansAmount, String ChargingAccount, String GLACode,
			String WholesalerCharge, String PrintonDocuments, String PackageID, String HUNoContainerId,
			String ReturnNoOfPkgs, String TypeOfPacking, String ReturnNetWeight, String TotalNetWeight,
			String UnitPrice, String TotalPrice, String CountryofOrigin, String IRequestorUserName,
			String IRequestorUserTitle, String IRequestorTelephone, String IRequestorEmail, String IRequestorPickedBy,
			String IRequestorLoadedBy, String IRequestorCustomerServiceRep, String Status) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		CreateNewOrderItemHazmatDetailsPage ItemHazmat = new CreateNewOrderItemHazmatDetailsPage(driver, test);
		CreateNewOrderItemSubComponentPage ItemSubComponent = new CreateNewOrderItemSubComponentPage(driver, test);
		EditShipmentBookingDeatilsPage BookingDetails = new EditShipmentBookingDeatilsPage(driver, test);
		EditShipmentHazmatDetailsPage HazmatDetails = new EditShipmentHazmatDetailsPage(driver, test);
		EditShipmentInstructionsPage Instruction = new EditShipmentInstructionsPage(driver, test);
		EditInvoiceOrderFormPage Invoice = new EditInvoiceOrderFormPage(driver, test);
		EditInvoiceMiscellaneousDetailsPage Misc = new EditInvoiceMiscellaneousDetailsPage(driver, test);
		EditInvoiceInstructionsAndNotesPage Instructions = new EditInvoiceInstructionsAndNotesPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
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
					CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, "", "", "", "", "", "", "", ModeOfTransport,
							"", "", "", "", "", "");
					CreateNewShp.partiesToTheTransaction(ExporterCode, ConsigneeId, "", "");
					String shipmnetID = CreateNewShp.get_shipmentID();
					// String CEF = CreateNewShp.get_CountryShippedFrom();
					CreateNewShp.addContainerPackingDetails(MarkingsContainerID, SealNumber, ConsolidatedPackNumber,
							Hazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType, Model, TareWeight,
							DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity, Class, "TEST");
					CreateNewShp.validateContainerPackingDeatils(MarkingsContainerID);
					CreateNewShp.select_additems();
					ShipItem.click_AddItem();
					NewItem.typeDesc(ProductDescription);
					NewItem.AddGeneralInformation("", "SourceSystemPartNumber", "SerialNumbers", "PONumber",
							"CustomerPartNumber", "SalesOrderNo", "SalesOrderItemNo", "DeliveryOrderNo",
							"DeliveryOrderItemNo", ManufacturerID, CountryOfOrigin, CountryOfOriginType, FTAApplicable,
							NetworkOrderNumber, EngineLine, MTFNumber, "Remarks");
					NewItem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
					NewItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN,
							StatisticalCode);
					NewItem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo, AuthorisationItemNo,
							InternalAuthNo, AuthorisationExpiryDate, MLCategoryCode, EUSNo,SMEIndicator);
					NewItem.addAdditionalAuthorizationUS(AdditionalAuthorisationNo, AdditionalAuthorisationItemNo);

					ArrayList<String> hUNoContainerID = GenericMethods.stringtoken(HUNoContainerID);
					ArrayList<String> hUNoSubLevel = GenericMethods.stringtoken(HUNoSubLevel);
					ArrayList<String> grossWeight = GenericMethods.stringtoken(GrossWeight);
					ArrayList<String> netWeight = GenericMethods.stringtoken(NetWeight);
					ArrayList<String> markings = GenericMethods.stringtoken(Markings);
					ArrayList<String> dimensions = GenericMethods.stringtoken(Dimensions);
					ArrayList<String> noOfPkgs = GenericMethods.stringtoken(NoOfPkgs);
					ArrayList<String> alternateUOM = GenericMethods.stringtoken(AlternateUOM);
					ArrayList<String> skids = GenericMethods.stringtoken(Skids);
					ArrayList<String> length = GenericMethods.stringtoken(Length);
					ArrayList<String> width = GenericMethods.stringtoken(Width);
					ArrayList<String> height = GenericMethods.stringtoken(Height);
					ArrayList<String> weight = GenericMethods.stringtoken(Weight);
					ArrayList<String> extendedWeight = GenericMethods.stringtoken(ExtendedWeight);
					ArrayList<String> factor = GenericMethods.stringtoken(Factor);
					ArrayList<String> cubic = GenericMethods.stringtoken(Cubic);
					ArrayList<String> m_TypeOfPacking = GenericMethods.stringtoken(M_TypeOfPacking);
					ArrayList<String> m_QuantityUOM = GenericMethods.stringtoken(M_QuantityUOM);
					ArrayList<String> m_AlternateUOM = GenericMethods.stringtoken(M_AlternateUOM);

					for (int i = 0; i < hUNoContainerID.size(); i++) {
						if (PackingInfo.contains("Single") && HUNoContainerID.length() > 0)
							NewItem.addPackingDetails(hUNoContainerID.get(i), hUNoSubLevel.get(i), grossWeight.get(i),
									netWeight.get(i), markings.get(i), dimensions.get(i), noOfPkgs.get(i),
									alternateUOM.get(i), skids.get(i), length.get(i), width.get(i), height.get(i),
									weight.get(i), extendedWeight.get(i), factor.get(i), cubic.get(i));
						if (PackingInfo.contains("Multiple") && HUNoContainerID.length() > 0)
							NewItem.addMultiplePackinges(hUNoContainerID.get(i), hUNoSubLevel.get(i),
									grossWeight.get(i), netWeight.get(i), markings.get(i), dimensions.get(i),
									noOfPkgs.get(i), m_TypeOfPacking.get(i), skids.get(i), length.get(i), width.get(i),
									height.get(i), weight.get(i), extendedWeight.get(i), factor.get(i), cubic.get(i),
									m_QuantityUOM.get(i), m_AlternateUOM.get(i));
					}
					NewItem.addBatchInfo(BatchNumber, BatchInfoCountryOfOrigin, BatchInfoQuantity, BatchInfoExpiryDate,
							BatchInfoSterilityDate);
					NewItem.addReExportInfo(ImportShipmentType, InbondCode, EntryNo, ItemNO, ImportIdentificationNo,
							RateofYield, ReExportReliefAuthorizationNo);
					NewItem.click_SaveBtn();
					NewItem.select_HazmatDetails();
					ItemHazmat.add_HazmatInformation(SearchHazardClassorDivision, HazmatIdentifactionNumber,
							HazmatClass, HazmatDivision, HazmatGroup, HazmatPackingInstruction, HazmatAuthorisation,
							HazmatNoAndKindOfPack, HazmatGrossWeight, HazmatNetWeight, HazmatCube);
					ItemHazmat.click_SaveItemHazmatDetails();
					Wait.waitfor(3);
					NewItem.select_SubComponent();
					ItemSubComponent.addOrderItemSubComponent(SubcomponentItemNo, ProductNo);
					ItemSubComponent.click_CloseBtn();
					Wait.waitfor(3);
					CreateNewShp.select_BookingDetails();
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
					CreateNewShp.select_HazmatDetails();
					HazmatDetails.addHazmatShipmentDetails(HazmatHazardous, Destination, ContainerAndVehicleNumber,
							SealNumbers, ContainerVechileSize, TareMass, TotalGross, Nameofthecompanypacking,
							NameStatusDeclarant, ContainerPlace, ConatinerDate, NameoftheCompany,
							ShipperNameStatusDeclarant, ShipperPlace, ShipperDate, Radioactive,
							"HazmatloadsheetInstructions", "CarrierInfo", EmergencyContactNo, "", "", "");
					HazmatDetails.click_SaveHazmatDetails();
					Wait.waitfor(3);
					CreateNewShp.select_Instructions();
					Instruction.add_Instruction(SpecialInstructions, ShipmentSpecialInstructions, AttachedDocuments,
							ExemptionStatementRoutingInfo, DestinationControlStatement, ComplianceCertificateText);
					Instruction.click_save();
					Wait.waitfor(3);
					CreateNewShp.select_AssociatedLinked();
					Invoice.click_InvoiceNo(shipmnetID);
					Invoice.add_InvoiceDetails(SkipWatchListScreening, SubcomponentScreening, SkipExportAuthScreening);
					Invoice.addAdditionalOrderDetails(InvoiceChargeNo, InvoiceContractNo, InoviceOrderCategory,
							InovicePriority, InoviceSalesOrderNo, InoviceSalesOrderDate, InvoiceCustomerOrderNo,
							InoviceCustomerOrderNo, InvoiceLetterofCredit, InoviceLetterofCreditExpiryDate,
							InoviceNotifyPartyInstructions);
					Invoice.addCurrencyAndPayment(PaymentID, IncotermCode, IncotermPlace);
					Invoice.addPartiesToTransaction(EntityType, AddPartyConsigneeID);
					Invoice.addAdditionalCharges(AdditionalCharges, TansAmount, ChargingAccount, GLACode,
							WholesalerCharge, PrintonDocuments);
					Invoice.addContainerPackingDetails(MarkingsContainerID, SealNumbers, ConsolidatedPackNumber,
							HazmatHazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType, Model,
							TareWeight, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity, HazmatClass,
							"BOLText");
					Invoice.addReturnablePackage(PackageID, HUNoContainerId, ReturnNoOfPkgs, TypeOfPacking,
							ReturnNetWeight, TotalNetWeight, UnitPrice, TotalPrice, CountryofOrigin);
					Invoice.click_InvoiceSave();
					Wait.waitfor(3);
					Misc.select_InvoiceInstructionsNotes();
					Instructions.addInstructions("InvoiceInstructions", "InvoiceInstNote", "InvoiceItemHeader",
							"InvoiceItemFooter", "InvoicePackingDetails", "InvoicePackingSheetNo",
							"InvoiceNumberofPackingSheets", IRequestorUserName, IRequestorUserTitle,
							IRequestorTelephone, IRequestorEmail, IRequestorPickedBy, IRequestorLoadedBy,
							IRequestorCustomerServiceRep, "Notes");
					Instructions.click_SaveInstructionAndNote();
					Wait.waitfor(3);
					Instructions.select_LinkedShipmentDetails();
					Wait.waitfor(3);
					CreateNewShp.select_additems();
					ShipItem.click_OrderNo(shipmnetID);
					NewItem.click_SaveAndReturn();
					CreateNewShp.select_ShipmentForm();
					Wait.waitfor(3);
					ArrayList<String> status = GenericMethods.stringtoken(Status);
					for (int i = 0; i < status.size(); i++) {
						CreateNewShp.click_ChangeStatusUS(status.get(i));
						Wait.waitfor(2);
						if (status.get(i).equalsIgnoreCase(CreateNewShp.get_shipmentStatus())) {
							test.log(LogStatus.PASS, "Shipment Status : " + CreateNewShp.get_shipmentStatus());
						} else {
							test.log(LogStatus.FAIL, "Shipment Status : " + CreateNewShp.get_shipmentStatus());
							testFail();
						}
					}
					Wait.waitfor(3);
					HGExport.return_ExportHome();
					Wait.waitfor(3);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					HGExport.type_ShipmentNo(shipmnetID);
					HGExport.click_Search();
					result.click_ShipmentNo(shipmnetID);
					Wait.waitfor(5);
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
