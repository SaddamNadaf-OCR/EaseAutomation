package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2023
 * Descriptions : Copy Export Request Template
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
import crsClasses.ERResultTemplatePage;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportReqTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CopyExportReqTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyERTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void copyExportReqTemplate(String Testcase, String RunMode, String Template, String templateName) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchExportReqTemplatePage searchPage = new SearchExportReqTemplatePage(driver, test);
		ERResultTemplatePage resultPage = new ERResultTemplatePage(driver, test);
		ExportAddRequestorDetailsPage generalinfo = new ExportAddRequestorDetailsPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.ExportReqTemplate();
					searchPage.SearchByTemplateName(Template);
					searchPage.Search();
					resultPage.TitleisDisplayed();
					resultPage.GridisDisplayed();
					resultPage.copyIcon();
					Wait.waitfor(3);
					generalinfo.add_template(templateName);
					generalinfo.saveExportRequest();
					generalinfo.clickTypeofExportLink();
					Wait.waitfor(3);
					String Templatename = generalinfo.get_RequestID();
					homepage.returnToCRPage();
					Wait.waitfor(3);
					homepage.ExportReqTemplate();
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
