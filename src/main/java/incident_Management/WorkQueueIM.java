package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class WorkQueueIM extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String IM_myQueueBtn="//select[@name='myQueue']";
	public static final String IM_myQueueGoBtn="//button[contains(text(),'Go')][1]";
	
	public static final String IM_InvQueueBtn="//select[@name='invQueue']";
    public static final String IM_InvQueueGoBtn="(//button[contains(text(),'Go')])[8]";
    public static final String Sinvest_ClosePopup="//button[@class='btn-close']";
    
    public static final String IM_CaaQueueBtn="//select[@name='caAssignedQueue']";
    public static final String IM_CaaQueueGoBtn="(//button[contains(text(),'Go')])[6]";
    
    public static final String Result_WorkQueue = "//h3[@class='page-heading']";

	
	
	
	
	
	
	/* ******************************* Constructor ****************************** */
	public WorkQueueIM(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************************* Action ****************************** */
	
	//..........................Title of the page is Displayed or not................................//
			public void titleIsDisplayed() {
				try {
					if(isDisplayed(driver, Result_WorkQueue)) {
						test.log(LogStatus.PASS, "Title is Displayed");
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Title is not Displayed");
				}
			}
	
	//My Queue	
			public void myQueue(String myQueuedata, String investigationsQueue,String correctiveActionQueue) {
				
				//Investigations Queue
				if (investigationsQueue.length() > 0) {
					
					clickElement(driver, test, IM_InvQueueBtn, "Clicking On my Queue Button");
					Wait.waitfor(2);
					selectByVisibleText(driver, test, IM_InvQueueBtn,"Select the investigations Queue dropdown :", myQueuedata);
					clickElement(driver, test, IM_InvQueueGoBtn, "Clicking On investigations Queue Go Button");
                    Wait.waitfor(3);
                    clickElement(driver, test, Sinvest_ClosePopup, "Clicking On investigations Edit PopUp Button");
                    
//				}else if (exportPOCQueue.length() > 0) {
//                    clickElement(driver, test, IM_exportPOCBtn, "Clicking On my Queue Button");
//					Wait.waitfor(2);
//					selectByVisibleText(driver, test, IM_exportPOCBtn,"Select the investigations Queue dropdown :", myQueuedata);
//					clickElement(driver, test, IM_exportPOCGoBtn, "Clicking On investigations Queue Go Button");
//                    Wait.waitfor(3);
                    
                    
//					
//				}else if (complianceAuditPOCQueue.length() > 0) {
//				 clickElement(driver, test, IM_complianceAuditPOCBtn, "Clicking On my Queue Button");
//					Wait.waitfor(2);
//					selectByVisibleText(driver, test, IM_complianceAuditPOCBtn,"Select the investigations Queue dropdown :", myQueuedata);
//					clickElement(driver, test, IM_complianceAuditPOCGoBtn, "Clicking On investigations Queue Go Button");
//                    Wait.waitfor(3);
                    
                    
                    
                    
//				}
//				else if (legalLawDepartmentPOCQueue.length() > 0) {
                    
//                    clickElement(driver, test, IM_legalLawDepartmentPOCBtn, "Clicking On my Queue Button");
//					Wait.waitfor(2);
//					selectByVisibleText(driver, test, IM_legalLawDepartmentPOCBtn,"Select the investigations Queue dropdown :", myQueuedata);
//					clickElement(driver, test, IM_legalLawDepartmentPOCGoBtn, "Clicking On investigations Queue Go Button");
//                    Wait.waitfor(3);
                    
                    
//					
//				}else if (externalAuditorQueue.length() > 0) {
//					 clickElement(driver, test, IM_externalAuditorQueueBtn, "Clicking On my Queue Button");
//					Wait.waitfor(2);
//					selectByVisibleText(driver, test, IM_externalAuditorQueueBtn,"Select the investigations Queue dropdown :", myQueuedata);
//					clickElement(driver, test, IM_externalAuditorQueueGoBtn, "Clicking On investigations Queue Go Button");
//                    Wait.waitfor(3);
                    
				}else if (correctiveActionQueue.length() > 0) 
				{
					clickElement(driver, test, IM_CaaQueueBtn, "Clicking On my Queue Button");
					Wait.waitfor(2);
					selectByVisibleText(driver, test,  IM_CaaQueueBtn,"Select the Corrective Action Queue dropdown :", myQueuedata);
					clickElement(driver, test, IM_CaaQueueGoBtn, "Clicking On Corrective Action Queue Go Button");
                    Wait.waitfor(3);
					
				}
				
				
				else {
				
				
				//	My Queue			
				clickElement(driver, test, IM_myQueueBtn, "Clicking On my Queue Button");
			    clickElement(driver, test, "//option[contains(text(),'" + myQueuedata + "')]","My Queue Data selected  :" + myQueuedata);
				Wait.waitfor(3);
				clickElement(driver, test, IM_myQueueGoBtn, "Clicking On my Queue Go Button");
				
				Wait.waitfor(3);
				}
		//	  	selectByVisibleText(driver, test, IM_myQueuedata,"Select the document type from dropdown :", myQueuedata);
				
				
			}
			
			//Export POC Queue	
			public void exportPOCQueue() {
				
			}
			
			//Compliance Audit POC Queue
			public void complianceAuditPOCQueue() {
				
			}
			
			//Legal/Law Department POC Queue	
			public void legalLawDepartmentPOCQueue() {
				
			}
			
		
			
			//External Auditor Queue
			public void externalAuditorQueue() {
				
			}
			
			//Corrective Action Queue
			public void correctiveActionQueue() {
				
			}
			
			//Investigations Queue
			public void investigationsQueue() {
				
			}
	
			
		
	
}
