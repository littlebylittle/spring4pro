package org.springforpro.chptr4.xml;

import org.springforpro.chptr4.MessageProvider;
import org.springforpro.chptr4.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;
	private String fuck;

	public void setFuck(String fuck) {
		this.fuck = fuck;
	}

	public String getFuck() {
		return fuck;
	}

	public StandardOutMessageRenderer(String fuck) {
		this.fuck = fuck;
	}

	@Override
	public void render() {
		if(messageProvider == null)
			throw new RuntimeException("You must set property mp of class : " +
					StandardOutMessageRenderer.class.getName());
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider mp) {
		this.messageProvider = mp;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	public StandardOutMessageRenderer(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public StandardOutMessageRenderer() {
	}

}
