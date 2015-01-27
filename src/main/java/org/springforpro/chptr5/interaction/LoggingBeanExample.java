package org.springforpro.chptr5.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LoggingBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:interaction/logging.xml");
		ctx.refresh();
		LoggingBean bean = ctx.getBean("loggingBean", LoggingBean.class);
		System.out.println("::::::: = ");
		bean.someOperation();
	}
}
