package org.springforpro.chptr5.javaconfig;

public class ConfigurableMessageProvider implements MessageProvider {
	public String message;

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public ConfigurableMessageProvider() {
		this.message = "Default message";
	}
}
