/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**  @author igorm  */
public class SecurityAdvice implements MethodBeforeAdvice {
	private final SecurityManager manager;

	public SecurityAdvice() {
		this.manager = new SecurityManager();
	}
	
	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		UserInfo user = manager.getLoggedUser();
		if(null == user) {
			System.out.println("Not authenticated");
			throw new SecurityException("You must login before attempting to invoke method:"  
					+ method.getName()
			);
		} else if("clarence".equals(user.getUserName())) {
			System.out.println("Logged in user `Clarence` - OKEY!");
		} else {
			System.out.println("Logged in user " + user.getUserName() + " NOT GOOD!");
			throw new SecurityException("User: `" + user.getUserName() + "` is not allowed access to "
					+ "method " + method.getName());
		}		
	}
}