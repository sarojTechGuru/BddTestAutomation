package com.UI.TestStepDefinitions;

import java.util.List;
import org.junit.Assert;
import com.UI.PageClasses.HomePage;
import com.UI.PageClasses.LoginPage;
import com.UI.Utilities.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();

	@Given("User navigate to the login page")
	public void User_navigate_to_the_login_page() {
		Assert.assertEquals("Swag Labs", loginPage.getHeaderLabel());
	}

	@When("User submit username {string}")
	public void User_submit_username(String username) {
		loginPage.enterUsername(JsonReader.getNestedValue("testUsers", "username"));
	}

	@When("User submit password {string}")
	public void User_submit_password(String password) {
		loginPage.enterPassword(JsonReader.getNestedValue("testUsers", "password"));
		loginPage.clickLoginButton();
	}

	@Then("User has landed on homepage")
	public void user_has_landed_on_homepage() {
		Assert.assertEquals("Swag Labs", homePage.getHeaderLabel());
	}

	@When("user checks the secondary header label")
	public void user_checks_the_secondary_header_label() {
		Assert.assertEquals("Products", homePage.getSecondaryHeader());
	}

	@Then("validate all the items labels")
	public void validate_all_the_items_labels() {
		List<String> actualLabels = homePage.validateAllItemLabels();
		Assert.assertTrue(actualLabels.contains("Sauce Labs Backpack"));
		Assert.assertTrue(actualLabels.contains("Sauce Labs Bike Light"));
		Assert.assertTrue(actualLabels.contains("Sauce Labs Bolt T-Shirt"));
		Assert.assertTrue(actualLabels.contains("Sauce Labs Fleece Jacket"));
		Assert.assertTrue(actualLabels.contains("Sauce Labs Onesie"));
		Assert.assertTrue(actualLabels.contains("Test.allTheThings() T-Shirt (Red)"));
	}
}
