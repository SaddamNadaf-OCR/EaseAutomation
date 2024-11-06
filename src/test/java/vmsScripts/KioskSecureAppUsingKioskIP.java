/* 
 * Module : VMS
 * Author  : Venkat
 * created date : May 2019
 * Descriptions : To verify Kiosk security application by using Kiosk IP address.
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


public class KioskSecureAppUsingKioskIP extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("KioskReqIPSecurity", excel);
	}

	@Test(dataProvider = "getData")
	public void vmctkioskrequest(String Testcase, String RunMode, String KioskType,String SBU, String SiteID, 
			String KioskIPAddrErrormsg, String KioskIPAddr) throws Exception {

		// ******************************** Objects Creation *******************************************
				HomePage							homePage 		= new HomePage(driver, test);
				SearchVisitorRequestPage			searchVR 		= new SearchVisitorRequestPage(driver, test);
				VisitorMangmentConfigToolPage		vmct 			= new VisitorMangmentConfigToolPage(driver,test);
				VisitorRequestConfigPage			visitReqconfg 	= new VisitorRequestConfigPage(driver, test);
				KioskSettingsPage   				KioskSettings 	= new KioskSettingsPage(driver, test);
				SoftAssert  						SoftAsscertion  = new SoftAssert();
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
							vmct.click_Kiosksettings();
							visitReqconfg.select_KioskSBUcode(SBU);
							Wait.waitfor(3);
							visitReqconfg.select_VRSite(SiteID);
							Wait.waitfor(3);
							visitReqconfg.click_KioskRequestEdit();
							KioskSettings.click_KReqKioskProcess();
							KioskSettings.type_KReqIPAddr(KioskIPAddr);
							KioskSettings.click_KReqIPAddrSave();
							Wait.waitfor(3);
							KioskSettings.click_KReqVisitor();
							KioskSettings.click_KReqGenerateAccessLink();
							Wait.waitfor(3);
							KioskSettings.click_KReqAccessKioskLink();
							Wait.waitfor(4);
							if(KioskIPAddrErrormsg.contains("Different")) {
							KioskSettings.KReqErrorHomeScreen();
							}else {
								KioskSettings.KReqHomeScreen();
							}
							KioskSettings.backtomainwindow();
							Wait.waitfor(3);
							KioskSettings.click_KReqAccessLinkCancel();
							Wait.waitfor(3);
							homePage.returnPage();
							Wait.waitfor(3);
							SoftAsscertion.assertAll();
						}else {
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
					throw e;
				}
			}

		}
		
		
		

