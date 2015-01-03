package org.springforpro.chptr2;

public class HelloWorldDecoupled {
	public static void main(String[] args) {
		MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
		MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
		mr.setMessageProvider(mp);
		mr.render();
	}
}