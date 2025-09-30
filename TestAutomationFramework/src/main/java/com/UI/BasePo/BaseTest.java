package com.UI.BasePo;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.w3c.dom.UserDataHandler;

import com.UI.Utilities.DateTimeUtils;

public abstract class BaseTest {

	public static WebDriver driver;

	protected void clickElement(By element) {
		driver.findElement(element).click();
	}

	protected void enterTextValue(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}

	public static File takeScreenshots(String testname) {
		String path = null;
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			path = System.getProperty("user.dir") + "\\TestOutput\\" + testname + "_"+DateTimeUtils.timeStamp()
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

}
