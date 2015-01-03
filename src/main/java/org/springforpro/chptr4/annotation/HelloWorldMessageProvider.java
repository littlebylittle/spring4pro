package org.springforpro.chptr4.annotation;

import org.springforpro.chptr4.MessageProvider;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider{

	@Override
	public String getMessage() {
		return "<Hello world!> from ANNOTATED HelloWold message provider::";
	}

}
