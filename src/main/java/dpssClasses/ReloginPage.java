
package dpssClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ReloginPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Logo = "//img[@alt='OCR Services Inc.']";
	public static final String OCR_LoginPage_UserName = "//input[@id='login_username']";
	public static final String OCR_LoginPage_Password = "//input[@id='login_password']";
	public static final String OCR_LoginPage_Login = "//button[contains(text(),'Login')]";
	public static final String OCR_LoginPage_Logout = "//i[@class='fa fa-sign-out']";
	
	/* ******************** Constructor ***************************** */
	
	public ReloginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */

	// click logout button
	public void click_Logout() throws InterruptedException {
		clickElement(driver, test, OCR_LoginPage_Logout, "Clicking on Logout");
	}

	// login method
	public void login(String userRole) throws FileNotFoundException, IOException {
		
		if (userRole.equals("FTZCORP_ADMIN")) {
			typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", "FTZCorpAdmin");	
			typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", "SELpassword!");
			
		
		}else if (userRole.equals("FTZ_USER")) {
			typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", "FTZSeleniumUser");	
			typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", "SELpassword!");
		
		}else if (userRole.equals("FTZ_NormalUser")) {
			typeText(driver, test, OCR_LoginPage_UserName, "Enter user name : ", "UserFTZ");	
			typeText(driver, test, OCR_LoginPage_Password, "Enter Password : ", "SELpassword!");
		}
		clickElement(driver, test, OCR_LoginPage_Login, "Clicking on Login");
	}	
		

}
