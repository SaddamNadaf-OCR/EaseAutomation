package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;
import vmsClasses.WorkflowConfigurationDetailsPage;

public class ReviewWorkflowTrigger extends SeleniumTestBase {

	@Test
	public void standardrequest() {
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		WorkflowConfigurationDetailsPage workConfig = new WorkflowConfigurationDetailsPage(driver, test);
		VisitorSubmissionPage visitorSub = new VisitorSubmissionPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				
				/*searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_WorkFlowConfig();
				workConfig.VmctCofigSelect(propVMs.getProperty("SBU"));
				workConfig.enforceReview("No");
				workConfig.clickSaveAndReturn();*/
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				detail.enable_AllDayAcess();
				visitorInfo.get_RequestID();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				Wait.waitfor(3);
				visitors.addOrganisation(propVMs.getProperty("OrgName"), propVMs.getProperty("OrgType"),
						propVMs.getProperty("Address"), propVMs.getProperty("Address2"),
						propVMs.getProperty("Address3"), propVMs.getProperty("City"), propVMs.getProperty("Zip"),
						propVMs.getProperty("Country"), propVMs.getProperty("State"),
						propVMs.getProperty("CountryOfIncorporation"), propVMs.getProperty("UsAgency"),
						propVMs.getProperty("DLISCageCode"), propVMs.getProperty("DUNS_EIN"));

				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty("Company"),*/ propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));

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
				detail.forwardToQuestionnaire();
				Wait.waitfor(3);

				questionnairre.add_questions(propVMs.getProperty("Questionnairre"));
				detail.forwardToSubmit();
				Wait.waitfor(4);
				visitorSub.submitforreviewerAndApproved();
				
				homePage.returnPage();
				/*Wait.waitfor(4);
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_WorkFlowConfig();
				workConfig.VmctCofigSelect(propVMs.getProperty("SBU"));
				workConfig.enforceReview("Yes");
				workConfig.clickSaveAndReturn();
				Wait.waitfor(4);*/
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			searchVR.moveTo_Tools();
			searchVR.click_VMCT();
			vmct.click_WorkFlowConfig();
			workConfig.VmctCofigSelect(propVMs.getProperty("SBU"));
			workConfig.enforceReview("Yes");
			workConfig.clickSaveAndReturn();
			Assert.assertTrue(false);
		}
	}

}
