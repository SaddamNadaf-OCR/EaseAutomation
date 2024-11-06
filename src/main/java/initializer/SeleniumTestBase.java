/* 
 * Project : EASE
 * Author  : Maheswara
 * Created date : Aug 2018
 * Descriptions : Test Base class
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import utilities.excel_reader;
import vmsClasses.LoginPage;

public class SeleniumTestBase {
	public WebDriver driver;
	public ExtentTest test;
	public static excel_reader excel = null;
	public static String extentReportsPath = System.getProperty("user.dir") + "\\Results";
	public static String screenshotname;
	public static Properties prop;
	public static Properties propVMs;
	public static Properties propLP;
	public static Properties propGTC;
	public static Properties propCRs;
	public static Properties propEO;
	public static Properties propProd;
	public static Properties propLpUk;
	public static Properties propDMS;
	public static Properties propIO;
	public static Properties propNRC;
	public static String proppath = System.getProperty("user.dir") + "\\config\\Credentials.properties";
	public static String CRsproppath = System.getProperty("user.dir") + "\\config\\CRs.properties";
	public static String GTCproppath = System.getProperty("user.dir") + "\\config\\GTC.properties";
	public static String vmsproppath = System.getProperty("user.dir") + "\\config\\Vms.properties";
	public static String EOproppath = System.getProperty("user.dir") + "\\config\\ExportOperations.properties";
	public static String LpApplicationproppath = System.getProperty("user.dir") + "\\config\\LPApplication.properties";
	public static String LpUkproppath = System.getProperty("user.dir") + "\\config\\LPUKApplication.properties";
	public static String Pdproppath = System.getProperty("user.dir") + "\\config\\Product.properties";
	public static String DMSproppath = System.getProperty("user.dir") + "\\config\\DMS.properties";
	public static String IOproppath = System.getProperty("user.dir") + "\\config\\ImportOperation.properties";
	public static String NRCproppath = System.getProperty("user.dir") + "\\config\\NRC.properties";
	public static final ExtentReports extent = new ExtentReports(
			extentReportsPath + "\\EASE_Execution_Report_" + Utility.getTimeStamp() + ".html", false);

	@BeforeSuite
	// ************* Report move to archive folder *****************
	public void report() {
		Utility.archiveExtentReports(System.getProperty("user.dir") + "\\Results");
	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters({ "browser", "url", "ExcelDataWB" })
	public void startSelenium(String browser, String url, String ExcelDataWB) throws IOException {

		// *************** Properties file configuration ******************************

		// Credentials Properties file Reading
		prop = new Properties();
		prop.load(new FileInputStream(proppath));
		PropertyConfigurator.configure(proppath);

		// vms Properties file Reading
		propVMs = new Properties();
		propVMs.load(new FileInputStream(vmsproppath));
		PropertyConfigurator.configure(vmsproppath);

		// LP applications Properties file Reading
		propLP = new Properties();
		propLP.load(new FileInputStream(LpApplicationproppath));
		PropertyConfigurator.configure(LpApplicationproppath);

		// GTC applications Properties file Reading
		propGTC = new Properties();
		propGTC.load(new FileInputStream(GTCproppath));
		PropertyConfigurator.configure(GTCproppath);

		// CRs applications Properties file Reading
		propCRs = new Properties();
		propCRs.load(new FileInputStream(CRsproppath));
		PropertyConfigurator.configure(CRsproppath);

		// CRs applications Properties file Reading
		propEO = new Properties();
		propEO.load(new FileInputStream(EOproppath));
		PropertyConfigurator.configure(EOproppath);

		// Product applications Properties file Reading
		propProd = new Properties();
		propProd.load(new FileInputStream(Pdproppath));
		PropertyConfigurator.configure(Pdproppath);

		// CRs applications Properties file Reading
		propEO = new Properties();
		propEO.load(new FileInputStream(EOproppath));
		PropertyConfigurator.configure(EOproppath);

		// LP UK applications Properties file Reading
		propLpUk = new Properties();
		propLpUk.load(new FileInputStream(LpUkproppath));
		PropertyConfigurator.configure(LpUkproppath);

		// Import Operation applications Properties file Reading
		propIO = new Properties();
		propIO.load(new FileInputStream(IOproppath));
		PropertyConfigurator.configure(IOproppath);

		// DMS applications Properties file Reading
		propDMS = new Properties();
		propDMS.load(new FileInputStream(DMSproppath));
		PropertyConfigurator.configure(DMSproppath);

		// NRC applications Properties file Reading
		propNRC = new Properties();
		propNRC.load(new FileInputStream(NRCproppath));
		PropertyConfigurator.configure(NRCproppath);

		// ***************** Extent Report generation *********************************

		extent.addSystemInfo("Host Name", "EASE").addSystemInfo("Environment", "QA").addSystemInfo("User Name", "EASE");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		test = extent.startTest("Launch the Browser and Login to EASE");

		// ******************** Browser launching/URL/Login ****************

		System.out.println(browser);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			// caps.setCapability("nativeEvents",false);
			caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver(caps);
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			// caps.setCapability("nativeEvents",false);
			caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setJavascriptEnabled(true);
			driver = new EdgeDriver();
		}

		else {
			throw new RuntimeException("No driver available for browser: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		test.log(LogStatus.PASS, "Loading the URL : " + url + "   ,Browser : " + browser);

		String uname = prop.getProperty("Username");
		String password = prop.getProperty("Password");

		LoginPage login = new LoginPage(driver, test);
		try {
			login.login(uname, password);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to login ");
			testFail();
			e.printStackTrace();
		}

		// ******************* Reading Excel data sheet path **************************

		String testDataPath = System.getProperty("user.dir") + "\\testdata\\";
		excel = new excel_reader(testDataPath + ExcelDataWB);
	}

	@BeforeMethod
	public void astarttest(Method method) {
		test = extent.startTest((this.getClass().getSimpleName() + " :- " + method.getName()), method.getName());
	}

	@AfterMethod
	public void zendtest() {
		extent.endTest(test);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@AfterSuite
	public void StopSelenium() {
		extent.flush();
	}

	// To take Screenshot and attached to the Extent Report after test fail.
	public void testFail() {
		try {
			Wait.capture(driver, getClass().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, "Failed to run : " + getClass().getSimpleName() + " "
				+ test.addScreenCapture(System.getProperty("user.dir") + "\\Screenshots\\" + Wait.screenshotname));
	}

}
