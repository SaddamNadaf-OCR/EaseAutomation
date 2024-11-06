package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2023
 * Descriptions : Copy Import Request Template
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
import crsClasses.HomePageCRs;
import crsClasses.IRResultTemplatePage;
import crsClasses.ImportRequestPage;
import crsClasses.SearchImportRequestTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CopyImportRequestTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyIRTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void copyImportRequestTemplate(String Testcase, String RunMode, String Templatename, String templateName) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchImportRequestTemplatePage searchPage = new SearchImportRequestTemplatePage(driver, test);
		IRResultTemplatePage resultPage = new IRResultTemplatePage(driver, test);
		ImportRequestPage generalinfo = new ImportRequestPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.ImportReqTemplate();
					searchPage.SearchByTemplatename(Templatename);
					searchPage.Search();
					resultPage.TitleisDisplayed();
					Wait.waitfor(3);
					resultPage.GridisDisplayed();
					Wait.waitfor(3);
					resultPage.copyIcon();
					Wait.waitfor(3);
					generalinfo.add_template(templateName);
					generalinfo.click_Save();
					generalinfo.click_TypeOfExport();
					Wait.waitfor(3);
					String TemplateName = generalinfo.get_RequestID();
					homepage.returnToCRPage();
					Wait.waitfor(3);
					homepage.ImportReqTemplate();
					searchPage.SearchByTemplatename(TemplateName);
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