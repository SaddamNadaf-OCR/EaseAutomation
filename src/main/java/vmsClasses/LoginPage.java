package vmsClasses;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class LoginPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Logo = "//img[@alt='OCR Services Inc.']";
	public static final String OCR_LoginPage_UserName = "//input[@id='login_username']";
	public static final String OCR_LoginPage_Password = "//input[@id='login_password']";
	public static final String OCR_LoginPage_Login = "//button[contains(text(),'Login')]";
	public static final String OCR_LoginPage_Logout = "//i[@class='fa fa-sign-out']";
	public static final String OCR_LoginPage_CompliancePort = "(//a/img)[1]";
	public static final String OCR_Enhanced_Search_functionalitybutton="(//button[@id='enhanced-search-info-gotit'])[1]";

	/* ******************** Constructor ***************************** */

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click logout button
	public void click_Logout() throws InterruptedException {
		clickElement(driver, test, OCR_LoginPage_Logout, "Clicking on Logout");
	}

	// login method
	public void login(String uname, String password) throws FileNotFoundException, IOException {
			//System.out.println(OCR_LoginPage_UserName);
			//typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", uname);
			//typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", password);
			//System.out.println(OCR_LoginPage_Password);
			//clickElement(driver, test, OCR_LoginPage_Login, "Clicking on Login");
		WebElement username= driver.findElement(By.id("login_username"));
		username.sendKeys(uname);
		test.log(LogStatus.INFO, "Entring User Name :");
		WebElement pass=driver.findElement(By.id("login_password"));
		pass.sendKeys(password);
		test.log(LogStatus.INFO, "Entring Password :");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		test.log(LogStatus.INFO, "Clicking on Log In Button :");
	}

	/*
	// login method
		public void loginNewUser(String ActualuserId, String Password) throws FileNotFoundException, IOException {
				//System.out.println(OCR_LoginPage_UserName);
				//typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", uname);
				//typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", password);
				//System.out.println(OCR_LoginPage_Password);
				//clickElement(driver, test, OCR_LoginPage_Login, "Clicking on Login");
			WebElement username= driver.findElement(By.id("login_username"));
			username.sendKeys(ActualuserId);
			test.log(LogStatus.INFO, "Entring User Name :");
			WebElement pass=driver.findElement(By.id("login_password"));
			pass.sendKeys(Password);
			test.log(LogStatus.INFO, "Entring Password :");
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			test.log(LogStatus.INFO, "Clicking on Log In Button :");
		}*/
	
	// login method for new user creation ---------------------------------------Added By Afsha
		public void loginNewUser(String uname, String password) throws FileNotFoundException, IOException {
			WebElement username= driver.findElement(By.id("login_username"));
			username.sendKeys(uname);
			WebElement pass=driver.findElement(By.id("login_password"));
			pass.sendKeys(password);
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			Wait.waitfor(5);
		    scrollToElement(driver, OCR_Enhanced_Search_functionalitybutton);
	        clickElement(driver, test,OCR_Enhanced_Search_functionalitybutton , "Click on Got It button");
			Wait.waitfor(2);
		}
		
		
	// Click on Compliance portal
	public void click_CompliancePortal() {
		clickElement(driver, test, OCR_LoginPage_CompliancePort, "Click on Compliance Portal");
		Wait.waitfor(5);
		try {
			if(isDisplayed(driver, "//button[@id='enhanced-search-info-gotit']"))
			clickElement(driver, test, "//button[@id='enhanced-search-info-gotit']", "Click on Alert Close");
		} catch (Exception e) {
			Wait.waitfor(3);
		}
		mouseOver(driver, test, "//i[@class='fa fa-pencil']", "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, "//a[contains(text(),'Visitor Management')]",
				"Click on Visitor Management");
		clickElement(driver, test, "(//button[contains(text(),'Reset')])[1]", "");
		Wait.waitfor(3);
	}

}
