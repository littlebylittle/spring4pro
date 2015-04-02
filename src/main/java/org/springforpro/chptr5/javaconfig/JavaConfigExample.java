package org.springforpro.chptr5.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageRenderer r = ctx.getBean("messageRenderer", MessageRenderer.class);
//		r.getMessageProvider().setMessage("Fuck you piggy!");
		r.render();
	}
}
