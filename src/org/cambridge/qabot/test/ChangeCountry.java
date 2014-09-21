package org.cambridge.qabot.test;

import javax.swing.DefaultListModel;

import org.cambridge.qabot.config.Config;

/**
 * Initialise a test to change countries
 * @author johnmaenard
 *
 */
public class ChangeCountry extends TestCore {
	private int errors = 0;
	
	public ChangeCountry(String url, DefaultListModel<String> countries) {
		this.url = url;
		this.countries = countries;
	}

	public int start() {
		System.out.println("Start Country Change Test");
		
		if (Config.Log()) {
			System.out.println("Initialising Country Change test for the following countries:");
			for (int c = 0; c < countries.toArray().length; c++) {
				System.out.println(countries.getElementAt(c).toString());
			}
		}
		
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
			changeCountry(countries, c);
		}
		System.out.println("Completed");
		return errors;
	}
}
