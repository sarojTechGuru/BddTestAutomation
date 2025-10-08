package com.UI.TestStepDefinitions;

import com.UI.PageClasses.HomePage;
import com.UI.PageClasses.LoginPage;
import com.UI.Utilities.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

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

	@Then("Validate that user landed on homepage")
	public void validate_that_user_landed_on_homepage() {
		Assert.assertEquals("Swag Labs", homePage.getHeaderLabel());
	}

	@Given("User has landed on login page")
	public void user_has_landed_on_login_page() {
		Assert.assertEquals("Swag Labs", loginPage.getHeaderLabel());
	}

	@When("User waits for login button to display")
	public void user_waits_for_login_button_to_display() {
		Assert.assertTrue(loginPage.isLoginButtonPresent());
	}

	@Then("Validate the user name and password field is present")
	public void validate_the_user_name_and_password_field_is_present() {
		Assert.assertTrue(loginPage.isUserNameFieldPresent());
		Assert.assertTrue(loginPage.isPasswordFieldPresent());
	}

	@Then("Login button is enabled")
	public void login_button_is_enabled() {
		Assert.assertTrue(loginPage.isButtonEnabled());
	}
	
	@Then ("validate the subheaders")
	public void validate_the_subheaders() {
		Assert.assertEquals("Accepted usernames are:", loginPage.getSubHeaderLabels("Accepted usernames are:"));
	}
	

}
