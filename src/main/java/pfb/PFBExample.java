package pfb;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PFBExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:aop/pfb.xml");
		ctx.refresh();
		MyBean bean1 = ctx.getBean("myBean1", MyBean.class);
		MyBean bean2 = ctx.getBean("myBean2", MyBean.class);
		System.out.println("Bean 1: *****************************************************************************");
		bean1.execute();

		System.out.println("Bean 2: *****************************************************************************");
		bean2.execute();
	}
}
