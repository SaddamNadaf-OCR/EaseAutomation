/*-----------------------Page added by Nancy --------------------------*/
package vmsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class QuestionnairrePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/
	
	public static final String OCR_NoExportControlAuthorityInvolved="//input[@id='noExportControl']";
	public static final String OCR_QuestionsUnknownResponseList="//input[@id='__checkbox_noExportControl']/following::div[@class='col-xs-3']/input[@value='Y']";
	public static final String OCR_Button_Save="(//button[@name='save'])[1]";
	public static final String OCR_Button_ForwardNavigation="//button[contains(text(),'Save')]/preceding::button[1]";
	
	/*--------------------------------Constructor------------------------------------------*/
	public QuestionnairrePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/
	
	//Adding Questions
    public void add_questions(String Questionnairre) {
		if(Questionnairre.length()>0) {
			List<WebElement> questionaireresponse=driver.findElements(By.xpath(OCR_QuestionsUnknownResponseList));
			clickElement(driver, test, "//input[@id='editVmctQuestions_visitorAdditionalInfoValue_presLocationNaY']","");
			for(int i=0; i<questionaireresponse.size(); i++) {
				WebElement radiobuttons=questionaireresponse.get(i);
				radiobuttons.click();	
			}
		}else {
			clickElement(driver, test, OCR_NoExportControlAuthorityInvolved,"Check No Export Control Authority Involved");
		}		
		Wait.waitfor(3);
		clickElement(driver, test, "//span[contains(text(), 'Request ID : ')]", "Que Heading");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button");
		Wait.waitfor(5);
		
	}
    
    public void movetonextpage() {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
		Wait.waitfor(3);
    }
    
    //click on Save Button
    public void click_saveBtn() {
    	clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button");
    	Wait.waitfor(3);
    }
    
    //validating Questions
    public void validate_Questions() {
    	try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {							
				if (isDisplayed(driver,"//span[text()='Question 1 is required. ']")) {
					test.log(LogStatus.INFO, "Question 1 is required. ");
				}
				/*	if (isDisplayed(driver,"//span[text()='Question 2 is required. ']")) {
					test.log(LogStatus.INFO, "Question 2 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 3 is required. ']")) {
					test.log(LogStatus.INFO, "Question 3 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 4 is required. ']")) {
					test.log(LogStatus.INFO, "Question 4 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 5 is required. ']")) {
					test.log(LogStatus.INFO, "Question 5 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 6 is required. ']")) {
					test.log(LogStatus.INFO, "Question 6 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 7 is required. ']")) {
					test.log(LogStatus.INFO, "Question 7 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 8 is required. ']")) {
					test.log(LogStatus.INFO, "Question 8 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 9 is required. ']")) {
					test.log(LogStatus.INFO, "Question 9 is required. ");
				}
				if (isDisplayed(driver,"//span[text()='Question 10 is required. ']")) {
					test.log(LogStatus.INFO, "Question 10 is required. ");
				}		*/		
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error Vaildation for Questions is not Displayed by clicking on SAVE button");
			testFailSshot(driver, test);
		}		
    }
    
    //click No Export Control Authority Involved checkbox
    public void noexportcontrolauthorityreq() {
    	clickElement(driver, test, OCR_NoExportControlAuthorityInvolved,"Checking NoExportControlAuthorityInvolved CheckBox");
    }
}
