/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package throwsaop;

import java.lang.reflect.Method;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class SimpleThrowsAdvice implements ThrowsAdvice {
	public static void main(String[] args) {
		ErrorBean bean = new ErrorBean();
		ProxyFactory f = new ProxyFactory();
		f.setTarget(bean);
		f.addAdvice(new SimpleThrowsAdvice());
		ErrorBean proxy = (ErrorBean)f.getProxy();
		try {
			proxy.errorProneMethod();
		} catch(Exception e) {}
		try {
			proxy.otherErrorProneMethod();
		} catch(Exception e) {}
	}
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("***");
		System.out.println("Generic exception capture");
		System.out.println("Caught `" + ex.getClass().getName() + "` exception");
		System.out.println("***");
		System.out.println("");
	}
	public void afterThrowing(Method m, Object[] args, Object target, IllegalArgumentException ex)
			throws Throwable {
		System.out.println("***");
		System.out.println("IllegalArgumentException capture");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("Method: " + m.getName());
		System.out.println("***");
		System.out.println("");
	}
}
