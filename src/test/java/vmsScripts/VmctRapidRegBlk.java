/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : Dec 2018
 * Descriptions : VMCT BLOCK CONFIG. checking and creating of request.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class VmctRapidRegBlk extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VmctBlocks", excel);
	}

	@Test(dataProvider = "getData")
	public void rapidRegBlockConfig(String Testcase, String RunMode, String SBU, String ScreenName, String SelectList,
			String AvailableList, String CheckAvailBlkList, String Site, String BuildingName, String HostName,
			String EmailAddress, String HostPhone, String OrgName, String OrgAddress, String OrgType, String Orgcity,
			String OrgZip, String OrgCountry, String OrgState, String OrgAssociated, String FirstName,
			String MiddleName, String LastName, String VisitorEmail, String VisitorPhone, String BadgeType,
			String BadgeNo, String ACSBadgeId, String TypeofPerson, String Category, String ContryOfcitizenShip,
			String Address, String Address2, String Address3, String City, String Zip, String Country, String State,
			String IdentifyingDocs, String DocumentNo, String IssuingCountry, String IssuingState,
			String ExpirationDate, String Description, String Justification) throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorRequestConfigPage visitReqconfg = new VisitorRequestConfigPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_VisitorRequest();
					visitReqconfg.VmctCofigSelect(SBU, ScreenName);
					visitReqconfg.select_VR_SelectList(SelectList);
					visitReqconfg.click_VR_LeftMove();
					visitReqconfg.click_VR_SaveBlk();

					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_AddNewVisitorRequest();
					if (CheckAvailBlkList.contains("Categories")) {
						visitorInfo.validating_AvailBlklist(CheckAvailBlkList);
					}
					if (CheckAvailBlkList.contains("Information")) {
						visitorInfo.validating_AvailBlklist(CheckAvailBlkList);
					}
					visitorInfo.select_Site(Site);
					visitorInfo.type_BuildingName(BuildingName);

					if (HostName.length() > 0) {
						visitorInfo.click_AddHost();
						visitorInfo.type_HostName(HostName);
						visitorInfo.type_HostEmail(EmailAddress);
						visitorInfo.type_HostPhNo(HostPhone);
						visitorInfo.click_HostAdd();
					}
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();

					visitorInfo.click_AddVisitor();

					if (CheckAvailBlkList.contains("Equipment")) {
						visitorInfo.validating_AvailBlklist(CheckAvailBlkList);
					}
					if (CheckAvailBlkList.contains("Vehicle")) {
						visitorInfo.validating_AvailBlklist(CheckAvailBlkList);
					}
					if (CheckAvailBlkList.contains("Details")) {
						visitorInfo.validating_AvailBlklist(CheckAvailBlkList);
					}

					if (OrgName.length() > 0) {
						addVisitor.click_AddOrganizationBtn();
						try {
							addOrganization.type_OrgName(OrgName);
							addOrganization.type_OrgAddress(OrgAddress);
							addOrganization.select_OrgType(OrgType);
							addOrganization.type_Orgcity(Orgcity);
							addOrganization.type_OrgZip(OrgZip);
							addOrganization.type_OrgCountry(OrgCountry);
							addOrganization.type_OrgState(OrgState);
							addOrganization.click_SaveAndReturn();
						} catch (Exception e) {
							testFail();
							test.log(LogStatus.FAIL, "Fail to add the organization");
						}
						visitorInfo.get_RequestStatus();
						addOrganization.click_AddVisitorBtn();
					}

					addVisitor.select_OrgAssociated(OrgAssociated);
					addVisitor.type_FirstName(FirstName);
					addVisitor.type_MiddleName(MiddleName);
					addVisitor.type_LastName(LastName);
					addVisitor.type_VisitorEmail(VisitorEmail);
					addVisitor.type_VisitorPhone(VisitorPhone);
					addVisitor.select_BadgeType(BadgeType);
					addVisitor.type_BadgeNo(BadgeNo);
					addVisitor.escortRequired();
					if (TypeofPerson.length() > 0) {
						addVisitor.select_Person(TypeofPerson);
						addVisitor.select_Category(Category);
						addVisitor.select_Citizenship(ContryOfcitizenShip);
						addVisitor.type_Address(Address);
						addVisitor.type_Address2(Address2);
						addVisitor.type_Address3(Address3);
						addVisitor.type_City(City);
						addVisitor.type_Zip(Zip);
						addVisitor.type_Country(Country);
						addVisitor.type_State(State);
					}
					addVisitor.type_IdentifyingDocs(IdentifyingDocs);

					if (IdentifyingDocs.length() > 0) {
						addVisitor.type_IssuingCountry(IssuingCountry);
						if (TypeofPerson.length() > 0) {
							addVisitor.type_IssuingState(IssuingState);
						} else {
							addVisitor.type_IssuingState2(IssuingState);

						}
						addVisitor.select_ExpiratiponDate(ExpirationDate);
						addVisitor.type_DocumentNo(DocumentNo);
					}
					if (Description.length() > 0) {
						addVisitor.select_ReqVisitorLaptop();
						addVisitor.select_ReqVisitorCmPhone();
						addVisitor.type_Description(Description);
						addVisitor.type_Justification(Justification);
					}
					addVisitor.click_SaveAndReturn();
					Wait.waitfor(3);
					visitorInfo.click_DplStatus();
					Wait.waitfor(2);
					visitorInfo.get_RequestStatusFinal();
					visitorInfo.click_CheckIn();
					visitorInfo.PrintBadge();
					Wait.waitfor(2);
					searchVR.moveTo_Features();
					Wait.waitfor(2);
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(3);
					searchVR.moveTo_Tools();
					Wait.waitfor(2);
					searchVR.click_VMCT();
					vmct.click_VisitorRequest();
					visitReqconfg.VmctCofigSelect(SBU, ScreenName);
					visitReqconfg.select_VR_AvailableList(AvailableList);
					visitReqconfg.click_VR_RightMove();
					visitReqconfg.click_VR_SaveBlk();
					Wait.waitfor(3);
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
			// homePage.returnPage();
			searchVR.moveTo_Tools();
			searchVR.click_VMCT();
			vmct.click_VisitorRequest();
			visitReqconfg.VmctCofigSelect(SBU, ScreenName);
			visitReqconfg.select_VR_AvailableList(AvailableList);
			visitReqconfg.click_VR_RightMove();
			visitReqconfg.click_VR_SaveBlk();
			Assert.assertTrue(false);

		}
	}

}
