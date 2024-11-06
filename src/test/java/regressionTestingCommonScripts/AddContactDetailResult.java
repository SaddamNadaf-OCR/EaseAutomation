package regressionTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AddConsigneePage;
import filesClasses.AddNewContactDetailsPage;
import filesClasses.HomepageConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddContactDetailResult extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddContactDetailResult", excel);
	}
	@Test(dataProvider = "getData")
	public void AddContactDetails( String testcases,String RunMode, String SBU, String InputId,
			String ConsigneeName, String ID, String ContactCode, String FirstName, String Email,
			String Middlename, String LastName, String Address, String City, String State, String Zip, 
			String Country, String Language, String phone, String Fax)
	
	{
		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		AddConsigneePage addConsignee = new AddConsigneePage(driver, test);
		AddNewContactDetailsPage addcontact = new AddNewContactDetailsPage(driver, test); 
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hpConsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpConsignee.movetoFiles();
					Wait.waitfor(3);
					hpConsignee.ClickOnAddConsingee();
					Wait.waitfor(3);
					addConsignee.AddConsigneeDetails(InputId, ConsigneeName, ID);
					Wait.waitfor(3);
					addConsignee.Click_ConsigneeSave();
					Wait.waitfor(3);
					addConsignee.Click_ContactDetails();
					Wait.waitfor(3);
					addcontact.Click_addContactButton();
					Wait.waitfor(3);
					addcontact.Addcontactdetails(ContactCode, FirstName, Middlename, LastName, Address, City,
							State, Zip, Country, Language, phone, Email, Fax);
					addcontact.Click_ConsigneeSave();
					hpConsignee.logout();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}

		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpConsignee.logout();

		}
	}
}
	
	
	
	
	

