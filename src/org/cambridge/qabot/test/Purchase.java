package org.cambridge.qabot.test;

import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

import org.cambridge.qabot.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Purchase extends TestCore {
	private int cartCount = 0;
	
	public Purchase(String url, DefaultListModel<String> countries) {
		this.url = url;
		this.countries = countries;
	}
	
	public int start() throws NoSuchElementException {
		System.out.println("Start e-commerce test");
		
		if (Config.Log()) {
			System.out.println("Initialising e-commerce test for the following coutnries:");
			for (int c = 0; c < countries.toArray().length; c++) {
				System.out.println(countries.getElementAt(c).toString());
			}
		}
		
		for (int c = 0; c < countries.toArray().length; c++) {
			cartCount = 0;
			driver.manage().deleteAllCookies();
			String site = server.testServers().get(url) + "/catalog/dictionaries";
			
			if (Config.Log())
				System.out.println("Starting at " + site);
			
			driver.get(site);
			changeCountry(countries, c);
			// Try to add a cart, if no add to cart link is found, skip to the next country and log the error
			try {
				clickByLinkText("Add to cart");
				cartCount++;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (!getTextById("cartQty").contentEquals("(" + cartCount + ")")) {
					System.out.println("Cart count is not updated! Expecting that cart count is " + cartCount + " but result was " + getTextById("cartQty"));
					errors++;
				}
			} catch (NoSuchElementException e) {
				System.out.println("No Add to cart link found for " + countries.getElementAt(c) + "! Perhaps its ecom toggle is switched off?");
				errors++;
				cartCount = 0;
				continue;
			}
			
			clickByCSSElement("div#itemAddedModal a.viewCart");
			// TODO: Add a script to check if shipping country tab in ecom page matches the chosen locale
			clickByLinkText("Proceed to Checkout");
			driver.findElement(By.id("user.login.username")).sendKeys("cboac@cambridge.org");
			driver.findElement(By.id("user.login.password")).sendKeys("Develop100");
			driver.findElement(By.name("signing-submit")).click();
		
			clickByLinkText("Create address");
			if (!driver.findElements(By.id("buildingIdentifier")).isEmpty()) {
				typeToId("buildingIdentifier", "N7");
				typeToId("postCode", "some zip");
				clickById("lookup_bt_a");
			} else if (!driver.findElements(By.id("surname")).isEmpty()) {
				typeToId("surname", "Sample Tester");
				typeToId("street", "Sample Street");
				typeToId("town", "town");
				typeToId("postalCode", "1453");
				// clickByLinkText("Ship to this address");
			} else {
				typeToId("street", "Sample Street");
				typeToId("town", "Sample Town");
				typeToId("postCode", "8BC 2BS");
			}
		}
		return errors;
	}
}
