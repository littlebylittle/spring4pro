package org.springforpro.chptr4.spel;

public class InjectSimpleConfig {
	private String name = "John Dow";
	private int age  = 45;
	private float height = 1.88f;
	private boolean programmer = false;
	private Long  ageInSeconds = 1231234214L;

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
}
