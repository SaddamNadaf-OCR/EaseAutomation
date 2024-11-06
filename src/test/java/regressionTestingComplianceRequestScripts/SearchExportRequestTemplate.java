package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportReqTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchExportRequestTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ERTemplateSearch", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportReqTemplate(String Testcase, String RunMode, String SBU, String TemplateName, String RequestDateFrom, 
			String RequestDateTo, String RequesterName, String Program, String Segment, String Site, String ProductLine, 
			String ProductFamily, String SortBy, String Direction) {
		
		HomePageCRs homepage=new HomePageCRs(driver,test);
		SearchExportReqTemplatePage search = new SearchExportReqTemplatePage(driver,test);
		
		// **********Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test :");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.ExportReqTemplate();
					search.SearchByParameters(SBU, TemplateName, RequestDateFrom, RequestDateTo, RequesterName, Program, 
							Segment, Site, ProductLine, ProductFamily, SortBy, Direction);
					search.Search();
					search.TitleisDisplayed();
					homepage.returnToCRPage();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException e) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			e.printStackTrace();
			throw e;
		}catch(Exception s) {
			s.printStackTrace();
			testFail();
			homepage.returnToCRPage();
		}	
	}

}
