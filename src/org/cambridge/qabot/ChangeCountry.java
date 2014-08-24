package org.cambridge.qabot;

import static org.cambridge.qabot.Main.addLog;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;

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
public class ChangeCountry extends SwingWorker<Integer, String> {
	private String url;
	private DefaultListModel<String> countries;
	
	public ChangeCountry(String url, DefaultListModel<String> countries) {
		this.url = url;
		this.countries = countries;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		publish("Start");
		setProgress(1);
		
		if (Config.Log()) {
			publish("Initialising Country Change test for the following countries:");
			for (int c = 0; c < countries.toArray().length; c++) {
				publish(countries.getElementAt(c).toString());
			}
		}
		
		WebDriver driver = new FirefoxDriver();
		Config server = new Config();
		String site = server.testServers().get(url);
		if (Config.Log())
			publish("Starting at " + site);
		
		driver.get(site);
		for (int c = 0; c < countries.toArray().length; c++) {
			publish(c + " out of " + countries.toArray().length + " being tested");
			setProgress((int) ((c / countries.toArray().length) * 100));
			
			if (Config.Log()) {
				addLog("Currently in " + driver.getTitle() + " at " + driver.getCurrentUrl());
				if (!driver.getCurrentUrl().contains("cambridgeenglish")) {
					addLog(countries.getElementAt(c) + " DID NOT REDIRECT TO THE C5 CAMBRIDGE ENGLISH SITE!");
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
		publish("Completed");
		setProgress(100);
		return 1;
	}
	
	@Override
	protected void process(final List<String> chunks) {
		// Updates the messages text area
		for (final String string : chunks) {
			addLog(string);
		}
	}
}
