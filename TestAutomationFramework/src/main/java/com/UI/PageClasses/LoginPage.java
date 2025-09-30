package com.UI.PageClasses;

import org.openqa.selenium.By;

import com.UI.BasePo.BaseTest;

public class LoginPage extends BaseTest {

	By userName = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	By headerLabel = By.xpath("//div[@id='menu_button_container']/following-sibling::div/div");

	public void enterUsername(String username) {
		enterTextValue(userName, username);
	}

	public void enterPassword(String pwd) {
		enterTextValue(password, pwd);
	}

	public void clickLoginButton() {
		clickElement(loginButton);
	}

	public String getHeaderLabel() {
		return getTextMessages(headerLabel);

	}

}
