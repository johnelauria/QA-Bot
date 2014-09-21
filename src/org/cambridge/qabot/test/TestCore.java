package org.cambridge.qabot.test;

import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

import org.cambridge.qabot.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestCore {
	protected static WebDriver driver = new FirefoxDriver();
	protected Config server = new Config();
	protected String url;
	protected DefaultListModel<String> countries;
	protected int errors = 0;

	/**
	 * Changes the current locale by clicking the nav bar's country selector
	 * @param DefaultListModel countries
	 * @param int position
	 */
	protected void changeCountry(DefaultListModel<String> countries, int position) {
		clickByCSSElement("ul li.navLocation a");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement txtBox = driver.findElement(By.id("localeText"));
		txtBox.sendKeys(countries.getElementAt(position));
		clickByClass("autocomplete-suggestion");
		clickById("saveLocaleButton");
	}
	
	/**
	 * Click a specific link / button by CSS Selector
	 * @param String CSSelement
	 */
	protected static void clickByCSSElement(String CSSelement) {
		driver.findElement(By.cssSelector(CSSelement)).click();
	}
	
	/**
	 * Click a specific link / button by class name
	 * @param String className
	 */
	protected static void clickByClass(String className) {
		driver.findElement(By.className(className)).click();
	}
	
	/**
	 * Click a specific link / button by ID
	 * @param String id
	 */
	protected static void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	/**
	 * Click a specific link / button by Link's text
	 * @param String text
	 */
	protected static void clickByLinkText(String text) {
		driver.findElement(By.linkText(text)).click();
	}
	
	protected static void typeToId(String id,String value) {
		driver.findElement(By.id(id)).sendKeys(value);
	}
	
	protected static void typeToName(String name,String value) {
		driver.findElement(By.name(name)).sendKeys(value);
	}
	
	/**
	 * Searches for the element's id and returns the text within it
	 * @param String id
	 * @return String
	 */
	protected String getTextById(String id) {
		return driver.findElement(By.id(id)).getText();
	}
}
