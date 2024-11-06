package importOperationScript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import importOperationClasses.EntryCreateNewEntrySummaryPage;
import importOperationClasses.EntrySummaryBillOfLadingPage;
import importOperationClasses.EntrySummaryDetailsPage;
import importOperationClasses.EntrySummaryHomePage;
import importOperationClasses.EntrySummaryItemDetailsPage;
import importOperationClasses.EntrySummaryPartyDetails;
import importOperationClasses.EntrySummarySearchPage;
import importOperationClasses.EntrySummarySubmitforReviewPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class CreateNewEntrySummary extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EntrySummaryDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void EntrySummary(String Testcase, String RunMode, String SBU, String TemplatesEN, String TemplatesRefN,
			String SummaryDate, String FilingMode, String FilingSystem, String Action, String EntryNumber,
			String ShipmentUsageType, String MutipleReliefAuthorizations, String DutyReliefType,
			String ReliefActivityType, String DueDate, String ElectronicSignature, String LiveEntry, String TeamNumber,
			String FTAReconciliation, String ReconciliationIssues, String Filer, String BondWaived,
			String BondWaiverReason, String BondType, String UseContinuousBond, String SuretyCompanyNo,
			String STBAmount, String BondAccountNo, String AddtlSTBCompanyNo, String AddtlSTBAmount,
			String AddtlSTBAccountNo, String BondDesignationTypeCode, String PaymentMode, String PaymentType,
			String PaymentTermType, String PaymentTerms, String INCOTerms, String INCOLocationIdentifier,
			String PreliminaryStatementPrintDate, String AccountInPeriodicStatement, String DeferredTaxPayment,
			String StatementClientBranch, String RequestAcceleratedLiquidation, String ElectronicInvoice,
			String ConsolidateSummary, String CertifyCargoRelease, String KnownImporterIndicator,
			String INCOTermsLocation, String ModeofTransport, String CarrierCode, String VesselName, String VesselCode,
			String VoyageFlightTripNo, String ForeignTradeZone, String EstimatedArrivalDate, String EstimatedEntryDate,
			String DateofImportation, String ITDate, String PortofEntry, String PortofUnlading, String LocationofGoods,
			String FIRMSCode, String RemoteLocationFiling, String DesignatedExamPort, String PartyType,
			String SourceFile, String PartyCode, String PartyName, String PartyIdType, String PartNo,
			String SupplierPartNo, String SourceSystemPartNo, String ProductName, String IdentificationQualifier,
			String IdentificationNo, String ArticleSet, String GrossWeight, String RelatedParty, String SupplierManufID,
			String CountryofOrigin, String ProvinceOfOrigin, String ExportingCountry, String ForeignPortOfLadingID,
			String DateOfExport, String SoldToParty, String DeliverToParty, String SIPCode, String FeeExemptionCode,
			String NAFTANetCost, String FTZMerchandiseStatus, String FTZLineItemQuantity,
			String ApplyTradeProgramPrivileges, String ClaimSPICode, String EligibleForDutyDrawback,
			String PrivilegedFTZMerchFilingDate, String PreviousFTZHSNo, String TariffRulingType, String HSRuling,
			String PrimaryHSNO, String PrimaryQty1, String PrimaryValue, String Charges, String DutyAmount,
			String BillNo, String BillType, String ParentBillNo, String BillCarrierCode, String Quantity, String UOM,
			String EquipmentNumber, String NonAMSIndicator, String DateOfArrival, String ConveyanceName, String ManifestUOM)
			throws Exception {
		// 41201

		EntrySummaryHomePage homeES = new EntrySummaryHomePage(driver, test);
		EntrySummarySearchPage searchES = new EntrySummarySearchPage(driver, test);
		EntryCreateNewEntrySummaryPage createES = new EntryCreateNewEntrySummaryPage(driver, test);
		EntrySummaryDetailsPage details = new EntrySummaryDetailsPage(driver, test);
		EntrySummaryPartyDetails party = new EntrySummaryPartyDetails(driver, test);
		EntrySummaryItemDetailsPage item = new EntrySummaryItemDetailsPage(driver, test);
		EntrySummaryBillOfLadingPage billofLading = new EntrySummaryBillOfLadingPage(driver, test);
		EntrySummarySubmitforReviewPage submit = new EntrySummarySubmitforReviewPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homeES.moveTo_SBUSelection(SBU);
					homeES.SelectFeatureAndEntry();
					searchES.addEntrySummary();
					createES.clkGoBtn();
					details.headerDeatils(TemplatesEN, TemplatesRefN, SummaryDate, FilingMode, FilingSystem, Action,
							EntryNumber, ShipmentUsageType, MutipleReliefAuthorizations, DutyReliefType,
							ReliefActivityType, DueDate, ElectronicSignature, LiveEntry, TeamNumber, FTAReconciliation,
							ReconciliationIssues, Filer);
					details.clickSave();
					Wait.waitfor(3);

					details.bondDetails(BondWaived, BondWaiverReason, BondType, UseContinuousBond, SuretyCompanyNo,
							STBAmount, BondAccountNo, AddtlSTBCompanyNo, AddtlSTBAmount, AddtlSTBAccountNo,
							BondDesignationTypeCode);
					details.clickSave();
					Wait.waitfor(3);
					details.paymentDetails(PaymentMode, PaymentType, PaymentTermType, PaymentTerms, INCOTerms,
							INCOLocationIdentifier, PreliminaryStatementPrintDate, AccountInPeriodicStatement,
							DeferredTaxPayment, StatementClientBranch, RequestAcceleratedLiquidation, ElectronicInvoice,
							ConsolidateSummary, CertifyCargoRelease, KnownImporterIndicator, INCOTermsLocation);
					details.clickSave();
					Wait.waitfor(3);
					details.shipmentDetails(ModeofTransport, CarrierCode, VesselName, VesselCode, VoyageFlightTripNo,
							ForeignTradeZone, EstimatedArrivalDate, EstimatedEntryDate, DateofImportation, ITDate,
							PortofEntry, PortofUnlading, LocationofGoods, FIRMSCode, RemoteLocationFiling,
							DesignatedExamPort);
					details.clickSave();
					Wait.waitfor(3);

					ArrayList<String> partyType = GenericMethods.stringtoken(PartyType);
					ArrayList<String> partyCode = GenericMethods.stringtoken(PartyCode);
					ArrayList<String> sourceFile = GenericMethods.stringtoken(SourceFile);
					for (int i = 0; i < partyType.size(); i++) {
						Wait.waitfor(3);
						details.clickAddparty();
						Wait.waitfor(3);
						party.addPartyDetails(partyType.get(i).trim(), sourceFile.get(i).trim(),
								partyCode.get(i).trim(), PartyIdType, "", "", "", "", "", "", "", "", "", "", "");
						party.saveAndReturnPartyDetails();
					}
					details.clickSaveAndProceed();
					Wait.waitfor(3);
					item.clickAddItem();
					Wait.waitfor(3);
					item.clickGO();
					Wait.waitfor(5);
					item.addItemInformation(PartNo, SupplierPartNo, SourceSystemPartNo, ProductName,
							IdentificationQualifier, IdentificationNo, ArticleSet, GrossWeight, RelatedParty,
							SupplierManufID, CountryofOrigin, ProvinceOfOrigin, ExportingCountry, ForeignPortOfLadingID,
							DateOfExport, SoldToParty, DeliverToParty);
					Wait.waitfor(3);
					item.addtariffDetails(TariffRulingType, HSRuling, PrimaryHSNO, PrimaryQty1, PrimaryValue);
					Wait.waitfor(5);
					
					/*item.addTradePrivilegesInformation(SIPCode, FeeExemptionCode, NAFTANetCost, FTZMerchandiseStatus,
							FTZLineItemQuantity, ApplyTradeProgramPrivileges, ClaimSPICode, EligibleForDutyDrawback,
							PrivilegedFTZMerchFilingDate, PreviousFTZHSNo);*/

					item.addInvoiceQuantityPrice("", "", "", Charges, "", DutyAmount, "");
					Wait.waitfor(3);
					item.clickBillofLading();
					Wait.waitfor(3);
					billofLading.bolDetails(BillNo, BillType, ParentBillNo, BillCarrierCode, Quantity, UOM,
							EquipmentNumber, NonAMSIndicator, DateOfArrival, ConveyanceName);
					Wait.waitfor(3);
					billofLading.clickSaveandReturn();
					Wait.waitfor(3);
					item.clickRefreshValue(ManifestUOM);
					Wait.waitfor(7);
					details.clickSubmitTab();
					submit.fillDeclaration();
					submit.clickApproved();
					Wait.waitfor(10);
					submit.getCustomFilingStatus();
					Wait.waitfor(4);
					homeES.returnHomepageImport();

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
			homeES.returnHomepageImport();
		}
	}

}
