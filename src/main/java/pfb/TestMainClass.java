package pfb;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**  @author igorm  */
public class TestMainClass {
	public static void main(String[] args) {
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setInterceptorNames(new String[]{"bean"});
		DefaultPointcutAdvisor pc = new DefaultPointcutAdvisor();
	}
}
