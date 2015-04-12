package pfb;

import org.springframework.aop.framework.ProxyFactoryBean;

/**  @author igorm  */
public class TestMainClass {
	public static void main(String[] args) {
		System.out.println("Little steps: getName = " + MySecretAdvice.class.getName());
		System.out.println("Little steps: getCanonicalName  = " + MySecretAdvice.class.getCanonicalName());


		ProxyFactoryBean pfb1 = new ProxyFactoryBean();
		MyDependency trgt = new MyDependency();
		pfb1.setTarget(trgt);
		pfb1.setInterceptorNames(new String[]{MySecretAdvice.class.getName()});
		pfb1.addAdvice(new MySecretAdvice());
//		MyDependency proxed = (MyDependency) pfb1.getObject();
	}
}
