package com.UI.Hooks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.compress.archivers.StreamingNotSupportedException;
import org.apache.commons.io.FileUtils;
import com.UI.BasePo.BaseTest;
import com.UI.Utilities.DateTimeUtils;
import com.UI.Utilities.JsonReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;

public class Setup {

	@Before
	public void init() throws StreamingNotSupportedException {
		String browser = JsonReader.getTtextValue("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			BaseTest.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			BaseTest.driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			BaseTest.driver = new EdgeDriver();
			break;
		default:
			throw new StreamingNotSupportedException(
					browser + "is not supported or check test data file and pass correct browser name");
		}

		BaseTest.driver.manage().window().maximize();
		BaseTest.driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(JsonReader.getIntValue("implicitTimeout")));
		BaseTest.driver.get(JsonReader.getNestedValue("urls", "baseUrl"));
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			File path = BaseTest.takeScreenshots(scenario.getName());
			try {
				Allure.addAttachment(scenario.getName() + "_" + DateTimeUtils.timeStamp(),
						FileUtils.openInputStream(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BaseTest.driver.quit();
	}

}
