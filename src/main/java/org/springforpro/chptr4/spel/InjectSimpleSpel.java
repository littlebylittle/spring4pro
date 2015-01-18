package org.springforpro.chptr4.spel;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpel {
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private Long  ageInSeconds;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	public boolean isProgrammer() {
		return programmer;
	}

	public Long getAgeInSeconds() {
		return ageInSeconds;
	}

	@Override
	public String toString() {
		return "InjectSimpleSpel{" + "\nname=" + name +
				", \nage=" + age + ", \nheight=" + height +
				", \nprogrammer=" + programmer +
				", \nageInSeconds=" + ageInSeconds + '}';
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spel/app-context-xml.xml");
		ctx.refresh();
		InjectSimpleSpel injectSimpleSpel = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println("injectSimpleSpel = " + injectSimpleSpel.toString());
	}
}
