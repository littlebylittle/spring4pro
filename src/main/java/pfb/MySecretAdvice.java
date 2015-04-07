/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pfb;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**  @author igorm  */
public class MySecretAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Executing method  `" + arg0.getName());
	}
}
