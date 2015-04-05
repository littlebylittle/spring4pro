package cflow;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExampleBean {
	public static void main(String[] args) {
		ControlFlowExampleBean ex = new ControlFlowExampleBean();
		ex.run();
	}

	public void run() {
		TestBean target = new TestBean();
		Pointcut pc = new ControlFlowPointcut(ControlFlowExampleBean.class, "test");
		Advisor ad = new DefaultPointcutAdvisor(pc, new aop.SimpleBeforeAdvice());
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(ad);
		pf.setTarget(target);
		TestBean proxy = (TestBean) pf.getProxy();
		System.out.println("Trying normal invoke! ");
		proxy.foo();
		System.out.println("Trying call into ControlFlowExample.test():");
		test(proxy);
	}

	private void test(TestBean proxy) {
		proxy.foo();
	}
}
