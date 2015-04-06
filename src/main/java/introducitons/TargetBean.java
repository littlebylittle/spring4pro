/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introducitons;

/**  @author igorm  */
public class TargetBean {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("MODIFYING!");
		this.name = name;
	}
}
