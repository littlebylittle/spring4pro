/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**  @author igorm  */
public class Publisher implements ApplicationContextAware{
	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		this.ctx = ac;
	}
	
	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:events/events.xml");
		Publisher pub = ctx.getBean("publisher", Publisher.class);
		pub.publish("Hello world! Amigo!");
		pub.publish("The fast quick brown fox jumped over the lazy dog!");
	}
}
