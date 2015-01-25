package org.springforpro.chptr5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	private final String DEFAULT_NAME = "Luke Skywalker";
	private String name = null;
	private int age = Integer.MIN_VALUE;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void init() {
		System.out.println("Initializing bean");
		if(name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the property :: " + this.getClass().getName() +
							".age, for each bean instance");
		}
	}
	@Override
	public String toString() {
		return "SimpleBean{" + "name=" + name + ", age=" + age + ", null=" + '}';
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/initMethod.xml");
		ctx.refresh();

		SimpleBean sb1 = getBean("simpleBean1", ctx);
		SimpleBean sb2 = getBean("simpleBean2", ctx);
		SimpleBean sb3 = getBean("simpleBean3", ctx);
	}

	private static SimpleBean getBean(String beanName, ApplicationContext ctx) throws BeansException, BeanCreationException{
		try {
			SimpleBean res = ctx.getBean(beanName, SimpleBean.class);
			System.out.println("Bean === " + res );
			return res;
		} catch (BeanCreationException ex) {
			System.out.println("Exception in bean instancing, configuration error : " + ex.getMessage() );
			return null;
		}
	}
}