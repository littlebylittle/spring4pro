package org.springforpro.chptr4.annotation;

import org.springforpro.chptr4.MessageProvider;
import org.springforpro.chptr4.MessageRenderer;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider mp;

	@Override
	public void render() {
		if(mp == null)
			throw new RuntimeException("You must set property mp of class : " +
					StandardOutMessageRenderer.class.getName());
		System.out.println(mp.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider mp) {
		this.mp = mp;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return mp;
	}

	public StandardOutMessageRenderer(MessageProvider mp) {
		this.mp = mp;
	}

	public StandardOutMessageRenderer() {
	}

}