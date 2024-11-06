package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2023
 * Descriptions : Copy Foreign Travel Request Template
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
import crsClasses.FTRResultTemplatePage;
import crsClasses.FTTravelDetailsPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchForeignTravelTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CopyFTRTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyFTRTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void copyForeignTravelRequestTemplate(String Testcase, String RunMode, String Templatename, String templateName) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchForeignTravelTemplatePage searchPage = new SearchForeignTravelTemplatePage(driver, test);
		FTRResultTemplatePage resultPage = new FTRResultTemplatePage(driver, test);
		FTTravelDetailsPage generalinfo = new FTTravelDetailsPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.FTRReqTemplate();
					searchPage.SearchByTemplatename(Templatename);
					searchPage.Search();
					resultPage.TitleisDisplayed();
					Wait.waitfor(3);
					resultPage.GridisDisplayed();
					Wait.waitfor(3);
					resultPage.copyIcon();
					Wait.waitfor(3);
					generalinfo.add_template(templateName);
					generalinfo.save();
					generalinfo.moveForward();
					Wait.waitfor(3);
					String TemplateName = generalinfo.get_RequestID();
					homepage.returnToCRPage();
					Wait.waitfor(3);
					homepage.FTRReqTemplate();
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