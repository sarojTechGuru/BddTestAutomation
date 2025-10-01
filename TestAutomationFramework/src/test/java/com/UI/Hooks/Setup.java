package com.UI.Hooks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void init() {
		WebDriverManager.chromedriver().setup();
		BaseTest.driver = new ChromeDriver();
		BaseTest.driver.manage().window().maximize();
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(JsonReader.getIntValue("implicitTimeout")));
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
