package pfb;

import org.springframework.aop.framework.ProxyFactoryBean;

/**  @author igorm  */
public class TestMainClass {
	public static void main(String[] args) {
		System.out.println("Little steps: getName = " + MySecretAdvice.class.getName());
		System.out.println("Little steps: getCanonicalName  = " + MySecretAdvice.class.getCanonicalName());


		ProxyFactoryBean pfb1 = new ProxyFactoryBean();
		MyDependency trgt = new MyDependency();
		MyBean bean1 = new MyBean();
		bean1.setDep(trgt);
		pfb1.setTarget(bean1);
		pfb1.addAdvice(new MySecretAdvice());
//		pfb1.setInterceptorNames(new String[] {MySecretAdvice.class.getName()});
		MyBean proxed = (MyBean) pfb1.getObject();
		proxed.execute();
	}
}
