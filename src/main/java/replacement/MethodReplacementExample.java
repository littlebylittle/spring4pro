package replacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:replacement.xml");
		ctx.refresh();
		ReplacementTarget r = ctx.getBean("replacementTarget",	ReplacementTarget.class);
		ReplacementTarget s = ctx.getBean("standardTarget",		ReplacementTarget.class);
		displayInfo(r);
		displayInfo(s);
	}

	private static void displayInfo(ReplacementTarget r) {
		System.out.println("First call = " + r.formatMessage("Hello world!"));
		StopWatch watch = new StopWatch("Call");
		watch.start("perfomance test");
		for (int i = 0; i < 90000; i++) {
			String out = r.formatMessage("foo");
		}
		watch.stop();
		System.out.println("perfomance result = " + watch.getTotalTimeMillis() + "ms");
	}
}
