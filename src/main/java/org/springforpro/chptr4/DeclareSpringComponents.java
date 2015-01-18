package org.springforpro.chptr4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println("Provider says :" + messageProvider.getMessage() );
		MessageRenderer mr = ctx.getBean("messageRenderer", MessageRenderer.class);
//		mr.render();
//		System.out.println( messageProvider.getMessage());
	}
}