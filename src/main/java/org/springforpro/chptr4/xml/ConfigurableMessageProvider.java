package org.springforpro.chptr4.xml;

import org.springforpro.chptr4.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
	private String message;

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
