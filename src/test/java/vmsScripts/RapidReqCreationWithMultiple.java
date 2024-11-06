/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : OCT 2018
 * Descriptions : Creating Multiple Request in Rapid Reg. with Same VID.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package vmsScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.AddOrEditIndividualPage;
import vmsClasses.AddOrEditOrganizationPage;
import vmsClasses.HomePage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;

public class RapidReqCreationWithMultiple extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void repidRegtn(String Testcase, String RunMode, String SBU, String Site, String BuildingName,
			String HostName, String EmailAddress, String OrgName, String OrgType, String Orgcity, String OrgZip,
			String OrgCountry, String OrgState, String OrgAssociated, String FirstName, String MiddleName,
			String LastName, String VisitorEmail, String BadgeType, String BadgeNo, String TypeofPerson,
			String Category, String ContryOfcitizenShip, String Zip, String Country, String State,
			String IdentifyingDocs, String IssuingCountry, String IssuingState, String ExpirationDate,
			String DocumentNo, String Description, String Justification) throws Exception {

		// ******************************** Objects Creation *************************

		HomePage homePage = new HomePage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

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

					ArrayList<String> site = GenericMethods.stringtoken(Site);
					for (int i = 0; i < site.size(); i++) {
						Wait.waitfor(2);
						visitorInfo.select_Site(site.get(i));
						
						visitorInfo.type_BuildingName(BuildingName);
						visitorInfo.clickAddSite();
					}

					ArrayList<String> name = GenericMethods.stringtoken(HostName);
					ArrayList<String> email = GenericMethods.stringtoken(EmailAddress);
					for (int i = 0; i < name.size(); i++) {
						visitorInfo.click_AddHost();
						visitorInfo.type_HostName(name.get(i));
						visitorInfo.type_HostEmail(email.get(i));
						visitorInfo.click_HostAdd();
						Wait.waitfor(5);
					}
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();

					ArrayList<String> orgname = GenericMethods.stringtoken(OrgName);
					ArrayList<String> orgtype = GenericMethods.stringtoken(OrgType);
					ArrayList<String> orgcity = GenericMethods.stringtoken(Orgcity);
					ArrayList<String> orgzip = GenericMethods.stringtoken(OrgZip);
					ArrayList<String> orgcountry = GenericMethods.stringtoken(OrgCountry);
					ArrayList<String> orgstate = GenericMethods.stringtoken(OrgState);
					for (int i = 0; i < orgname.size(); i++) {
						visitorInfo.click_AddOrganization();
						addOrganization.type_OrgName(orgname.get(i));
						addOrganization.select_OrgType(orgtype.get(i));
						addOrganization.type_Orgcity(orgcity.get(i));
						addOrganization.type_OrgZip(orgzip.get(i));
						addOrganization.type_OrgCountry(orgcountry.get(i));
						addOrganization.type_OrgState(orgstate.get(i));
						addOrganization.click_SaveAndReturn();
					}
					visitorInfo.get_RequestStatus();

					ArrayList<String> orgass = GenericMethods.stringtoken(OrgAssociated);
					ArrayList<String> fname = GenericMethods.stringtoken(FirstName);
					ArrayList<String> midname = GenericMethods.stringtoken(MiddleName);
					ArrayList<String> lname = GenericMethods.stringtoken(LastName);
					ArrayList<String> vemail = GenericMethods.stringtoken(VisitorEmail);
			//		ArrayList<String> btype = GenericMethods.stringtoken(BadgeType);
					ArrayList<String> bno = GenericMethods.stringtoken(BadgeNo);
					ArrayList<String> tperson = GenericMethods.stringtoken(TypeofPerson);
					ArrayList<String> category = GenericMethods.stringtoken(Category);
					ArrayList<String> cityzen = GenericMethods.stringtoken(ContryOfcitizenShip);
					ArrayList<String> country = GenericMethods.stringtoken(Country);
					ArrayList<String> idocs = GenericMethods.stringtoken(IdentifyingDocs);
					ArrayList<String> edate = GenericMethods.stringtoken(ExpirationDate);
					for (int i = 0; i < fname.size(); i++) {
						visitorInfo.click_AddVisitor();
						addVisitor.select_OrgAssociated(orgass.get(i));
						addVisitor.type_FirstName(fname.get(i));
						addVisitor.type_MiddleName(midname.get(i));
						addVisitor.type_LastName(lname.get(i));
						addVisitor.type_VisitorEmail(vemail.get(i));
				//		addVisitor.select_BadgeType(btype.get(i));
						addVisitor.type_BadgeNo(bno.get(i));
						addVisitor.select_Person(tperson.get(i));
						addVisitor.select_Category(category.get(i));
						addVisitor.select_Citizenship(cityzen.get(i));
						addVisitor.type_Zip(Zip);
						addVisitor.type_Country(country.get(i));
						addVisitor.type_State(State);
						addVisitor.type_IdentifyingDocs(idocs.get(i));
						addVisitor.type_IssuingCountry(IssuingCountry);
						addVisitor.type_IssuingState(IssuingState);
						Wait.waitfor(2);
						addVisitor.select_ExpiratiponDate(edate.get(i));
						addVisitor.type_DocumentNo(DocumentNo);
						addVisitor.select_ReqVisitorLaptop();
						addVisitor.select_ReqVisitorCmPhone();
						addVisitor.type_Description(Description);
						addVisitor.type_Justification(Justification);
						addVisitor.click_SaveAndReturn();
						Wait.waitfor(3);
					}
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
					Wait.waitfor(2);
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckIN();
					Wait.waitfor(2);
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(2);
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
			homePage.returnPage();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("RapidRegistrationWithMultiple", excel);
	}

}
