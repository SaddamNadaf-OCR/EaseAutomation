/* 
 * Module : VMs
 * Author  : Venkat
 * created date : FEB 2019
 * Descriptions : Creating Kiosk reception and Warehouse Request by using visitor code and visitor pin.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

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
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class KioskRequestCreationWarehouse extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("KioskRequestCreationWarehouse", excel);
	}

	@Test(dataProvider = "getData")
	public void vmctkioskrequest(String Testcase, String RunMode, String SBU, String SBUCode, String SiteID,
			String KioskWelcomeText, String FirstName, String LastName, String Email, String Phone,
			String CountryofCitizenship, String IDType, String IDNumber, String Organization, String VisitPurpose,
			String VisitorCategory, String BoxRefNumber, String Vehicleno, String CarMake, String CarModel,
			String SearchHost, String KioskDefaultText, String CheckOutStatus, String Pin, String ConfirmPin,
			String FirstSecurityQuestion, String Answer1, String SecondSecurityQuestion, String Answer2,
			String RegistrationStatus) throws Exception {

		// ******************************** Objects Creation
		// *******************************************
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorRequestConfigPage visitReqconfg = new VisitorRequestConfigPage(driver, test);
		KioskSettingsPage KioskSettings = new KioskSettingsPage(driver, test);
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
					visitReqconfg.select_KioskSBUcode(SBUCode);
					Wait.waitfor(3);
					visitReqconfg.select_VRSite(SiteID);
					Wait.waitfor(3);
					visitReqconfg.click_KioskRequestEdit();
					KioskSettings.get_KReqWelcomeScreenText(KioskWelcomeText);
					KioskSettings.click_KReqVisitor();
					KioskSettings.click_KReqGenerateAccessLink();
					Wait.waitfor(3);
					KioskSettings.click_KReqAccessKioskLink();
					Wait.waitfor(3);
					KioskSettings.get_KReqHomeWelcomeScreenText(KioskWelcomeText);
					Wait.waitfor(3);
					KioskSettings.click_KReqHomeStart();

					KioskSettings.click_KReqWarehouseNo();

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
					Wait.waitfor(5);

					KioskSettings.click_KReqVehicleNext();

					KioskSettings.click_KReqPhotoScreenSubmit();

					Wait.waitfor(5);

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
					if (Pin.length() > 0) {
						KioskSettings.click_KReqFutureVisitCheckBox();
						KioskSettings.click_KReqCOStatusOk();
						KioskSettings.type_KReqFutureVisitPin(Pin);
						KioskSettings.type_KReqFutureVisitConfirmPin(ConfirmPin);
						Wait.waitfor(5);
						KioskSettings.click_KReqRegistrationNext();
						Wait.waitfor(5);
						KioskSettings.select_KReqRegistartionSecQuestion1(FirstSecurityQuestion);
						KioskSettings.type_KReqRegistartionSecAnswer1(Answer1);
						KioskSettings.select_KReqRegistartionSecQuestion2(SecondSecurityQuestion);
						KioskSettings.type_KReqRegistartionSecAnswer2(Answer2);
						KioskSettings.click_KReqPhotoScreenSubmit();
						KioskSettings.click_KReqCOStatusOk();
						/*
						 * String RegText = KioskSettings.get_KReqRegistrationText(); if
						 * (RegText.contains(RegistrationStatus)) { test.log(LogStatus.PASS,
						 * RegistrationStatus); KioskSettings.click_KReqCOStatusOk(); } else {
						 * test.log(LogStatus.FAIL, RegistrationStatus); testFail();
						 * SoftAsscertion.assertTrue(false); }
						 */
					}
					if (Pin.length() == 0) {
						KioskSettings.click_KReqHomeIcon();
					}
					KioskSettings.click_KReqHomeStart();

					KioskSettings.click_KReqWHYes();

					KioskSettings.type_KReqPreRegisteredLastname(LastName);
					if (Pin.length() == 0) {
						KioskSettings.type_KReqPreRegisteredVisitorCode(VisitorCode);
					} else {
						KioskSettings.type_KReqPreRegisteredVisitorCode(Pin);
					}
					KioskSettings.click_KReqVisitorVerificationNext();
					Wait.waitfor(5);
					KioskSettings.click_KReqFirstNameNext();
					Wait.waitfor(5);
					KioskSettings.click_KReqCOCNext1();
					KioskSettings.select_KReqVisitorCategory(VisitorCategory, BoxRefNumber);
					KioskSettings.click_KReqOrgNameNext();
					KioskSettings.click_KReqPhotoNext();

					KioskSettings.click_KReqPhotoScreenSubmit();
					String PreVisitorCode = KioskSettings.get_KReqVisitorCode();
					if (VisitorCode.contains(PreVisitorCode)) {
						test.log(LogStatus.PASS, "Visitor Code is same : " + PreVisitorCode);
					} else {
						test.log(LogStatus.FAIL, "Visitor Code is not same : " + PreVisitorCode);
						testFail();
						SoftAsscertion.assertTrue(false);
					}
					KioskSettings.backtomainwindow();
					Wait.waitfor(3);
					KioskSettings.click_KReqAccessLinkCancel();
					Wait.waitfor(3);
					homePage.returnPage();
					Wait.waitfor(3);
					SoftAsscertion.assertAll();
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
