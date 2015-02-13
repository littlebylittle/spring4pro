package org.springforpro.chptr5.Factory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:factory/factory.xml");
		ctx.refresh();
		MessageDigester bean = ctx.getBean("digester", MessageDigester.class);
		bean.digest("Hallo?");
		bean.showDiff();
	}
}