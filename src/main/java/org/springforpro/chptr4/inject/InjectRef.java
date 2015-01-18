package org.springforpro.chptr4.inject;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
	private Oracle oracle;

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:injectref/app-inject-conf.xml");
		ctx.refresh();
		InjectRef ref = ctx.getBean("injectRef", InjectRef.class);
		System.out.println("End result it is :: " + ref);
	}

	@Override
	public String toString() {
		return "InjectRef{" + "oracle`=" + oracle.meaningOfLife() + '}';
	}
}
