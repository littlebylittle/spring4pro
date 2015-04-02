/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aop;

/**  @author igorm  */
public class MessageWriter {
	private String message = "Default message";

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void writeMessage() {
		System.out.print("Write message method");
	}
	
	public void writeAnotherMessage() { 
		System.out.print("Another message");
	}
}
