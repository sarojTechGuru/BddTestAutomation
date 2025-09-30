package com.UI.TestStepDefinitions;

import com.UI.PageClasses.LoginPage;
import com.UI.Utilities.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginTest {
	LoginPage loginPage = new LoginPage();

	@Given("User has entered {string}")
	public void user_has_entered(String username) {
		loginPage.enterUsername(JsonReader.getNestedValue("testUsers", "username"));
	}

	@Given("user entered {string}")
	public void user_entered(String password) {
		loginPage.enterPassword(JsonReader.getNestedValue("testUsers", "password"));
	}

	@When("User clicked on login button")
	public void user_clicked_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("Validate that user laned on homepage")
	public void validate_that_user_laned_on_homepage() {
		Assert.assertEquals("Swag", loginPage.getHeaderLabel());
	}

}
