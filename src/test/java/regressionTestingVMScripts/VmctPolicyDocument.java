/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : OCT 2018
 * Descriptions : Creating Rapid Reg. Request From Front Desk in Multiple ways.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package regressionTestingVMScripts;

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
import vmsClasses.CheckInVerifyDetailsPage;
import vmsClasses.HomePage;
import vmsClasses.PolicyDocumentsPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;

public class VmctPolicyDocument extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VmctPolicyDocument", excel);
	}

	@Test(dataProvider = "getData")
	public void repidRegtn(String Testcase, String RunMode, String SBU, String PDSBUCode, String PDSite,
			String PDNationality, String PDVisitorCategory, String DocumentDetails, String Site, String BuildingName,
			String HostName, String EmailAddress, String OrgName, String OrgType, String Orgcity, String OrgZip,
			String OrgCountry, String OrgState, String OrgAssociated, String FirstName, String LastName,
			String TypeofPerson, String Category, String ContryOfcitizenShip, String IdentifyingDocs,
			String Description, String Justification, String AckwledgeAndDoc) throws Exception {

		// ******************************** Objects Creation
		// *******************************************

		HomePage homePage = new HomePage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		PolicyDocumentsPage policyDoc = new PolicyDocumentsPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		CheckInVerifyDetailsPage checkInVerify = new CheckInVerifyDetailsPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

		// ******************************************** Test steps execution
		// ***************************
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
					vmct.click_PolicyDoc();
					policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
					policyDoc.click_ConfigBtn();
					policyDoc.click_DocTypeCheckBox(DocumentDetails);
					homePage.returnPage();
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_NewVisitor();
					visitorInfo.select_Site(Site);
					visitorInfo.type_BuildingName(BuildingName);
					visitorInfo.click_AddHost();
					visitorInfo.type_HostName(HostName);
					visitorInfo.type_HostEmail(EmailAddress);
					visitorInfo.click_HostAdd();
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();
					visitorInfo.click_AddOrganization();
					addOrganization.type_OrgName(OrgName);
					addOrganization.select_OrgType(OrgType);
					addOrganization.type_Orgcity(Orgcity);
					addOrganization.type_OrgZip(OrgZip);
					addOrganization.type_OrgCountry(OrgCountry);
					addOrganization.type_OrgState(OrgState);
					addOrganization.click_SaveAndReturn();
					visitorInfo.get_RequestStatus();
					visitorInfo.click_AddVisitor();
					addVisitor.select_OrgAssociated(OrgAssociated);
					addVisitor.type_FirstName(FirstName);
					addVisitor.type_LastName(LastName);
					addVisitor.type_VisitorEmail(EmailAddress);
					addVisitor.select_Person(TypeofPerson);
					addVisitor.select_Category(Category);
					addVisitor.select_Citizenship(ContryOfcitizenShip);
					addVisitor.type_IdentifyingDocs(IdentifyingDocs);
					addVisitor.select_ReqVisitorLaptop();
					addVisitor.select_ReqVisitorCmPhone();
					addVisitor.type_Description(Description);
					addVisitor.type_Justification(Justification);
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
					Wait.waitfor(3);
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					Wait.waitfor(3);
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					Wait.waitfor(3);
					visitorFD.clickVisitorLink(FirstName);
					
					checkInVerify.acceptingPolicy(AckwledgeAndDoc);
					checkInVerify.click_CheckIn();
					Wait.waitfor(3);
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(3);
					homePage.returnPage();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_PolicyDoc();
					policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
					policyDoc.click_DeleteIcon();
					Wait.waitfor(3);

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
			homePage.returnPage();
			/*searchVR.moveTo_Tools();
			searchVR.click_VMCT();
			vmct.click_PolicyDoc();
			policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
			policyDoc.click_DeleteIcon();*/
			Assert.assertTrue(false);
		}
	}

}
