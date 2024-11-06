package importOperationScript;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import importOperationClasses.CargoReleaseBillofLadingPage;
import importOperationClasses.CargoReleaseDeatilsPage;
import importOperationClasses.CargoReleaseFormPage;
import importOperationClasses.CargoReleaseItemsPage;
import importOperationClasses.CargoReleaseLineItemPage;
import importOperationClasses.CargoReleasePartyDetailsPage;
import importOperationClasses.HomePage;
import importOperationClasses.SearchCargoReleasePage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class CargoReleaseValidation extends SeleniumTestBase {

	// Error validations for Cargo Release Details tab

	@Test(priority = 1)
	public void validateCargoReleaseDetailstab(Method method) throws Exception {
		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		CargoReleaseFormPage formPage = new CargoReleaseFormPage(driver, test);
		CargoReleaseDeatilsPage detailsPage = new CargoReleaseDeatilsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCR.moveTo_SBUSelection(propIO.getProperty("SBU"));
				homeCR.SelectFeatureAndEntry();
				searchCR.addNew();
				formPage.clickGo();
				detailsPage.clickOnSave();
				detailsPage.validationCargoDetails();
				detailsPage.generalInformation(propIO.getProperty("TemplatesEN"), propIO.getProperty("TemplatesRefN"),
						"", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
				detailsPage.clickOnSave();
				Wait.waitfor(3);
				detailsPage.alertIcon();
				detailsPage.validationGeneralInformation();
				Wait.waitfor(3);
				detailsPage.alertClose();
				Wait.waitfor(3);
				detailsPage.generalInformation("", "", "", propIO.getProperty("Filer"), propIO.getProperty("Action"),
						propIO.getProperty("EntryNumber"), propIO.getProperty("PortEntryId"),
						propIO.getProperty("MOTDesc"), "", propIO.getProperty("BondHolderIDType"), "",
						propIO.getProperty("BondType"), propIO.getProperty("BondHolderIDNo"), "", "", "",
						propIO.getProperty("EstimatedShipmentValue"));
				detailsPage.clickOnSave();
				detailsPage.alertIcon();
				detailsPage.alertClose();
				Wait.waitfor(4);
				homeCR.returnHomepageImport();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeCR.returnHomepageImport();
			Assert.assertTrue(false);
		}
	}

	// Error validations for Cargo Release Party Details

	@Test(priority = 2)
	public void validateCargoReleasePartyDetails(Method method) throws Exception {
		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		CargoReleaseFormPage formPage = new CargoReleaseFormPage(driver, test);
		CargoReleaseDeatilsPage detailsPage = new CargoReleaseDeatilsPage(driver, test);
		CargoReleasePartyDetailsPage partyDeatils = new CargoReleasePartyDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCR.moveTo_SBUSelection(propIO.getProperty("SBU"));
				homeCR.SelectFeatureAndEntry();
				searchCR.addNew();
				formPage.clickGo();
				detailsPage.clickOnSave();
				detailsPage.validationCargoDetails();
				detailsPage.generalInformation(propIO.getProperty("TemplatesEN"), propIO.getProperty("TemplatesRefN"),
						"", propIO.getProperty("Filer"), propIO.getProperty("Action"),
						propIO.getProperty("EntryNumber"), "", propIO.getProperty("MOTDesc"), "", "", "", "", "", "",
						"", "", "");
				detailsPage.clickOnSave();
				ArrayList<String> partyType = GenericMethods.stringtoken(propIO.getProperty("PartyType"));
				ArrayList<String> importerName = GenericMethods.stringtoken(propIO.getProperty("ImporterName"));
				ArrayList<String> partyCode = GenericMethods.stringtoken(propIO.getProperty("PartyCode"));
				for (int i = 0; i < partyType.size(); i++) {
					Wait.waitfor(3);
					detailsPage.alertIcon();
					if (partyType.get(i).trim().contains("Importer of Record")) {
						detailsPage.validationPartyDeatilsImporter();
					}
					if (partyType.get(i).trim().contains("Buyer")) {
						detailsPage.validationPartyDeatilsBuyingParty();
					}
					if (partyType.get(i).trim().contains("Seller")) {
						detailsPage.validationPartyDeatilsSellingParty();
					}
					if (partyType.get(i).trim().contains("Consignee")) {
						detailsPage.validationPartyDeatilsConsignee();
					}
					if (partyType.get(i).trim().contains("Supplier/Manufacturer")) {
						detailsPage.validationPartyDeatilsManufSupplier();
					}
					detailsPage.alertClose();
					Wait.waitfor(3);
					detailsPage.addPartyDetails();
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
				detailsPage.alertIcon();
				detailsPage.validationContactNameAndPhone();
				detailsPage.alertClose();
				Wait.waitfor(3);
				detailsPage.clickImporter();
				partyDeatils.addContactNameAndPhone(propIO.getProperty("ContactName"),
						propIO.getProperty("ContactPhone"));
				partyDeatils.saveandReturn();
				detailsPage.alertIcon();
				detailsPage.alertClose();
				Wait.waitfor(4);
				homeCR.returnHomepageImport();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeCR.returnHomepageImport();
			Assert.assertTrue(false);
		}
	}

	// Error Validation for BOL Details

	@Test(priority = 3)
	public void validateCargoReleaseBillOfLadingDetails(Method method) throws Exception {
		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		CargoReleaseFormPage formPage = new CargoReleaseFormPage(driver, test);
		CargoReleaseDeatilsPage detailsPage = new CargoReleaseDeatilsPage(driver, test);
		CargoReleaseItemsPage itemPage = new CargoReleaseItemsPage(driver, test);
		CargoReleaseBillofLadingPage billPage = new CargoReleaseBillofLadingPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCR.moveTo_SBUSelection(propIO.getProperty("SBU"));
				homeCR.SelectFeatureAndEntry();
				searchCR.addNew();
				formPage.clickGo();
				detailsPage.clickOnSave();
				detailsPage.validationCargoDetails();
				detailsPage.generalInformation(propIO.getProperty("TemplatesEN"), propIO.getProperty("TemplatesRefN"),
						"", propIO.getProperty("Filer"), propIO.getProperty("Action"),
						propIO.getProperty("EntryNumber"), "", propIO.getProperty("MOTDesc"), "", "", "", "", "", "",
						"", "", "");
				detailsPage.clickOnSave();
				detailsPage.lineitemdetails();

				itemPage.clickAlertIcon();
				itemPage.validationBillOfLading();
				itemPage.closeAlertPopUp();
				itemPage.clkBillOfLading();
				billPage.save();
				Wait.waitfor(3);
				billPage.validationBillTypeBillNo();
				Wait.waitfor(3);
				billPage.addBillType(propIO.getProperty("BillType1"));
				Wait.waitfor(3);
				billPage.addBOI(propIO.getProperty("BillNo"), "", "", "", "", "", "", "", "", "");
				Wait.waitfor(3);
				billPage.saveandReturn();
				Wait.waitfor(3);
				itemPage.clickAlertIcon();
				itemPage.validationIssuerCode();
				Wait.waitfor(3);
				itemPage.closeAlertSec();
				Wait.waitfor(3);
				itemPage.clickBOL1();
				Wait.waitfor(3);
				billPage.addBOI("", "", propIO.getProperty("CarrierCode"), "", "", "", "", "", "", "");
				billPage.saveandReturn();
				itemPage.clickAlertIcon();
				Wait.waitfor(3);
				itemPage.validationHouseBill();
				Wait.waitfor(3);
				itemPage.closeAlertTh();
				itemPage.clkBillOfLading();
				billPage.addBillType(propIO.getProperty("BillType2"));
				billPage.addBOI(propIO.getProperty("BillNo"), "", propIO.getProperty("CarrierCode"), "", "", "", "", "",
						"", "");
				billPage.saveandReturn();
				Wait.waitfor(3);
				itemPage.clickAlertIcon();
				itemPage.closeAlert4th();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeCR.returnHomepageImport();
			Assert.assertTrue(false);
		}
	}

	// Error Validation for Item Details

	@Test(priority = 4)
	public void validateCargoReleaseItemDeatils(Method method) throws Exception {
		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		CargoReleaseFormPage formPage = new CargoReleaseFormPage(driver, test);
		CargoReleaseDeatilsPage detailsPage = new CargoReleaseDeatilsPage(driver, test);
		CargoReleaseItemsPage itemPage = new CargoReleaseItemsPage(driver, test);
		CargoReleasePartyDetailsPage partyDeatils = new CargoReleasePartyDetailsPage(driver, test);
		CargoReleaseLineItemPage lineItem = new CargoReleaseLineItemPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCR.moveTo_SBUSelection(propIO.getProperty("SBU"));
				homeCR.SelectFeatureAndEntry();
				searchCR.addNew();
				formPage.clickGo();
				detailsPage.clickOnSave();
				detailsPage.validationCargoDetails();
				detailsPage.generalInformation(propIO.getProperty("TemplatesEN"), propIO.getProperty("TemplatesRefN"),
						"", propIO.getProperty("Filer"), propIO.getProperty("Action"),
						propIO.getProperty("EntryNumber"), "", propIO.getProperty("MOTDesc"), "", "", "", "", "", "",
						"", "", "");
				detailsPage.clickOnSave();
				ArrayList<String> partyType = GenericMethods.stringtoken(propIO.getProperty("PartyType"));
				ArrayList<String> importerName = GenericMethods.stringtoken(propIO.getProperty("ImporterName"));
				ArrayList<String> partyCode = GenericMethods.stringtoken(propIO.getProperty("PartyCode"));
				for (int i = 0; i < partyType.size(); i++) {
					detailsPage.addPartyDetails();
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
				detailsPage.lineitemdetails();
				itemPage.clickAlertIcon();
				itemPage.validationItemDetails();
				itemPage.closeAlertPopUp();
				Wait.waitfor(3);
				itemPage.clkAddItems();
				Wait.waitfor(3);
				lineItem.saveandReturn();
				Wait.waitfor(3);
				lineItem.validationPartNoHSNo();
				lineItem.addItems("", "", "", "", propIO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "",
						propIO.getProperty("PrimaryHSNo"), "", "", "", "");
				lineItem.saveandReturn();
				itemPage.clickAlertIcon();
				Wait.waitfor(5);
				itemPage.validationInItemsDetails();
				Wait.waitfor(5);
				itemPage.closeAlertSec();
				Wait.waitfor(3);
				itemPage.clkAddItems1();
				lineItem.addItems("", "", "", "", "", "", "", propIO.getProperty("CountryofOrigin"), "",
						propIO.getProperty("ManufSupplier"), "", "", "", "", "", "", propIO.getProperty("PrimaryValue"),
						"", "", propIO.getProperty("ConsigneeItem"));
				lineItem.saveandReturn();
				itemPage.clickAlertIcon();
				itemPage.closeAlertTh();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeCR.returnHomepageImport();
			Assert.assertTrue(false);
		}
	}

}
