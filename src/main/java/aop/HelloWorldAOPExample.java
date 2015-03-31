/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class HelloWorldAOPExample {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		ProxyFactory pf2 = new ProxyFactory();	
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);
		MessageWriter proxyObj = (MessageWriter) pf.getProxy();
			
		pf2.setTarget(proxyObj);
		pf2.addAdvice(new MessageDecorator());
		
		MessageWriter proxyObj2 = (MessageWriter) pf2.getProxy();
		System.out.println("::::::::::::");
		target.writeMessage();
		System.out.println("\n:::::::::::::");
		proxyObj2.writeMessage();
		proxyObj2.writeAnotherMessage();
//		Advisor a = new Advisor
	}
}
