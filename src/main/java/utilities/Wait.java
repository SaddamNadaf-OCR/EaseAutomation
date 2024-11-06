/* 
 * Project : EASE
 * Author  : Maheswara
 * Created date : SEP 2018
 * Descriptions : Test Base class
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
//import com.google.common.base.Function;
import org.openqa.selenium.StaleElementReferenceException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {

	public static String screenshotname;

	// Fluent wait with loading page method
	@SuppressWarnings({"deprecation", "unused" })
	public static void wait(final WebDriver driver, final String locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(WebDriverException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				List <WebElement> element = driver.findElements(By.xpath(locator));
				// String getTextOnPage = element.getText();
				if (element.size() > 0) {
					try {
						loading(driver);
				//		loadingrid(driver);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					return driver.findElement(By.xpath(locator));
				} else {
					// System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
	}

	// Fluent wait With Out Loading page method
	@SuppressWarnings({ "deprecation", "unused" })
	public static void fluwait(final WebDriver driver, final String locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(WebDriverException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				List <WebElement> element = driver.findElements(By.xpath(locator));
				// String getTextOnPage = element.getText();
				if (element.size() > 0) {
					return driver.findElement(By.xpath(locator));
				} else {
					// System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
	}

	// Screenshot method
	public static void capture(WebDriver driver, String classname) throws IOException {
		screenshotname = classname;
		screenshotname = screenshotname.substring(screenshotname.lastIndexOf('.') + 1);
		screenshotname = screenshotname + 
				new SimpleDateFormat("@dd_MM_yyyy_HH_mm_ss").format(new Date()) + ".png";

		String path = System.getProperty("user.dir") +"\\Screenshots\\" + screenshotname;
		//System.out.println(path);		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(path);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	// Page Loading method
	public static void loading(WebDriver driver) throws InterruptedException {
		String loc = "//label[contains(text(),'Loading Content')]";
		while(driver.findElement(By.xpath(loc)).isDisplayed()) {
				Thread.sleep(2000);							
			}		
	}
	
	//Grid load Pop up load_gridPopup
	public static void loadingrid(WebDriver driver) throws InterruptedException {
		String loc = "//div[@id='load_gridPopup']";
		while(driver.findElement(By.xpath(loc)).isDisplayed()) {
				Thread.sleep(2000);							
			}		
	}

	// Element to wait upto given time seconds method.
	public static void waitfor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
