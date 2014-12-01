package org.springforpro.chptr2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDecoupled {
	public static void main(String[] args) {
		Class<String> c = String.class;
		MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
//		MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
//		mr.setMessageProvider(mp);
		mr.render();
	}
}
