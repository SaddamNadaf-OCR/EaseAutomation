package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.NotificationConfigurationEmailPage;
import vmsClasses.NotificationConfigurationPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestPage;
import vmsClasses.VisitorsPage;

public class DisableAttachFileCapabilityValidations extends SeleniumTestBase {

	@Test
	public void validateStandardReqDisableAttachFile() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver,test);
		NotificationConfigurationPage notifictn = new NotificationConfigurationPage(driver, test);
		NotificationConfigurationEmailPage notifnEmail = new NotificationConfigurationEmailPage(driver, test);
		VisitorRequestPage VRLog = new VisitorRequestPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.clickNotification();
				notifictn.VmctCofigNotifictn("SETES");
				notifnEmail.selectEmailType("Visitor Registration Invite");
				Wait.waitfor(4);
				notifnEmail.DisableAttachFileOFF();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.type_Phone("23231232134");
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				String RequestID = visitorInfo.get_RequestID();
				Wait.waitfor(4);
				detail.alertReqIDCreated(RequestID);
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				
				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"), propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));
				visitors.select_OrgzAssociated("Representing Self");
				visitors.add_AddressDetails(propVMs.getProperty("Vaddress"), propVMs.getProperty("Vaddress2"),
						propVMs.getProperty("Vaddress3"), propVMs.getProperty("VCity"), propVMs.getProperty("VCountry"),
						propVMs.getProperty("VState"), propVMs.getProperty("VZip"));

				visitors.add_Citizenship(propVMs.getProperty("TypeOfPerson"), propVMs.getProperty("CountryofResidence"),
						propVMs.getProperty("Visitorcategory"), propVMs.getProperty("CountryofCitizenship"),
						propVMs.getProperty("RepresentingForeignInterest"),
						propVMs.getProperty("OtherCountriesofCitizenship"));

				visitors.add_AdditionalDetails(propVMs.getProperty("DateofBirth"), propVMs.getProperty("PlaceofBirth"),
						propVMs.getProperty("Countryofbirth"), propVMs.getProperty("Gender"));

				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));

				visitors.add_AddEquipment(propVMs.getProperty("EquipDescription"),
						propVMs.getProperty("EquipJustification"));
				visitors.saveAndReturnBtn();
				visitors.click_DplStatus();
				visitors.verifyAttachFile();
				Wait.waitfor(4);
				homePage.returnPage();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.clickNotification();
				notifictn.VmctCofigNotifictn("SETES");
				notifnEmail.selectEmailType("Visitor Registration Invite");
				notifnEmail.DisableAttachFileOFF();
				notifnEmail.clickDisableAttachFile();
				notifnEmail.clickSave();
				notifnEmail.DisableAttachFileON();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.searchVisitorID(RequestID);
				searchVR.click_SearchButton();
				VRLog.click_visitorID(RequestID);
				visitors.sendInviteDisable();
				Wait.waitfor(3);
				homePage.returnPage();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.clickNotification();
				notifictn.VmctCofigNotifictn("SETES");
				notifnEmail.selectEmailType("Visitor Registration Invite");
				notifnEmail.clickDisableAttachFile();
				notifnEmail.clickSave();
				Wait.waitfor(4);
				homePage.returnPage();
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

}
