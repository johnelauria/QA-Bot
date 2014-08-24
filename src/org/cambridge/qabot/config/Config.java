package org.cambridge.qabot.config;

import java.util.HashMap;

public class Config {
	/**
	 * Setting this to true will include system logging which is useful for debugging purposes
	 * @return Boolean
	 */
	public static final boolean Log() {
		return true;
	}
	
	/**
	 * This is the list of environments to conduct test on the WMP ELT site. Add more in here if you wish
	 * @return HashMap servers
	 */
	public HashMap<String, String> testServers() {
		HashMap<String, String> servers = new HashMap<String, String>();
		servers.put("learning-dev", "http://learning-dev.aws.cambridge.org/gb/cambridgeenglish");
		servers.put("learning-uat", "http://learning-uat.aws.cambridge.org/gb/cambridgeenglish");
		servers.put("staging", "http://wwwstaging.cambridge.org/gb/cambridgeenglish");
		servers.put("live", "http://www.cambridge.org/gb/cambridgeenglish");
		return servers;
	}
}
