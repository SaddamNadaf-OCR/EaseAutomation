package regressionTestingVMScripts;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.KioskSettingsPage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;
import initializer.SeleniumTestBase;


public class PreApprovedReqWithoutOrgincheckinkiosk extends SeleniumTestBase {

	@Test(priority = 12)
	public void validate() throws Exception {

		HomePage 					homePage 		 = new HomePage(driver, test);
		SearchVisitorRequestPage 	searchVR 		 = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create           = new CreateNewVisitorRequestPage(driver,test);
		VisitDetailsPage            detail           = new VisitDetailsPage(driver,test);
		VisitorsPage                visitors         = new VisitorsPage(driver, test);
		QuestionnairrePage          questionnairre   = new QuestionnairrePage(driver,test); 
		VisitorRequestNotesPage		notes            = new VisitorRequestNotesPage(driver,test);
		ReviewPage                  review           = new ReviewPage(driver,test);
		VisitorSubmissionPage       submit           = new VisitorSubmissionPage(driver,test);	
		VisitorInformationPage 		visitorInfo		 = new VisitorInformationPage(driver, test);
		VisitorMangmentConfigToolPage		vmct 			= new VisitorMangmentConfigToolPage(driver,test);
		VisitorRequestConfigPage			visitReqconfg 	= new VisitorRequestConfigPage(driver, test);
		KioskSettingsPage   				KioskSettings 	= new KioskSettingsPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.click_Create();
				detail.enable_AllDayAcess();
			//	String vid = visitorInfo.get_RequestID();
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));	
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				
				Wait.waitfor(5);
				detail.add_Site(propVMs.getProperty("Site"),propVMs.getProperty("BuildingName") , 
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.click_Savebtn();
				detail.forwardToVisitors();						

				visitors.add_Individual1(propVMs.getProperty("Title"),propVMs.getProperty("FirstName"),propVMs.getProperty("MiddleName"), 
						propVMs.getProperty("LastName"),propVMs.getProperty("Company1"),
						propVMs.getProperty("VisitorEmail"),propVMs.getProperty("PhoneNumber"));					

				visitors.add_AddressDetails(propVMs.getProperty("Vaddress"), propVMs.getProperty("Vaddress2"), 
						propVMs.getProperty("Vaddress3"),propVMs.getProperty("VCity") ,propVMs.getProperty("VCountry"),
						propVMs.getProperty("VState"),propVMs.getProperty("VZip") );				

				visitors.add_Citizenship(propVMs.getProperty("TypeOfPerson"),propVMs.getProperty("CountryofResidence") , 
						propVMs.getProperty("Visitorcategory"), propVMs.getProperty("CountryofCitizenship"),
						propVMs.getProperty("RepresentingForeignInterest"),	propVMs.getProperty("OtherCountriesofCitizenship"));				

				visitors.add_AdditionalDetails(propVMs.getProperty("DateofBirth"), propVMs.getProperty("PlaceofBirth"),
						propVMs.getProperty("Countryofbirth"),propVMs.getProperty("Gender"));				

				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),propVMs.getProperty("DocumentNumber"), 
						propVMs.getProperty("ExpirationDate"),propVMs.getProperty("IssuingState"),propVMs.getProperty("IssuingCountry"));				

				visitors.add_AddEquipment(propVMs.getProperty("EquipDescription"),propVMs.getProperty("EquipJustification"));			
				visitors.saveAndReturnBtn();
				Wait.waitfor(3);

				detail.forwardToQuestionnaire();
				Wait.waitfor(3);

				questionnairre.add_questions(propVMs.getProperty("Questionnairre"));
				detail.forwardToNotes();
				
				notes.click_AddNoteBtn();
				notes.add_notes(propVMs.getProperty("Notes"));		
				detail.forwardToSubmit();
				if(propVMs.getProperty("HostUserFirstName").length()>0) {
					submit.add_HostReviewer(propVMs.getProperty("HostUserFirstName"));
				}
				if(propVMs.getProperty("TDFPUserFirstName").length()>0) {
					submit.add_TDFPReviewer(propVMs.getProperty("TDFPUserFirstName"));	

				}
				if(propVMs.getProperty("ExportUserFirstName").length()>0) {
					submit.add_ExportControlReviewer(propVMs.getProperty("ExportUserFirstName"));
				}
				if(propVMs.getProperty("SecurityUserFirstName").length()>0) {
					submit.add_SecurityReviewer(propVMs.getProperty("SecurityUserFirstName"));						
				}
				submit.submitforreview();  
				review.multiplereviewersprocess1(propVMs.getProperty("WithSelectedBadgeType"),propVMs.getProperty("OverallDecision"), "");				
			
				Wait.waitfor(3);
				detail.forwardToVisitors();
				Wait.waitfor(3);
			
				String vistorC = detail.getVisitorCode();
				
                System.out.println(vistorC);
				Wait.waitfor(3);
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_Kiosksettings();
				visitReqconfg.select_KioskSBUcode(propVMs.getProperty("SelectSBU"));
				Wait.waitfor(3);
				visitReqconfg.select_VRSite(propVMs.getProperty("SiteId"));
				Wait.waitfor(3);
				visitReqconfg.click_KioskRequestEdit();
				KioskSettings.click_KReqVisitor();
				KioskSettings.click_KReqGenerateAccessLink();
				Wait.waitfor(3);
				KioskSettings.click_KReqAccessKioskLink();
				KioskSettings.click_KReqHomeStart();
				KioskSettings.click_KReqWHYes();
				Wait.waitfor(3);
				KioskSettings.type_KReqPreRegisteredLastname(propVMs.getProperty("LastName"));
				KioskSettings.type_KReqPreRegisteredVisitorCode(vistorC);
				Wait.waitfor(3);
				KioskSettings.click_KReqVisitorVerificationNext();
				KioskSettings.click_KReqFirstNameNext();
				Wait.waitfor(3);
				KioskSettings.click_KReqCOCNext();
				Wait.waitfor(3);
				String Org = KioskSettings.getOrgName();
				System.out.println(Org);
				if(Org.equalsIgnoreCase("Representing Self")) {
					test.log(LogStatus.PASS, "Organization name is showing "+Org);											
				}else {
					test.log(LogStatus.FAIL, "Organization name is not showing "+Org);
					testFail();						
				}
				KioskSettings.backtomainwindow();
				Wait.waitfor(3);
				KioskSettings.click_KReqAccessLinkCancel();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);			
			}
		} catch (SkipException s) {
			//s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();		
			e.printStackTrace();
			String window = "OCR Services, Inc. | Export & Import Global Trade Compliance Software Solutions";
			String window1 = driver.getTitle();
			if(!window.equalsIgnoreCase(window1)) {
				KioskSettings.backtomainwindow();
				KioskSettings.click_KReqAccessLinkCancel();
			}
			homePage.returnPage();		
		}
	}




}



