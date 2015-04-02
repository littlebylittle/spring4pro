/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.context;

import java.util.Locale;
import org.springframework.context.support.GenericXmlApplicationContext;

/**  @author igorm  */
public class MessageSourceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx  = new GenericXmlApplicationContext();
		ctx.load("classpath:appContext/messageSource.xml");
		ctx.refresh();

		Locale english = Locale.ENGLISH;
		Locale russian = new Locale("ru", "RU");

		System.out.println("English msg: " + ctx.getMessage("msg", null, english));
		System.out.println("Russian msg: " + ctx.getMessage("msg", null, russian));
		System.out.println("English nameMsg" + ctx.getMessage("nameMsg", new Object[] {	"Clarence", "Ho"}, english ));
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		StaticMessageSource source = new StaticMessageSource();
//		source.setBasename("appContext/labels");
//		System.out.println(source.getMessage("msg", null, russian) );
//		System.out.println(source.getMessage("msg", null, english) );
//		Object[] os = new Object[] {"One", "two"};
//		System.out.println(source.getMessage("nameMsg", new Object[] {"wut", "in my butt"}, english));		
	}
}
