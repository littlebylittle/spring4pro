package replacement;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer{

	@Override
	public Object reimplement(Object arg0, Method method, Object[] args) throws Throwable {
		if(isFormatMessageMethod(method)) {
			String msg = (String )args[0];
			return "<h2>" + msg + "</h2>";
		} else {
			throw new IllegalArgumentException("Unable to reimplement method ::" + method.getName());
		}
	}

	private boolean isFormatMessageMethod(Method method) {
		Boolean[] fails = new Boolean[] {
			(  method.getParameterTypes().length != 1 ),
			(! "formatMessage".equals(method.getName()) ),
			(! (method.getReturnType() == String.class) ),
			(  (method.getParameterTypes()[0] != String.class))
		};
		for (Boolean fail : fails) {
			if(fail)
				return false;
		}
		return true;
	}

}
