package org.springforpro.chptr5.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

public class LoggingBean implements BeanNameAware {
	private static final Log log = LogFactory.getLog(LoggingBean.class);
	private String beanName = null;
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void someOperation() {
		if(log.isInfoEnabled()) {
			log.info("Bean [" + beanName + "] call someOperation()");
		}
	}
}
