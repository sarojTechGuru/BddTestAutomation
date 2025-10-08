package com.UI.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "com.UI.TestStepDefinitions",
		"com.UI.Hooks" }, tags="@Login",plugin = { "pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class TestRunner {

}
