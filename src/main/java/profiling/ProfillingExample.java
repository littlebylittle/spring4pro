/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package profiling;

import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class ProfillingExample {
	public static void main(String[] args) {
		WorkerBean bean = getWorkerBean();
		bean.doSomeWork(1000000);
		bean.sayNigga();
	}

	private static WorkerBean getWorkerBean() {
		WorkerBean target = new WorkerBean();
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(new ProfilingInterceptor());
		return  (WorkerBean)factory.getProxy();
	}
}
