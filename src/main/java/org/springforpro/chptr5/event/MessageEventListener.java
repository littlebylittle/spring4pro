/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.event;

import org.springframework.context.ApplicationListener;

/**  @author igorm  */
public class MessageEventListener implements ApplicationListener<MessageEvent>{

	@Override
	public void onApplicationEvent(MessageEvent e) {
		System.out.println("Received event: " + e.getMsg());
	}
}
