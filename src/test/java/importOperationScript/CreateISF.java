package importOperationScript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import importOperationClasses.ISFHomePage;
import importOperationClasses.ISFItemDetailsPage;
import importOperationClasses.ISFSearchSecurityFilingPage;
import importOperationClasses.ISFSecurityFilingBillOfLadingPage;
import importOperationClasses.ISFSecurityFilingDetailsPage;
import importOperationClasses.ISFSecurityFilingItemDetailsPage;
import importOperationClasses.ISFSecurityFilingPage;
import importOperationClasses.ISFSecurityFilingPartyDetailsPage;
import importOperationClasses.ISFSecurityFilingSubmitforReviewPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class CreateISF extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ISFDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void ISF(String Testcase, String RunMode, String SBU, String TemplatesISFNo, String TemplatesIntRefNo,
			String CustomsTransactionNo, String ModeofTransport, String CarrierSCACCode, String ShipmentType,
			String ShipmentSubType, String ShippingDate, String EstimatedArrivalDate, String FilingMode,
			String FilingSystem, String Action, String ActionReason, String FiledBy, String SubmissionType,
			String ImporterCode, String FilerName, String FilerIDType, String FilerIDNo, String PortID,
			String BondHolderType, String ImporterCode1, String BondHolderName, String BondHolderIDType,
			String BondHolderIDNo, String BondType, String BondActivityType, String SuretyNo,
			String BondReferenceNumber, String EstimatedValue, String EstimatedNoofPackages, String EstimatedQty,
			String EstimatedUOM, String EstimatedWeight, String EstimatedUOM1, String UnladingPortCodeType,
			String UnladingPortName, String UnladingPortCode, String PlaceofDeliveryCodeType,
			String PlaceofDeliveryName, String PlaceofDeliveryCode, String OrderNo, String PartyType,
			String ImporterName, String PartyCode, String BillType, String BillNo, String ParentBillNo,
			String CarrierCode, String Qty, String UOM, String BillStatus, String EquipmentType,
			String EquipmentInitial, String EquipmentNo, String BillNoIt, String PartNo, String SourceSystemPartNumber,
			String ManufacturerPartNumber, String HSNo, String PartDescription, String ProductName,
			String CountryofOrigin, String UseSupplierManuf, String Name, String PhoneNo) throws Exception {

		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSecurityFilingPage goISF = new ISFSecurityFilingPage(driver, test);
		ISFSecurityFilingDetailsPage detailsISF = new ISFSecurityFilingDetailsPage(driver, test);
		ISFSecurityFilingPartyDetailsPage partyDeatils = new ISFSecurityFilingPartyDetailsPage(driver, test);
		ISFSecurityFilingBillOfLadingPage billPage = new ISFSecurityFilingBillOfLadingPage(driver, test);
		ISFItemDetailsPage itemPage = new ISFItemDetailsPage(driver, test);
		ISFSecurityFilingItemDetailsPage addItemsPage = new ISFSecurityFilingItemDetailsPage(driver, test);
		ISFSecurityFilingSubmitforReviewPage submitPage = new ISFSecurityFilingSubmitforReviewPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homeISF.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					homeISF.SelectFeatureAndPreEntry();
					Wait.waitfor(3);
					searchISF.addNew();
					Wait.waitfor(3);
					goISF.clickOnGo();
					detailsISF.generalInformationISF(TemplatesISFNo, TemplatesIntRefNo, CustomsTransactionNo,
							ModeofTransport, CarrierSCACCode, ShipmentType, ShipmentSubType, ShippingDate,
							EstimatedArrivalDate);
					detailsISF.clickSave();
					detailsISF.filingDetails(FilingMode, FilingSystem, Action, ActionReason, FiledBy, SubmissionType,
							ImporterCode, FilerName, FilerIDType, FilerIDNo, PortID);
					Wait.waitfor(3);
					detailsISF.clickSave();
					detailsISF.bondDetails(BondHolderType, ImporterCode1, BondHolderName, BondHolderIDType,
							BondHolderIDNo, BondType, BondActivityType, SuretyNo, BondReferenceNumber);
					Wait.waitfor(3);
					detailsISF.clickSave();
					detailsISF.summary(EstimatedValue, EstimatedNoofPackages, EstimatedQty, EstimatedUOM,
							EstimatedWeight, EstimatedUOM1, UnladingPortCodeType, UnladingPortName, UnladingPortCode,
							PlaceofDeliveryCodeType, PlaceofDeliveryName, PlaceofDeliveryCode);
					Wait.waitfor(3);
					detailsISF.clickSave();

					ArrayList<String> partyType = GenericMethods.stringtoken(PartyType);
					ArrayList<String> importerName = GenericMethods.stringtoken(ImporterName);
					ArrayList<String> partyCode = GenericMethods.stringtoken(PartyCode);
					for (int i = 0; i < partyType.size(); i++) {
						detailsISF.addParty();
						partyDeatils.addimportOrderNo(OrderNo);
						partyDeatils.addImporterOfRecord((partyType.get(i).trim()));
						if (importerName.get(i).trim().contains("Importer")) {
							partyDeatils.addImporter(partyCode.get(i).trim());
						}
						if (importerName.get(i).trim().contains("Vendor")) {
							partyDeatils.addVendor(partyCode.get(i).trim());
						}
						partyDeatils.saveandReturn();
						Wait.waitfor(3);
					}
					Wait.waitfor(5);
					detailsISF.itemDeatilsTab();
					ArrayList<String> billType = GenericMethods.stringtoken(BillType);
					ArrayList<String> qty = GenericMethods.stringtoken(Qty);
					ArrayList<String> uOM = GenericMethods.stringtoken(UOM);
					ArrayList<String> billNo = GenericMethods.stringtoken(BillNo);
					ArrayList<String> billStatus = GenericMethods.stringtoken(BillStatus);
					for (int i = 0; i < billType.size(); i++) {
						itemPage.addBOIButton();
						billPage.billType(billType.get(i));
						billPage.bolDetails(billNo.get(i), ParentBillNo, CarrierCode, qty.get(i), uOM.get(i),
								billStatus.get(i));
						billPage.clickSaveandReturn();
					}
					Wait.waitfor(3);
					itemPage.addItem();
					addItemsPage.addItem(BillNoIt, PartNo, SourceSystemPartNumber, ManufacturerPartNumber, HSNo,
							PartDescription, ProductName, CountryofOrigin, UseSupplierManuf);
					addItemsPage.saveAndReturn();
					Wait.waitfor(3);
					itemPage.clickSubmitTab();
					Wait.waitfor(3);
					submitPage.clickAlert();
					Wait.waitfor(3);
					submitPage.validationCheck();
					Wait.waitfor(3);
					submitPage.closeAlet();
					Wait.waitfor(3);
					submitPage.clickApprove();
					Wait.waitfor(5);
					submitPage.clickISFDeatils();
					Wait.waitfor(15);
					detailsISF.clickAlert();
					Wait.waitfor(3);
					submitPage.clickCustomResonsetab();
					Wait.waitfor(3);
					submitPage.getCustomResponse();
					Wait.waitfor(3);
					homeISF.returnHomepageImport();

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
			homeISF.returnHomepageImport();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
