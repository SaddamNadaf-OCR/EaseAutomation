package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewDocumentTypePage;
import filesClasses.HomePage;

import filesClasses.SearchDocumentTypePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateDocumentType extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddDocumentType", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddDocumentType(String Testcase, String RunMode, String SBU,String DocumentTypeCode, String DocumentTypeDescription, String SetID) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchDocumentTypePage searchpage=new SearchDocumentTypePage(driver,test);
		CreateNewDocumentTypePage CreatePage=new CreateNewDocumentTypePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionLS(SBU);
					homepage.movetoDocumentType();
					searchpage.addCode();
					CreatePage.enterDocumentTypeCode(DocumentTypeCode,DocumentTypeDescription,SetID);
					CreatePage.saveandReturn();
					
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
			homepage.returnToIOHomePage();
			Assert.assertTrue(false);
		}
	}


}
