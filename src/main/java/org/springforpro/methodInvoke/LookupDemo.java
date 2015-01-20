package org.springforpro.methodInvoke;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/lookup.xml");
		ctx.refresh();
		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);
		displayInfo(abstractBean);
	}

	private static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		boolean isEquals = helper1.equals(helper2);
		System.out.println("helper1 is equals helper2 ::= " + isEquals);
		StopWatch stopWatch  = new StopWatch();
		stopWatch.start("lookupDemo!");
	}

}
