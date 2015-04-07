/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introducitons;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

/**  @author igorm  */
public class IntroducitonExample {
	public static void main(String[] args) {
		TargetBean target = new TargetBean();
		target.setName("Loup Garou");
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		
		Advisor advisor = new IsModifiedAdvisor();
		pf.addAdvisor(advisor);
		pf.setOptimize(true);
		TargetBean proxy = (TargetBean) pf.getProxy();
		IsModified proxyInterface = (IsModified) proxy;
		System.out.println("Proxy is target bean ?         : " +  (proxy instanceof TargetBean));
		System.out.println("Proxy is child of  Ismodified? : " +  (proxy instanceof IsModified));
		
		System.out.println("Has been modified interface? : " + proxyInterface.isModified());
		proxy.setName("Loup Garou");
		System.out.println("Has been modified? Loup Garou != Loup Garou : " + proxyInterface.isModified());
		proxy.setName("Za Warudo");
		System.out.println("Has been modified? : " + proxyInterface.isModified());
	}
}
