package org.springforpro.chptr2;

public class HelloWorldMessageProvider implements MessageProvider{

	@Override
	public String getMessage() {
		return "<Hello world!> from HelloWold message provider::";
	}

}
