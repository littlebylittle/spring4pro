package org.springforpro.chptr2;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageSupportFactory {
	private static final MessageSupportFactory instance;
	private static Properties props;
	private MessageProvider provider;
	private MessageRenderer renderer;
	static {
		instance = new MessageSupportFactory();
	}

	@SuppressWarnings("UseSpecificCatch")
	public MessageSupportFactory() {
		try {
			props = new Properties();

			props.load(new FileInputStream("conf/msf.properties"));
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
		} catch (Exception ex) {
			Logger.getLogger(MessageSupportFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static MessageSupportFactory getInstance() {
		return instance;
	}

	public MessageProvider getProvider() {
		return provider;
	}

	public MessageRenderer getRenderer() {
		return renderer;
	}
}