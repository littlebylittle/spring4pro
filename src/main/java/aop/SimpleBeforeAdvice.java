/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aop;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(target);
		MessageWriter proxyTarget = (MessageWriter)pf.getProxy();
		proxyTarget.writeMessage();
		System.out.println("");
		proxyTarget.writeAnotherMessage();
		System.out.println("");
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("[Before method " + arg0.getName() + ", we call `before` decoration]");
	}
}
