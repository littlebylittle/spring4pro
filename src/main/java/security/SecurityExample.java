/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class SecurityExample {
	public static void main(String[] args) {
		SecurityManager manager = new SecurityManager(); 
		SecureBean bean = getSecureBean();
		manager.login("clarence", "pwd");
		bean.writeSecureMessage();
		manager.logout();
		try {
			manager.login("bilbo", "mylittletreasure");
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception caught: " + ex.getMessage());
		} finally {
			manager.logout();
		}
		try {
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception caught: " + ex.getMessage());
		}
	}
	
	private static SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		SecurityAdvice advice = new SecurityAdvice();
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		return (SecureBean)factory.getProxy();	
	}
}