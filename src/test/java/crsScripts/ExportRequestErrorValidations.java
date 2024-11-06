
package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportRequestAddNotesPage;
import crsClasses.ExportRequestDocumentsTabPage;
import crsClasses.ExportRequestFreightForwardersPage;
import crsClasses.ExportRequestItemsPage;
import crsClasses.ExportRequestPartiesPage;
import crsClasses.ExportRequestPortPage;
import crsClasses.ExportRequestSourceManufacturerPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestErrorValidations extends SeleniumTestBase {

	@Test
	public void exportGeneralInfo() throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCRs.moveTo_ListScreening();
				homeCRs.click_ComplianceRequest();
				searchExportRequest.moveTo_Features();
				searchExportRequest.click_Requests();
				searchExportRequest.click_ExportAuthReqlink();
				searchExportRequest.click_AddRequestBtn();
				exportAddRequestorDetails.addNewRequest();
				exportAddRequestorDetails.saveExportRequest();
				exportAddRequestorDetails.validateRequestorName();
				exportAddRequestorDetails.addRequestor("", propCRs.getProperty("ExportRequestorName"), "", "");
				exportAddRequestorDetails.saveExportRequest();
				exportAddRequestorDetails.validteRequestorEmail();
				exportAddRequestorDetails.addRequestor("", "", propCRs.getProperty("ExportRequestorEmail"), "");
				exportAddRequestorDetails.saveExportRequest();
				Wait.waitfor(4);
				homeCRs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			homeCRs.returnToCRPage();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void exportInfo() throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);
		ExportRequestItemsPage items = new ExportRequestItemsPage(driver, test);
		ExportRequestPartiesPage party = new ExportRequestPartiesPage(driver, test);
		ExportRequestFreightForwardersPage freightForward = new ExportRequestFreightForwardersPage(driver, test);
		ExportRequestPortPage port = new ExportRequestPortPage(driver, test);
		ExportRequestSourceManufacturerPage sourceManfture = new ExportRequestSourceManufacturerPage(driver, test);
		ExportRequestDocumentsTabPage document = new ExportRequestDocumentsTabPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCRs.moveTo_ListScreening();
				homeCRs.click_ComplianceRequest();
				searchExportRequest.moveTo_Features();
				searchExportRequest.click_Requests();
				searchExportRequest.click_ExportAuthReqlink();
				searchExportRequest.click_AddRequestBtn();
				exportAddRequestorDetails.addNewRequest();
				exportAddRequestorDetails.addRequestor("", propCRs.getProperty("ExportRequestorName"),
						propCRs.getProperty("ExportRequestorEmail"), "");
				exportAddRequestorDetails.saveExportRequest();
				exportAddRequestorDetails.clickOnGeneralDescription();
				exportAddRequestorDetails.click_ExportInfo();
				exportAddRequestorDetails.addItemLink();
				items.click_ItemSaveandReturn();
				items.validateItems();
				items.click_CancleItemBtn();
				exportAddRequestorDetails.addPartiesLink();
				party.saveAndReturn();
				party.validateAddParty();
				party.click_CancleBtn();
				exportAddRequestorDetails.addFreightFowarders();
				freightForward.click_FFSaveAndReturnBtn();
				freightForward.validationFreightForwarder();
				freightForward.click_CancleFreightForwarderBtn();
				exportAddRequestorDetails.addPorts();
				port.click_PortSaveAndReturnBtn();
				port.validationPort();
				port.click_CancelPortBtn();
				exportAddRequestorDetails.addSourceManufacturer();
				sourceManfture.clickSaveandReturn();
				sourceManfture.validateSourceAndManf();
				sourceManfture.click_cancleBtn();
				exportAddRequestorDetails.addDocument();
				document.SaveaAndReturn();
				document.validate_Document();
				document.click_CancleDocBtn();
				Wait.waitfor(4);
				homeCRs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			homeCRs.returnToCRPage();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void submitRequest() throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);
		ExportRequestAddNotesPage notes = new ExportRequestAddNotesPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCRs.moveTo_ListScreening();
				homeCRs.click_ComplianceRequest();
				searchExportRequest.moveTo_Features();
				searchExportRequest.click_Requests();
				searchExportRequest.click_ExportAuthReqlink();
				searchExportRequest.click_AddRequestBtn();
				exportAddRequestorDetails.addNewRequest();
				exportAddRequestorDetails.addRequestor("", propCRs.getProperty("ExportRequestorName"),
						propCRs.getProperty("ExportRequestorEmail"), "");
				exportAddRequestorDetails.saveExportRequest();
				exportAddRequestorDetails.submitRequest();
				exportAddRequestorDetails.addNotesBtn();
				notes.clickSavandReturn();
				notes.validate_Note();
				notes.clickOnCancel();
				exportAddRequestorDetails.click_submitTab();
				exportAddRequestorDetails.click_submitForReview();
				exportAddRequestorDetails.validate_SubmitReq();
				exportAddRequestorDetails.Add_ExportFocalPoint(propCRs.getProperty("ExportFocalUserName"));
				exportAddRequestorDetails.click_submitForReview();
				exportAddRequestorDetails.click_ExportStatus();
				exportAddRequestorDetails.click_SaveAndFinalizeBtn();
				exportAddRequestorDetails.validate_ExportFocalPoint();
				Wait.waitfor(4);
				homeCRs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homeCRs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}