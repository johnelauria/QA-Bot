package org.cambridge.qabot.config;

import javax.swing.DefaultComboBoxModel;

public class Data {
	private String startCountries[] = {"United States", "United Kingdom"};
	
	/**
	 * These are the countries that are automatically loaded to the main application after launched. Add more as needed
	 * @return DefaultListModel preSetCountries
	 */
	public String[] preSetCountries() {
		return this.startCountries;
	}
	
	/**
	 * Lists all countries that can be added for testing
	 * @return DefaultComboBoxModel countryList
	 */
	public static DefaultComboBoxModel<String> countryList() {
		DefaultComboBoxModel<String> countryList = new DefaultComboBoxModel<String>();
		countryList.addElement("United States");
		countryList.addElement("United Kingdom");
		countryList.addElement("Hungary");
		countryList.addElement("China");
		countryList.addElement("Lithuania");
		countryList.addElement("Latvia");
		countryList.addElement("Philippines");
		countryList.addElement("Singapore");
		return countryList;
	}

}
