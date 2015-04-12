package composable;

import cflow.SimpleBeforeAdvice;
import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import org.springframework.aop.support.StaticMethodMatcher;
public class CompolsablePointcutExample {
	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodMatcher());
		System.out.println("Test one");
		SampleBean proxy = getProxy(pc, target);
		testInvoke(proxy);

		System.out.println("");
		System.out.println("Test 2, `and` logical == union");
		pc.union(new SetterMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);

		System.out.println("");
		System.out.println("Test 3, `or` logical => intersect fucntion");
		pc.intersection(new GetAgeMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);
		System.out.println();
	}

	private static SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice() ));
		return (SampleBean) pf.getProxy();
	}

	private static void testInvoke(SampleBean proxy) {
		proxy.getAge();
		proxy.getName();
		proxy.setName("Invoker Managementoff");
	}

	private static class GetterMethodMatcher extends StaticMethodMatcher {

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("get");
		}
	}

	private static class SetterMethodMatcher extends StaticMethodMatcher {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("set");
		}
	}

	private static class GetAgeMethodMatcher extends StaticMethodMatcher {

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return ("getAge".equals(method.getName()));
		}
	}
}
