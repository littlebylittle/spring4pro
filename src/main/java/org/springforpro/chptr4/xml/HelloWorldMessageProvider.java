package org.springforpro.chptr4.xml;

import org.springforpro.chptr4.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider{

	@Override
	public String getMessage() {
		return "<Hello world!> from HelloWold message provider::";
	}

}
