package org.springforpro.chptr5.javaconfig;

public class StandardOutMessageRenderer implements MessageRenderer{
	private MessageProvider mp;

	@Override
	public void render() {
		if(null == mp) {
			throw new RuntimeException("Set property messageProvider, for example : " + this.getClass().getName());
		}
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

}
