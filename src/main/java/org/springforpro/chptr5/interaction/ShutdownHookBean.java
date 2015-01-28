package org.springforpro.chptr5.interaction;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
	private ApplicationContext ctx = null;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
		if(ctx instanceof GenericApplicationContext) {
//			((GenericApplicationContext) ctx).registerShutdownHook();
		}
	}
}
