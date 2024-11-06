package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultDocumentTypePage;
import filesClasses.SearchDocumentTypePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchDocumentTypeScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchDocumentType", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchDocumentType(String Testcase, String RunMode, String SBU, String DocumentTypeCode, String SetID, String Status, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchDocumentTypePage searchpage=new SearchDocumentTypePage(driver,test);
		ResultDocumentTypePage DocumentTypeTitle=new ResultDocumentTypePage(driver,test);
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionLS(SBU);
					homepage.movetoDocumentType();
					Wait.waitfor(4);
					searchpage.searchbyParameters(DocumentTypeCode,SetID,Status,SortBy,direction);
					searchpage.searchbutton();
					DocumentTypeTitle.ResultDocumentTypeIsDisplayed();
					Wait.waitfor(2);
					homepage.returnToLSHomePage();
				
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homepage.returnToLSHomePage();
			Assert.assertTrue(false);
		}
		
	}

}
