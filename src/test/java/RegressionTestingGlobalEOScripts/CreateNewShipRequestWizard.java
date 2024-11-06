package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardAdditionalChargesPage;
import globalExportClasses.ShipWizardExportAuthorisationsPage;
import globalExportClasses.ShipWizardInvoicePartyDetailsPage;
import globalExportClasses.ShipWizardRequestorInformationPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipWizardShipmentTermsPage;
import globalExportClasses.ShipWizardSupportingDocumentationPage;
import globalExportClasses.ShipWizardTSCAReachInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewShipRequestWizard extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewShipRequestWizard", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipmentWizard(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo,
			String PhoneNo, String TrackingNo, String UltDestination, String ExporterCode, String ConsigneeId,
			String MarkingsContainerID, String SealNumber, String ConsolidatedPackNumber, String Hazardous,
			String RadioActivityAmnt, String DryIce, String GrossCartonWeight, String PackageType, String Model,
			String TareWeight, String DimensionUOM, String LenghtWidthHight, String WeightUOM, String GrossNet,
			String SKUQuantity, String Class, String BOLText, String PaymnetID, String IncotermCode,
			String DontPayInvoice, String IncoNamedforDestination, String ForCustomsPurpose, String Notes,
			String EntryType, String ConsigneeIdBillTo, String CartonDimensionUOM, String CartonLenghtWidthHight,
			String CartonWeightUOM, String CartonGrossNet, String PartNo, String MLCategoryExportClassification,
			String TariffCode, String ExportClassification, String ImportHTSUOM, String USExportClassificationECCN,
			String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo,
			String SerialNumbers, String CustomsInvoiceQuantity, String Units, String QuantityOrdered,
			String TotalItemValue, String DiscountRate, String WholesaleRate, String GrossWeight, String NetWeight,
			String MarksAndNos, String Dimensions, String NoOfPkgs, String AlternateUOM, String Skids,
			String PackingLenghtWidthHight, String PackingWeightExWeight, String Factor, String Cubic,
			String BatchNumber, String BatchCountryOfOrigin, String BatchQuantity, String BatchExpiryDate,
			String BatchSterilityDate, String FreightChargesPaidBy, String CustomDutiesPaidBy, String ForeignVATPaidBy,
			String InsuranceRequired, String ShipmentContainsPersonalInfo, String CostCenterNo,
			String LineofBusinessSupported, String ModeofTransportation, String ManagertoApproveFreight,
			String POReferenceNo, String SpecialInstructions, String ShipmentSpecialInstructions,
			String AttachedDocuments, String ChargeDescription, String Amount, String ChargingAccount, String GLACode,
			String ChargeToCustomer, String WholesalerCharge, String PrintOnDocuments, String ExportClasfctnECCN,
			String AuthorizationNo, String MLCategory, String RegistrationNo, String LicenseException,
			String ITARExemption, String RegulatoryCitation, String TSCAReachInfoQuestion, String TSCAReachInfoAnswer,
			String DocumentType, String UploadfileName, String DocumentLocationPath, String ShippingDeptReviewer,
			String ExportComplianceReviewer, String TransportGatekeeperExportOps) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardInvoicePartyDetailsPage InvoiceParty = new ShipWizardInvoicePartyDetailsPage(driver, test);
		ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
		ShipWizardShipmentTermsPage ShipTerms = new ShipWizardShipmentTermsPage(driver, test);
		ShipWizardAdditionalChargesPage AdditionalCharge = new ShipWizardAdditionalChargesPage(driver, test);
		ShipWizardExportAuthorisationsPage ExportClassiftn = new ShipWizardExportAuthorisationsPage(driver, test);
		ShipWizardTSCAReachInformationPage TSCA = new ShipWizardTSCAReachInformationPage(driver, test);
		ShipWizardSupportingDocumentationPage SupportDoc = new ShipWizardSupportingDocumentationPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWizd.select_SBUcode(SBUcode);
					ShipWizd.click_GoBtn();
					RequstorInfo.addRequestorInfo(ShipmentNo, PhoneNo);
					RequstorInfo.click_SaveAndProceed();
					ShipNoInfo.addShipmentInfo(TrackingNo, UltDestination);
					String ShipNo = ShipNoInfo.get_ShipmentNo();
					ShipNoInfo.partiesToTheTransaction(ExporterCode, ConsigneeId, "", "", "");
					ShipNoInfo.click_SaveBtn();
					Wait.waitfor(3);
					CreateNewShp.addContainerPackingDetails(MarkingsContainerID, SealNumber, ConsolidatedPackNumber,
							Hazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType, Model, TareWeight,
							DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity, Class, BOLText);
					ShipNoInfo.clickSaveAndProceedBtn();
					Wait.waitfor(3);
					InvoiceParty.addInvoiceDetails(PaymnetID, IncotermCode, DontPayInvoice, IncoNamedforDestination,
							ForCustomsPurpose, Notes);
					Wait.waitfor(3);
					InvoiceParty.addPartiesToTheTransaction(EntryType, ConsigneeIdBillTo);
					InvoiceParty.addCartonDetails(CartonDimensionUOM, CartonLenghtWidthHight, CartonWeightUOM,
							CartonGrossNet);
					ShipNoInfo.clickSaveAndProceedBtn();
					Wait.waitfor(3);
					Items.click_AddItem();
//					Items.addItemGeneralInfo(PartNo, MLCategoryExportClassification, TariffCode, ExportClassification,
//							ImportHTSUOM, USExportClassificationECCN, SalesOrderNo, SalesOrderItemNo, DeliveryOrderNo,
//							DeliveryOrderItemNo, SerialNumbers);
					Items.clickSaveBtn();
//					Items.addQuantityAndPricingInfo(CustomsInvoiceQuantity, Units, QuantityOrdered, TotalItemValue,
//							DiscountRate, WholesaleRate);
					Items.clickSaveBtn();
					Wait.waitfor(3);
					Items.addPackingInfo(GrossWeight, NetWeight, MarksAndNos, Dimensions, NoOfPkgs, AlternateUOM, Skids,
							PackingLenghtWidthHight, PackingWeightExWeight, Factor, Cubic);
					Wait.waitfor(3);
					Items.addBatchInfo(BatchNumber, BatchCountryOfOrigin, BatchQuantity, BatchExpiryDate,
							BatchSterilityDate);

					Items.clickSaveAndReturn();
					ShipNoInfo.clickShipmentTermsIcon();
					Wait.waitfor(3);
					ShipTerms.addShipiigTerms(FreightChargesPaidBy, CustomDutiesPaidBy, ForeignVATPaidBy,
							InsuranceRequired, ShipmentContainsPersonalInfo);
					ShipTerms.addOtherShipInfo(CostCenterNo, LineofBusinessSupported, ModeofTransportation,
							ManagertoApproveFreight, POReferenceNo, SpecialInstructions, ShipmentSpecialInstructions,
							AttachedDocuments);
					ShipTerms.addNotes(SpecialInstructions);
					ShipTerms.clickSaveAndProceedBtn();
					Wait.waitfor(3);
					AdditionalCharge.clickAddMoreChargesBtn();
					AdditionalCharge.addAdditionalCharges(ChargeDescription, Amount, ChargingAccount, GLACode,
							ChargeToCustomer, WholesalerCharge, PrintOnDocuments);
					ShipNoInfo.clickExportAuthorisationsIcon();
					Wait.waitfor(3);
					ExportClassiftn.Click_SelectAllItems();
					ExportClassiftn.addExportClassifications(ExportClasfctnECCN, AuthorizationNo, MLCategory,
							RegistrationNo, LicenseException, ITARExemption, RegulatoryCitation);
					ExportClassiftn.click_SaveBtn();
					ExportClassiftn.click_SaveAndProceed();
					TSCA.addTSCAReachInformation(TSCAReachInfoQuestion, TSCAReachInfoAnswer);
					ShipNoInfo.clickScreeningValidationsIcon();
					ShipNoInfo.clickAttachDocsSubmitIcon();
					Wait.waitfor(3);
					SupportDoc.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					Wait.waitfor(3);
					SupportDoc.submitShipReviewer(ShippingDeptReviewer, ExportComplianceReviewer,
							TransportGatekeeperExportOps);
					SupportDoc.click_Save();
					SupportDoc.click_SubmitForReviewer();
					Wait.waitfor(3);
					HGExport.return_ExportHome();
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWizd.type_ShipmentNo(ShipNo);
					ShipWizd.click_search();
					result.click_ShipmentNo(ShipNo);
					Wait.waitfor(4);
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
