package com.UI.BasePo;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public abstract class BaseTest {

	public static WebDriver driver;

	protected void clickElement(By element) {
		driver.findElement(element).click();
	}

	protected void enterTextValue(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}
	
	public static void takeScreenshots() {
		try {
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
			File destFile=new File("src/TestAutomationFramework/TestOutput");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("unable to take screenshot"+ e.getMessage());
		}
		
		
	}

}
