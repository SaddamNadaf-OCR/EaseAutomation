
package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ImportAddPartyPage;
import crsClasses.ImportHardwareTechDataImportFreightForwarderPage;
import crsClasses.ImportHardwareTechDataPortPage;
import crsClasses.ImportHardwareTechDataServicesItemsPage;
import crsClasses.ImportNotesPage;
import crsClasses.ImportRequestPage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.ImportTemplatePage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ImportRequestErrorValidations extends SeleniumTestBase{
	
	@Test
	public void generalInfo() throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage     	searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 	searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportTemplatePage              template = new ImportTemplatePage(driver, test);
		ImportRequestPage			    importReq = new ImportRequestPage(driver, test);		
		
		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_ImportReq();
				searchIR.click_AddRequest();
				template.click_NewRequest();
				importReq.click_Save();
				Wait.waitfor(3);
				importReq.sbuValidation();				
				importReq.addImportRequest(propCRs.getProperty("BusinessUnit"), propCRs.getProperty("ImportRequiredDate"));
				importReq.click_Save();
				Wait.waitfor(3);
				importReq.reqNameValidation();
				importReq.addRequestor("",propCRs.getProperty("RequestorName") , "","");
				importReq.click_Save();
				Wait.waitfor(3);
				importReq.reqEmailValidation();
				importReq.addRequestor("", "",propCRs.getProperty("RequestorEmail"), "");
				importReq.click_Save();
				Wait.waitfor(4);
				home.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			home.returnToCRPage();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void importInfo() throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage     	searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 	searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportTemplatePage              template = new ImportTemplatePage(driver, test);
		ImportRequestPage			    importReq = new ImportRequestPage(driver, test);
		ImportHardwareTechDataServicesItemsPage htsItems = new ImportHardwareTechDataServicesItemsPage(driver, test);
		ImportAddPartyPage 			    addParty = new ImportAddPartyPage(driver, test);
		ImportHardwareTechDataImportFreightForwarderPage freightforwd  = new ImportHardwareTechDataImportFreightForwarderPage(driver, test);
		ImportHardwareTechDataPortPage 	port   = new ImportHardwareTechDataPortPage(driver, test);
	
		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_ImportReq();
				searchIR.click_AddRequest();
				template.click_NewRequest();				
				importReq.addImportRequest(propCRs.getProperty("BusinessUnit"), propCRs.getProperty("ImportRequiredDate"));				
				importReq.addRequestor("",propCRs.getProperty("RequestorName"),propCRs.getProperty("RequestorEmail"), "");
				importReq.click_Save();
				importReq.click_ImportInfoTab();
				importReq.click_ItemsTab();
				importReq.click_AddItemsBtn();
				htsItems.click_ItemSaveAndReturnBtn();
				htsItems.validationAddItems();
				htsItems.click_CancleItemBtn();
				importReq.click_PartiesTab();
				importReq.click_AddPartiesBtn();				
				addParty.click_PartySaveAndReturn();
				addParty.validationAddParty();
				addParty.click_CanclePartyBtn();				
				importReq.click_FreightForwardersTab();
				importReq.click_AddFreightForwdBtn();
				freightforwd.click_FFSaveAndReturnBtn();
				freightforwd.validationFreightForwarder();
				freightforwd.click_CancleFreightForwarderBtn();
				importReq.click_PortsTab();
				importReq.click_AddPortsBtn();							
				port.click_ItemSaveAndReturnBtn();
				port.validationPort();
				port.click_CanclePortBtn();
				importReq.click_DocumentTab();
				importReq.click_AddDocumentBtn();
				importReq.click_SaveAddDocumentBtn();
				importReq.validationDocument();
				importReq.click_CancleAddDocumentBtn();
				Wait.waitfor(4);
				home.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			home.returnToCRPage();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void submitRequest() throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage     	searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 	searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportTemplatePage              template = new ImportTemplatePage(driver, test);
		ImportRequestPage			    importReq = new ImportRequestPage(driver, test);	
		ImportNotesPage 				notes    = new ImportNotesPage(driver, test);
		
		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_ImportReq();
				searchIR.click_AddRequest();
				template.click_NewRequest();
				importReq.addImportRequest(propCRs.getProperty("BusinessUnit"), propCRs.getProperty("ImportRequiredDate"));		
				importReq.addRequestor("",propCRs.getProperty("RequestorName"),propCRs.getProperty("RequestorEmail"), "");
				importReq.click_Save();				
				importReq.click_SubmitReqTab();
				importReq.click_AddNoteBtn();								
				notes.click_SaveAndReturn();
				notes.validationNotes();
				notes.click_CancleNotesBtn();					
				importReq.click_SubmitTab();				
				importReq.click_SubmitForReview();
				Wait.waitfor(3);
				importReq.submitForReviewValidation();
				Wait.waitfor(4);
				home.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			home.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

}