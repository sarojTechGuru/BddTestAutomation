package com.UI.BasePo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.UI.Utilities.DateTimeUtils;
import com.UI.Utilities.JsonReader;

public abstract class BaseTest {

	public static WebDriver driver;

	protected void clickElement(By locator) {
		driver.findElement(locator).click();
	}

	protected void enterTextValue(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static File takeScreenshots(String testname) {
		String path = null;
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			path = System.getProperty("user.dir") + "\\TestOutput\\" + testname + "_" + DateTimeUtils.timeStamp()
					+ "_screenshots.png";

			File destFile = new File(path);
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("unable to take screenshot" + e.getMessage());
		}
		return srcFile;
	}

	protected String getTextMessages(By element) {
		return driver.findElement(element).getText();
	}

	protected void waitForlocator(WebElement locator) {
		long time = JsonReader.getIntValue("ExplicitTimeout");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	protected List<String> getAllText(By locator) {
		List<WebElement> locators = driver.findElements(locator);
		List<String> actualLabels = new ArrayList<String>();
		for (WebElement element : locators) {
			actualLabels.add(element.getText());
		}
		return actualLabels;
	}

	protected boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	protected boolean isElementEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}	
}
