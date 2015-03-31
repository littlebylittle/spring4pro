/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package staticpc;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**  @author igorm  */
public class StaticPointcutExample {
	public static void main(String[] args) {
		BeanOne one = new BeanOne();
		BeanTwo two = new BeanTwo();
		BeanOne proxyOne;
		BeanTwo proxyTwo;
		Pointcut pc = new SimpleStaticPointCut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(one);
		pf.addAdvisor(advisor);
		proxyOne = (BeanOne) pf.getProxy();
		pf = new ProxyFactory();
		pf.setTarget(two);
		pf.addAdvisor(advisor);
		proxyTwo = (BeanTwo) pf.getProxy();
		proxyOne.foo();
		proxyOne.bar();
		proxyTwo.foo();
		proxyTwo.bar();	
	}
}
