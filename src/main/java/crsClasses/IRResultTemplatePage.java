package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class IRResultTemplatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//.........................................Locators................................................//
	public static final String IR_Template_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String IR_Template_ResultGrid = "//div[@id='gbox_grid']";
	public static final String IR_Template_ResultPage = "//h3[@class='page-heading']";
	
	//...........................................Constructor....................................................//
	public IRResultTemplatePage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	//...................................Click on Search Button.......................................//
	public void copyIcon() {
		clickElement(driver, test, IR_Template_CopyIcon, "Clicking on Copy Icon :");
		Wait.waitfor(6);
		String alertmsg = "Proceed to Copy without Invalid data";
		//String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Alert Msg :");
		try {
			if(alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Clicking on Proceed Without Invalid Data Button :");
				}
			else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		}catch(Exception e) {
				test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
			}
	}
	
	//................................Result Page Method............................................//
	public void TitleisDisplayed() {
		try {
            if(isDisplayed(driver, IR_Template_ResultPage)) {
                test.log(LogStatus.PASS, "Title is Displayed : Import Request Template Search Page :");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : Import Request Template Search Page :");
        }
	}
	
	//................................Result Page Method............................................//
	public void GridisDisplayed() {
		try {
	           if(isDisplayed(driver, IR_Template_ResultGrid)) {
	               test.log(LogStatus.PASS, "Grid is Displayed : Import Request Template Search Page :");
	           }
	       } catch (Exception e) {
	           testFailSshot(driver, test);
	           test.log(LogStatus.FAIL, "Grid is not Displayed : Import Request Template Search Page :");
	       }
	}
}