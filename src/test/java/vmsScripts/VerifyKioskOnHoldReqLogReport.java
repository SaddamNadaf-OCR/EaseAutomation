package vmsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.KioskSettingsPage;
import vmsClasses.SearchRapidRegReqResultPage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRegReportPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class VerifyKioskOnHoldReqLogReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("KioskOnHoldcheCkedInLogReport", excel);
	}

	@Test(dataProvider = "getData")
	public void kioskonholdcheckedinreport(String Testcase, String RunMode, String KioskType, String SBU, String SiteID,
			String FirstName, String LastName, String Email, String Phone, String CountryofCitizenship, String IDType,
			String IDNumber, String Organization, String VisitPurpose, String VisitorCategory, String BoxRefNumber,
			String Vehicleno, String CarMake, String CarModel, String SearchHost, String KioskDefaultText)
			throws Exception {

		// ******************************** Objects Creation
		// *******************************************
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorRequestConfigPage visitReqconfg = new VisitorRequestConfigPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		KioskSettingsPage KioskSettings = new KioskSettingsPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchRapidRegReqResultPage SRapidRRR = new SearchRapidRegReqResultPage(driver, test);
		SearchVisitorRegReportPage SVRegReport = new SearchVisitorRegReportPage(driver, test);
		SoftAssert SoftAsscertion = new SoftAssert();
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
					vmct.click_Kiosksettings();
					visitReqconfg.select_KioskSBUcode(SBU);
					Wait.waitfor(3);
					visitReqconfg.select_VRSite(SiteID);
					Wait.waitfor(3);
					visitReqconfg.click_KioskRequestEdit();
					// KioskSettings.get_KReqWelcomeScreenText(KioskWelcomeText);
					KioskSettings.click_KReqVisitor();
					KioskSettings.click_KReqGenerateAccessLink();
					Wait.waitfor(3);
					KioskSettings.click_KReqAccessKioskLink();
					Wait.waitfor(3);
					// KioskSettings.get_KReqHomeWelcomeScreenText(KioskWelcomeText);
					Wait.waitfor(3);
					KioskSettings.click_KReqHomeStart();
					if (KioskType.contains("Warehouse")) {
						KioskSettings.click_KReqWarehouseNo();
					} else {
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
					KioskSettings.select_KReqVisitorCategory(VisitorCategory, BoxRefNumber);
					KioskSettings.click_KReqOrgNameNext();
					KioskSettings.type_KReqVehicleNo(Vehicleno);
					KioskSettings.type_KReqCarMake(CarMake);
					KioskSettings.type_KReqCarModel(CarModel);
					if (KioskType.contains("Warehouse")) {
						KioskSettings.click_KReqVehicleNext();
					} else {
						KioskSettings.click_KReqPhotoNext();
					}
					if (KioskType.contains("Warehouse")) {
						KioskSettings.click_KReqPhotoScreenSubmit();
						Wait.waitfor(5);
					} else {
						KioskSettings.click_KReqHostNext();
						KioskSettings.select_KReqSearchHost(SearchHost);
						KioskSettings.click_KReqSubmit();
					}
					String VisitorText = KioskSettings.get_KReqVisitorText();
					if (VisitorText.equals(KioskDefaultText.trim())) {
						test.log(LogStatus.PASS, KioskDefaultText);
						SoftAsscertion.assertTrue(true);
					} else {
						test.log(LogStatus.FAIL, VisitorText);
						SoftAsscertion.assertTrue(false);
						testFail();
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
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();
					Wait.waitfor(3);
					searchVR.moveTo_Reports();
					searchVR.click_VisitorLogReport();
					SVRegReport.LogReportsVID(vid);
					SVRegReport.click_SearchReport();
					SVRegReport.validating_Norecordsfound();
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
			String window = "OCR Services, Inc. | Export & Import Global Trade Compliance Software Solutions";
			String window1 = driver.getTitle();
			if (!window.equalsIgnoreCase(window1)) {
				KioskSettings.backtomainwindow();
				KioskSettings.click_KReqAccessLinkCancel();
			}
			homePage.returnPage();
			throw e;
		}
	}

}
