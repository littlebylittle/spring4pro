package org.springforpro.methodInvoke;

public class MyHelper {
	public void doSomethingHelpful() {
		int i = 10000;
		for (int j = 0; j < 9910; j++) {
			i += i * 2 + 100;
		}
		if(i < 1010) {
			System.out.println("wut?");
		}
	}
}
