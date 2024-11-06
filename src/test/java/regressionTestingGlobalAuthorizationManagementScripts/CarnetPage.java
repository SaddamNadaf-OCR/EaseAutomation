package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewCarnetPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchCarnetPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CarnetPage extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CarnetPageScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void carnetPage(String TestCases,String RunMode, String SBU, String carnetNo, String carnetHolderNo, String issuedate, String expirydate, 
			String Import, String breach, String countryAllowed, String issueCountryCode, String issueAssociation, String liqDamage, String carnetPenalityAmount, 
			String carnetBroker, String carnetRemarks) {
		HomePage_AMPage homaPage = new HomePage_AMPage(driver, test);
		SearchCarnetPage searchCarnet = new SearchCarnetPage(driver, test);
		CreateNewCarnetPage newCarnet = new CreateNewCarnetPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homaPage.move_to_moduleSelection(SBU);
					homaPage.moduleSelection();
					homaPage.click_on_Carnet();
					searchCarnet.addCarnet();
					newCarnet.carnetData(carnetNo, carnetHolderNo, issuedate, expirydate, Import, breach, countryAllowed, 
							issueCountryCode, issueAssociation, liqDamage, carnetPenalityAmount, carnetBroker, carnetRemarks);
					newCarnet.saveandreturn();
					homaPage.logOut();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
		}
	}

}
