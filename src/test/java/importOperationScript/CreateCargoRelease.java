package importOperationScript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import importOperationClasses.CargoReleaseBillofLadingPage;
import importOperationClasses.CargoReleaseDeatilsPage;
import importOperationClasses.CargoReleaseFormPage;
import importOperationClasses.CargoReleaseItemsPage;
import importOperationClasses.CargoReleaseLineItemPage;
import importOperationClasses.CargoReleasePartyDetailsPage;
import importOperationClasses.CargoReleaseSubmitforReviewPage;
import importOperationClasses.HomePage;
import importOperationClasses.SearchCargoReleasePage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;

public class CreateCargoRelease extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CargoReleaseDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void CargoRelease(String Testcase, String RunMode, String SBU, String TemplatesEN, String TemplatesRefN,
			String CountryOfImp,String Filer, String Action, String EntryNumber, String PortEntryId, String MOTDesc,
			String PortUnladingId, String BondHolderIDType, String Carrier, String BondType, String BondHolderIDNo,
			String BondAccountNo, String SuretyCompanyNo, String BondAmount, String EstimatedShipmentValue,
			String FTZId, String ImmediateDlvryIndicator, String DISIndicator, String CancellationCode,
			String LocationofGoods, String MultiCargoDispositionsInd, String DISRefNumber, String ElectedExamSite,
			String ElectedEntryDate, String WarehouseEntryFilerCode, String WarehouseEntryPort, String GeneralOrderNo,
			String WarehouseEntryNo, String OrderNo, String PartyType, String ImporterName, String PartyCode,
			String ContactName, String ContactPhone, String BillType, String BillNo, String ParentBillNo,
			String CarrierCode, String Qty, String UOM, String EquipmentNo, String NonAMSIndicator,
			String ConveyanceName, String VoyageFlightTripNumber, String DateOfArrival, String CommercialInvoiceNo,
			String InvoiceItemNo, String OrderNol, String OrderItemNo, String PartNo, String SourceSystemPartNo,
			String ManufacturerPartNumber, String CountryofOrigin, String PartDescription, String ManufSupplier,
			String FTZMerchandiseStatus, String Qtyl, String UOMl, String PrivilegedFTZMerchandiseFilingDate,
			String CurrentFTZHSNo, String PrimaryHSNo, String PrimaryValue, String SecondaryHsNo, String SecondaryValue,
			String ConsigneeItem, String Name) throws Exception {

		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		CargoReleaseFormPage formPage = new CargoReleaseFormPage(driver, test);
		CargoReleaseDeatilsPage detailsPage = new CargoReleaseDeatilsPage(driver, test);
		CargoReleasePartyDetailsPage partyDeatils = new CargoReleasePartyDetailsPage(driver, test);
		CargoReleaseItemsPage itemPage = new CargoReleaseItemsPage(driver, test);
		CargoReleaseBillofLadingPage billPage = new CargoReleaseBillofLadingPage(driver, test);
		CargoReleaseLineItemPage lineItem = new CargoReleaseLineItemPage(driver, test);
		CargoReleaseSubmitforReviewPage submit = new CargoReleaseSubmitforReviewPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homeCR.moveTo_SBUSelection(SBU);
					homeCR.SelectFeatureAndEntry();
					searchCR.addNew();
					formPage.clickGo();
					detailsPage.generalInformation(TemplatesEN, TemplatesRefN, CountryOfImp,Filer, Action, EntryNumber,
							PortEntryId, MOTDesc, PortUnladingId, BondHolderIDType, Carrier, BondType, BondHolderIDNo,
							BondAccountNo, SuretyCompanyNo, BondAmount, EstimatedShipmentValue);
					detailsPage.AdditionalInformation(FTZId, ImmediateDlvryIndicator, DISIndicator, CancellationCode,
							LocationofGoods, MultiCargoDispositionsInd, DISRefNumber, ElectedExamSite, ElectedEntryDate,
							WarehouseEntryFilerCode, WarehouseEntryPort, GeneralOrderNo, WarehouseEntryNo);

					ArrayList<String> partyType = GenericMethods.stringtoken(PartyType);
					ArrayList<String> importerName = GenericMethods.stringtoken(ImporterName);
					ArrayList<String> partyCode = GenericMethods.stringtoken(PartyCode);
					for (int i = 0; i < partyType.size(); i++) {
						detailsPage.addPartyDetails();
						partyDeatils.addOrderNo(OrderNo);
						partyDeatils.addImporterOfRecord(partyType.get(i).trim());
						if (importerName.get(i).trim().contains("Importer")) {
							partyDeatils.addImporter(partyCode.get(i).trim());
						}
						if (importerName.get(i).trim().contains("Vendor")) {
							partyDeatils.addVendor(partyCode.get(i).trim());
						}
						if (importerName.get(i).trim().contains("Consignee")) {
							partyDeatils.addConsignee(partyCode.get(i).trim());
						}
						partyDeatils.saveandReturn();
					}

					detailsPage.clickImporter();
					partyDeatils.addContactNameAndPhone(ContactName, ContactPhone);
					partyDeatils.saveandReturn();
					detailsPage.lineitemdetails();
					ArrayList<String> billType = GenericMethods.stringtoken(BillType);
					ArrayList<String> qty = GenericMethods.stringtoken(Qty);
					ArrayList<String> uOM = GenericMethods.stringtoken(UOM);
					ArrayList<String> billNo = GenericMethods.stringtoken(BillNo);
					for (int i = 0; i < billType.size(); i++) {
						itemPage.clkBillOfLading();
						billPage.addBillType(billType.get(i));
						billPage.addBOI(billNo.get(i), ParentBillNo, CarrierCode, qty.get(i), uOM.get(i), EquipmentNo,
								NonAMSIndicator, ConveyanceName, VoyageFlightTripNumber, DateOfArrival);
						billPage.saveandReturn();
					}

					itemPage.clkAddItems();
					lineItem.addItems(CommercialInvoiceNo, InvoiceItemNo, OrderNol, OrderItemNo, PartNo,
							SourceSystemPartNo, ManufacturerPartNumber, CountryofOrigin, PartDescription, ManufSupplier,
							FTZMerchandiseStatus, Qtyl, UOMl, PrivilegedFTZMerchandiseFilingDate, CurrentFTZHSNo,
							PrimaryHSNo, PrimaryValue, SecondaryHsNo, SecondaryValue, ConsigneeItem);
					lineItem.saveandReturn();
					itemPage.submitTab();
					submit.alertIcon();
					submit.getDataScrenningAndApprove();
					// submit.alertClose();
					// submit.addName(Name);
					// submit.clickApprove();
					submit.alertIcon();
					submit.customResponseTab();
					submit.getCustomResponse();

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
			homeCR.returnHomepageImport();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
