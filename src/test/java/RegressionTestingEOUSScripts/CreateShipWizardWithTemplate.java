package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardInvoicePartyDetailsPage;
import globalExportClasses.ShipWizardRequestorInformationPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipWizardSupportingDocumentationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateShipWizardWithTemplate extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateShipWizardWithTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipmentWizard(String Testcase, String RunMode, String SBU, String SBUcode, String TemplateID, String MarkingsContainerID, 
			String SealNumber, String ConsolidatedPackNumber, String Hazardous, String RadioActivityAmnt,
			 String DryIce, String GrossCartonWeight, String PackageType, String Model, String TareWeight, String DimensionUOM,
			String LenghtWidthHight, String WeightUOM, String GrossNet, String SKUQuantity, String Class, String BOLText, String DocumentType, 
			String UploadfileName, String DocumentLocationPath, String ShippingDeptReviewer,
			String ExportComplianceReviewer, String TransportGatekeeperExportOps) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardInvoicePartyDetailsPage InvoiceParty = new ShipWizardInvoicePartyDetailsPage(driver, test);
		ShipWizardSupportingDocumentationPage SupportDoc = new ShipWizardSupportingDocumentationPage(driver, test);
		
		
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
					ShipWizd.Click_CreateNewShipmentfromTemplate();
					ShipWizd.select_TemplateID(TemplateID);
					Wait.waitfor(2);
					ShipWizd.click_GoBtn();
					Wait.waitfor(2);
					RequstorInfo.validate_RequestorInformation();
					Wait.waitfor(2);
					RequstorInfo.click_SaveAndProceed();
					Wait.waitfor(3);
					ShipNoInfo.validate_PartiestotheTransaction();
					String ShipNo = ShipNoInfo.get_ShipmentNo();
					Wait.waitfor(3);
					CreateNewShp.addContainerPackingDetails(MarkingsContainerID, SealNumber, ConsolidatedPackNumber,
							Hazardous, RadioActivityAmnt, DryIce, GrossCartonWeight, PackageType, Model,
							TareWeight, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet, SKUQuantity, Class,
							BOLText);
					ShipNoInfo.clickSaveAndProceedBtn();
					Wait.waitfor(3);
					InvoiceParty.validate_ShipToOnInvoicePartyDetails();
					Wait.waitfor(3);
					ShipNoInfo.clickSaveAndProceedBtn();
					ShipNoInfo.clickShipmentTermsIcon();
					Wait.waitfor(3);
					ShipNoInfo.clickAttachDocsSubmitIcon();
					Wait.waitfor(3);
					SupportDoc.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					Wait.waitfor(3);
					SupportDoc.submitShipReviewer(ShippingDeptReviewer, ExportComplianceReviewer, TransportGatekeeperExportOps);
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
