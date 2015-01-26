package org.springforpro.chptr5;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface implements InitializingBean  {
	private static final String DEFAULT_NAME = "Luke SkyWalker";

	private String name = null;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	private int age = Integer.MIN_VALUE;

	public void myInit() {
		System.out.println("Init call! " );
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Call afterPropertiesSet, initializing bean." );
		if(name == null) {
			System.out.println("Using default name.");
			name = DEFAULT_NAME;
		}
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("You must set the `age`-property of any bean of type" + SimpleBean.class);
		}
	}

	@Override
	public String toString() {
		return "SimpleBeanWithInterface{" + "name=" + name + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/initInterface.xml");
		ctx.refresh();

		SimpleBeanWithInterface simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBeanWithInterface simpleBean2 = getBean("simpleBean2", ctx);
		SimpleBeanWithInterface simpleBean3 = getBean("simpleBean3", ctx);
		System.out.println("b1  = b2 => " + (simpleBean1 == simpleBean2) +
				"# b2 == b3 =>  " + (simpleBean2 == simpleBean3) );
		ctx.getBeanFactory().destroySingletons();
	}

	private static SimpleBeanWithInterface getBean(String beanName, GenericXmlApplicationContext ctx) {
		try {
			SimpleBeanWithInterface bean = ctx.getBean(beanName, SimpleBeanWithInterface.class);
			System.out.println("Bean => " + bean );
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("Exception in bean configuration, " + ex.getMessage() );
			return null;
		}
	}
}