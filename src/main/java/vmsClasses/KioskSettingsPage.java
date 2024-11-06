package vmsClasses;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class KioskSettingsPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	// ******************** LOCATORS ********************************

	public static final String OCR_KioskSettings_Visitor =  "//button[contains(text(),'Visitor')]";
	public static final String OCR_KioskSettings_GenerateAccessLink = "//i[@class='fa fa-location-arrow']";
	public static final String OCR_KioskSettings_AccessKioskLink = "//a[contains(text(),'Access Kiosk Visitor Request')]";
	public static final String OCR_KioskSettings_KioskHomeStart = "//button[@id='startButton']";
	public static final String OCR_KioskSettings_NewVisitor = "//button[@id='newVisitor']";
	
	//---------------------- Visitor Details
	public static final String OCR_KioskSettings_FirstName = "//div[@id='field1Div']/div/input";
	public static final String OCR_KioskSettings_MiddleName = "//input[@id='field16']";
	public static final String OCR_KioskSettings_LastName = "//input[@name='visitorPersonValue.lastName']";
	public static final String OCR_KioskSettings_Email = "//input[@id='field3']";
	public static final String OCR_KioskSettings_Phone = "//input[@id='field4']";
	
	
	public static final String OCR_KioskSettings_VisitorEmail = "//input[@class='form-control emailField screenKeyboard']";
	public static final String OCR_KioskSettings_RegEmail = "//input[@id='registerNewWarehouseVisitor_visitorRegistrationValue_email']";
	public static final String OCR_KioskSettings_RegPhone = "//input[@id='registerNewWarehouseVisitor_visitorRegistrationValue_phone']";
	public static final String OCR_KioskSettings_Next = "(//button[contains(text(),'Next')])[1]";
	
	//--------------------------Visitor Address Details 
	
	public static final String OCR_KioskSettings_VisitorCountry = "//input[@id='field22']";
	public static final String OCR_KioskSettings_VisitorZip = "//input[@id='field25']";
	public static final String OCR_KioskSettings_VisitorState = "//input[@id='field23']";
	public static final String OCR_KioskSettings_VisitorCity = "//input[@id='field24']";
	public static final String OCR_KioskSettings_VisitorAddress = "//input[@id='field26']";
	public static final String OCR_KioskSettings_Next2 ="(//button[contains(text(),'Next')])[2]";
	
	// ------------------------Visitor Citizenship Details
	
	public static final String OCR_KioskSettings_CountryofCitizenship = "//div[@id='field6Div']/div/input";
	public static final String OCR_KioskSettings_VisitPurpose = "//select[@id='field9']";
	public static final String OCR_KioskSettings_VisitCategory = "//select[@id='field11']";
	public static final String OCR_KioskSettings_TypeOfPerson = "//select[@id='field15']";
	
	// ------------------------Visitor ID Details
	public static final String OCR_KioskSettings_IdType = "//select[@id='field7']";
	public static final String OCR_KioskSettings_IdNumber = "//input[@id='field8']";
	public static final String OCR_KioskSettings_IdCountry = "//input[@id='field32']";
	public static final String OCR_KioskSettings_IdState = "//input[@id='field33']";
	public static final String OCR_KioskSettings_IdExpirationDate= "//select[@id='field15']";
	public static final String OCR_KioskSettings_Next3 ="(//button[contains(text(),'Next')])[3]";
	
	//------------------------Visitor Organization Details
	public static final String OCR_KioskSettings_Organization = "//input[@id='field5']";
	public static final String OCR_KioskSettings_ORGCountry = "//input[@id='field17']";
	public static final String OCR_KioskSettings_ORGZip = "//input[@id='field29']";
	public static final String OCR_KioskSettings_ORGState = "//input[@id='field27']";
	public static final String OCR_KioskSettings_ORGCity = "//input[@id='field28']";
	public static final String OCR_KioskSettings_ORGAdress = "//input[@id='field30']";
	public static final String OCR_KioskSettings_ORGRepresentingSelfCheckBox = "//input[@id='visitorCompanyValue_noCompanyName']";
	public static final String OCR_KioskSettings_Next4 ="(//button[contains(text(),'Next')])[4]";
	
	//------------------------Visitor Vehicle Details
	public static final String OCR_KioskSettings_VehicleNo = "//input[@id='field12']";
	public static final String OCR_KioskSettings_CarMake = "//input[@id='field13']";
	public static final String OCR_KioskSettings_CarModel = "//input[@id='field14']";
	public static final String OCR_KioskSettings_Next5 ="(//button[contains(text(),'Next')])[5]";
	
	//------------------------Visitor Photo
	public static final String OCR_KioskSettings_Previous = "//button[contains(text(),'Previous')]";
	public static final String OCR_KioskSettings_Capture = "//button[@id='captureBtn']";
	public static final String OCR_KioskSettings_Next6 = "//button[@id='submitForm']";
	
	
	//------------------------Visitor Host
	public static final String OCR_KioskSettings_SearchHost = "//input[@id='hostFullName']";
	public static final String OCR_KioskSettings_Next7 = "//button[@id='policyDocBtn']";
	
	
	//------------------------Policy Agreement
	public static final String OCR_KioskSettings_Submit = "//button[@id='submitBtn']";
	
	
	
	
	public static final String OCR_KioskSettings_Next1 = "//button[@class='next btn primary-btn fs-height action-button']";
	public static final String OCR_KioskSettings_BoxRefNo ="//input[@id='field10']";
	public static final String OCR_KioskSettings_WhNext3 = "//button[@id='submitForm']";
	public static final String OCR_KioskSettings_WhSubmit = "//button[contains(text(),'Submit')]";
	public static final String OCR_KioskSettings_WhVisitorCode = "(//div[@class='col-6'])[1]";
	
	
	public static final String OCR_KioskSettings_WarehouseNo ="//button[@id='newVisitor']";
	public static final String OCR_KioskSettings_Cancel = "//button[@id='cancel']";
	public static final String OCR_KisokSettings_HomeIcon = "//i[@class='fa fa-home']";
	public static final String OCR_KisokSettings_Checkout = "//button[@id='coSearchVisitor']";
	public static final String OCR_KisokSettings_VisitorCode = "//input[@id='coThankYou_visitorCode']";
	public static final String OCR_KisokSettings_Validate = "//button[@id='validateBtn']";
	public static final String OCR_KisokSettings_COStatus = "(//div[@class='col-6'])[1]";
	public static final String OCR_KisokSettings_COStatus_Ok = "//button[@id='okbtn']";
	public static final String OCR_KisokSettings_PreRegisteredVisitor = "//button[@id='resetVisitor']";
	public static final String OCR_KisokSettings_PreRegistered_Lastname = "//input[@id='validateVisitorPin_visitorRegistrationValue_lastName']";
	public static final String OCR_KisokSettings_PreRegistered_VisitorCode = "//input[@id='validateVisitorPin_visitorRegistrationValue_visitorPin']";
	public static final String OCR_KioskSettings_VisitorVerification_Next = "//button[@id='validateSubmit']";
	public static final String OCR_KisokSettings_FutureVisit_CheckBox  = "//label[contains(text(),'Do you wish to save your registration for future v')]"; //label
	public static final String OCR_KisokSettings_FutureVisit_Pin  = "//input[@id='newPin']";
	public static final String OCR_KisokSettings_FutureVisit_ConfirmPin  = "//input[@id='confirmPin']";
	public static final String OCR_KisokSettings_FutureVisit_Next  = "//button[contains(text(),'Next')]";
	public static final String OCR_KisokSettings_FutureVisit_SQuestion1  = "//select[@id='firstSecQues']";
	public static final String OCR_KisokSettings_FutureVisit_SAnswer1  = "//input[@id='firstSecAns']";
	public static final String OCR_KisokSettings_FutureVisit_SQuestion2  = "//select[@id='secondSecQues']";
	public static final String OCR_KisokSettings_FutureVisit_SAnswer2  = "//input[@id='secondSecAns']";
	public static final String OCR_KisokSettings_Regtatus = "//div[@class='col-xs-12']";
	public static final String OCR_KioskSettings_WHYes = "//button[@id='resetVisitorPin']";
	public static final String OCR_VM_DashBoardIcon = "//i[@class='fa fa-dashboard']";
	public static final String OCR_KReq_PolicyDocNext = "//button[@id='policyDocBtn']";
	public static final String OCR_KReq_AcknwlegmntAndDocTable = "//table[@id='tableGrid1']";
	public static final String OCR_KReq_AcknwlegmntAndDocAgreeBtn = "//button[@id='submitBtn']";
	public static final String OCR_KReq_PolicyDocScrollCancel = "//button[@id='cancelBtn']";
	public static final String OCR_KReq_KioskProcessButton = "//button[@class='kProcessBtn col-xs-10 linkButtons']";
	public static final String OCR_KReq_KioskIPAddr = "//input[@id='kioskIpAddresses']";
	public static final String OCR_KReq_KioskIPAddrSave = "//button[contains(text(),'Save')]";
	public static final String OCR_KReq_ErrorHomeScreen = "//div[contains(text(),'Problem occurred. Please contact administrator.')]";
	public static final String OCR_KReq_WelcomeScreen = "//textarea[@id='welcomeScreenContent']";
	public static final String OCR_KioskSettings_FeaturesSave = "//button[@id='updateBtn']";
	public static final String OCR_KioskSettings_WelcomeText = "//h2[@id='welcomeScreenContent']";

	// ******************** Constructor *****************************

	public KioskSettingsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// ******************** Actions *********************************

	//Click on Kiosk Process tab
	public void click_KReqKioskProcess() {
		clickElement(driver, test, OCR_KReq_KioskProcessButton, "Clicking Kiosk Process Tab under kiosk setting page");
	}

	//Enter Kiosk IP Address
	public void type_KReqIPAddr(String KioskIPAddr){
		Wait.waitfor(2);
		clearText(driver, test, OCR_KReq_KioskIPAddr, "clearing the kiosk IP address");
		typeText(driver, test, OCR_KReq_KioskIPAddr, "Enter Kiosk IP address : ", KioskIPAddr);		
	}

	//Click on Save button
	public void click_KReqIPAddrSave() {
		clickElement(driver, test, OCR_KReq_KioskIPAddrSave, "Clicking Kiosk IP Address save button");
	}

	//Click Visitor Tab under kiosk setting page
	public void click_KReqVisitor(){	
		Wait.waitfor(3);
		clickElement(driver, test, OCR_KioskSettings_Visitor, "Clicking Visitor Tab under kiosk setting page");
	}

	//Getting the Kiosk Request welcome screen text
	public void get_KReqWelcomeScreenText(String WelcomeText)  {		
		//String Firsttext = driver.findElement(By.xpath(OCR_KReq_WelcomeScreen)).getText();		
		Wait.waitfor(4);
		clearText(driver, test, OCR_KReq_WelcomeScreen, "Clearing the welcome screen text");
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.waitfor(3);
		click_KReqFeaturesSave();
		Wait.waitfor(4);
		String Cleartext = driver.findElement(By.xpath(OCR_KReq_WelcomeScreen)).getText();
		if(Cleartext.isEmpty()) {
			test.log(LogStatus.PASS, " welcome screen text is empty");
		}else {
			test.log(LogStatus.FAIL, " welcome screen text is not empty");
			testFailSshot(driver, test);
		}
		typeText(driver, test, OCR_KReq_WelcomeScreen, "Enter the welcome text : ", WelcomeText);
		scrollToElement(driver, OCR_KioskSettings_FeaturesSave);
		click_KReqFeaturesSave();
		Wait.waitfor(3);
		String text = driver.findElement(By.xpath(OCR_KReq_WelcomeScreen)).getText();
		if(text.equals(WelcomeText)) {
			test.log(LogStatus.PASS, " welcome screen text is : " +text);
		}else {
			test.log(LogStatus.FAIL, " welcome screen text is : "+text);
			testFailSshot(driver, test);
		}

	}
	
	// Getting the Checkout Text
		/*public String get_KReqCOText() throws InterruptedException {		
			Wait.fluwait(driver, OCR_KisokSettings_COStatus);	
			Wait.waitfor(3);
			String text = driver.findElement(By.xpath(OCR_KisokSettings_COStatus)).getText();
			test.log(LogStatus.PASS, "Kiosk request checkout text : " + text);
			return text;
		}*/
	
	//getting the kiosk email text

	public void get_KReqRegEmailText(String REmail) {
		Wait.fluwait(driver, "//input[@class='form-control emailField screenKeyboard']");
		Wait.waitfor(3);
		String text = getAttribute(driver, test, "//input[@class='form-control emailField screenKeyboard']", "value", "Email text is populated");
		Wait.waitfor(4);
		if(text.equals(REmail)) {
			test.log(LogStatus.PASS, " Email text is populated : " +text);
		}else {
			test.log(LogStatus.FAIL, " Email text is not populated : "+text);
			testFailSshot(driver, test);
		}

	}
	
	// Click on kiosk Features save button
	public void click_KReqFeaturesSave(){	
		scrollToElement(driver, OCR_KioskSettings_FeaturesSave);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_KioskSettings_FeaturesSave, "Clicking save button under kiosk setting features page");
	}

	//Getting the Kiosk Request welcome screen text
	public void get_KReqHomeWelcomeScreenText(String WelcomeText)  {		
		String Hometext = driver.findElement(By.xpath(OCR_KioskSettings_WelcomeText)).getText();		
		Wait.waitfor(4);
		if(Hometext.equals(WelcomeText)) {
			test.log(LogStatus.PASS, " welcome screen text is : " +Hometext);
		}else {
			test.log(LogStatus.FAIL, " welcome screen text is : "+Hometext);
			testFailSshot(driver, test);
		}
	}

	//Click Generate Access link under kiosk setting page
	public void click_KReqGenerateAccessLink(){	
		try {
			clickElement(driver, test, OCR_KioskSettings_GenerateAccessLink, "Clicking Generate Access link under kiosk setting page");

		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Fail at Kiosk Access link");
			clickElement(driver, test, OCR_KioskSettings_Cancel, "click on cancle icon");			
		}
	}

	//Click Kiosk Access link under kiosk setting page
	public void click_KReqAccessKioskLink(){
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_KioskSettings_AccessKioskLink, "Clicking Kiosk Access link under kiosk setting page");
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());		
			driver.switchTo().window(tabs2.get(1));
			String str = driver.toString();
			if(str.contains("internet")) {
				driver.manage().window().maximize();
			}
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Fail at Kiosk Access link");
			clickElement(driver, test, OCR_KioskSettings_Cancel, "click on cancle icon");			
		}
	}

	//return to main window
	public void backtomainwindow() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());	
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}

	// Verify error message welcome home screen is available or not
	public void KReqErrorHomeScreen() throws Exception {		
		try {
			if (driver.findElement(By.xpath(OCR_KReq_ErrorHomeScreen)).isDisplayed()) {
				test.log(LogStatus.PASS, "Kiosk error message Home screen is displayed");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Kiosk error message Home screen is not displayed");
		}
	}

	//Home screen is Displayed or not
	public void KReqHomeScreen() throws Exception {		
		try {
			if (driver.findElement(By.xpath(OCR_KioskSettings_KioskHomeStart)).isDisplayed()) {
				test.log(LogStatus.PASS, "Kiosk Home screen is displayed");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Kiosk Home screen is not displayed");
		}
	}

	//Clicking Start button under kiosk home page
	public void click_KReqHomeStart(){
		Wait.fluwait(driver, OCR_KioskSettings_KioskHomeStart);
		Wait.waitfor(5);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_KioskSettings_KioskHomeStart)));
		test.log(LogStatus.PASS,"Clicking Start button under kiosk home page");	
	}

	//click New Visitor button under kiosk home page
	public void click_KReqNewVisitor(){
		Wait.fluwait(driver, OCR_KioskSettings_NewVisitor);
		driver.findElement(By.xpath(OCR_KioskSettings_NewVisitor)).click();
		test.log(LogStatus.PASS,"Clicking new visitor button under kiosk home page");
	}

	//Enter First name in visitor details screen
	public void type_KReqFirstName(String FirstName){
		Wait.fluwait(driver, OCR_KioskSettings_FirstName);
		Wait.waitfor(4);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(OCR_KioskSettings_FirstName))).click().build().perform();
		driver.findElement(By.xpath(OCR_KioskSettings_FirstName)).sendKeys(FirstName);
		test.log(LogStatus.PASS,"Enter First name in visitor details screen : " +FirstName);
	}

	//Enter last name in visitor details screen
	public void type_KReqLastName(String LastName){
		Wait.fluwait(driver, OCR_KioskSettings_LastName);
		driver.findElement(By.xpath(OCR_KioskSettings_LastName)).sendKeys(LastName);
		test.log(LogStatus.PASS,"Enter last name in visitor details screen : " +LastName);
	}

	//Enter email in visitor details screen
	public void type_KReqEmail(String Email){
		Wait.fluwait(driver, OCR_KioskSettings_Email);
		driver.findElement(By.xpath(OCR_KioskSettings_Email)).sendKeys(Email);
		test.log(LogStatus.PASS,"Enter email in visitor details screen : " +Email);
	}
	
	//Enter Visitor Registration email in kiosk 
		public void type_KReqRegEmail(String REmail){
			Wait.fluwait(driver, OCR_KioskSettings_RegEmail);
			driver.findElement(By.xpath(OCR_KioskSettings_RegEmail)).sendKeys(REmail);
			test.log(LogStatus.PASS,"Enter email in visitor details screen : " +REmail);
		}
		
	//Enter Phno in visitor details screen
	public void type_KReqPhone(String Phone){
		Wait.fluwait(driver, OCR_KioskSettings_Phone);
		driver.findElement(By.xpath(OCR_KioskSettings_Phone)).sendKeys(Phone);
		Wait.waitfor(4);
		test.log(LogStatus.PASS,"Enter Phno in visitor details screen : " +Phone);
	}
	
	//Enter Visitor Country in visitor address details screen
		public void select_KReqVisitorCountry(String VisitorCountry) throws InterruptedException {
			if(VisitorCountry.length()>0) {
				Wait.fluwait(driver,OCR_KioskSettings_VisitorCountry);
				driver.findElement(By.xpath(OCR_KioskSettings_VisitorCountry)).click();
				driver.findElement(By.xpath(OCR_KioskSettings_VisitorCountry)).sendKeys(VisitorCountry);
				Wait.waitfor(3);
				String locator="//div[contains(text(),'"+VisitorCountry.trim()+"')]";
				Wait.fluwait(driver, locator);
				driver.findElement(By.xpath(locator)).click();
				test.log(LogStatus.PASS, "Select Contry Of citizenShip in kiosk visitor details page : " +VisitorCountry);
			}	
		}
	
		//Enter  Visitor state in visitor address details screen
		public void select_KReqVisitorState(String VisitorState) throws InterruptedException {
			if(VisitorState.length()>0) {
				Wait.fluwait(driver,OCR_KioskSettings_VisitorState);
				driver.findElement(By.xpath(OCR_KioskSettings_VisitorState)).click();
				driver.findElement(By.xpath(OCR_KioskSettings_VisitorState)).sendKeys(VisitorState);
				Wait.waitfor(3);
				String locator="(//div[contains(text(),'"+VisitorState.trim()+"')])[1]";
				Wait.fluwait(driver, locator);
				System.out.println(locator);
				driver.findElement(By.xpath(locator)).click();
				test.log(LogStatus.PASS, "Select Visitor state in visitor address details page : " +VisitorState);
			}	
		}
	
		//Enter Visitor zip on visitor address details screen
				public void type_KReqRegVisitorZip(String VisitorZip){
					Wait.fluwait(driver, OCR_KioskSettings_VisitorZip);
					driver.findElement(By.xpath(OCR_KioskSettings_VisitorZip)).sendKeys(VisitorZip);
					test.log(LogStatus.PASS,"Enter Visitor zip on visitor address details screen : " +VisitorZip);
				}
			
		//Enter Visitor City on visitor address details screen
				public void type_KReqRegVisitorCity(String VisitorCity){
					Wait.fluwait(driver, OCR_KioskSettings_VisitorCity);
					driver.findElement(By.xpath(OCR_KioskSettings_VisitorCity)).sendKeys(VisitorCity);
					test.log(LogStatus.PASS,"Enter Visitor City on visitor address details screen : " +VisitorCity);
				}
				
		//Enter Visitor Address on visitor address details screen
				public void type_KReqRegVisitorAddress(String VisitorAddress){
					Wait.fluwait(driver, OCR_KioskSettings_VisitorAddress);
					driver.findElement(By.xpath(OCR_KioskSettings_VisitorAddress)).sendKeys(VisitorAddress);
					test.log(LogStatus.PASS,"Enter Visitor City on visitor address details screen : " +VisitorAddress);
				}
				
				//Clicking on Next button in FN visitor details page
				public void click_KReqVisitorAddressNext(){
					Wait.waitfor(3);
					scrollToBottom(driver);
					Wait.fluwait(driver, OCR_KioskSettings_Next2);
					Wait.waitfor(3);
					driver.findElement(By.xpath(OCR_KioskSettings_Next2)).click();
					Wait.waitfor(3);
					test.log(LogStatus.PASS,"Clicking on Next button visitor Address details page");
				}	
	
		//Enter Visitor Reg. Phno in kiosk reg. screen
		public void type_KReqRegPhone(String RPhone){
			Wait.fluwait(driver, OCR_KioskSettings_RegPhone);
			driver.findElement(By.xpath(OCR_KioskSettings_RegPhone)).sendKeys(RPhone);
			Wait.waitfor(4);
			test.log(LogStatus.PASS,"Enter Phno in visitor details screen : " +RPhone);
		}
		
		
		// Verify email and phone content is displayed in visitor details screen		
		public void validating_EmailPhone() throws InterruptedException {
			try {
				if (isDisplayed(driver,"//label[contains(text(),'View All OCR Hits')]")) {
					test.log(LogStatus.PASS, "View All OCR Hits label is displayed in view detail hits popup ");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "View All OCR Hits label is not displayed in view detail hits popup ");			
			}
		}
	

	//Clicking on Next button in FN visitor details page
	public void click_KReqFirstNameNext(){
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.fluwait(driver, OCR_KioskSettings_Next);
		Wait.waitfor(3);
		driver.findElement(By.xpath(OCR_KioskSettings_Next)).click();
		Wait.waitfor(3);
		test.log(LogStatus.PASS,"Clicking on Next button in First name visitor details page");
	}	

	//Enter CountryofCitizenship in visitor details screen
	public void select_KReqCountryofCitizenship(String CountryofCitizenship) throws InterruptedException {
		if(CountryofCitizenship.length()>0) {
			Wait.fluwait(driver,OCR_KioskSettings_CountryofCitizenship);
			driver.findElement(By.xpath(OCR_KioskSettings_CountryofCitizenship)).click();
			driver.findElement(By.xpath(OCR_KioskSettings_CountryofCitizenship)).sendKeys(CountryofCitizenship);
			Wait.waitfor(3);
			String locator="(//div[contains(text(),'"+CountryofCitizenship.trim()+"')])[1]";
			Wait.fluwait(driver, locator);
			driver.findElement(By.xpath(locator)).click();
			test.log(LogStatus.PASS, "Select Contry Of citizenShip in kiosk visitor details page : " +CountryofCitizenship);
		}	
	}

	//Enter Organization Country in visitor organization details screen
	public void select_KReqCountryofORGCountry(String ORGCountry) throws InterruptedException {
		if(ORGCountry.length()>0) {
			Wait.fluwait(driver,OCR_KioskSettings_ORGCountry);
			driver.findElement(By.xpath(OCR_KioskSettings_ORGCountry)).click();
			driver.findElement(By.xpath(OCR_KioskSettings_ORGCountry)).sendKeys(ORGCountry);
			Wait.waitfor(3);
			String locator="(//span[contains(text(),'"+ORGCountry.trim()+"')])[4]";
			Wait.fluwait(driver, locator);
			System.out.println(locator);
			driver.findElement(By.xpath(locator)).click();
			test.log(LogStatus.PASS, "Select organization Contry in kiosk visitor details page : " +ORGCountry);
		}	
	}
	
	//Select Id type in visitor details screen
	public void select_KReqIdType(String IDType) {
		if(IDType.length()==0) {
		}else {
			Wait.fluwait(driver,OCR_KioskSettings_IdType);
			new Select(driver.findElement(By.xpath(OCR_KioskSettings_IdType))).selectByVisibleText(IDType.trim());		
			test.log(LogStatus.PASS, "Select Id type in visitor details screen : " +IDType);
		}
	}

	//Enter IDnumber in visitor details screen
	public void type_KReqIdNumber(String IDNumber){
		Wait.fluwait(driver, OCR_KioskSettings_IdNumber);
		driver.findElement(By.xpath(OCR_KioskSettings_IdNumber)).sendKeys(IDNumber);
		test.log(LogStatus.PASS,"Enter Id number in visitor details screen : " +IDNumber);
	}
	
	//Enter identifying Country in visitor details screen
	public void select_KReqIDCountry(String IDCountry) throws InterruptedException {
		if(IDCountry.length()>0) {
			Wait.fluwait(driver,OCR_KioskSettings_IdCountry);
			driver.findElement(By.xpath(OCR_KioskSettings_IdCountry)).click();
			driver.findElement(By.xpath(OCR_KioskSettings_IdCountry)).sendKeys(IDCountry);
			Wait.waitfor(3);
			String locator="(//div[contains(text(),'"+IDCountry.trim()+"')])[1]";
			Wait.fluwait(driver, locator);
			System.out.println(locator);
			driver.findElement(By.xpath(locator)).click();
			test.log(LogStatus.PASS, "Select identifying Contry in kiosk visitor details page : " +IDCountry);
		}	
	}
	
	//Enter  identifying state in visitor details screen
		public void select_KReqIDState(String IDState) throws InterruptedException {
			if(IDState.length()>0) {
				Wait.fluwait(driver,OCR_KioskSettings_IdState);
				driver.findElement(By.xpath(OCR_KioskSettings_IdState)).click();
				driver.findElement(By.xpath(OCR_KioskSettings_IdState)).sendKeys(IDState);
				Wait.waitfor(3);
				String locator="(//div[contains(text(),'"+IDState.trim()+"')])[1]";
				Wait.fluwait(driver, locator);
				System.out.println(locator);
				driver.findElement(By.xpath(locator)).click();
				test.log(LogStatus.PASS, "Select identifying state in kiosk visitor details page : " +IDState);
			}	
		}
	
	
	//Clicking on Next button in COC visitor details page  
	public void click_KReqCOCNext(){
		Wait.fluwait(driver, OCR_KioskSettings_Next1);
		driver.findElement(By.xpath(OCR_KioskSettings_Next1)).click();
		test.log(LogStatus.PASS,"Clicking on Next button in COC visitor details page");
	}
	
	//Clicking on Next button in COC visitor details page
	public void click_KReqCOCNext1(){
		Wait.fluwait(driver, "(//button[@name='next'])[4]");
		driver.findElement(By.xpath("(//button[@name='next'])[4]")).click();
		test.log(LogStatus.PASS,"Clicking on Next button in COC visitor details page");
	}	

	//Enter Organization in visitor details screen
	public void type_KReqOrganization(String Organization){
		Wait.fluwait(driver, OCR_KioskSettings_Organization);
		driver.findElement(By.xpath(OCR_KioskSettings_Organization)).sendKeys(Organization);
		test.log(LogStatus.PASS,"Enter Organization in visitor details screen: " +Organization);
	}	

	//getting the Organization name
	public String getOrgName() {
		return driver.findElement(By.xpath(OCR_KioskSettings_Organization)).getAttribute("value");
	}

	//Select Visit purpose in visitor details screen
	public void select_KReqVisitPurpose(String VisitPurpose) {
		Wait.fluwait(driver,OCR_KioskSettings_VisitPurpose);
		new Select(driver.findElement(By.xpath(OCR_KioskSettings_VisitPurpose))).selectByVisibleText(VisitPurpose.trim());		
		test.log(LogStatus.PASS, "Select Visit purpose in visitor details screen : " +VisitPurpose);
	}

	//Select Visitor Category or BoxRefNumber in visitor details screen or Box/Ref no
	public void select_KReqVisitorCategory(String VisitorCategory,String BoxRefNumber) {
		if(VisitorCategory.length()==0) {
			Wait.fluwait(driver,OCR_KioskSettings_BoxRefNo);
			driver.findElement(By.xpath(OCR_KioskSettings_BoxRefNo)).sendKeys(BoxRefNumber);
			test.log(LogStatus.PASS, "Select BoxRefNumber in visitor details screen : " +BoxRefNumber);
		}else {		
			Wait.fluwait(driver,OCR_KioskSettings_VisitCategory);
			new Select(driver.findElement(By.xpath(OCR_KioskSettings_VisitCategory))).selectByVisibleText(VisitorCategory.trim());		
			test.log(LogStatus.PASS, "Select Visit Category in visitor details screen : " +VisitorCategory);
		}
	}
	
	//Select Visitor Category in visitor details screen 
		public void select_KReqVisitorCategory(String VisitorCategory) {
			if(VisitorCategory.length()>0) {
				Wait.fluwait(driver,OCR_KioskSettings_VisitCategory);
				new Select(driver.findElement(By.xpath(OCR_KioskSettings_VisitCategory))).selectByVisibleText(VisitorCategory.trim());		
				test.log(LogStatus.PASS, "Select Visit Category in visitor details screen : " +VisitorCategory);
			}
		}

		//Select Type of person in visitor details screen
			public void select_KReqTypeOfPerson(String TypeOfPerson) {
				if(TypeOfPerson.length()>0) {
					Wait.fluwait(driver,OCR_KioskSettings_TypeOfPerson);
					new Select(driver.findElement(By.xpath(OCR_KioskSettings_TypeOfPerson))).selectByVisibleText(TypeOfPerson.trim());		
					test.log(LogStatus.PASS, "Select type of person in visitor details screen : " +TypeOfPerson);
				}
			}
		
	//Clicking on Next button in Org Name visitor details page
	public void click_KReqOrgNameNext(){
		Wait.fluwait(driver, OCR_KioskSettings_Next2);
		Wait.waitfor(3);
		driver.findElement(By.xpath(OCR_KioskSettings_Next2)).click();
		test.log(LogStatus.PASS,"Clicking on Next button in Org Name visitor details page");
		Wait.waitfor(3);
	}	

	//Enter Vehicle no in visitor details screen
	public void type_KReqVehicleNo(String Vehicleno){
		Wait.fluwait(driver, OCR_KioskSettings_VehicleNo);
		driver.findElement(By.xpath(OCR_KioskSettings_VehicleNo)).sendKeys(Vehicleno);
		test.log(LogStatus.PASS,"Enter Vehicle no in visitor details screen : " +Vehicleno);
	}

	//Enter Car Make in visitor details screen
	public void type_KReqCarMake(String CarMake){
		Wait.fluwait(driver, OCR_KioskSettings_CarMake);
		driver.findElement(By.xpath(OCR_KioskSettings_CarMake)).sendKeys(CarMake);
		test.log(LogStatus.PASS,"Enter Car Make in visitor details screen: " +CarMake);
	}	

	//Enter Car Model in visitor details screen
	public void type_KReqCarModel(String CarModel){
		Wait.fluwait(driver, OCR_KioskSettings_CarModel);
		Wait.waitfor(3);
		driver.findElement(By.xpath(OCR_KioskSettings_CarModel)).sendKeys(CarModel);
		test.log(LogStatus.PASS,"Enter Car Model in visitor details screen : " +CarModel);
	}	

	//Clicking on Vehicle Next button in visitor details page
	public void click_KReqVehicleNext(){
		Wait.fluwait(driver, OCR_KioskSettings_WhNext3);
		Wait.waitfor(4);
		driver.findElement(By.xpath(OCR_KioskSettings_WhNext3)).click();
		test.log(LogStatus.PASS,"Clicking on Vehicle Next button in visitor details page");
	}

	//Clicking on Photo screen Next button in visitor details page
	public void click_KReqPhotoNext(){
		Wait.fluwait(driver, OCR_KioskSettings_Next3);
		Wait.waitfor(4);
		driver.findElement(By.xpath(OCR_KioskSettings_Next3)).click();
		test.log(LogStatus.PASS,"Clicking on Vehicle Next button in visitor details page");
	}

	//Clicking on Submit button in photo screen
	public void click_KReqPhotoScreenSubmit(){
		Wait.waitfor(5);
		Wait.fluwait(driver, OCR_KioskSettings_WhSubmit);
		scrollToBottom(driver);
		Wait.waitfor(5);
		driver.findElement(By.xpath(OCR_KioskSettings_WhSubmit)).click();
		test.log(LogStatus.PASS,"Clicking on Submit button in photo screen");
	}

	//Clicking on Next button in Photo screen visitor details page
	public void click_KReqHostNext(){
		Wait.fluwait(driver, OCR_KioskSettings_Next4);
		scrollToBottom(driver);
		Wait.waitfor(5);
		driver.findElement(By.xpath(OCR_KioskSettings_Next4)).click();
		test.log(LogStatus.PASS,"Clicking on Next button in photo screen visitor details page");
	}

	//Enter Host in Search host screen
	public void select_KReqSearchHost(String SearchHost) throws InterruptedException {
		Wait.fluwait(driver,OCR_KioskSettings_SearchHost);
		driver.findElement(By.xpath(OCR_KioskSettings_SearchHost)).click();
		driver.findElement(By.xpath(OCR_KioskSettings_SearchHost)).sendKeys(SearchHost);
		test.log(LogStatus.PASS, "Enter Host in Search host screen : " +SearchHost);
		Wait.waitfor(5);
		String locator="//span[contains(text(),'"+SearchHost.trim()+"')]";
		Wait.fluwait(driver, locator);
		driver.findElement(By.xpath(locator)).click();
		test.log(LogStatus.PASS, "click on : " +SearchHost);
	}	

	//Clicking on Submit button in Search host screen
	public void click_KReqSubmit(){
		Wait.fluwait(driver, OCR_KioskSettings_Submit);
		driver.findElement(By.xpath(OCR_KioskSettings_Submit)).click();
		test.log(LogStatus.PASS,"Clicking on submit button in Search Host page");
	}	

	public void cancel_popup() {
		AlertPopUp(driver, test, "Cancel");
	}
	//Clicking on No button in Warehouse kiosk type
	public void click_KReqWarehouseNo(){
		scrollToBottom(driver);
		Wait.waitfor(3);
		Wait.fluwait(driver, OCR_KioskSettings_WarehouseNo);
		driver.findElement(By.xpath(OCR_KioskSettings_WarehouseNo)).click();
		test.log(LogStatus.PASS,"Clicking on No button in Warehouse kiosk type");
	}	

	//Clicking on Cancel button in generate access link popup
	public void click_KReqAccessLinkCancel(){
		Wait.fluwait(driver, OCR_KioskSettings_Cancel);
		driver.findElement(By.xpath(OCR_KioskSettings_Cancel)).click();
		test.log(LogStatus.PASS,"Clicking on Cancel button in generate access link popup");
	}

	// Getting the default text in kiosk confirmation page
	public String get_KReqVisitorText() throws InterruptedException {		
		Wait.fluwait(driver, OCR_KioskSettings_WhVisitorCode);	
		Wait.waitfor(3);
		String text = driver.findElement(By.xpath(OCR_KioskSettings_WhVisitorCode)).getText();		
		String VisitorText = text.substring(0, 43);	
		return VisitorText.trim();
	}

	// Getting the Visitor code
	public String get_KReqVisitorCode() throws InterruptedException {		
		Wait.fluwait(driver, OCR_KioskSettings_WhVisitorCode);	
		Wait.waitfor(3);
		String id = driver.findElement(By.xpath(OCR_KioskSettings_WhVisitorCode)).getText();		
		test.log(LogStatus.PASS, "Visitor Code : " + id);
		String VisitorCode = id.substring(id.length()-6);		
		return VisitorCode;
	}

	//Clicking on Home icon in Kiosk confirmation page
	public void click_KReqHomeIcon(){
		Wait.fluwait(driver, OCR_KisokSettings_HomeIcon);
		driver.findElement(By.xpath(OCR_KisokSettings_HomeIcon)).click();
		test.log(LogStatus.PASS,"Clicking on home icon in kiosk confirmation page");
	}

	//Clicking on checkout button in confirmation page
	public void click_KReqCheckout(){
		Wait.fluwait(driver, OCR_KisokSettings_Checkout);
		scrollToBottom(driver);
		Wait.waitfor(2);
		driver.findElement(By.xpath(OCR_KisokSettings_Checkout)).click();
		test.log(LogStatus.PASS,"Clicking on checkout button in confirmation page");
	}

	//Enter Visitor code in visitor verification page
	public void type_KReqVisitorCode(String VisitorCode){
		Wait.fluwait(driver, OCR_KisokSettings_VisitorCode);
		Wait.waitfor(3);
		driver.findElement(By.xpath(OCR_KisokSettings_VisitorCode)).sendKeys(VisitorCode);
		test.log(LogStatus.PASS,"Enter Visitor code in visitor verification page : " +VisitorCode);
	}	

	//Clicking on validate button in visitor verification page
	public void click_KReqValidate(){
		Wait.fluwait(driver, OCR_KisokSettings_Validate);
		driver.findElement(By.xpath(OCR_KisokSettings_Validate)).click();
		test.log(LogStatus.PASS,"Clicking on validate button in visitor verification page");
	}

	// Getting the Checkout Text
	public String get_KReqCOText() throws InterruptedException {		
		Wait.fluwait(driver, OCR_KisokSettings_COStatus);	
		Wait.waitfor(3);
		String text = driver.findElement(By.xpath(OCR_KisokSettings_COStatus)).getText();
		test.log(LogStatus.PASS, "Kiosk request checkout text : " + text);
		return text;
	}

	// Clicking on Ok button in checkout status screen
	public void click_KReqCOStatusOk(){
		Wait.fluwait(driver, OCR_KisokSettings_COStatus_Ok);
		driver.findElement(By.xpath(OCR_KisokSettings_COStatus_Ok)).click();
		test.log(LogStatus.PASS,"Clicking on Ok button in checkout status screen");
	}

	// Clicking on Pre Registered visitor button 
	public void click_KReqPreRegisteredVisitor(){
		Wait.fluwait(driver, OCR_KisokSettings_PreRegisteredVisitor);
		driver.findElement(By.xpath(OCR_KisokSettings_PreRegisteredVisitor)).click();
		test.log(LogStatus.PASS,"Clicking on Pre Registered visitor button ");
	}

	//Enter last name in Visitor verification screen
	public void type_KReqPreRegisteredLastname(String LastName){
		Wait.fluwait(driver, OCR_KisokSettings_PreRegistered_Lastname);
		driver.findElement(By.xpath(OCR_KisokSettings_PreRegistered_Lastname)).clear();
		driver.findElement(By.xpath(OCR_KisokSettings_PreRegistered_Lastname)).sendKeys(LastName);
		test.log(LogStatus.PASS,"Enter last name in Visitor verification screen : " +LastName);
	}	

	//Enter visitor code in Visitor verification screen
	public void type_KReqPreRegisteredVisitorCode(String Pin){
		Wait.fluwait(driver, OCR_KisokSettings_PreRegistered_VisitorCode);
		driver.findElement(By.xpath(OCR_KisokSettings_PreRegistered_VisitorCode)).clear();
		driver.findElement(By.xpath(OCR_KisokSettings_PreRegistered_VisitorCode)).sendKeys(Pin);
		test.log(LogStatus.PASS,"Enter visitor code in Visitor verification screen : " +Pin);
	}	

	// Clicking on next button in visitor verification page
	public void click_KReqVisitorVerificationNext(){
		Wait.fluwait(driver, OCR_KioskSettings_VisitorVerification_Next);
		driver.findElement(By.xpath(OCR_KioskSettings_VisitorVerification_Next)).click();
		test.log(LogStatus.PASS,"Clicking on next button in visitor verification page ");
	}	

	//Select future visit check box in confirmation page
	public void click_KReqFutureVisitCheckBox() {
		Wait.fluwait(driver,OCR_KisokSettings_FutureVisit_CheckBox);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_CheckBox)).click();
		test.log(LogStatus.PASS, "Select future visit check box in confirmation page");
	}

	//Enter visitor pin in new registration screen
	public void type_KReqFutureVisitPin(String Pin){
		Wait.fluwait(driver, OCR_KisokSettings_FutureVisit_Pin);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_Pin)).sendKeys(Pin);
		test.log(LogStatus.PASS,"Enter visitor pin in new registration screen :" +Pin);
	}	

	//Enter visitor Confirm pin in new registration screen
	public void type_KReqFutureVisitConfirmPin(String ConfirmPin){
		Wait.fluwait(driver, OCR_KisokSettings_FutureVisit_ConfirmPin);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_ConfirmPin)).sendKeys(ConfirmPin);
		test.log(LogStatus.PASS,"Enter visitor Confirm pin in new registration screen : " +ConfirmPin);
	}	

	//Clicking next button in the new registration page
	public void click_KReqRegistrationNext(){
		Wait.fluwait(driver, OCR_KisokSettings_FutureVisit_Next);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_Next)).click();
		test.log(LogStatus.PASS,"Clicking on next button in new registration page ");
	}	

	//Select Security question 1 in the password reset questions page				
	public void select_KReqRegistartionSecQuestion1(String FirstSecurityQuestion) {
		Wait.fluwait(driver,OCR_KisokSettings_FutureVisit_SQuestion1);
		new Select(driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_SQuestion1))).selectByVisibleText(FirstSecurityQuestion.trim());		
		test.log(LogStatus.PASS, "Select Security question 1 in the password reset questions page : " +FirstSecurityQuestion);
	}

	//Enter security answer 1 in the password reset questions page	
	public void type_KReqRegistartionSecAnswer1(String Answer1){
		Wait.fluwait(driver, OCR_KisokSettings_FutureVisit_SAnswer1);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_SAnswer1)).sendKeys(Answer1);
		test.log(LogStatus.PASS,"Enter security answer 1 in the password reset questions page :" +Answer1);
	}

	//Select Security question 2 in the new registration page				
	public void select_KReqRegistartionSecQuestion2(String SecondSecurityQuestion) {
		Wait.fluwait(driver,OCR_KisokSettings_FutureVisit_SQuestion2);
		new Select(driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_SQuestion2))).selectByVisibleText(SecondSecurityQuestion.trim());		
		test.log(LogStatus.PASS, "Select Security question 2 in the password reset questions page : " +SecondSecurityQuestion);
	}

	//Enter security answer 2 in the password reset questions page	
	public void type_KReqRegistartionSecAnswer2(String Answer2){
		Wait.fluwait(driver, OCR_KisokSettings_FutureVisit_SAnswer2);
		driver.findElement(By.xpath(OCR_KisokSettings_FutureVisit_SAnswer2)).sendKeys(Answer2);
		test.log(LogStatus.PASS,"Enter security answer 2 in the password reset questions page:" +Answer2);
	}

	// Getting the Kiosk Request registration text
	public String get_KReqRegistrationText() throws InterruptedException {		
		Wait.fluwait(driver, OCR_KisokSettings_Regtatus);	
		Wait.waitfor(3);
		String text = driver.findElement(By.xpath(OCR_KisokSettings_Regtatus)).getText();
		test.log(LogStatus.PASS, "Kiosk Request registration text : " + text);
		return text;
	}

	//Clicking Yes button in the registration page
	public void click_KReqWHYes(){
		Wait.fluwait(driver, OCR_KioskSettings_WHYes);
		Wait.waitfor(70);
		driver.findElement(By.xpath(OCR_KioskSettings_WHYes)).click();
		test.log(LogStatus.PASS,"Clicking Yes button in the registration page ");
	}

	//Clicking on VM DashBoard icon in confirmation page
	public void click_VMDashBoardIcon(){
		Wait.fluwait(driver, OCR_VM_DashBoardIcon);
		driver.findElement(By.xpath(OCR_VM_DashBoardIcon)).click();
		test.log(LogStatus.PASS,"Clicking on VM Dashboard icon ");
		Wait.waitfor(3);
		sortDropDown(driver, test, "//select[@id='userSite']", "");
		test.log(LogStatus.PASS,"Verifying dash board site list is alphabetical order ");
	}
	
	

	//Clicking on next button in search host page
	public void click_KReqPolicyDocNext(){
		Wait.fluwait(driver, OCR_KReq_PolicyDocNext);
		Wait.waitfor(4);
		driver.findElement(By.xpath(OCR_KReq_PolicyDocNext)).click();
		test.log(LogStatus.PASS,"Clicking on next button in search host page ");
	}

	//Validating Acknowledgement and Documentation for policy Document and Accepting the Document in Kiosk request. 
	public void kReqvalidAckwAndDoc(String AcknowledgementAndDoc){
		ArrayList<String> DocName = stringtoken(AcknowledgementAndDoc);
		for (int i = 0; i < DocName.size(); i++) {	
			Wait.waitfor(3);
			driver.findElement(By.xpath(OCR_KReq_AcknwlegmntAndDocTable)).isDisplayed();	
			test.log(LogStatus.PASS, "Acknowledgement and Documentation Table is Displayed");
			Wait.waitfor(3);
			String locPDF = "//td[contains(text(),'"+DocName.get(i).trim() +"')]/following-sibling::td/a";
			Wait.waitfor(7);
			Wait.fluwait(driver, locPDF);
			driver.findElement(By.xpath(locPDF)).click();
			test.log(LogStatus.PASS,"click on policy Document : "+DocName.get(i));
			Wait.waitfor(3);
			Wait.fluwait(driver, OCR_KReq_AcknwlegmntAndDocAgreeBtn);
			driver.findElement(By.xpath(OCR_KReq_AcknwlegmntAndDocAgreeBtn)).click();
			test.log(LogStatus.PASS,"click on policy docuements Agree button ");
			String locAccepted = "//td[contains(text(),'"+DocName.get(i).trim()+"')]/following-sibling::td[2]/input";
			Wait.fluwait(driver, locAccepted);
			driver.findElement(By.xpath(locAccepted)).isSelected();
			test.log(LogStatus.PASS,"Check box is Selected in Accepted Columns : "+DocName.get(i));
		}
	}	


}