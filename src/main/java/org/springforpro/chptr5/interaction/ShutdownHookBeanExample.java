package org.springforpro.chptr5.interaction;

import org.springforpro.chptr5.destroy.DestructiveBeanInterface;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:interaction/shutdownHook.xml");
		ctx.refresh();
		DestructiveBeanInterface bean = ctx.getBean("destructiveBean", DestructiveBeanInterface.class);
	}
}
