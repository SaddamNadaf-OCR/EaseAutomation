package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2023
 * Descriptions : Copy Agreement Request Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AGRResultTemplatePage;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CopyAgreementRequestTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyAGRTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void copyagreementRequestTemplate(String Testcase, String RunMode, String Template, String TemplateName) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchAgreementRequestTemplatePage searchPage = new SearchAgreementRequestTemplatePage(driver, test);
		AGRResultTemplatePage resultPage = new AGRResultTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.AgrReqTemplate();
					searchPage.SearchByTemplateName(Template);
					searchPage.Search();
					resultPage.TitleisDisplayed();
					resultPage.GridisDisplayed();
					resultPage.copyIcon();
					Wait.waitfor(3);
					generalinfo.templateName(TemplateName);
					generalinfo.click_SaveButton();
					Wait.waitfor(3);
					generalinfo.moveForward();
					String Templatename = generalinfo.get_TemplateName();
					homepage.returnToCRPage();
					Wait.waitfor(3);
					homepage.AgrReqTemplate();
					searchPage.SearchByTemplateName(Templatename);
					searchPage.Search();
					resultPage.TitleisDisplayed();
					resultPage.GridisDisplayed();
					homepage.returnToCRPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			Assert.assertTrue(false);
	}
}

}
