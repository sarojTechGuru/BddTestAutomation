package com.UI.PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.UI.BasePo.BaseTest;

public class HomePage extends BaseTest {

	By itemLabels = By.xpath("//div[@class='inventory_item_name ']");
	By secondaryHeader = By.xpath("//div[@class='header_secondary_container']/span");
	By headerLabel = By.xpath("//div[@id='menu_button_container']/following-sibling::div/div");

	public String getSecondaryHeader() {
		return getTextMessages(secondaryHeader);
	}

	public List<String> validateAllItemLabels() {
		return getAllText(itemLabels);
	}

	public String getHeaderLabel() {
		return getTextMessages(headerLabel);
	}
}
