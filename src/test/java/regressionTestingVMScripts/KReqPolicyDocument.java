/* 
 * Module : VMS
 * Author  : Mannem venkat 
 * created date : Feb 2019
 * Descriptions : Creating a Kiosk Request and verify policy document functionality in kiosk,Rapi and front desk page.
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
import vmsClasses.CheckInVerifyDetailsPage;
import vmsClasses.HomePage;
import vmsClasses.KioskSettingsPage;
import vmsClasses.PolicyDocumentsPage;
import vmsClasses.SearchRapidRegReqResultPage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class KReqPolicyDocument extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("KioskRequestPolicyDocument", excel);
	}

	@Test(dataProvider = "getData") 
	public void KReqPolicy(String Testcase,String RunMode, String PDSBUCode, String PDSite, String PDNationality,
			String PDVisitorCategory, String DocumentDetails, String SBU, String SiteID, String FirstName, 
			String LastName, String Email, String Phone, String CountryofCitizenship, String IDType, String IDNumber,
			String Organization, String VisitPurpose, String VisitorCategory,String BoxRefNumber, String Vehicleno, String CarMake,
			String CarModel, String SearchHost, String AcknowledgementAndDoc)throws Exception {

		// ******************************** Objects Creation *******************************************

		HomePage							homePage 		= new HomePage(driver, test);
		SearchVisitorRequestPage			searchVR 		= new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage		vmct 			= new VisitorMangmentConfigToolPage(driver,test);
		VisitorRequestConfigPage			visitReqconfg 	= new VisitorRequestConfigPage(driver, test);
		KioskSettingsPage   				KioskSettings 	= new KioskSettingsPage(driver, test);
		PolicyDocumentsPage					policyDoc      	= new PolicyDocumentsPage(driver, test);
		SearchRapidRegRequestPage			rapid			= new SearchRapidRegRequestPage(driver, test);
		SearchRapidRegReqResultPage 		SRapidRRR		= new SearchRapidRegReqResultPage(driver, test);
		VisitorInformationPage 				visitorInfo		= new VisitorInformationPage(driver, test);
		CheckInVerifyDetailsPage			checkInVerify	= new CheckInVerifyDetailsPage(driver, test);
		VisitorFrontDeskResultsPage 	    visitorFD       = new VisitorFrontDeskResultsPage(driver, test);
		

		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{ 
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {				
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();	
					searchVR.moveTo_Tools();					
					searchVR.click_VMCT();					
					vmct.click_PolicyDoc();
					policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
					policyDoc.click_ConfigBtn();
					policyDoc.click_DocTypeCheckBox(DocumentDetails);
					vmct.click_Kiosksettings();
					visitReqconfg.select_KioskSBUcode(SBU);
					visitReqconfg.select_VRSite(SiteID);
					visitReqconfg.click_KioskRequestEdit();
					KioskSettings.click_KReqVisitor();
					KioskSettings.click_KReqGenerateAccessLink();
					KioskSettings.click_KReqAccessKioskLink();
					KioskSettings.click_KReqHomeStart();
					KioskSettings.click_KReqNewVisitor();
					KioskSettings.type_KReqFirstName(FirstName);
					KioskSettings.type_KReqLastName(LastName);				
					KioskSettings.type_KReqEmail(Email);
					KioskSettings.type_KReqPhone(Phone);
					KioskSettings.click_KReqFirstNameNext();
					KioskSettings.select_KReqCountryofCitizenship(CountryofCitizenship);
					KioskSettings.select_KReqIdType(IDType);
					KioskSettings.type_KReqIdNumber(IDNumber);
					KioskSettings.click_KReqCOCNext();
					KioskSettings.type_KReqOrganization(Organization);
					KioskSettings.select_KReqVisitPurpose(VisitPurpose);
					KioskSettings.select_KReqVisitorCategory(VisitorCategory,BoxRefNumber);
					KioskSettings.click_KReqOrgNameNext();
					KioskSettings.type_KReqVehicleNo(Vehicleno);
					KioskSettings.type_KReqCarMake(CarMake);
					KioskSettings.type_KReqCarModel(CarModel);
					KioskSettings.click_KReqPhotoNext();
					KioskSettings.click_KReqHostNext();		
					KioskSettings.select_KReqSearchHost(SearchHost);
					KioskSettings.click_KReqPolicyDocNext();
					Wait.waitfor(5);
					KioskSettings.kReqvalidAckwAndDoc(AcknowledgementAndDoc);
					Wait.waitfor(5);
					KioskSettings.click_KReqSubmit();
					String VisitorCode = KioskSettings.get_KReqVisitorCode();					
					KioskSettings.backtomainwindow();
					KioskSettings.click_KReqAccessLinkCancel();
					Wait.waitfor(3);
					searchVR.moveTo_Features();				
					Wait.waitfor(4);
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_SearchRapidHostVisitorDetails();
					rapid.type_KReqVisitorCode(VisitorCode);
					rapid.click_SearchRapidSearch();
					SRapidRRR.click_SearchRapidRequestId();
				//	String KReqStatus = visitorInfo.get_RequestStatus();
								
					//visitorInfo.click_DplStatus();
					Wait.waitfor(2);
				//	visitorInfo.kReqvalidAckwAndDocinrapid(AcknowledgementAndDoc);
					Wait.waitfor(3);
					String RS=visitorInfo.get_RequestStatusAfterAddingVisitor();
					Wait.waitfor(4);
					
					if (RS.equalsIgnoreCase("System Approved"))
					{
						searchVR.moveTo_Features();				
						searchVR.click_VisitorFrontDesk();
						visitorFD.click_AdvSearchBtn();
						visitorFD.searchVID(VisitorCode);
						visitorFD.clickSearch();
						visitorFD.clickCheckOut();
						Wait.waitfor(3);
						Wait.waitfor(5);
						homePage.returnPage();
						searchVR.moveTo_Tools();
						searchVR.click_VMCT();
						vmct.click_PolicyDoc();
						policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
						policyDoc.click_DeleteIcon();
					}
					else
					if(RS.equalsIgnoreCase("WLS On Hold")) {
							visitorInfo.checkNotifyWLSReview();	
							visitorInfo.click_DplStatus();
							visitorInfo.changeStatus();
							Wait.waitfor(4);
							
					} 
					else
					{
					Wait.waitfor(3);
					String RS1=visitorInfo.get_RequestStatusAfterAddingVisitor();
					
					if(RS1.equalsIgnoreCase("FV On Hold")) {
							visitorInfo.checkNotifyFVReview();
							Wait.waitfor(2);
							visitorInfo.changeStatus();
					} 
					
					//visitorInfo.get_RequestStatusFinal();
					visitorInfo.click_RapidClose();
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					Wait.waitfor(3);			
					searchVR.moveTo_Features();				
					searchVR.click_VisitorFrontDesk();
					Wait.waitfor(3);
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVID(VisitorCode);
					visitorFD.clickSearch();
					visitorFD.clickCheckIN();
					Wait.waitfor(3);
					/*visitorFD.clickVisitorLink(FirstName);
					checkInVerify.acceptingPolicy(AcknowledgementAndDoc);
					checkInVerify.click_CheckIn();*/
					Wait.waitfor(3);
					searchVR.moveTo_Features();				
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVID(VisitorCode);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(3);
					Wait.waitfor(5);
					homePage.returnPage();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_PolicyDoc();
					policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
					policyDoc.click_DeleteIcon();
				}
					}
				else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			//s.printStackTrace();
			test.log(LogStatus.SKIP,"Please check the run mode");
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
			searchVR.moveTo_Tools();
			searchVR.click_VMCT();			
			vmct.click_PolicyDoc();
			policyDoc.select_Policy(PDSBUCode, PDSite, PDNationality, PDVisitorCategory);
			policyDoc.click_DeleteIcon();
			Assert.assertTrue(false);
		}

	}

}

