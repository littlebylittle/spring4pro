/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.event;

import org.springframework.context.ApplicationEvent;

/**  @author igorm  */
public class MessageEvent extends ApplicationEvent{
	private final String msg;

	public String getMsg() {
		return msg;
	}
	
	public MessageEvent(Object source, String msg) {
		super(source);
		System.out.println("Call messageEvent constructor");
		this.msg = msg;
	}
}
