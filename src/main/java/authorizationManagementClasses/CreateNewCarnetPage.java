package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewCarnetPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//....................................Locators ......................................//
	public static final String CreateCarnet_Save="//button[@name='Save.x']";
	public static final String CreateCarnet_SaveandReturn="//button[@name='Ok']";
	public static final String CreateCarnet_Cancel="//button[@name='Cancel.x']";
	public static final String CreateCarnet_CarnetNo="//input[@name='carnetHeader.carnetNo']";
	public static final String CreateCarnet_CarnetHolder="//input[@name='carnetHeader.carnetHolder']";
	public static final String CreateCarnet_CarnetIssueDate="//input[@name='carnetIssueDate']";
	public static final String CreateCarnet_CarnetExpirationDate="//input[@name='carnetExpirationDate']";
	public static final String CreateCarnet_TransactionTypeExport="//input[@id='editCarnet_carnetHeader_exportOrImportE']";
	public static final String CreateCarnet_TransactionTypeImport="//input[@id='editCarnet_carnetHeader_exportOrImportI']";
	public static final String CreateCarnet_CountriesAllowed="//select[@id='editCarnet_country']";
	public static final String CreateCarnet_BreachY="//input[@id='editCarnet_carnetHeader_breachY']";
	public static final String CreateCarnet_BreachN="//input[@id='editCarnet_carnetHeader_breachN']";
	public static final String CreateCarnet_IssuedCountryName="//input[@id='editCarnet_carnetHeader_issuedCountryName']";
	public static final String CreateCarnet_IssuedAssociation="//input[@id='editCarnet_carnetHeader_issuedAssociation']";
	public static final String CreateCarnet_LiqDamage="//input[@id='editCarnet_liqDamage']";
	public static final String CreateCarnet_PenalityAmount="//input[@id='editCarnet_penalityAmount']";
	public static final String CreateCarnet_Broker="//input[@id='editCarnet_carnetHeader_ffBroker']";
	public static final String CreateCarnet_Remarks="//textarea[@id='editCarnet_carnetHeader_remarks']";
	
	//...................................Constructors............................................//
	public CreateNewCarnetPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...............................CLick on Save Tab ........................................//
	public void save() {
		clickElement(driver, test, CreateCarnet_Save, "Clicking on Save Tab");
	}
	
	//...............................Click on save and Return Button..........................//
	public void saveandreturn() {
		clickElement(driver, test, CreateCarnet_SaveandReturn, "Clicking on Save And Return Tab");
	}
	
	//..............................Click on Cancel Tab .................................//
	public void cancel() {
		clickElement(driver, test, CreateCarnet_Cancel, "Clicking on Cancel Tab");
	}
	
	//............................Entering Data into Carnet Page...........................//
	public void carnetData(String carnetNo,String carnetHolderNo,String issuedate,String expirydate,String transactionType,String breach,
			String countryAllowed,String issueCountryCode,String issueAssociation,String liqDamage,String carnetPenalityAmount,String carnetBroker,String carnetRemarks) {
		typeText(driver, test, CreateCarnet_CarnetNo, "Entering Carnet No into TextBox", carnetNo);
		Wait.waitfor(2);
		typeText(driver, test, CreateCarnet_CarnetHolder, "Entering Carnet Holder Number", carnetHolderNo);
		Wait.waitfor(2);
		if (issuedate.length()>0) {
			clickElement(driver, test, CreateCarnet_CarnetIssueDate, "Clicking on Issue Date : ");
			Wait.waitfor(2);
			dateOfMonthName(driver, test, "Selecting Date From PopUp :", issuedate);
			test.log(LogStatus.PASS, "Selecting Date From PopUp :"+issuedate);
			Wait.waitfor(2);
			clickElement(driver, test, CreateCarnet_CarnetExpirationDate, "Clicking on Expiration Date");
			Wait.waitfor(2);
			dateOfMonthName(driver, test, "Selecting Date From PopUp :", expirydate);
			test.log(LogStatus.PASS, "Selecting Date From PopUp :"+expirydate);
			Wait.waitfor(2);
		}
		if(transactionType.equalsIgnoreCase("export")) {
			clickElement(driver, test, CreateCarnet_TransactionTypeExport, "Clicking on Export");
		}
		if(transactionType.equalsIgnoreCase("import")) {
			clickElement(driver, test, CreateCarnet_TransactionTypeImport, "Clicking on Import");
		}
		Wait.waitfor(3);
		if(breach.equalsIgnoreCase("yes")) {
			clickElement(driver, test, CreateCarnet_BreachY, "Clicking on Breach Yes");
		}
		if(breach.equalsIgnoreCase("no")){
			clickElement(driver, test, CreateCarnet_BreachN, "Clicking on Breach No");
		}
		selectByVisibleText(driver, test, CreateCarnet_CountriesAllowed, "Selecting Country Allowed Name From DropDown", countryAllowed);
		Wait.waitfor(3);
		/*
		 * clickElement(driver, test, CreateCarnet_IssuedCountryCode,
		 * "Clicking on Issue Country Code"); Wait.waitfor(3);
		 */
		typeText(driver, test, CreateCarnet_IssuedCountryName, "Clicking on Issue Country Code", issueCountryCode);
		Wait.waitfor(3);
		typeText(driver, test, CreateCarnet_IssuedAssociation, "Entering Issue Association ", issueAssociation);
		Wait.waitfor(3);
		typeText(driver, test, CreateCarnet_LiqDamage, "Entering Liq Damage : ", liqDamage);
		Wait.waitfor(3);
		typeText(driver, test, CreateCarnet_PenalityAmount, "Entering Penality Amount :", carnetPenalityAmount);
		Wait.waitfor(3);
		typeText(driver, test, CreateCarnet_Broker, "Entering Carnet Broker :", carnetBroker);
		Wait.waitfor(3);
		typeText(driver, test, CreateCarnet_Remarks, "Entering Carnet Remarks :", carnetRemarks);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, CreateCarnet_IssuedCountryName, "Getting Country First Value :");
	}

}
