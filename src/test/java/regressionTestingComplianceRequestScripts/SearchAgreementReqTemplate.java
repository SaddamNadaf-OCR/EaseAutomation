package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.annotations.Test;

import com.ibm.icu.impl.Assert;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestTemplatePage;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAgreementReqTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgrTemplateSearch", excel);
	}
	
	@Test(dataProvider="getData")
	public void agreementReqTemplate(String Testcase, String RunMode, String SBU, String TemplateName, String RequestDateFrom, 
			String RequestDateTo, String RequesterName, String Program, String Segment, String Site, String ProductLine, 
			String ProductFamily, String SortBy, String Direction) {
		
		HomePageCRs homepage=new HomePageCRs(driver,test);
		SearchAgreementRequestTemplatePage search = new SearchAgreementRequestTemplatePage(driver,test);
		
		// **********Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test :");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.AgrReqTemplate();
					search.SearchByParameters(SBU, TemplateName, RequestDateFrom, RequestDateTo, RequesterName, Program, Segment, 
							Site, ProductLine, ProductFamily, SortBy, Direction);
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
