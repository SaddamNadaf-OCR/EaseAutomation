/* 
 * Module : VMs
 * Author  : Venkat
 * created date : FEB 2019
 * Descriptions : Creating Kiosk Rception and Warehouse Request comparing visit time to and from by using Other
                  settings all day access configuration in Dash Board page.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;

import java.util.ArrayList;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.DashBoardModePage;
import vmsClasses.HomePage;
import vmsClasses.KioskSettingsPage;
import vmsClasses.OtherSettingsPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class KRVmctOtherSettingsTimeFromAndTo extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() 
	{
		return Utility.getData("KioskRequestVisitTimeCapturing", excel);
	}

	@Test(dataProvider = "getData")
	public void vmctkioskrequest(String Testcase, String RunMode, String KioskType,String SBU,String VisitFrom, 
			String VisitTo, String SiteID, String FirstName, String LastName, String Email, String Phone, 
			String CountryofCitizenship, String IDType, String IDNumber, String Organization, String VisitPurpose, 
			String VisitorCategory,String BoxRefNumber, String Vehicleno, String CarMake, String CarModel, String SearchHost)
					throws Exception {

		// ******************************** Objects Creation *******************************************
		HomePage							homePage 		= new HomePage(driver, test);
		SearchVisitorRequestPage			searchVR 		= new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage		vmct 			= new VisitorMangmentConfigToolPage(driver,test);
		VisitorRequestConfigPage			visitReqconfg 	= new VisitorRequestConfigPage(driver, test);
		KioskSettingsPage   				KioskSettings 	= new KioskSettingsPage(driver, test);
		OtherSettingsPage			  		os			   	= new OtherSettingsPage(driver,test);
		DashBoardModePage					FrontdeskMode	= new DashBoardModePage(driver, test);
		SoftAssert 					 		 softAssertion  = new SoftAssert();		

		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)){
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_OtherSetting();
					os.select_OS_SBUCode(SBU);
					os.click_OS_Search();
					os.click_OS_Edit();
					os.get_visitFrom(VisitFrom);
					os.get_visitTo(VisitTo);
					os.click_OS_Update();
					Wait.waitfor(3);
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
					}else {
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
					}else {
						KioskSettings.click_KReqPhotoNext();
					}
					if(KioskType.contains("Warehouse")){
						KioskSettings.click_KReqPhotoScreenSubmit();
					}else {
						KioskSettings.click_KReqHostNext();		
						KioskSettings.select_KReqSearchHost(SearchHost);
						KioskSettings.click_KReqSubmit();
					}
					KioskSettings.backtomainwindow();
					KioskSettings.click_KReqAccessLinkCancel();
					Wait.waitfor(3);
					KioskSettings.click_VMDashBoardIcon();
					ArrayList<String> tm =	FrontdeskMode.get_VisitorStartTimeEndTime(VisitFrom);	
					String tm1 = tm.get(0);
					String tm2 = tm.get(1);
					if(tm1.contains(VisitFrom)) {
						test.log(LogStatus.PASS,"Expected Start Time : " +VisitFrom);
						softAssertion.assertTrue(true);
					}else {						
						test.log(LogStatus.FAIL,"Expected Start Time: " +VisitFrom);
						testFail();
						softAssertion.assertTrue(false);
					}
					if(tm2.contains(VisitTo)) {
						test.log(LogStatus.PASS,"Expected End Time : " +VisitTo);
						softAssertion.assertTrue(true);
					}else {						
						test.log(LogStatus.FAIL,"Expected End Time: " +VisitTo);
						testFail();
						softAssertion.assertTrue(false);
					}					
					Wait.waitfor(3);
					softAssertion.assertAll();	
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			//s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
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


