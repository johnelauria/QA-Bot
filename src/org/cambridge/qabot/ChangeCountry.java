package org.cambridge.qabot;

import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

import org.cambridge.qabot.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Initialise a test to change countries
 * @author johnmaenard
 *
 */
public class ChangeCountry {
	private String url;
	private DefaultListModel<String> countries;
	private int errors = 0;
	
	public ChangeCountry(String url, DefaultListModel<String> countries) {
		this.url = url;
		this.countries = countries;
	}

	public int start() {
		System.out.println("Start");
		
		if (Config.Log()) {
			System.out.println("Initialising Country Change test for the following countries:");
			for (int c = 0; c < countries.toArray().length; c++) {
				System.out.println(countries.getElementAt(c).toString());
			}
		}
		
		WebDriver driver = new FirefoxDriver();
		Config server = new Config();
		String site = server.testServers().get(url);
		if (Config.Log())
			System.out.println("Starting at " + site);
		
		driver.get(site);
		for (int c = 0; c < countries.toArray().length; c++) {
			System.out.println(c + " out of " + countries.toArray().length + " being tested");
			
			if (Config.Log()) {
				System.out.println("Currently in " + driver.getTitle() + " at " + driver.getCurrentUrl());
				if (!driver.getCurrentUrl().contains("cambridgeenglish")) {
					System.out.println(countries.getElementAt(c - 1) + " DID NOT REDIRECT TO THE C5 CAMBRIDGE ENGLISH SITE!");
					errors++;
					driver.get(site);
				}
			}
			driver.findElement(By.cssSelector("ul li.navLocation a")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement txtBox = driver.findElement(By.id("localeText"));
			txtBox.sendKeys(countries.getElementAt(c));
			driver.findElement(By.className("autocomplete-suggestion")).click();
			driver.findElement(By.id("saveLocaleButton")).click();
		}
		System.out.println("Completed");
		return errors;
	}
}
