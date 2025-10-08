package com.UI.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.UI.BasePo.BaseTest;

public class LoginPage extends BaseTest {

	By userName = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	By loginPageHeader = By.xpath("//div[@class='login_logo']");
	String loginSubHeaders = "//h4[text()='%s']";//in case of parameterized Xpath or locator use String here and by at method level

	public void enterUsername(String username) {
		enterTextValue(userName, username);
	}

	public void enterPassword(String pwd) {
		enterTextValue(password, pwd);
	}

	public boolean isLoginButtonPresent() {
		return isElementPresent(loginButton);
	}

	public void clickLoginButton() {
		clickElement(loginButton);
	}

	public String getHeaderLabel() {
		return getTextMessages(loginPageHeader);

	}

	public boolean isUserNameFieldPresent() {
		return isElementPresent(userName);
	}

	public boolean isPasswordFieldPresent() {
		return isElementPresent(password);
	}

	public boolean isButtonEnabled() {
		return isElementEnabled(loginButton);
	}

	public String getSubHeaderLabels(String dynamicHeaderLabel) {
		By element = By.xpath(String.format(loginSubHeaders, dynamicHeaderLabel));
		return getTextMessages(element);
	}

}