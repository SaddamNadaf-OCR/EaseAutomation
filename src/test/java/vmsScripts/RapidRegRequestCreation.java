/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : SEP 2018
 * Descriptions : Creating Rapid Registration Request in Multiple ways.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.AddOrEditIndividualPage;
import vmsClasses.AddOrEditOrganizationPage;
import vmsClasses.HomePage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;

public class RapidRegRequestCreation extends SeleniumTestBase {

	@Test(dataProvider = "getData")

	public void repidRegtn(String Testcase, String RunMode, String SBU, String FromDate, String ToDate, String Site,
			String BuildingName, String HostName, String EmailAddress, String HostPhone, String VisitHost,
			String OrgName, String OrgAddress, String OrgType, String Orgcity, String OrgZip, String OrgCountry,
			String OrgState, String RechangeOrgCountry, String RechangeOrgState, String OrgAssociated, String FirstName,
			String MiddleName, String LastName, String VisitorEmail, String VisitorPhone, String BadgeType,
			String BadgeNo, String ACSBadgeId, String TypeofPerson, String Category, String ContryOfcitizenShip,
			String Address, String Address2, String Address3, String City, String Zip, String Country, String State,
			String OtherCountryOfCitz, String IdentifyingDocs, String DocumentNo, String IssuingCountry,
			String IssuingState, String ExpirationDate, String Description, String Justification) throws Exception {

		// ************* Objects Creation ******************************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

		// ****************Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_AddNewVisitorRequest();
			
					visitorInfo.select_Site(Site);
					visitorInfo.type_BuildingName(BuildingName);
					if (HostName.length() > 0) {
						visitorInfo.click_AddHost();
						visitorInfo.type_HostName(HostName);
						visitorInfo.type_HostEmail(EmailAddress);
						visitorInfo.type_HostPhNo(HostPhone);
						visitorInfo.click_HostAdd();
					} else {
						visitorInfo.Select_HostAdd(VisitHost);
					}
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();
					if (OrgName.length() > 0) {
						visitorInfo.click_AddOrganization();
						addOrganization.type_OrgName(OrgName);
						addOrganization.type_OrgAddress(OrgAddress);
						addOrganization.select_OrgType(OrgType);
						addOrganization.type_Orgcity(Orgcity);
						addOrganization.type_OrgZip(OrgZip);
						addOrganization.type_OrgCountry(OrgCountry);
						addOrganization.type_OrgState(OrgState);
						addOrganization.click_SaveAndReturn();
						visitorInfo.get_RequestStatus();
						if (RechangeOrgCountry.length() > 0) {
							visitorInfo.ValidateDPLStatus();
							visitorInfo.click_OrgName(OrgName);
							addOrganization.validReScanAddOrg(RechangeOrgCountry, RechangeOrgState);
							addOrganization.click_SaveAndReturn();
						}
					}
					visitorInfo.click_AddVisitor();
					addVisitor.select_OrgAssociated(OrgAssociated);
					addVisitor.type_FirstName(FirstName);
					addVisitor.type_MiddleName(MiddleName);
					addVisitor.type_LastName(LastName);
					addVisitor.type_VisitorEmail(VisitorEmail);
					addVisitor.type_VisitorPhone(VisitorPhone);
					addVisitor.select_BadgeType(BadgeType);
					addVisitor.type_BadgeNo(BadgeNo);
					addVisitor.escortRequired();
					// addVisitor.type_ACSBadgeId(ACSBadgeId);
					addVisitor.select_Person(TypeofPerson);
					addVisitor.select_Category(Category);
					addVisitor.select_Citizenship(ContryOfcitizenShip);
					addVisitor.type_Address(Address);
					addVisitor.type_Address2(Address2);
					addVisitor.type_Address3(Address3);
					addVisitor.type_City(City);
					addVisitor.type_Zip(Zip);
					addVisitor.type_Country(Country);
					//addVisitor.type_State(State);
					Wait.waitfor(2);
					addVisitor.type_OtherCountryOfCitz(OtherCountryOfCitz);
					addVisitor.type_IdentifyingDocs(IdentifyingDocs);
					if (IdentifyingDocs.length() > 0) {
						addVisitor.type_IssuingCountry(IssuingCountry);
						addVisitor.type_IssuingState(IssuingState);
						addVisitor.select_ExpiratiponDate(ExpirationDate);
						addVisitor.type_DocumentNo(DocumentNo);
					}
					addVisitor.select_ReqVisitorLaptop();
					addVisitor.select_ReqVisitorCmPhone();
					addVisitor.type_Description(Description);
					addVisitor.type_Justification(Justification);
					Wait.waitfor(3);
					addVisitor.click_SaveAndReturn();
					
					Wait.waitfor(3);
					String RS=visitorInfo.get_RequestStatusAfterAddingVisitor();
					Wait.waitfor(4);
					
					if(RS.equalsIgnoreCase("WLS On Hold")) {
							visitorInfo.checkNotifyWLSReview();	
							visitorInfo.click_DplStatus();
							visitorInfo.changeStatus();
							Wait.waitfor(4);
							
					} 
					String RS1=visitorInfo.get_RequestStatusAfterAddingVisitor();
					
					if(RS1.equalsIgnoreCase("FV On Hold")) {
							visitorInfo.checkNotifyFVReview();
							Wait.waitfor(2);
							visitorInfo.changeStatus();
					} 
					
					visitorInfo.get_RequestStatusFinal();
					
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckIN();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(4);
					homePage.returnPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Wait.waitfor(3);
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("RapidRegistration", excel);
	}

}