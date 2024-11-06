package dpssClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class LoginPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Logo = "//img[@alt='OCR Services Inc.']";
	public static final String OCR_LoginPage_UserName = "//input[@id='login_username']";
	public static final String OCR_LoginPage_Password = "//input[@id='login_password']";
	public static final String OCR_LoginPage_Login = "//button[contains(text(),'Login')]";
	public static final String OCR_LoginPage_Logout = "//i[@class='fa fa-sign-out']";
	
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
		typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", uname);	
		typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", password);
		clickElement(driver, test, OCR_LoginPage_Login, "Clicking on Login");
	}	

}
