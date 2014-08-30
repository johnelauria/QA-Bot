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
	    countryList.addElement("Afghanistan");
	    countryList.addElement("Albania");
	    countryList.addElement("Algeria");
	    countryList.addElement("Andorra");
	    countryList.addElement("Angola");
	    countryList.addElement("Antigua and Barbuda");
	    countryList.addElement("Argentina");
	    countryList.addElement("Armenia");
	    countryList.addElement("Aruba");
	    countryList.addElement("Australia");
	    countryList.addElement("Austria");
	    countryList.addElement("Azerbaijan"); 

	    countryList.addElement("Bahamas");
	    countryList.addElement("Bahrain");
	    countryList.addElement("Bangladesh");
	    countryList.addElement("Barbados");
	    countryList.addElement("Belarus");
	    countryList.addElement("Belgium");
	    countryList.addElement("Belize");
	    countryList.addElement("Benin");
	    countryList.addElement("Bhutan");
	    countryList.addElement("Bolivia");
	    countryList.addElement("Bosnia and Herzegovina");
	    countryList.addElement("Botswana");
	    countryList.addElement("Brazil");
	    countryList.addElement("Brunei");
	    countryList.addElement("Bulgaria");
	    countryList.addElement("Burkina Faso");
	    countryList.addElement("Burma");
	    countryList.addElement("Burundi");

	    countryList.addElement("Cambodia");
	    countryList.addElement("Cameroon");
	    countryList.addElement("Canada");
	    countryList.addElement("Cape Verde");
	    countryList.addElement("Central African Republic");
	    countryList.addElement("Chad");
	    countryList.addElement("Chile");
	    countryList.addElement("China");
	    countryList.addElement("Colombia");
	    countryList.addElement("Comoros");
	    countryList.addElement("Congo");
	    countryList.addElement("Costa Rica");
	    countryList.addElement("Cote d'Ivoire");
	    countryList.addElement("Croatia");
	    countryList.addElement("Cuba");
	    countryList.addElement("Curacao");
	    countryList.addElement("Cyprus");
	    countryList.addElement("Czech Republic");

	    countryList.addElement("Denmark");
	    countryList.addElement("Djibouti");
	    countryList.addElement("Dominica");
	    countryList.addElement("Dominican Republic");

	    countryList.addElement("Ecuador");
		countryList.addElement("Egypt");
		countryList.addElement("El Salvador");
		countryList.addElement("Equatorial Guinea");
		countryList.addElement("Eritrea");
		countryList.addElement("Estonia");
		countryList.addElement("Ethiopia");

    	countryList.addElement("Fiji");
    	countryList.addElement("Finland");
    	countryList.addElement("France");

	    countryList.addElement("Gabon");
	    countryList.addElement("Gambia");
	    countryList.addElement("Georgia");
	    countryList.addElement("Germany");
	    countryList.addElement("Ghana");
	    countryList.addElement("Greece");
	    countryList.addElement("Grenada");
	    countryList.addElement("Guatemala");
	    countryList.addElement("Guinea");
	    countryList.addElement("Guinea-Bissau");
	    countryList.addElement("Guyana");

	    countryList.addElement("Haiti");
	    countryList.addElement("Holy See");
	    countryList.addElement("Honduras");
	    countryList.addElement("Hong Kong");
	    countryList.addElement("Hungary");

	    countryList.addElement("Iceland");
	    countryList.addElement("India");
	    countryList.addElement("Indonesia");
	    countryList.addElement("Iran");
	    countryList.addElement("Iraq");
	    countryList.addElement("Ireland");
	    countryList.addElement("Israel");
	    countryList.addElement("Italy");

	    countryList.addElement("Jamaica");
	    countryList.addElement("Japan");
	    countryList.addElement("Jordan");

	    countryList.addElement("Kazakhstan");
	    countryList.addElement("Kenya");
	    countryList.addElement("Kiribati");
	    countryList.addElement("Korea, North");
	    countryList.addElement("Korea, South");
	    countryList.addElement("Kosovo");
	    countryList.addElement("Kuwait");
	    countryList.addElement("Kyrgyzstan");

	    countryList.addElement("Laos");
	    countryList.addElement("Latvia");
	    countryList.addElement("Lebanon");
	    countryList.addElement("Lesotho");
	    countryList.addElement("Liberia");
	    countryList.addElement("Libya");
	    countryList.addElement("Liechtenstein");
	    countryList.addElement("Lithuania");
	    countryList.addElement("Luxembourg");

	    countryList.addElement("Macau");
	    countryList.addElement("Macedonia");
	    countryList.addElement("Madagascar");
	    countryList.addElement("Malawi");
	    countryList.addElement("Malaysia");
	    countryList.addElement("Maldives");
	    countryList.addElement("Mali");
	    countryList.addElement("Malta");
	    countryList.addElement("Marshall Islands");
	    countryList.addElement("Mauritania");
	    countryList.addElement("Mauritius");
	    countryList.addElement("Mexico");
	    countryList.addElement("Micronesia");
	    countryList.addElement("Moldova");
	    countryList.addElement("Monaco");
	    countryList.addElement("Mongolia");
	    countryList.addElement("Montenegro");
	    countryList.addElement("Morocco");
	    countryList.addElement("Mozambique");

	    countryList.addElement("Namibia");
	    countryList.addElement("Nauru");
	    countryList.addElement("Nepal");
	    countryList.addElement("Netherlands");
	    countryList.addElement("Netherlands Antilles");
	    countryList.addElement("New Zealand");
	    countryList.addElement("Nicaragua");
	    countryList.addElement("Niger");
	    countryList.addElement("Nigeria");
	    countryList.addElement("North Korea");
	    countryList.addElement("Norway");

	    countryList.addElement("Oman");

	    countryList.addElement("Pakistan");
	    countryList.addElement("Palau");
	    countryList.addElement("Palestinian Territories");
	    countryList.addElement("Panama");
	    countryList.addElement("Papua New Guinea");
	    countryList.addElement("Paraguay");
	    countryList.addElement("Peru");
	    countryList.addElement("Philippines");
	    countryList.addElement("Poland");
	    countryList.addElement("Portugal");

	    countryList.addElement("Qatar");
	    countryList.addElement("Romania");

	    countryList.addElement("Russia");
	    countryList.addElement("Rwanda");

	    countryList.addElement("Saint Kitts and Nevis");
	    countryList.addElement("Saint Lucia");
	    countryList.addElement("Saint Vincent and the Grenadines");
	    countryList.addElement("Samoa");
	    countryList.addElement("San Marino");
	    countryList.addElement("Sao Tome and Principe");
	    countryList.addElement("Saudi Arabia");
	    countryList.addElement("Senegal");
	    countryList.addElement("Serbia");
	    countryList.addElement("Seychelles");
	    countryList.addElement("Sierra Leone");
	    countryList.addElement("Singapore");
	    countryList.addElement("Sint Maarten");
	    countryList.addElement("Slovakia");
	    countryList.addElement("Slovenia");
	    countryList.addElement("Solomon Islands");
	    countryList.addElement("Somalia");
	    countryList.addElement("South Africa");
	    countryList.addElement("South Korea");
	    countryList.addElement("South Sudan");
	    countryList.addElement("Spain");
	    countryList.addElement("Sri Lanka");
	    countryList.addElement("Sudan");
	    countryList.addElement("Suriname");
	    countryList.addElement("Swaziland");
	    countryList.addElement("Sweden");
	    countryList.addElement("Switzerland");
	    countryList.addElement("Syria");

	    countryList.addElement("Taiwan");
	    countryList.addElement("Tajikistan");
	    countryList.addElement("Tanzania");
	    countryList.addElement("Thailand");
	    countryList.addElement("Timor-Leste");
	    countryList.addElement("Togo");
	    countryList.addElement("Tonga");
	    countryList.addElement("Trinidad and Tobago");
	    countryList.addElement("Tunisia");
	    countryList.addElement("Turkey");
	    countryList.addElement("Turkmenistan");
	    countryList.addElement("Tuvalu");

	    countryList.addElement("Uganda");
	    countryList.addElement("Ukraine");
	    countryList.addElement("United Arab Emirates");
	    countryList.addElement("United Kingdom");
	    countryList.addElement("Uruguay");
	    countryList.addElement("Uzbekistan");
	    
	    countryList.addElement("Vanuatu");
	    countryList.addElement("Venezuela");
	    countryList.addElement("Vietnam");
	    countryList.addElement("Yemen");
	    countryList.addElement("Zambia");
	    countryList.addElement("Zimbabwe");

		return countryList;
	}

}
