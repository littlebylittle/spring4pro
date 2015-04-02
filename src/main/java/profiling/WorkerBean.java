/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package profiling;

/**  @author igorm  */
public class WorkerBean {
	public void doSomeWork(int noOfTimes) {
		for (int i = 0; i < noOfTimes; i++) {
			work();
		}
	}
	public void work() {
		System.out.print("");
	}
	
	public void sayNigga() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nigga!");
		}
		System.out.println("Yes, i'm 100 percent nigga....");
	}
}
