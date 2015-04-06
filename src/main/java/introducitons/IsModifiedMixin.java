/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introducitons;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**  @author igorm  */
public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {
	private volatile boolean modified = false;
	private final Map<Method, Method> methodCache = new HashMap<>();
	@Override
	protected Object doProceed(MethodInvocation mi) throws Throwable {
		return super.doProceed(mi); //To change body of generated methods, choose Tools | Templates.
	}
	@Override
	@SuppressWarnings("null")
	public Object invoke(MethodInvocation mi) throws Throwable {
		if(!isModified()) {
			if(methodStartWith(mi, "set") && mi.getArguments().length == 1) {
				Method getter = getGetterFromSetter(mi.getMethod());

				if(null != getter) {
					Object newVal = mi.getArguments()[0];
					Object oldVal = getter.invoke(mi.getThis(), (Object[]) null);
					if(newVal == null && oldVal == null) {
						modified = false;
					} else if ((newVal != null && oldVal == null) || 
							   (newVal == null && oldVal != null) ) {
						modified =  true;
					} else
						modified = newVal.equals(oldVal);
				}
			}
		} 
		return super.invoke(mi);
	}
	
	private boolean methodStartWith(MethodInvocation mi, String substr) {
		if(mi.getMethod().getName().startsWith(substr)) {
			return true;
		} else
			return false;
	}
	@Override
	public boolean isModified() {
		return modified;
	}
	private Method getGetterFromSetter(Method setter) {
		Method getter = methodCache.get(setter);
		if(null == getter) {
		} else {
			return getter;
		}
		String getterName = setter.getName().replaceFirst("set", "get");
		try {
			getter = setter.getDeclaringClass().getMethod(getterName, (Class<?>) null);
			synchronized (methodCache) {
				methodCache.put(setter, getter);
			}
			return getter;
		} catch (NoSuchMethodException ex) {
			return null;
		}
	}
	
	private Method getGetter(Method setter) {
		return getGetterFromSetter(setter);
	}
}