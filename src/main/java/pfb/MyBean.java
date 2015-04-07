/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pfb;

/**  @author igorm  */
public class MyBean {
	private MyDependency dep;

	public void setDep(MyDependency dep) {
		this.dep = dep;
	}

	public MyDependency getDep() {
		return dep;
	}
	
	public void execute() {
		dep.foo();
		dep.bar();
	}
}
