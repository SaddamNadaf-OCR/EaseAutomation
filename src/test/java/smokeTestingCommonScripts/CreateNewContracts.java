package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewContractsPage;
import filesClasses.HomePage;


import filesClasses.SearchContractsPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewContracts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddContract", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddContract(String Testcase, String RunMode, String SBU, String ContractNo, String Part130Req) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchContractsPage searchpage=new SearchContractsPage(driver,test);
		CreateNewContractsPage CreatePage=new CreateNewContractsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionAM(SBU);
					homepage.movetoContracts();
					searchpage.addContract();
					CreatePage.enterContractNo(ContractNo,Part130Req);
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
