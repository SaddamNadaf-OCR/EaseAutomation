package importOperationScript;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
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
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class ISFValidation  extends SeleniumTestBase {
	
	//Error Validation for Security Filing (ISF) Details tab
	@Test(priority = 1)
	public void validateSecurityFilingDetailstab(Method method) throws Exception {
		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSecurityFilingPage goISF = new ISFSecurityFilingPage(driver, test);
		ISFSecurityFilingDetailsPage detailsISF = new ISFSecurityFilingDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeISF.moveTo_SBUSelection(propIO.getProperty("ISFSBU"));
				Wait.waitfor(3);
				homeISF.SelectFeatureAndPreEntry();
				Wait.waitfor(3);
				searchISF.addNew();
				Wait.waitfor(3);
				goISF.clickOnGo();
				detailsISF.clickSave();
				detailsISF.validationISFDetails();
				detailsISF.generalInformationISF("", "", "",propIO.getProperty("ModeofTransport"), "", "", "", "", "");
				detailsISF.clickSave();
				detailsISF.clickAlert();
				detailsISF.validationGeneralInformation();
				detailsISF.closeAlert();
				detailsISF.generalInformationISF("", "", "", "", "", propIO.getProperty("ShipmentType"), "", "", "");
				detailsISF.clickSave();
				detailsISF.clickAlert();
				detailsISF.validationFilingDetails();
				detailsISF.closeAlert();
				Wait.waitfor(3);
				detailsISF.filingDetails(propIO.getProperty("FilingMode"), propIO.getProperty("FilingSystem"), "", "",propIO.getProperty("FiledBy"), "",
						propIO.getProperty("ImporterCode"), "", "","", propIO.getProperty("PortID"));
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.clickAlert();
				detailsISF.validationBondDetails();
				Wait.waitfor(3);
				detailsISF.closeAlert();
				detailsISF.bondDetails(propIO.getProperty("BondHolderType"), propIO.getProperty("ImporterCode1"), "", "", "", 
						propIO.getProperty("BondType"), propIO.getProperty("BondActivityType"), "", "");
				Wait.waitfor(3);
				detailsISF.clickSave();
				detailsISF.clickAlert();
				detailsISF.closeAlert();
				homeISF.returnHomepageImport();
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
		
	// Error validations for Security Filing (ISF) Party Details.
	@Test(priority = 2)
	public void validateSecurityFilingPartyDetailstab(Method method) throws Exception {
		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSecurityFilingPage goISF = new ISFSecurityFilingPage(driver, test);
		ISFSecurityFilingDetailsPage detailsISF = new ISFSecurityFilingDetailsPage(driver, test);
		ISFSecurityFilingPartyDetailsPage partyDeatils = new ISFSecurityFilingPartyDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeISF.moveTo_SBUSelection(propIO.getProperty("ISFSBU"));
				Wait.waitfor(3);
				homeISF.SelectFeatureAndPreEntry();
				Wait.waitfor(3);
				searchISF.addNew();
				Wait.waitfor(3);
				goISF.clickOnGo();
				detailsISF.clickSave();
				detailsISF.validationISFDetails();
				detailsISF.generalInformationISF("", "", "",propIO.getProperty("ModeofTransport"), "", propIO.getProperty("ShipmentType"), "", "", "");
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.filingDetails(propIO.getProperty("FilingMode"), propIO.getProperty("FilingSystem"), "", "",propIO.getProperty("FiledBy"), "",
						propIO.getProperty("ImporterCode"), "", "","", propIO.getProperty("PortID"));
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.bondDetails(propIO.getProperty("BondHolderType"), propIO.getProperty("ImporterCode1"), "", "", "", 
						propIO.getProperty("BondType"), propIO.getProperty("BondActivityType"), "", "");
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.clickAlert();
				Wait.waitfor(3);
				detailsISF.validationPartyDetails();
				Wait.waitfor(3);
				detailsISF.closeAlert();
				Wait.waitfor(3);
				ArrayList<String> partyType = GenericMethods.stringtoken(propIO.getProperty("ISFPartyType"));
				ArrayList<String> importerName = GenericMethods.stringtoken(propIO.getProperty("ISFImporterName"));
				ArrayList<String> partyCode = GenericMethods.stringtoken(propIO.getProperty("ISFPartyCode"));
				for (int i = 0; i < partyType.size(); i++) {
					Wait.waitfor(3);
					detailsISF.clickAlert();
					if (partyType.get(i).trim().contains("Importer of Record")) {
						detailsISF.validationPartyDetails();
					}
					if (partyType.get(i).trim().contains("Supplier/Manufacturer")) {
						detailsISF.validationPartyDetailsManufacturer();
					}
					if (partyType.get(i).trim().contains("Seller")) {
						detailsISF.validationPartyDetailsSeller();
					}
					if (partyType.get(i).trim().contains("Buyer")) {
						detailsISF.validationPartyDetailsBuyer();
					}
					if (partyType.get(i).trim().contains("Ship To")) {
						detailsISF.validationPartyDetailsShipTo();
					}
					if (partyType.get(i).trim().contains("Consolidator")) {
						detailsISF.validationPartyDetailsConsolidator();
					}
					if (partyType.get(i).trim().contains("Consignee")) {
						detailsISF.validationPartyDetailsConsignee();	
					}
					if (partyType.get(i).trim().contains("Container Stuffing Location")) {
						detailsISF.validationPartyDetailsContainerStuffingLocation();
					}
					detailsISF.closeAlert();
					Wait.waitfor(3);
					detailsISF.addParty();
					partyDeatils.addImporterOfRecord((partyType.get(i).trim()));
					if (importerName.get(i).trim().contains("Importer")) {
						partyDeatils.addImporter(partyCode.get(i).trim());
					}
					if (importerName.get(i).trim().contains("Vendor")) {
						partyDeatils.addVendor(partyCode.get(i).trim());
					}
					partyDeatils.saveandReturn();
				}
				Wait.waitfor(3);
				detailsISF.clickAlert();
				Wait.waitfor(3);
				detailsISF.closeAlert();
				Wait.waitfor(3);
				homeISF.returnHomepageImport();		
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
	
	// Error Validation for BOL Details
	@Test(priority = 3)
	public void validateSecurityFilingBillOfLadingDetails(Method method) throws Exception {
		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSecurityFilingPage goISF = new ISFSecurityFilingPage(driver, test);
		ISFSecurityFilingDetailsPage detailsISF = new ISFSecurityFilingDetailsPage(driver, test);
		ISFSecurityFilingBillOfLadingPage billPage = new ISFSecurityFilingBillOfLadingPage(driver, test);
		ISFItemDetailsPage itemPage = new ISFItemDetailsPage (driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeISF.moveTo_SBUSelection(propIO.getProperty("ISFSBU"));
				Wait.waitfor(3);
				homeISF.SelectFeatureAndPreEntry();
				Wait.waitfor(3);
				searchISF.addNew();
				Wait.waitfor(3);
				goISF.clickOnGo();
				detailsISF.clickSave();
				detailsISF.validationISFDetails();
				detailsISF.generalInformationISF("", "", "",propIO.getProperty("ModeofTransport"), "", propIO.getProperty("ShipmentType"), "", "", "");
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.filingDetails(propIO.getProperty("FilingMode"), propIO.getProperty("FilingSystem"), "", "",propIO.getProperty("FiledBy"), "",
						propIO.getProperty("ImporterCode"), "", "","", propIO.getProperty("PortID"));
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.itemDeatilsTab();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.validationBillOfLading();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				itemPage.addBOIButton();
				Wait.waitfor(3);
				billPage.clickSave();
				Wait.waitfor(3);
				billPage.validationBillTypeBillNo();
				Wait.waitfor(3);
				billPage.billType(propIO.getProperty("BillType"));
				Wait.waitfor(3);
				billPage.bolDetails(propIO.getProperty("BillNo"), "", "", "", "", "");
				Wait.waitfor(3);
				billPage.clickSaveandReturn();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.validationHouseBill();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				itemPage.addBOIButton();
				Wait.waitfor(3);
				billPage.billType(propIO.getProperty("BillType3"));
				Wait.waitfor(3);
				billPage.bolDetails(propIO.getProperty("BillNo"), "", "", "", "", "");
				Wait.waitfor(3);
				billPage.clickSaveandReturn();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				homeISF.returnHomepageImport();
				Wait.waitfor(4);
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
	
	// Error Validation for Item Details
	@Test(priority = 4)
	public void validateSecurityFilingItemDetails(Method method) throws Exception {
		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSecurityFilingPage goISF = new ISFSecurityFilingPage(driver, test);
		ISFSecurityFilingDetailsPage detailsISF = new ISFSecurityFilingDetailsPage(driver, test);
		ISFSecurityFilingPartyDetailsPage partyDeatils = new ISFSecurityFilingPartyDetailsPage(driver, test);
		ISFItemDetailsPage itemPage = new ISFItemDetailsPage (driver, test);
		ISFSecurityFilingItemDetailsPage addItemsPage = new ISFSecurityFilingItemDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeISF.moveTo_SBUSelection(propIO.getProperty("ISFSBU"));
				Wait.waitfor(3);
				homeISF.SelectFeatureAndPreEntry();
				Wait.waitfor(3);
				searchISF.addNew();
				Wait.waitfor(3);
				goISF.clickOnGo();
				detailsISF.clickSave();
				detailsISF.validationISFDetails();
				Wait.waitfor(3);
				detailsISF.generalInformationISF("", "", "",propIO.getProperty("ModeofTransport"), "", propIO.getProperty("ShipmentType"), "", "", "");
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.filingDetails(propIO.getProperty("FilingMode"), propIO.getProperty("FilingSystem"), "", "",propIO.getProperty("FiledBy"), "",
						propIO.getProperty("ImporterCode"), "", "","", propIO.getProperty("PortID"));
				Wait.waitfor(3);
				detailsISF.clickSave();
				Wait.waitfor(3);
				detailsISF.addParty();
				Wait.waitfor(3);
				partyDeatils.addImporterOfRecord(propIO.getProperty("ISFPartyTypeItem"));
				Wait.waitfor(3);
				partyDeatils.addVendor(propIO.getProperty("ISFVendorCodeItem"));
				Wait.waitfor(3);
				partyDeatils.saveandReturn();
				Wait.waitfor(3);
				detailsISF.itemDeatilsTab();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.validationItemDetails();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				itemPage.addItem();
				Wait.waitfor(3);
				addItemsPage.clickSave();
				Wait.waitfor(3);
				addItemsPage.validationISFPartNoHSNoCountryofOrigin();
				Wait.waitfor(3);
				addItemsPage.addItem("", propIO.getProperty("ISFPartNo"), "", "", propIO.getProperty("ISFHSNo"), "", "", 
						"", "");
				Wait.waitfor(3);
				addItemsPage.saveAndReturn();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.validationSupplierManufacture();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				itemPage.clickItemOne();
				Wait.waitfor(3);
				addItemsPage.addItem("", "", "", "", "", "", "", "", propIO.getProperty("UseSupplierManuf"));
				Wait.waitfor(3);
				addItemsPage.saveAndReturn();
				Wait.waitfor(3);
				itemPage.clickAlert();
				Wait.waitfor(3);
				itemPage.closeAlert();
				Wait.waitfor(3);
				homeISF.returnHomepageImport();
				Wait.waitfor(4);				
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