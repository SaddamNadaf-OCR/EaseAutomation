/* 
 * Module : VMs
 * Author  : Venkat
 * created date : FEB 2019
 * Descriptions : Creating a On Hold Kiosk request and check the view detail hits in rapid page.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.KioskSettingsPage;
import vmsClasses.SearchRapidRegReqResultPage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class KioskOnHoldRequestViewDetailHits extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("OnholdKiosRequest", excel);
	}

	@Test(dataProvider = "getData")
	public void vmctkioskrequest(String Testcase, String RunMode, String KioskType,String SBU,String SiteID, String FirstName, 
			String LastName, String Email, String Phone, String CountryofCitizenship, String IDType, String IDNumber,
			String Organization, String VisitPurpose,String VisitorCategory,String BoxRefNumber, String Vehicleno, 
			String CarMake, String CarModel, String SearchHost, String BuildingName) throws Exception {

		// ******************************** Objects Creation *******************************************
		HomePage							homePage 		= new HomePage(driver, test);
		SearchVisitorRequestPage			searchVR 		= new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage		vmct 			= new VisitorMangmentConfigToolPage(driver,test);
		VisitorRequestConfigPage			visitReqconfg 	= new VisitorRequestConfigPage(driver, test);
		VisitorInformationPage 		  		visitorInfo 	= new VisitorInformationPage(driver, test);
		KioskSettingsPage   				KioskSettings 	= new KioskSettingsPage(driver, test);
		SearchRapidRegRequestPage			rapid			= new SearchRapidRegRequestPage(driver, test);
		SearchRapidRegReqResultPage 		SRapidRRR		= new SearchRapidRegReqResultPage(driver, test);
		
		try 
		{
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)){
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_Kiosksettings();
					visitReqconfg.select_KioskSBUcode(SBU);
					visitReqconfg.select_VRSite(SiteID);
					visitReqconfg.click_KioskRequestEdit();
					KioskSettings.click_KReqVisitor();
					KioskSettings.click_KReqGenerateAccessLink();
					KioskSettings.click_KReqAccessKioskLink();
					KioskSettings.click_KReqHomeStart();
					if(KioskType.contains("Warehouse")){
						KioskSettings.click_KReqWarehouseNo();
					}else{
						KioskSettings.click_KReqNewVisitor();
					}
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
					if(KioskType.contains("Warehouse")){
						KioskSettings.click_KReqVehicleNext();
					} else {
						KioskSettings.click_KReqPhotoNext();
					}
					if(KioskType.contains("Warehouse"))	{
						KioskSettings.click_KReqPhotoScreenSubmit();
					} else {
						KioskSettings.click_KReqHostNext();		
						KioskSettings.select_KReqSearchHost(SearchHost);
						KioskSettings.click_KReqSubmit();
					}
					String VisitorCode = KioskSettings.get_KReqVisitorCode();
					KioskSettings.backtomainwindow();
					KioskSettings.click_KReqAccessLinkCancel();
					Wait.waitfor(3);
					searchVR.moveTo_Features();				
					Wait.waitfor(2);
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_SearchRapidHostVisitorDetails();
					rapid.type_KReqVisitorCode(VisitorCode);
					rapid.click_SearchRapidSearch();
					SRapidRRR.click_SearchRapidRequestId();
					Wait.waitfor(5);
					visitorInfo.click_VisitorInfoDplStatusRed();
					visitorInfo.validating_ViewAllOCRHits();
					visitorInfo.click_Override();
					visitorInfo.Select_DispositionReason();
					visitorInfo.click_DisptnReasonMatxSave();
					Wait.waitfor(3);
					
					
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
					}
				}
			}catch(SkipException s) {
				//s.printStackTrace();e
				test.log(LogStatus.SKIP,"Please check the run mode");
				throw s;
			} catch (Exception e) {
				Wait.capture(driver, getClass().getName());
				test.log(LogStatus.FAIL, "Failed to run : " + getClass().getSimpleName() + " "
						+ test.addScreenCapture(System.getProperty("user.dir") +"\\Screenshots\\" + Wait.screenshotname));			
				e.printStackTrace();
				String window = "OCR Services, Inc. | Export & Import Global Trade Compliance Software Solutions";
				String window1 = driver.getTitle();
				if(!window.equalsIgnoreCase(window1)) {
				KioskSettings.backtomainwindow();
				KioskSettings.click_KReqAccessLinkCancel();
				}
				homePage.returnPage();
				throw e;
			}
	}
}
		

	

