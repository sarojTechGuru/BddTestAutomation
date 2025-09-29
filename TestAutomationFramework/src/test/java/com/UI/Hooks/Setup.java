package com.UI.Hooks;

import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.UI.BasePo.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

	@Before
	public void init() {
		WebDriverManager.chromedriver().setup();
		BaseTest.driver = new ChromeDriver();
		BaseTest.driver.manage().window().maximize();
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		BaseTest.driver.get("https://www.saucedemo.com/");
	}

	@After
	public void tearDown() {
		Scenario scenario = null;
		if (scenario.getStatus().FAILED != null) {
			BaseTest.takeScreenshots();
			BaseTest.driver.quit();
		}
	}

}
