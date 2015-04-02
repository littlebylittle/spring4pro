/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dynamicpc;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**  @author igorm  */
public class SimpleDynamicPointCut extends DynamicMethodMatcherPointcut{

	@Override
	public boolean matches(Method arg0, Class<?> arg1, Object[] arg2) {
		System.out.println("Dynamic check for " + arg0.getName());
		int x = ((Integer) arg2[0]);
		return (100 != x);
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("Static check for method " + method.getName() );
		return ("foo".equals(method.getName()));
	}
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return (clazz == SampleBean.class);
			}
		};
	}
}
