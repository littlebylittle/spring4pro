/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package profiling;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**  @author igorm  */
public class ProfilingInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(mi.getMethod().getName() );
		String methodName = mi.getMethod().getName();
		if("sayNigga".equals(methodName)) {
			System.out.println("FUCK YOU NIGGA!");
			return null;
		}
		Object returnValue = mi.proceed();
		sw.stop();
		dumpInfo(mi, sw.getTotalTimeMillis());
		return returnValue;		
	}

	private void dumpInfo(MethodInvocation mi, long ms) {
		Method m = mi.getMethod();
		Object target = (Object)mi.getThis();
		Object[] args = mi.getArguments();
		System.out.println("Executed method : " + m.getName());
		System.out.println("Object class : " + target.getClass().getName());
		System.out.println("With arguments:");
		for (Object arg : args) {
			System.out.print("\t\t>" + arg);
		}
		System.out.println("");
		System.out.println("Took:" +  ms);
	}
}
